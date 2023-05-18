package generics;

import java.util.*;
import java.util.function.Supplier;

public class Example10 {
    // хотим создать список элементов (количество мы можем задать через параметр)
    // тип элементов будет определён в будущем

    public static void main(String[] args) {

        NewOneList<Integer> list1 = new NewOneList<>(1,2,3,4,5,6,7,8,9);
        System.out.println(list1);

        NewOneList<CarRandom> list2 = new NewOneList<>(new CarRandom(), new CarRandom(), new CarRandom());
        System.out.println(list2);

        System.out.println("------");


        NewOneList<String> list3 = new NewOneList<>(10, () -> String.valueOf(Math.random()));
        System.out.println(list3);

        NewOneList<Integer> list4 = new NewOneList<>(3, () -> (int) (Math.random() * 100));
        System.out.println(list4);

        List<Integer> etalon = Arrays.asList(10,20,30,40);
        final Iterator<Integer> iterator = etalon.iterator();

        NewOneList<Integer> list5 = new NewOneList<>(4, () -> iterator.next());
        System.out.println(list5);

        final Iterator<Integer> iterator2 = etalon.iterator();
        NewOneList<Integer> list6 = new NewOneList<>(iterator2);
        System.out.println(list6);

    }
}

class CarRandom {
    private String model;
    private String[] models = {"bmw", "audi", "mercedes", "volkswagen"};

    public CarRandom() {
        Random r = new Random();
        model = models[r.nextInt(0, 4)];
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return "{Car model: " + model + "}";
    }
}

class NewOneList<T> {
    private List<T> storage = new ArrayList<>();

    public NewOneList(T... args) {
        storage.addAll(Arrays.asList(args));
    }

    public NewOneList(int n, Supplier<T> fabric) {
        for (int i = 0; i < n; i++) {
            storage.add(fabric.get());
        }
    }

    public NewOneList(Iterator<T> iterator) {
        while (iterator.hasNext())
            storage.add(iterator.next());
    }

    public List<T> getStorage() {
        return storage;
    }

    @Override
    public String toString() {
        return storage.toString();
    }
}