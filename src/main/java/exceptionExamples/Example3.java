package exceptionExamples;

public class Example3 {

    // todo повторить
    public static void a() throws NewQ41_Exception {
        System.out.println("Тест метода a() с NewQ41_Exception");
        throw new NewQ41_Exception();
    }
    public static void b() throws NewQ41_Exception {
        System.out.println("Тест метода b() с NewQ41_Exception with message");
        throw new NewQ41_Exception("generated in b() method");
    }
    public static void c() throws NewQ41_Exception {
        System.out.println("Тест метода c() с NewQ41_Exception with errorNumber");
        throw new NewQ41_Exception(1442);
    }
    public static void d() throws NewQ41_Exception {
        System.out.println("Тест метода d() с NewQ41_Exception with message & errorNumber");
        throw new NewQ41_Exception("genereted in d()", 1446);
    }

    public static void main(String[] args) {
        try {
            a();
        } catch (NewQ41_Exception e) {
            e.printStackTrace();
        }

        try {
            b();
        } catch (NewQ41_Exception e) {
            e.printStackTrace();
        }

        try {
            c();
        } catch (NewQ41_Exception e) {
            e.printStackTrace();
        }

        try {
            d();
        } catch (NewQ41_Exception e) {
            e.printStackTrace();
        }
    }
}

class NewQ41_Exception extends Exception {

    private int errorNumber;

    public NewQ41_Exception() {}
    public NewQ41_Exception(int errorNumber) {
        this.errorNumber = errorNumber;
    }

    public NewQ41_Exception(String message) {
        super(message);
    }

    public NewQ41_Exception(String message, int errorNumber) {
        super(message);
        this.errorNumber = errorNumber;
    }

    @Override
    public String getMessage() { // аналог метода toString() в классах
        String result = "";
        if (super.getMessage() != null && errorNumber != 0)
            result = "Exception properties: " + super.getMessage() + ", errorNumber: " + errorNumber;
        else if (super.getMessage() != null) {
            result = "Exception properties: " + super.getMessage();
        } else if (errorNumber != 0) {
            result = "ErrorNumber: " + errorNumber;
        }

        return result;
    }
}