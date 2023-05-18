package generics;

// типизированные классы (generic classes)
public class Example2 {
    public static void main(String[] args) {

        // generic examples
        Train<String> train1 = new Train<>("train of str");
        System.out.println(train1);

        Train<Integer> train2 = new Train<>(123);
        System.out.println(train2);

        Train<Wood> train5 = new Train<>(new Wood());
        System.out.println(train5);


        // classic examples
        System.out.println("------");
        ClassTrain train3 = new ClassTrain("train of str");
        System.out.println(train3);

        ClassTrain train4 = new ClassTrain(123);
        System.out.println(train4);

        ClassTrain train6 = new ClassTrain(new Wood());
        System.out.println(train6);

    }
}

class Wood {}
class Sand {}

class Train<T> {

    private T type;

    public Train(T type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Train of " + type.getClass().getName() + " coaches";
    }
}

class ClassTrain {
    private Object type;

    public ClassTrain(String type) {
        this.type = type;
    }

    public ClassTrain(Integer type) {
        this.type = type;
    }

    public ClassTrain(Wood type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Train of " + type.getClass().getName() + " coaches";
    }
}