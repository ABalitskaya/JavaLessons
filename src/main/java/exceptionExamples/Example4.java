package exceptionExamples;

import java.io.IOException;

public class Example4 {
    public static void main(String[] args) {
        // информация, которую мы можем получать из Exception
        try {
            throw new IOException("test message for qa_41m");
        } catch (IOException e) {
            System.out.println("перехвачено");
            System.out.println("getMessage(): " + e.getMessage());
            System.out.println("toString(): " + e.toString());
            System.out.print("printStackTrace(): ");
            e.printStackTrace(System.out);
        }
    }
}
