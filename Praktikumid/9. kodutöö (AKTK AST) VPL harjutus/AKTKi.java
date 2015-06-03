import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ee.ut.cs.akt.aktk.ast.Assignment;
import ee.ut.cs.akt.aktk.ast.AstNode;
import ee.ut.cs.akt.aktk.ast.Block;
import ee.ut.cs.akt.aktk.ast.Expression;
import ee.ut.cs.akt.aktk.ast.ExpressionStatement;
import ee.ut.cs.akt.aktk.ast.FloatingPointLiteral;
import ee.ut.cs.akt.aktk.ast.FunctionCall;
import ee.ut.cs.akt.aktk.ast.IfStatement;
import ee.ut.cs.akt.aktk.ast.IntegerLiteral;
import ee.ut.cs.akt.aktk.ast.Statement;
import ee.ut.cs.akt.aktk.ast.StringLiteral;
import ee.ut.cs.akt.aktk.ast.Variable;
import ee.ut.cs.akt.aktk.ast.VariableDeclaration;
import ee.ut.cs.akt.aktk.ast.WhileStatement;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import antlrgen.AKTKLexer;
import antlrgen.AKTKParser;
import antlrgen.AKTKParser.ArvuliteraalRContext;
import antlrgen.AKTKParser.FunktsiooniValjakutseContext;
import antlrgen.AKTKParser.IfLauseContext;
import antlrgen.AKTKParser.KorrutamineJagamineContext;
import antlrgen.AKTKParser.LauseContext;
import antlrgen.AKTKParser.LauseteJadaContext;
import antlrgen.AKTKParser.LiitmineLahutamineContext;
import antlrgen.AKTKParser.MuutujaDeklaratsioonContext;
import antlrgen.AKTKParser.MuutujaNimiRContext;
import antlrgen.AKTKParser.OmistamineContext;
import antlrgen.AKTKParser.SoneliteraalRContext;
import antlrgen.AKTKParser.SuluavaldisContext;
import antlrgen.AKTKParser.UnaarneMiinusContext;
import antlrgen.AKTKParser.VordlemineContext;
import antlrgen.AKTKParser.WhileLauseContext;
 
public class AKTKi {

	public static AstNode createAst(String program) {
        // Erindi viskamine tuleb asendada reaalse implementatsiooniga
        ParseTree tree = createParseTree(program);
        AstNode astNode = parseTreeToAst(tree);
        return astNode;
    }
    
    private static ParseTree createParseTree(String program) {
        ANTLRInputStream antlrInput = new ANTLRInputStream(program);
        AKTKLexer lexer = new AKTKLexer(antlrInput);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        AKTKParser parser = new AKTKParser(tokens);
        ParseTree tree = parser.programm();
        // System.out.println(tree.toStringTree(parser));
        return tree;
    }
    
    private static AstNode block(LauseteJadaContext lauseteJadaContext){
    	List<Statement> statements = new ArrayList<>();
    	for ( int i = 0; i< lauseteJadaContext.getChildCount(); i += 2){
    		statements.add((Statement) parseTreeToAst(lauseteJadaContext.getChild(i)));
    	}
    	return new Block(statements);
	}
	
    private static AstNode parseTreeToAst(ParseTree tree) {
    	 
        if (tree instanceof ArvuliteraalRContext) {
            if (tree.getText().contains(".")) {
                return new FloatingPointLiteral(Double.parseDouble(tree.getText()));
            }
            else {
                return new IntegerLiteral(Integer.parseInt(tree.getText()));
            }
        }
        
        
        else if (tree instanceof SoneliteraalRContext) {
            return new StringLiteral(tree.getText().substring(1, tree.getText().length()-1));
        }
        
        
        else if (tree instanceof SuluavaldisContext) {

            return parseTreeToAst(tree.getChild(1));
        }
        
        
        else if (tree instanceof KorrutamineJagamineContext
                || tree instanceof LiitmineLahutamineContext
                || tree instanceof VordlemineContext) {
            String operaator = tree.getChild(1).getText();
            Expression vasakArgument = (Expression) parseTreeToAst(tree.getChild(0));
            Expression paremArgument = (Expression) parseTreeToAst(tree.getChild(2));
     
            return new FunctionCall(operaator, Arrays.asList(vasakArgument, paremArgument));
        }
        
        
        else if (tree instanceof MuutujaDeklaratsioonContext) {
            // Muutuja deklaratsiooni esimene alluv (st. alluv 0) on võtmesõna "var",
            // teine alluv on muutuja nimi
     
            // Algväärtus võib olla, aga ei pruugi.
            // Kontrolli ANTLRi IntelliJ pluginaga järgi, mitu alluvat
            // on muutuja deklaratsioonil, millel on algväärtus ja mitu
            // alluvat on sellel, millel algväärtust pole.
        	String muutujaNimi = tree.getChild(1).getText();
        	Expression avaldis = null;
        	
        	if (tree.getChildCount() >= 4){
        		avaldis = (Expression) parseTreeToAst(tree.getChild(3));
        	}
            return new VariableDeclaration(muutujaNimi,avaldis);
        }
        
        
        else if (tree instanceof LauseContext) {
            // grammatikast on näha, et lause võib olla ühe alluvaga,
            // (nt. ifLause, whileLause), mis on käsitletud mujal
            if (tree.getChildCount() == 1) {
                AstNode child = parseTreeToAst(tree.getChild(0));
                // ainuke asi mida tuleb jälgida,
                // on see, et kui lause koosneb avaldisest, siis selleks,
                // et temast saaks ikkagi lause,
                // tuleb ta pakendada ExpressionStatement'i sisse
                if (child instanceof Expression) {
                    return new ExpressionStatement((Expression) child);
                }
                else {
                    return child;
                }
            }     
            // ... aga lause võib olla ka loogelistes sulgudes olev lausete jada
            else {
                assert tree.getChildCount() == 3;
                return parseTreeToAst(tree.getChild(1));
            }
        }
        
        else if (tree instanceof  MuutujaNimiRContext){
            return new Variable(tree.getText());
        }
        
        
        else if (tree instanceof IfLauseContext){
        		Expression condition = (Expression) parseTreeToAst(tree.getChild(1));
        		Statement thenBranch = (Statement) parseTreeToAst(tree.getChild(3));
        		Statement elseBranch = null;
        		if (tree.getChildCount() >= 5) elseBranch = (Statement) parseTreeToAst(tree.getChild(5));
        		
            return new IfStatement(condition, thenBranch, elseBranch);
        }    
        
        else if (tree instanceof WhileLauseContext){
        		Expression condition = (Expression) parseTreeToAst(tree.getChild(1));
        		Statement whileBranch = (Statement) parseTreeToAst(tree.getChild(3));
            return new WhileStatement(condition, whileBranch);
        }
        
        else if (tree instanceof UnaarneMiinusContext){
        		Expression arg = (Expression) parseTreeToAst(tree.getChild(1));
            return new FunctionCall("-", Arrays.asList(arg)) ;
        }
        
        else if (tree instanceof OmistamineContext){
        		String muutujaNimi = tree.getChild(0).getText();
        		Expression avaldis = (Expression) parseTreeToAst(tree.getChild(2));
        		return new Assignment(muutujaNimi, avaldis);
        }
        
        else if (tree instanceof LauseteJadaContext) {
            return block((AKTKParser.LauseteJadaContext) tree);
        }
        
        else if (tree instanceof FunktsiooniValjakutseContext){
        	String funktsioon = tree.getChild(0).getText();
        	List<Expression> argument = new ArrayList<Expression>();
        	if ( tree.getChildCount() > 3){
        		for (int i=2; i < tree.getChildCount(); i += 2){
        				argument.add((Expression) parseTreeToAst(tree.getChild(i)));
        		}
        		
        	}
        	return new FunctionCall(funktsioon, argument);
        }
        else {
            // Järele peaks olema jäänud (kui sa lisasid ülespoole ka puuduvad olulised juhtumid)
            // ainult need tiputüübid, millel on ainult
            // üks alluv ja mis olid olulised vaid parsimise jaoks.
            // Järelikult meil pole abstraktsesse süntaksipuusse neile vastavaid
            // tippe tarvis ja me liigume kohe nende alluva juurde
            return parseTreeToAst(tree.getChild(0));
        }
    }
}