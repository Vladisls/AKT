import ee.ut.cs.akt.automata.FiniteAutomaton;
import ee.ut.cs.akt.regex.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Grep {
    /*
     * main meetodit ei ole vaja muuta.
     *
     * See meetod on siin vaid selleks, et anda käesolevale  harjutusele veidi
     * realistlikum kontekst. Aga tegelikult on see vaid mäng -- see programm ei
     * pretendeeri päeva kasulikuima programmi tiitlile. Päris elus kasuta päris grep-i.
     */
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length < 1 || args.length > 2) {
            System.err.println(
                    "Programm vajab vähemalt ühte argumenti: regulaaravaldist.\n" +
                            "Teiseks argumendiks võib anda failinime (kui see puudub, siis loetakse tekst standardsisendist).\n" +
                            "Failinime andmisel eeldatakse, et tegemist on UTF-8 kodeeringus tekstifailiga.\n" +
                            "Rohkem argumente programm ei aktsepteeri.\n"
            );
            System.exit(1);
        }

        RegexNode regex = RegexParser.parse(args[0]);
        FiniteAutomaton automaton = optimize(regexToFiniteAutomaton(regex));

        Scanner scanner;
        if (args.length == 2) {
            scanner = new Scanner(new FileInputStream(args[1]), "UTF-8");
        } else {
            scanner = new Scanner(System.in);
        }

        // kuva ekraanile need read, mis vastavad antud regulaaravaldisele/automaadile
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (automaton.accepts(line)) {
                System.out.println(line);
            } 
        }

        scanner.close();
    }

    /*
     * See meetod peab loenguslaididel toodud konstruktsiooni põhjal koostama ja tagastama
     * etteantud regulaaravaldisele vastava mittedetermineeritud lõpliku automaadi.
     * Selle meetodi korrektne implementeerimine on antud ülesande juures kõige tähtsam.
     *
     * (Sa võid selle meetodi implementeerimiseks kasutada abimeetodeid ja ka abiklasse,
     * aga ära muuda meetodi signatuuri, sest automaattestid eeldavad just sellise signatuuri
     * olemasolu.)
     *
     * (Selle ülesande juures pole põhjust kasutada vahetulemuste salvestamiseks klassivälju,
     * aga kui sa seda siiski teed, siis kontrolli, et see meetod töötab korrektselt ka siis,
     * kui teda kutsutakse välja mitu korda järjest.)
     */
    /**
     * See on nüüd kõige tüüpilisem lähenemine. Me eeldame, et kõik teevad endale
     * selgeks, kuidas süntaksipuu niimoodi läbida:
     */
    static void computeEmpty(RegexNode node) {
        if (node instanceof Epsilon) {
            node.setEmpty(true); // Kas on õige??
        }
        else if (node instanceof Letter) {
            node.setEmpty(false); // Kas on õige??
        }
        else if (node instanceof Alternation) {
            Alternation alt = (Alternation) node;
            RegexNode left = alt.getLeft();
            RegexNode right = alt.getRight();
            computeEmpty(left);
            computeEmpty(right);
            node.setEmpty(left.isEmpty() || right.isEmpty()); // Ehk oli nii?
        }
        else if (node instanceof Concatenation) {
        	 Concatenation conc = (Concatenation) node;
             RegexNode left = conc.getLeft();
             RegexNode right = conc.getRight();
             computeEmpty(left);
             computeEmpty(right);
             node.setEmpty(left.isEmpty() && right.isEmpty()); // Ehk oli nii?
        }
        else {
            assert node instanceof Repetition;
            Repetition rep = (Repetition) node;
            RegexNode child = rep.getChild();
            node.setEmpty(true);
            computeEmpty(child);
            
        }
    }

    /**
     * Siin on demo homogeense liidese kasutamise kohta.
     */
    static void computeFirst(RegexNode node) {
    	for (RegexNode child : node.getChildren()) computeFirst(child);{
        switch (node.type) {
            case '*':
                node.addToFirstSet(node.getChild(0).getFirstSet());
                break;
            case '|':
            	node.addToFirstSet(node.getChild(0).getFirstSet());
            	node.addToFirstSet(node.getChild(1).getFirstSet());
                break;
            case '.':
            	if (node.getChild(0).isEmpty()){
            	node.addToFirstSet(node.getChild(0).getFirstSet());
            	node.addToFirstSet(node.getChild(1).getFirstSet());
            	}else {
            		node.addToFirstSet(node.getChild(0).getFirstSet());
            	}
                break;
            case 'ε':
                break;
            default :
                assert node instanceof Letter;
                node.addToFirstSet((Letter)node);
        	}
        }
        // Järgmine rida on peamine põhjus, miks tihti eelistatakse homogeenset liidest:
    }

    /**
     * See on siis näide visitori kasutamisest. Me soovitakse seda kasutada ainult siis,
     * kui oskate juba käsitsi puu läbimist implementeerida. Parem on vastasel juhul ära kustutada
     * see visitor ja implementeerida ise.
     */
    static void computeLast(RegexNode node) {
        RegexVisitorVoid lastVisitor = new RegexVisitorVoid() {
            public void visit(Repetition node, RegexNode child) {
            	node.addToLastSet(node.getChild(0).getLastSet());
            }
            public void visit(Alternation node, RegexNode left, RegexNode right) {
                node.addToLastSet(left.getLastSet());
                node.addToLastSet(right.getLastSet());
            }
            public void visit(Concatenation node, RegexNode left, RegexNode right) {
            	computeEmpty(right);
            	if(node.getChild(1).isEmpty()){
            		node.addToLastSet(node.getChild(0).getLastSet());
            		node.addToLastSet(node.getChild(1).getLastSet());
            	} else node.addToLastSet(node.getChild(1).getLastSet());
            }
            public void visit(Epsilon node) {
                // See võib isegi tühjaks jääda.
            }
            public void visit(Letter node) {
            	node.addToLastSet((Letter)node);
            }
        };
        node.acceptPost(lastVisitor);
    }

    // Siin saate ise valida, kuidas lahendada, aga pidage meeles, et siin tuleb puu
    // läbida eeljärjestuses (pre-order) ehk ülalt alla.
//    static void computeNext(RegexNode node) {
//    	for (RegexNode child : node.getChildren()) computeNext(child);{
//            switch (node.type) {
//                case '*':
//                    node.getChild(0).addToNextSet(node.getChild(0).getFirstSet());
//                    node.getChild(0).addToNextSet(node.getNextSet());
//                    break;
//                case '|':
//                	node.getChild(0).addToNextSet(node.getNextSet());
//                	node.getChild(1).addToNextSet(node.getNextSet());
//                    break;
//                case '.':
//    				computeEmpty(right);
//                	if (node.getChild(1).isEmpty()){
//                		node.getChild(0).addToNextSet(node.getChild(1).getFirstSet());
//                		node.getChild(0).addToNextSet(node.getNextSet());
//                	}else{
//                		node.getChild(0).addToNextSet(node.getChild(1).getFirstSet());
//                	}
//                	node.getChild(1).addToNextSet(node.getNextSet());
//                    break;
//                case 'ε':
//                    break;
//                default :
//                    assert node instanceof Letter;
//            	}
//    	}
//    }
    static void computeNext(RegexNode node) {
        RegexVisitorVoid nextVisitor = new RegexVisitorVoid() {
        	
            public void visit(Repetition node, RegexNode child) {
            	child.addToNextSet(child.getFirstSet());
            	child.addToNextSet(node.getNextSet());
            }
            
            public void visit(Alternation node, RegexNode left, RegexNode right) {
                left.addToNextSet(node.getNextSet());
                right.addToNextSet(node.getNextSet());
            }
            public void visit(Concatenation node, RegexNode left, RegexNode right) {
            	
            	left.addToNextSet(right.getFirstSet());
            	computeEmpty(right);
            	computeFirst(right);
            	if(right.isEmpty())left.addToNextSet(node.getNextSet());
            	right.addToNextSet(node.getNextSet());
            }
            public void visit(Epsilon node) {
            }
            public void visit(Letter node) {
            }
        };
        node.acceptPre(nextVisitor);
    }

    

    // Kui kõik ülemised funktsioonid on tehtud, siis saab järgmise funktsiooniga automaat ehitatud.
    // Te võite seega selle failis sisu kopeerida Grep.java faili ja esitada ka kodutöö lahendusena.
    public static FiniteAutomaton regexToFiniteAutomaton(RegexNode regex) {
        computeEmpty(regex);
        computeFirst(regex);
        computeLast(regex);
        computeNext(regex);
        return regex.toAutomaton();
    }

    /*
     * Boonus: See meetod peab looma etteantud NFA-le vastava DFA st. etteantud
     * automaat tuleb determineerida.
     * Kui sa seda ei oska, siis jäta see meetod nii, nagu ta on
     */
    public static FiniteAutomaton optimize(FiniteAutomaton automaton) {
        return automaton;
    }
}
