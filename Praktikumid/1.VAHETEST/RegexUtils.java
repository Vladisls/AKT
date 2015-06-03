package ee.ut.cs.akt.regex;

public class RegexUtils {
	
	public static String prettyPrint(RegexNode node) {
		if (node instanceof Letter){
			return String.valueOf(((Letter) node).getSymbol());
		}else if (node instanceof Epsilon){
			return "ε";
		}else if  (node instanceof Concatenation){
			String tmp = prettyPrint(((Concatenation) node).getLeft())+""+prettyPrint(((Concatenation) node).getRight());
			return tmp;
		}else if  (node instanceof Alternation){
			String tmp = prettyPrint(((Alternation) node).getLeft())+"|"+prettyPrint(((Alternation) node).getRight());
			return tmp;
		}else if  (node instanceof Repetition){
			String tmp = "(" + prettyPrint(((Repetition) node).getChild())+ ")" +"*";
			return tmp;
		}else return "";
			
	}
}
