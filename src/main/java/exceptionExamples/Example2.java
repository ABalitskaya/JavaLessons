package exceptionExamples;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Example2 {

    // создание исключения без сообщения
    public static void a() throws NewQ41_Error0Exception {
        System.out.println("Тест метода a() с NewQ41_Error0Exception");
        throw new NewQ41_Error0Exception();
    }

    public static void b() throws NewQ41_Error1Exception {
        System.out.println("Тест метода b() c NewQ41_Error1Exception");
        throw new NewQ41_Error1Exception();
    }

    public static void c() throws NewQ41_Error1Exception {
        System.out.println("Тест метода c() c NewQ41_Error1Exception");
        throw new NewQ41_Error1Exception("generated in c() method");
    }

    public static void d() throws NewQ41_CartIsEmptyException {
        System.out.println("Тест метода d() c NewQ41_CartIsEmptyException");
        throw new NewQ41_CartIsEmptyException();
    }

    public static void main(String[] args) {
        try {
            a();
        } catch (NewQ41_Error0Exception e) {
            System.out.println("перехвачено");
        }

        System.out.println();

        try {
            b();
        } catch (NewQ41_Error1Exception e) {
            e.printStackTrace();
        }

        try {
            c();
        } catch (NewQ41_Error1Exception e) {
            e.printStackTrace();
        }

        try {
            d();
        } catch (NewQ41_CartIsEmptyException e) {
            System.err.println("перехвачена пустая корзина");
        }

    }
}

class NewQ41_Error0Exception extends Exception {}
class NewQ41_Error1Exception extends Exception {

    public NewQ41_Error1Exception() {}
    public NewQ41_Error1Exception(String message) {
        super(message);
    }
}

class NewQ41_CartIsEmptyException extends ArrayIndexOutOfBoundsException {}

// todo last lesson:
// Сразу вопрос на последнее занятие: что полезного (для нас))) лежит в методах System?