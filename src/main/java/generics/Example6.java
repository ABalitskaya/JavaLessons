package generics;

// пример generic method
public class Example6 {
    public static <T> void printType(T x) {
        System.out.println(x.getClass().getName());
    }

    public static <T> T getElement(T x) {
        return x;
    }

    public static void main(String[] args) {
        Example6 example6 = new Example6();

        System.out.println("Print from generic method: ");
        printType(1);
        printType(1.5);
        printType(1.7F);
        printType('c');
        printType(" ");
        printType(true);
        printType(example6);

        System.out.println(" ----- ");

        System.out.println("Print from generic class: ");
        F<Integer> f1   = new F<>(1);
        F<Double> f2    = new F<>(1.5);
        F<Float> f3     = new F<>(1.7F);
        F<Character> f4 = new F<>('c');
        F<String> f5    = new F<>(" ");
        F<Boolean> f6   = new F<>(true);
        F<Example6> f7  = new F<>(example6);

        System.out.println("--------");
        System.out.println(getElement(1));
    }
}

class F<T> {
    public F(T type) {
        System.out.println(type.getClass().getName());
    }
}
