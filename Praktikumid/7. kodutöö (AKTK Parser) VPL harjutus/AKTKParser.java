package ee.ut.cs.akt.parser;

import ee.ut.cs.akt.ast.BinOp;
import ee.ut.cs.akt.ast.ExprNode;
import ee.ut.cs.akt.ast.IntLiteral;
import ee.ut.cs.akt.ast.Variable;
import ee.ut.cs.akt.lekser.Lexer;
import ee.ut.cs.akt.lekser.PositionedToken;
import ee.ut.cs.akt.lekser.TokenType;

import static ee.ut.cs.akt.lekser.TokenType.*;

public class AKTKParser {

    private Lexer lex;
    private PositionedToken current;

    public AKTKParser(Lexer lex) {
        this.lex = lex;
    }

    private void consume() {
        if (peek() == EOF) {
            // Korrektne parser ei tohiks siia jõuda.
            throw new AssertionError("Reading passed terminator!");
        }
        read();
    }

    private void read() {
        current = lex.readNextPositionedToken();
    }

    private TokenType peek() {
        if (current == null) read();
        return current.getToken().getType();
    }

    private void match(TokenType t) {
        if (peek() != t) throw new AKTKParseException(current, t);
        consume();
    }

    public ExprNode parse() {
        ExprNode result = avaldis();
        if (peek() != EOF) {
            throw new AKTKParseException(current, EOF);
        }
        return result;
    }

    public static ExprNode parse(String input) {
        Lexer lex = new Lexer(input);
        AKTKParser parser = new AKTKParser(lex);
        return parser.parse();
    }
    
    private ExprNode recognise(){
    	
    	final int start = 0;
        final int intVar = 1;
        final int plusMinus = 4;
//        final int timesDiv = 5;
        
        int state = start;
//        int parens = 0;
        
        
        while ( true ) {
 
        	// Starting point
            if ( current == null ) {
                    read();
            }
 
            	
            // Handle EOF
//            else if ( current.getToken().getType() == EOF ) {
//                    if ( parens == 0 && state != timesDiv && state != plusMinus ) {
//                            return null;
//                    } else {
//                            throw new AKTKParseException(current, EOF);
//                    }
//            }
            
            
            // Handling BinOp1
            
//            else if ( current.getToken().getType() == INTEGER || current.getToken().getType() == VARIABLE ) {
//                    
//            		//can't have 2 in a row
//            		if ( state == intVar ) {
//                            throw new AKTKParseException(current, EOF);
//                    }
//                    state = intVar;
//                    read();
//            }
            
            // Handling BinOp2
            else if (current.getToken().getType() == MINUS || current.getToken().getType() == TokenType.PLUS) {
                    if (state == intVar) {
                            state = plusMinus;
                            read();
 
                    } else {
                        throw new AKTKParseException(current, EOF);
                    }
            }
            
            // Handling parens
//            else if ( current.getToken().getType() == LPAREN ) {
//            		if ( state == start || state == plusMinus || state == timesDiv ){
//            			parens += 1;
//            			read();
//            			state = start;
//            			continue;
//            			}
//            		else {
//            			// Do nothing
//            			}
//            }
 
//            else if ( current.getToken().getType() == TokenType.RPAREN ) {
//                    parens = parens - 1;
//                    if ( parens < 0 ){
//                    	System.out.println("Parens not opened");
//                        throw new AKTKParseException(current, (TokenType) null);
//                    }
//                    read();
//                    state = start;
//            }
// 
            // Handling Times&Divs
//            else if ( current.getToken().getType() == DIV || current.getToken().getType() == TIMES ) {
//                    
//            		//can't have 2 in a row
//            		if ( state == start || state == plusMinus || state == timesDiv ) {
//                            throw new AKTKParseException(current, EOF);
//                    }
//                    state = timesDiv;
//                    read();
//            }
        }
    }
    
    private ExprNode factor() {
        
    	ExprNode token = null;
        switch (peek()) {
            case VARIABLE:
                token = new Variable((String) current.getToken().getData());
                match(VARIABLE);
                	break;
            case INTEGER:
                token = new IntLiteral(Integer.parseInt(current.getToken().getData().toString()));
                match(INTEGER);
                	break;
            case LPAREN:
                match(LPAREN);
                token = avaldis();
                match(RPAREN);
                	break;
            default:
            	// Writing recognise was pointless :D Should have had started from avaldis()
                recognise();
        }
 
        return token;
    }
    
    private ExprNode term() {
        ExprNode leftNode = factor();
        while ( peek() == DIV || peek() == TIMES){
            TokenType token = current.getToken().getType();
            consume();
            ExprNode rightNode = factor();
            leftNode = new BinOp(token, leftNode,rightNode);
        }
        return leftNode;
    }
    
    private ExprNode avaldis() {
        
        //recognise();
    	ExprNode leftNode = term();
        while ( peek() == PLUS || peek() == MINUS ) {
            TokenType token = current.getToken().getType();
            consume();
            ExprNode rightNode = term();
            leftNode = new BinOp(token, leftNode, rightNode);
        }
        return leftNode;
    }
 
    
}