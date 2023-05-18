import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaExamples {
    public static void main(String[] args) {
//        (a,b) -> System.out.println("hello java");

        List<Integer> a = Arrays.asList(11,21,3,5,8,11,3);
        System.out.print("Original list: ");
        a.forEach((n) -> System.out.print(n + " "));
//        a.forEach(System.out::println);
        System.out.println();

        System.out.print("Original list with map & forEach: ");
        a.stream()
                .map((x) -> x*2)
                .forEach((x) -> System.out.print(x + " "));

        System.out.println();
        System.out.print("Original list with map, filter & forEach: ");
        a.stream()
                .map((x) -> x*2)
                .filter((x) -> x < 25)
                .forEach((x) -> System.out.print(x + " "));

        System.out.println();
        System.out.print("Distinct example: ");
        a.stream().distinct().forEach((x) -> System.out.print(x + " "));

        System.out.println();
        System.out.println("Count: " + a.stream().count());

        System.out.println("Reduce exampel (sum) = " + a
                .stream()
//                .reduce((x,y) -> x + y)
                .reduce(Integer::sum)
                .get()
        );

        System.out.println("Max value: " + a
                .stream()
//                .max((x,y) -> Integer.compare(x,y))
                .max(Integer::compare)
                .get()
        );

        System.out.println("Min value: " + a
                .stream()
//                .min((x,y) -> Integer.compare(x,y))
                .min(Integer::compare)
                .get()
        );


        a.stream().limit(3).forEach(x-> System.out.print(x + " "));
        System.out.println();
        a.stream().skip(3).forEach(x-> System.out.print(x + " "));

        System.out.println();

        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1,2,3));
        list.add(Arrays.asList(4,5,6));
        list.add(Arrays.asList(7,8,9));

        System.out.println(list);

        list
                .stream()
                .parallel()
//                .flatMap(x -> x.stream())
                .flatMap(Collection::stream)
                .map(x -> x * 2)
                .forEach(x -> System.out.print(x + " ")
                );

    }

    public static List<Integer> mult2(List<Integer> list) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++)
            result.add(list.get(i)*2);
        return result;
    }
}
