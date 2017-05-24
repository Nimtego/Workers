package Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by myasnikov
 * on 24.05.2017.
 */
public class UserInput {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String inputString(final String question) {
        String string = "";
        if (question != null)
            System.out.println(question);
        try {
            string = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return string;
    }
    public static GregorianCalendar inputDate(final String question) {
        String dateForm = "";
        boolean check = true;
        while (check) {
            if (question != null)
                System.out.println(question);
            try {
                dateForm = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (dateForm.length() == 10 /*&& (dateForm.charAt(5) == '/' || dateForm.charAt(5) == '.') &&
                    (dateForm.charAt(2) == '/' || dateForm.charAt(2) == '.')*/) {
                String tmp = dateForm.replaceAll("/","");
                check = false;
                for (int i = 0; i < tmp.length(); i++) {
                    if (!Character.isDigit(dateForm.charAt(i))) {
                        check = true;
                        break;
                    }

                }

            }
        }
        String day;
        String month;
        String year;
        day = dateForm.substring(0, 1);
        month = dateForm.substring(3, 4);
        year = dateForm.substring(6, 9);
        Calendar calendar = new GregorianCalendar();
        calendar.set(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
        return (GregorianCalendar) calendar;
    }
}
