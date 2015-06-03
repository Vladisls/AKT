import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AKTKi {
	
public static void main(String[] args) throws Exception {
		
	    String content = new String(Files.readAllBytes(Paths.get(args[0])));
	    String[] parts = content.replaceAll("\\s+","").split("(?=[-+*/()])|(?<=[^-+*/][-+*/])|(?<=[()])");
	    ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(parts));
	    
	    
	    Map<String, String> muutujad = new HashMap<String, String>();
		for (int i=1 ; i < args.length -1; i= i+2){
			muutujad.put(args[i].toString(), args[i+1].toString());
		}
		
		for(int i=0; i<arrayList.size(); ++i){
			if(muutujad.containsKey(arrayList.get(i)) ){
				arrayList.set(i, (muutujad.get(arrayList.get(i))).toString()    );
			} 
		}
	    while (indexer.find(arrayList) != -1){
	    	int index = indexer.find(arrayList);
		    int a = Integer.parseInt(arrayList.get(index-1)); 
		    int b = Integer.parseInt(arrayList.get(index+1)); 
		    

		    String mp = Integer.toString(a * b);
		    arrayList.remove(index-1);
		    arrayList.set(index-1, mp);
		    arrayList.remove(index);}
	    
	    //System.out.println(arrayList.toString());
	    System.out.println(indexer.liitja(arrayList).get(0));
		 
		   
	   }
	}
	
	

