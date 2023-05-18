import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Stream;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Consumer<List<Integer>> consumer = (x) -> x.forEach(y -> System.out.print((y * 2) + " "));
        Consumer<String> consumerStr = (x) -> System.out.println(x.toUpperCase());

//        consumer.accept(Arrays.asList(11,5,3));
//        System.out.println();
//        consumerStr.accept("java");

        BiConsumer<String, String> biConsumer = (x,y) -> System.out.println("teams: " + x + ", result: " + y);
//        biConsumer.accept("BVB, Duisburg", "1:2");

        DoubleConsumer doubleConsumer = (x) -> System.out.println("PI value is = " + x);
//        doubleConsumer.accept(3.14);


        Predicate<Integer> predicate = (x) -> x < 25;
        List<Integer> a = Arrays.asList(11,21,3,5,8,11,3);
//        a.stream().map(x -> x*2).forEach((x) -> System.out.print(x + " "));
//        System.out.println();
//        a.stream().map(x -> x * 2).filter(predicate).forEach((x) -> System.out.print(x + " "));
//        System.out.println();

        BiPredicate<Integer, Integer> biPredicate = (x1, x2) -> (x1 * x2) < 25;

        double sigmoidDouble = 1 / (1 + Math.pow(Math.E, (-1) * 100));

        Function<Integer, Double> function = (x) -> Math.pow(x, 2);
//        System.out.println(function.apply(8));

        Function<Double, Double> sigmoidFunction = (x) -> 1 / (1 + Math.pow(Math.E, (-1) * x));
//        System.out.println(sigmoidFunction.apply(-10.0));

        UnaryOperator<Integer> unaryOperator = (x) -> x * 10;
//        System.out.println(unaryOperator.apply(20));

        Supplier<Double> supplier = () -> Math.random();
//        Supplier<Double> supplier = Math::random;
//        System.out.println(supplier.get());

        // 0 1 1 2 3 5 8 11 ..
        int[] f = {0, 1};

        Supplier<Integer> supplierFibonacci = () -> {
            int result = f[0];
            int f3 = f[0] + f[1];
            f[0] = f[1];
            f[1] = f3;

            return result;
        };

//        Stream<Integer> sequenceFibo = Stream.generate(supplierFibonacci);
        Stream<Integer> sequenceFibo = Stream.generate(
                () -> {
                    int result = f[0];
                    int f3 = f[0] + f[1];
                    f[0] = f[1];
                    f[1] = f3;

                    return result;
                }
        );
        System.out.println(sequenceFibo.limit(10).toList());

    }
}


// SAM - single abstract method interfaces
@FunctionalInterface
interface T {
    void print();

    default void getResult() {
        System.out.println("Result is ");
    }

    static void getWeather() {
        System.out.println("Weather");
    }

    default void getResult1() {
        System.out.println("Result is ");
    }

    static void getWeather1() {
        System.out.println("Weather");
    }
}