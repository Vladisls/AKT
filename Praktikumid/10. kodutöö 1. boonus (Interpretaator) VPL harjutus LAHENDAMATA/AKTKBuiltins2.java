package ee.cs.ut.akt.aktk;
 
import java.util.Scanner;
 
public class AKTKBuiltins2 {
    private static Scanner systemInScanner = null;
 
    public static boolean not(boolean x) {
        return !x;
    }
 
    public static boolean and(boolean a, boolean b) {
        return a && b;
    }
 
    public static boolean or(boolean a, boolean b) {
        return a || b;
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
 
    public static double sin(double x) {
        return Math.sin(x);
    }
 
    /**
     * Astendamine
     */
    public static int power(int x, int n) {
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
    public static int gcd(int a, int b) {
        while(b > 0) {
            int c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
 
}