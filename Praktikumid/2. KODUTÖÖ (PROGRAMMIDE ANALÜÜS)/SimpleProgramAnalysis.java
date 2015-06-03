import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.DoStatement;
import org.eclipse.jdt.core.dom.EnhancedForStatement;
import org.eclipse.jdt.core.dom.ExpressionStatement;
import org.eclipse.jdt.core.dom.ForStatement;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.WhileStatement;

import ee.ut.cs.akt.JavaASTUtils;

public class SimpleProgramAnalysis {
	
	static int c = 0;
 
    /**
     * See meetod peab ütlema (tagastama), kas antud Java programmis
     * esineb mõni ühetäheline nimi. Loeme praegu nimedeks kõiki süntaksipuu tippe,
     * mille tüüp on SimpleName.
     *
     * Korrektne lahendus annab 6 punkti
     */
    public static boolean hasOneLetterNames(String javaSourceCode) {

        ASTNode juurtipp = JavaASTUtils.parseCompilationUnit(javaSourceCode);
        Set<String> names = new HashSet<>();
        collectNames(juurtipp, names);
 
        for (String name : names) {
            System.out.println(name);
            if (name.length() == 1){return true;}
        }
        return false;
    }
    private static void collectNames(ASTNode node, Set<String> names) {
        if (node instanceof SimpleName) {
            names.add(((SimpleName) node).getIdentifier());
        }
        for (ASTNode child : JavaASTUtils.getChildNodes(node)) {
            collectNames(child, names);
        }
    }
 
    /**
     * See meetod peab tagastama mitu korda esineb programmis else-võtmesõna.
     * NB! Sõneliteraalides või kommentaarides esinevaid else-sid ei loe me võtmesõnadeks
     *
     * Vihje: else saab Javas esineda vaid if-lause (IfStatement) koosseisus
     *
     * Korrektne lahendus annab 2 punkti
     */
    public static int numberOfElseKeywords(String javaSourceCode) {
        // TODO: asenda erind enda lahendusega
    	
    	ASTNode juurtipp = JavaASTUtils.parseCompilationUnit(javaSourceCode);
        Set<IfStatement> names = new HashSet<>();
        collectNames2(juurtipp, names);
        int c = 0;
        
        for(IfStatement name: names){
            if(((IfStatement) name).getElseStatement()!=null){
                c++;
            }
        }
        
        return c;
    }
 
    private static void collectNames2(ASTNode juurtipp, Set<IfStatement> names) {
		
    	if (juurtipp instanceof IfStatement) {
        	names.add(((IfStatement) juurtipp));
        	}
        for (ASTNode child : JavaASTUtils.getChildNodes(juurtipp)) {
            collectNames2(child, names);
        }
	}
    
	/**
     * See meetod peab tagastama täisarvu, mis näitab mitu tsüklit
     * (while, do-while või mingi for-i variant) asuvad antud programmis
     * mõne teise tsükli sees
     *
     * Korrektne lahendus annab 2 punkti
     *
     * Vihje: Huvipakkuvad tiputüübid on WhileStatement, ForStatement,
     *        EnhancedForStatement ja DoStatement
     */
    public static int numberOfNestedLoops(String javaSourceCode) {
    	ASTNode node = JavaASTUtils.parseCompilationUnit(javaSourceCode);
        ArrayList<Integer> names = new ArrayList<Integer>();
        collectLoops(node, names, false);
        System.out.println(names.size());
        return (collectLoops(node, names, false));
    }
    
    private static int collectLoops(ASTNode node, ArrayList<Integer> names, 
    		boolean onSees){

    	if (node instanceof WhileStatement 
    			|| node instanceof ForStatement 
    			|| node instanceof EnhancedForStatement 
    			|| node instanceof DoStatement
    			|| node instanceof ExpressionStatement) {
    		System.out.println("here??" + onSees);
    		if(onSees){
    			System.out.println("SIIN");
    			c = c + 1;
    		}
	    	for (ASTNode child : JavaASTUtils.getChildNodes(node)) {
	            collectLoops(child, names, true);
    		}
    	}else	{for (ASTNode child : JavaASTUtils.getChildNodes(node)) {
            collectLoops(child, names, onSees);
        }}
    	//System.out.println(c);
    	return c/2;
    	
    }
    

	/**
     * NB! Viimane ülesanne on kõige raskem ja on mõeldud boonusena.
     * Varu aega ja kannatust!
     *
     * See meetod peab tagastama täisarvu, mis näitab mitu muutujadeklaratsiooni
     * on antud programmis kasutud, st. mitmel juhul on (lokaalne) muutuja deklareeritud
     * ilma, et teda selles meetodis hiljem kasutataks
     *
     * Kuigi Java skoobisüsteem lubab ühes meetodis deklareerida mitu erinevat samanimelist
     * muutujat, võib praegu lihtsuse mõttes eeldada, et erinevaid samanimelisi muutujaid
     * ei esine. Samuti võib eeldada, et klassis ei esine välja ega meetodi nimesid, mis langevad
     * kokku mõne muutuja nimega.
     *
     * Parameetreid ega klassi- isendivälju me siin lokaalsete muutujate hulka ei loe
     * (jah, harilikult loetakse ka meetodi parameetrid lokaalseteks muutujateks, aga lihtsuse
     * mõttes praegu me neid ei arvesta).
     *
     * Korrektne lahendus annab 1 (boonus)punkti
     */
    public static int numberOfUnusedVariables(String javaSourceCode) {
        // TODO: asenda erind enda lahendusega
        throw new UnsupportedOperationException();
 
    }
 
}