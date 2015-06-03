public class FormatMachine {
	final int INI = 0;
	final int SPC = 1;
	final int BGN = 2;
	final int SULG = 3;
	int state = BGN;
	
    public String process(char c) {
    	

    	switch (state){
    	case SULG:
    		if (c == ' ') return "";
    		else state = INI; return "" + c;
    	case BGN:
    		if (c == ' ') return "";
    		else if ( c == '(' ){ state = SULG; return "" + c;} 
    		else if ( c == '\n'){state = BGN; return "" + c;}
    		else state = INI; return "" + c;
    	case INI:
    		if (c == ' ') {state = SPC; return "";}
    		else if ( c == '\n'){ state = BGN; return "" + c;}
    		//else if ( c == '\r'){state = INI; return "" + c;}
    		else if ( c == ',' || c == '!' || c == ':' || c == '?' || c == ';' || c == '.'){ state = SPC; return c + "";}
    		else if (c == '('){state = SULG; return " " + c;}
    		else return "" + c;
    	case SPC:
    		if (c == ' ') return "";
        	else if ( c == ',' || c == '!' || c == ':' || c == '?' || c == ';' || c == '.'){ state = SPC; return c + "";}
        	else if ( c == ')' ){return "" + c;}
        	else if ( c == '\n'){state = BGN; return "" + c;}
        	//else if ( c == '\r'){state = INI; return "" + c;}
        	else if (c == '('){state = SULG; return " " + c;}
        	else state = INI; return " " + c;
    	}
		return null;
    
        
    }
}