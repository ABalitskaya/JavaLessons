package datesExamples;

import java.util.Date;

public class Example1 {
    public static void main(String[] args) {
        // устаревший подход

        Date date0 = new Date();
        System.out.println(date0);

        Date date1 = new Date(0); // 1970
        System.out.println(date1);

        System.out.println(date0.after(date1));
        System.out.println(date1.before(date0));


    }
}
