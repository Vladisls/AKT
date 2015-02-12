
import java.util.stream.IntStream;
 
public class Proov {
 
    public static void main(String[] args) {
        int answer = IntStream.range(1, 13).filter(n -> n % 2 == 0).sum();
        System.out.println(answer);
    }
}

