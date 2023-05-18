package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Example7 {

    static int count = 0;

    // Arrays.asList / List.of / Collections.addAll
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        testMethod2(stringList, new Car("bmw"), new Car("audi"));
        System.out.println(stringList);



        // Object casting
//        List<Integer> integerList = new ArrayList<>();
//        testMethod(integerList, "q", "w", 2);
//        System.out.println(integerList);
    }

    public static void example1() {
        // todo
        List<String> stringList = new ArrayList<>();
        testMethod(stringList, "hello", "java", "it's", "qa_41m");
        System.out.println(stringList);

        List<Integer> integerList = new ArrayList<>();
        testMethod(integerList, 1,2,3,4,5,6,7,8,9,0);
        System.out.println(integerList);

        List<Car> carList = new ArrayList<>();
        testMethod(carList, new Car("bmw"), new Car("audi"), new Car(null));
        System.out.println(carList);

    }

    public static void getSmallDescriptionVarArgs() {
//        int sum = 0;
//
//        int[] tmp = testMethod(2,5,6,7);
//
//        for (int i = 0; i < tmp.length; i++) {
//            sum += tmp[i];
//        }
//
//        System.out.println(sum);


        int[] q = {1,2,3,4};
//        System.out.println(Arrays.toString(testMethod(1,2,3,4)));
//        System.out.println(Arrays.toString(testMethod(q)));

        // примеры где применяются Arrays.asList / List.of / Collections.addAll
        // 1
//        List<Integer> list = Arrays.asList(1, 2, 3, 4);
//        System.out.println(list);

        // 2
        List<int[]> list1 = Arrays.asList(q);
//        System.out.println(Arrays.toString(list1.get(0))); // так не надо

        // 3
        List<Integer> integers = List.of(1, 2, 3, 4);
        List<int[]> q1 = List.of(q);

        List<Integer> integerList = new ArrayList<>();
        Collections.addAll(integerList, 0,6,8,9,0);
        System.out.println(integerList);
    }

    public static <T> void testMethod(List<T> list, T... args) {
        Collections.addAll(list, args);
    }

    public static <U> void testMethod2(List<String> list, U... args) {
        for (U element : args) {
            list.add(element.toString());
        }
    }

//    public static Integer[] testMethod(Integer... a) {
//        System.out.println(count++);
//        for (int i = 0; i < a.length; i++) {
//            System.out.println("\t" + (a[i] * 10));
//        }
//
//        return a;
//    }

//    public static int[][] testMethod(int[]... a) {
//        System.out.println(count++);
////        for (int i = 0; i < a.length; i++) {
////            System.out.println("\t" + (a[i] * 10));
////        }
//        return a;
//    }
}

class Car {
    private String model;

    public Car(String model) {
        if (model != null)
            this.model = model;
        else
            this.model = "default model";
    }

    @Override
    public String toString() {
        return "{Car model: " + model.toUpperCase() + "}";
    }
}