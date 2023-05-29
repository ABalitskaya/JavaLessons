package exceptionExamples;


public class Example1 {
    public static void main(String[] args) {
        getTest1(8,0);
    }

    public static void getTest1(int x, int y) {

        // unchecked
        int[] a = new int[3];
        System.out.println(a[0]);
        System.out.println(a[10]); // ArrayIndexOutOfBound
        System.out.println(x / y); // Arithmetic
    }
}
