package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

// создание списка, у которого выбор элемента будет происходить в случайном порядке
public class Example4 {
    public static void main(String[] args) {

        RandomArrayList<String> randomArrayList = new RandomArrayList<>();
        Arrays.stream("Hello, java! It's qa_41m".split(" ")).forEach(randomArrayList::add);

        for (int i = 0; i < 20; i++)
            System.out.println(randomArrayList.get());
    }
}

class RandomArrayList<T> {
    private List<T> storage = new ArrayList<>();
    private Random random = new Random();

    public void add(T element) {
        storage.add(element);
    }

    public T get() {
        return storage.get(random.nextInt(0, storage.size()));
    }
}