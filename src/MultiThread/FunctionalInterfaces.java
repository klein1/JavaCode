package MultiThread;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Function<String, String> function = str -> str;
        System.out.println(function.apply("Function"));

        Predicate<String> predicate = str -> str.isEmpty();
        System.out.println(predicate.test(""));

        Consumer<String> consumer = str -> System.out.println(str) ;
        consumer.accept("Consumer");

        Supplier<String> supplier = () -> "Supplier";
        System.out.println(supplier.get());

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        list.stream().filter(i->i>2).map(i->i+1).sorted((a,b)->b.compareTo(a)).limit(3).forEach(System.out::println);

    }
}
