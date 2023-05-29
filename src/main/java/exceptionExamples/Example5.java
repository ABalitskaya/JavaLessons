package exceptionExamples;

import java.io.IOException;

public class Example5 {
    public static void a() {
        try {
            throw new IOException("test message");
        } catch (IOException e) {
            for (StackTraceElement ste : e.getStackTrace())
                System.out.println(ste.getMethodName());
            e.printStackTrace(System.out);
        }
    }

    public static void b() {
        a();
    }

    public static void c() {
        b();
    }

    public static void main(String[] args) {

        a();
        System.out.println(" -".repeat(10));
        b();
        System.out.println(" -".repeat(10));
        c();

    }
}
