import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExamples {
    // ищем шаблон для email с помощью regex
    static String regex1 = "\\w+@\\w+\\.\\w+";
    static String regex2 = "[A-Za-z0-9\\.]+@[A-Za-z0-9\\.]+.[A-Za-z0-9]+";
    static String regex3 = "[A-Za-z0-9\\.]+@[A-Za-z0-9\\.]+[A-Za-z0-9]\\.[A-Za-z0-9]+";

    static String text = "hello java my name is Alex, Surname Brook, my email " +
            "is alex.brooks@cnn.co.au. My wife email is her@gmal.com";
    static String singleemail = "alex.brooks@cnn.co.au";


    public static void main(String[] args) {

    }

    public static void test2() {
        Pattern p = Pattern.compile(regex3);
        Matcher m = p.matcher(text);

        // для одного случая
//        System.out.println(m.find());
//        System.out.println(m.start());
//        System.out.println(m.end());
//        System.out.println(text.substring(55, 76));

        // печатаем в ручном режиме через substring
//        while (m.find()) {
//            System.out.println(m.start() + " " + m.end() + " " + text.substring(m.start(), m.end()));
//        }

        System.out.println();

        // печатаем через m.group() взаместо substring
        while (m.find()) {
            System.out.println(m.start() + " " + m.end() + " " + m.group() + " " + m.matches());
        }


    }

    public static void test1() {
        System.out.println(text.matches(regex1));
        System.out.println(text.matches(regex2));
        System.out.println(text.matches(regex3));

        System.out.println(singleemail.matches(regex1));
        System.out.println(singleemail.matches(regex2));
        System.out.println(singleemail.matches(regex3));

        if (text.contains("@")) {
            String[] arr = text.split(" ");
            for (String s : arr) {
                if (s.contains("@"))
                    System.out.println(s);
            }
        }
    }
}
