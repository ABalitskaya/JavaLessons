package datesExamples;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Example2 {
    public static void main(String[] args) {

        // пример календаря0
        Calendar c0 = Calendar.getInstance();
        System.out.println(c0.getTime());

//        Date date0 = new Date(0);
//        Calendar c05 = new GregorianCalendar();
//        c05.setTime(date0);
//        System.out.println(c05.getTime());

        // пример календаря1
        Calendar c1 = new GregorianCalendar(2022, Calendar.JANUARY, 1);

        // get
        System.out.println(c1.getTime());

        // set
        c1.set(Calendar.MONTH, Calendar.DECEMBER);
        System.out.println(c1.getTime());

        // add
        c1.add(Calendar.DATE, 100);
        System.out.println(c1.getTime());

    }
}
