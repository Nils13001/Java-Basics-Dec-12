import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        ArrayList<Integer> squares = new ArrayList<>();
        numbers.stream()   //created the stream
                .filter(x->x%2==0)  
                .mapToInt(x->x*x) 
                .forEach(squares::add);
        System.out.println(numbers);
        System.out.println(squares);
    }
}