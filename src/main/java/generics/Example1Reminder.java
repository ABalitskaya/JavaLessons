package generics;

import java.util.ArrayList;
import java.util.List;

public class Example1Reminder {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(3); // автоупаковка int -> Integer

        System.out.println(list);

        int a = list.get(0); // распаковка Integer -> int

        System.out.println(a);

    }
}
