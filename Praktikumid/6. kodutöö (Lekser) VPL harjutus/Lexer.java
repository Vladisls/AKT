package ee.ut.cs.akt.aktk;
import static ee.ut.cs.akt.aktk.TokenType.*;


 
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
 
public class Lexer {
	
	private static final char TERMINATOR = '\0';
	private final String input;
	private int pos;
 
    public Lexer(String input) {
    	input = input.replaceAll( "//.*|(\"(?:\\\\[^\"]|\\\\\"|.)*?\")|(?s)/\\*.*?\\*/", "$1 " );
        this.input = input + TERMINATOR;
        pos = 0;
    }
 
    public List<Token> readAllTokens() {
    	
    	List<Token> tokens = new ArrayList<>();
    	for (int pos = 0; pos < input.length(); pos++ ){
    		System.out.println(input.charAt(pos));
    		if (input.charAt(pos) == '('){
    			tokens.add(new Token(TokenType.LPAREN));
    		}
    		else if (input.charAt(pos) == ')'){
    			tokens.add(new Token(TokenType.RPAREN));
    		}
    		else if (input.charAt(pos) == '{'){
    			tokens.add(new Token(TokenType.LBRACE));
    		}
    		else if (input.charAt(pos) == '}'){
    			tokens.add(new Token(TokenType.RBRACE));
    		}
    		else if (input.charAt(pos) == '+'){
    			tokens.add(new Token(TokenType.PLUS));
    		}
    		else if (input.charAt(pos) == '-'){
    			tokens.add(new Token(TokenType.MINUS));
    		}
    		else if (input.charAt(pos) == '*'){
    			tokens.add(new Token(TokenType.TIMES));
    		}

    		else if(Character.isLetter(input.charAt(pos)) || input.charAt(pos) == '_'){
    			
    			StringBuilder sb = new StringBuilder();
    			
    			while( Character.isLetter(input.charAt(pos)) || input.charAt(pos) == '_' || Character.isDigit(input.charAt(pos)) || input.charAt(pos) == '\n' ){
    				sb.append(input.charAt(pos));
    				System.out.println(" isL : " + input.charAt(pos));
    				if ( pos < input.length() -1 ){ pos++; }
    			}
    			String found = sb.toString();
    			System.out.println("HERE IT IS : " + found);
    			if (found.equals("while")) {tokens.add(new Token(TokenType.WHILE));}
    			else if (found.equals("if")) {tokens.add(new Token(TokenType.IF));}
    			else if (found.equals("var")) {tokens.add(new Token(TokenType.VAR));}
    			else {tokens.add(new Token(TokenType.VARIABLE, sb.toString()));}
    		}
    		
    		// TODO DIVS !!! IF REPLACE NOT WORK
    		
    		else if (input.charAt(pos) == '+'){
    			tokens.add(new Token(TokenType.PLUS));
    		}
    		
    		else if (Character.isDigit(input.charAt(pos))){
    			StringBuilder sb = new StringBuilder();
    			
    			sb.append(input.charAt(pos));
    			pos++;
    			
    			Boolean deci = false;
    			Boolean added = false;
    			while (Character.isDigit(input.charAt(pos)) || input.charAt(pos) == '.' && !deci){
    				System.out.println(" isD : " + input.charAt(pos));
    				sb.append(input.charAt(pos));
    				if (input.charAt(pos) == '.') deci = true;
    				if (pos < input.length()-1) {pos++;}
    				else {
    					if(!deci) {
    						int integer = Integer.parseInt(sb.toString());
    						tokens.add(new Token(TokenType.INTEGER, integer));
    						pos--;
    					}else{
    						Double double_ = Double.parseDouble(sb.toString());
    						tokens.add(new Token(TokenType.DOUBLE, double_));
    						pos--;
    					}
    					added = true;
    				}
    			}
    			if (!added){
    				if(!deci) {
						int integer = Integer.parseInt(sb.toString());
						tokens.add(new Token(TokenType.INTEGER, integer));
						pos--;
					}else{
						Double double_ = Double.parseDouble(sb.toString());
						tokens.add(new Token(TokenType.DOUBLE, double_));
						pos--;
					}
    			}
    			
    		}
    		
    		
    		else if (input.charAt(pos) == '"'){
    			StringBuilder sb = new StringBuilder();
    			pos++;
    			boolean pass = false;
    			
    			while (input.charAt(pos) == '"' && pass || input.charAt(pos) != '"'){
    				
    				if (input.charAt(pos) == '\\' && input.charAt(pos + 1) == 'n'){
    					sb.append("\n");
    					pos = pos+2;
    				}
    				if (input.charAt(pos) == '\\' && input.charAt(pos + 1) == 't'){
    					sb.append("\t");
    					pos = pos+2;
    				}
    				if (input.charAt(pos) == '\\' && input.charAt(pos + 1) == '"'){
    					sb.append('"');
    					pos = pos+2;
    				}
    				sb.append(input.charAt(pos));
    				if (input.charAt(pos) == '\\'){
    					pass = true;
    				} else pass = false;
    				
    				pos++;
    			}
    			
    			String string = sb.toString();
    			
    			// Fix found from forum
    			string.replaceAll("\\\\n", "\n");
    			string.replaceAll("\\\\t", "\t");
    			string.replaceAll("\\\\", "\\");
    			string.replaceAll("\\\"", "\"");
    			
    			tokens.add(new Token(TokenType.STRING, string));
    					
    		}
    		
    		
    		
    	}
    	System.out.println(tokens);
    	tokens.add(new Token(TokenType.EOF));
    	return tokens;
    }
   
   
 
//    private Token findString() {
//    	StringBuilder sb = new StringBuilder();
//		while (input.charAt(pos) != '"'){
//			sb.append(input.charAt(pos));
//			pos++;
//		}
//		return new Token(TokenType.STRING, sb.toString());
//		
//	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * Boonus
     *
     * Tagasta list, kus lekseemid on pakendatud koos infoga nende paiknemise kohta lähtekoodis
     */
    public List<PositionedToken> readAllPositionedTokens() {
        throw new UnsupportedOperationException();
    }
 
    /**
     * Boonus2
     *
     * Kui Lexer toetab Reader-iga konstruktorit, siis
     * readNextToken-i kasutamisel ei tohiks sisendit lugeda korraga rohkem,
     * kui järgmise lekseemi tuvastamiseks hädapärast tarvis.
     *
     * NB! Arvesta, et Reader-i markSupported() võib tagastada false.
     */
    public Lexer(Reader input) {
        throw new UnsupportedOperationException();
    }
 
    /**
     * See meetod peab olema implementeeritud vaid boonuse saamiseks
     */
    public Token readNextToken() {
        throw new UnsupportedOperationException();
    }
 
}