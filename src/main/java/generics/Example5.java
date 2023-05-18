package generics;

// последовательность чисел Фибоначчи с использованием параметризации интерфейса как
// генератора
// 1 1 2 3 5 8 ...

public class Example5 {
    public static void main(String[] args) {

        Fibonacci f = new Fibonacci();

        for (int i = 0; i < 10; i++) {
            System.out.print(f.next() + " ");
        }

    }
}

class Fibonacci implements Generator<Integer> {

    private int counter = 0;

    private int generate(int n) {
        if (n < 2)
            return 1;
        else
            return generate(n-2) + generate(n - 1);
        // counter = 0 ->                                     1
        // counter = 1 ->                                     1
        // counter = 2 -> generate(0) + generate(1) = 1 + 1 = 2
        // counter = 3 -> generate(1) + generate(2) = 1 + 2 = 3
        // counter = 4 -> generate(2) + generate(3) = 2 + 3 = 5
    }

    @Override
    public Integer next() {
        return generate(counter++);
    }
}

interface Generator<T> {
    T next();
}

