import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample2 {
    public static void main(String[] args) {
        // вытащить название улиц + номера домов

        String[] addresses = {
                "Ständehausstraße 1, 40217 Düsseldorf",
                "Schulstraße 4, 40213 Düsseldorf",
                "Jacobistraße 2, 40211 Düsseldorf",
                "Jägerhofstraße 1, 40479 Düsseldorf",
                "Birkenstraße 47a, 40233 Düsseldorf"};

        long[] ex1 = new long[10];
        long[] ex2 = new long[10];
        long[] ex3 = new long[10];
        long[] ex4 = new long[10];

        // test example1
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            example1(addresses);
            long finish = System.nanoTime();
            ex1[i] = finish - start;
        }

        System.out.println(
                "Avg = " + getAvg(ex1) +
                "; AvgMinusFirst = " + getAvgMinusFirst(ex1) +
                "; Ex1 results = " + Arrays.toString(ex1)
        );

        // test example2
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            example2(addresses);
            long finish = System.nanoTime();
            ex2[i] = finish - start;
        }

        System.out.println(
                "Avg = " + getAvg(ex2) +
                        "; AvgMinusFirst = " + getAvgMinusFirst(ex2) +
                        "; Ex1 results = " + Arrays.toString(ex2)
        );

        // test example3
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            example3(addresses);
            long finish = System.nanoTime();
            ex3[i] = finish - start;
        }

        System.out.println(
                "Avg = " + getAvg(ex3) +
                        "; AvgMinusFirst = " + getAvgMinusFirst(ex3) +
                        "; Ex1 results = " + Arrays.toString(ex3)
        );

        // test example4
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            example4(addresses);
            long finish = System.nanoTime();
            ex4[i] = finish - start;
        }

        System.out.println(
                "Avg = " + getAvg(ex4) +
                        "; AvgMinusFirst = " + getAvgMinusFirst(ex4) +
                        "; Ex1 results = " + Arrays.toString(ex4)
        );
    }

    public static double getAvg(long[] q) {
        return (double) Arrays.stream(q).sum() / q.length;
    }

    public static double getAvgMinusFirst(long[] q) {
        return (double) (Arrays.stream(q).sum() - q[0]) / (q.length - 1);
    }


    // Pattern & Matcher
    public static void example1(String[] input) {

        Pattern pattern = Pattern.compile(",");
        List<String> clearAddress = new ArrayList<>();

        for (String s : input) {
            Matcher matcher = pattern.matcher(s);
            while (matcher.find())
                clearAddress.add(s.substring(0, matcher.end() - 1));
        }

//        System.out.println(clearAddress);
    }

    public static void example2(String[] input) {
//        Pattern pattern1 = Pattern.compile("straße");
        Pattern pattern2 = Pattern.compile("Düsseldorf");

        List<String> clearAddress = new ArrayList<>();

        for (String s : input) {
            // первая попытка вытащить адрес:
//            Matcher matcher1 = pattern1.matcher(s);
//            while (matcher1.find())
//                clearAddress.add(s.substring(0, matcher1.end()));

            Matcher matcher2 = pattern2.matcher(s);
            while (matcher2.find())
                clearAddress.add(s.substring(0, matcher2.start() - 8));
        }

//        System.out.println(clearAddress);
    }

    public static void example3(String[] input) {
        List<String> clearAddress = new ArrayList<>();

        for (String s : input) {
//            String[] tmp = s.split(", "); // разбитие строки по шаблону == "," => [Ständehausstraße 1, 40217 Düsseldorf]
//            String str = tmp[0];               // берем нулевой элемент массива строк => Ständehausstraße 1
//            clearAddress.add(str);             // упаковываем элемент в коллекцию

            // более компактный способ записи
            clearAddress.add(s.split(",")[0]);
        }

//        System.out.println(clearAddress);
    }

    public static void example4(String[] input) {
        List<String> clearAddress = new ArrayList<>();

        for (String s : input)
            clearAddress.add(s.substring(0, s.length() - 18));

//        System.out.println(clearAddress);
    }
}
