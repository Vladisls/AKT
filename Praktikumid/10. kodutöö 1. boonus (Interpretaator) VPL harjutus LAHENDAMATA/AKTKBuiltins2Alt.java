package ee.cs.ut.akt.aktk;
 
import java.util.Scanner;
 
public class AKTKBuiltins2Alt {
    private static Scanner systemInScanner = null;
 
    public static Integer not(Integer x) {
        return ~x;
    }
 
    public static Integer and(Integer a, Integer b) {
        return a & b;
    }
 
    public static Integer or(Integer a, Integer b) {
        return a | b;
    }
 
 
    public static void print(Object value) {
        System.out.println(value);
    }
 
    /**
     * Töötab umbes nagu Pythoni input
     */
    public static String input(String prompt) {
        System.out.print(prompt);
 
        if (systemInScanner == null) {
            systemInScanner = new Scanner(System.in);
        }
 
        return systemInScanner.nextLine().replaceAll("\\r", "").replaceAll("\\n", "");         
    }
 
    public static String input() {
        return input("");
    }
 
    public static String upper(String s) {
        return s.toUpperCase();
    }
 
    public static String lower(String s) {
        return s.toLowerCase();
    }
 
    public static Double sin(Double x) {
        return Math.sin(x);
    }
 
    /**
     * Astendamine
     */
    public static Integer power(Integer x, Integer n) {
        if (n < 0) {
            throw new IllegalArgumentException("Ainult mittenegatiivne astendaja on lubatud");
        }
 
        int result = 1;
        while (n > 0) {
            result *= x;
            n--;
        }
        return result;
    }
 
    /**
     * Suurim ühistegur
     */
    public static Integer gcd(Integer a, Integer b) {
        while(b > 0) {
            int c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
 
}