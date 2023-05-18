package generics;

import java.util.ArrayList;
import java.util.List;

// это не самый безопасный путь, не стоит использовать в production
public class Example1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("Java");
        list.add("qa_41m");
        list.add(String.valueOf(1));

        for (String e : list)
            System.out.println(e.toUpperCase());
    }

    public static void example3() {
        List list = new ArrayList();
        list.add("Java");

        String tmp = list.get(0) + "";// + " and generics!";

        System.out.println(tmp);
    }

    public static void example2() {
        // автоматическое приведение типов (расширение)
        // byte -> short -> int -> long -> float -> double

//        float e = 5.5F;
//        double r = e;
//
//        System.out.println(e);
//        System.out.println(r);

//        double q = 9.5;
//        int w = (int) q;
//
//        System.out.println(q);
//        System.out.println(w);

//        Book a = new Book();
//        Object b = a;

//        System.out.println(a);


        List q = new ArrayList();

        q.add("Java");
        q.add(1);

        for (Object element : q)
//            System.out.println((String) element); // работать не будет из-за приведение типов
            System.out.println(element);
    }

    public static void example1() {
        List list = new ArrayList();

        list.add("Hello");
        list.add("java");
        list.add(1);
        list.add(2.5);
        list.add(true);

        System.out.println(list);
    }
}

class Book {

}