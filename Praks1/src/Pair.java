	
public class Pair <T1, T2> {
	public Pair(T1 fst, T2 snd){
		this.fst = fst;
		this.snd = snd;
	}
	final public T1 fst;
	final public T2 snd;
}

class Demo {
	public static void main(String[] args){
		Pair<Integer, String> paar = new Pair<Integer, String>(3, "Tere");
	}
}