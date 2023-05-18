package generics;

import java.util.*;

public class Example8 {
    public static void main(String[] args) {
        A<String, Integer> objectA = new A<>("Hello", 41);
        objectA.print();

        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1,2,3,4);

        Set<String> strings = new HashSet<>();
        Collections.addAll(strings, "Hello", "java");

        A<List<Integer>, Set<String>> objectB = new A<>(list, strings);
        objectB.print();
    }
}

class A<T, U> {
    private T field1;
    private U field2;

    public A(T field1, U field2) {
        this.field1 = field1;
        this.field2 = field2;
    }

    public void print() {
        System.out.print(field1 + " ");
        System.out.println(field2);
    }
}