package Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
            if (dateForm.length() == 10 && (dateForm.charAt(5) == '/' || dateForm.charAt(5) == '.') &&
                    (dateForm.charAt(2) == '/' || dateForm.charAt(2) == '.')) {
                String tmp = dateForm.replaceAll("[/]","");
                System.out.println(tmp);
                check = false;
                for (int i = 0; i < tmp.length(); i++) {
                    if (!Character.isDigit(tmp.charAt(i))) {
                        check = true;
                        break;
                    }

                }

            }
        }
        System.out.println(dateForm);
        int day = Integer.parseInt(dateForm.substring(0, 2));
        int month = Integer.parseInt(dateForm.substring(3, 5));
        int year = Integer.parseInt(dateForm.substring(6, 10));
        Calendar cal = Calendar.getInstance();
        cal.set(year, DateGenerator.getMonthsBYInt(month),day);
        Date date1 = cal.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
        String string1 = dateFormat.format(date1); // TODO: 24.05.2017  
        Calendar ca = new GregorianCalendar();
        ca.setTime(date1);
        return (GregorianCalendar) ca;
    }
}
