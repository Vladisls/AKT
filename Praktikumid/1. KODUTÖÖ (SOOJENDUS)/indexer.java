import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class indexer {
	
	public static int find(ArrayList<String> arrayList){
		int index = -1;
		for (int i=0; i < arrayList.size(); ++i){
			
			if (arrayList.get(i).equals("*")){index = i;} 

		}
		return index;
    }
	
	public static ArrayList<String> liitja(ArrayList<String> arrayList){
		while (arrayList.size() > 1){
			int a = Integer.parseInt(arrayList.get(0));
			int b = Integer.parseInt(arrayList.get(2));
			int sum = 0;
			if ( arrayList.get(1).equals("+")){ sum = a+b;}
			if ( arrayList.get(1).equals("-")){ sum = a-b;}
			arrayList.remove(0);
			arrayList.remove(0);
			arrayList.set(0, Integer.toString(sum));
		}
		return arrayList;
	}

}


