package generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Example9 {

    // стирание типов

    public static void main(String[] args) {
        ArrayList<Integer> integerList = new ArrayList<>();
        Collections.addAll(integerList, 1,2,3,4);
        System.out.println(integerList.get(0).getClass());

        ArrayList<String> stringList = new ArrayList<>();
        Collections.addAll(stringList, "hello", "java");
        System.out.println(stringList.get(0).getClass());

        // компилятор ещё понимает разницу в параметризации
//        ArrayList<Integer> test = new ArrayList<String>();
//        integerList = stringList;

        System.out.println("-----");
        System.out.println(integerList.getClass());
        System.out.println(stringList.getClass());

        if (integerList.getClass() == stringList.getClass())
            System.out.println("equals");
    }
}

class TClass<T extends String> {

    public void receive(T q) {

    }
    public void receive(Object q) {

    }
}
