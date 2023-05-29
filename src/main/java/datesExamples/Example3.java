package datesExamples;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Example3 {
    public static void main(String[] args) {
        Calendar c0 = Calendar.getInstance();
        Date date0 = new Date();

        System.out.println(c0.getTime());
        System.out.println(date0);

        SimpleDateFormat sdf1 = new SimpleDateFormat("M/d/yyyy");

        System.out.println(sdf1.format(c0.getTime()));
        System.out.println(sdf1.format(date0));
    }
}
