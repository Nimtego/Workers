package Utils;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by myasnikov
 * on 24.05.2017.
 */
public class DateGenerator {
    public static int generateAge(GregorianCalendar birthDay) {
        // дата проверки
        GregorianCalendar checkDay = new GregorianCalendar();
        // получаем разницу в годах
        int years = checkDay.get(GregorianCalendar.YEAR) - birthDay.get(GregorianCalendar.YEAR);
        // корректируем, если текущий месяц в дате проверки меньше месяца даты рождения
        int checkMonth = checkDay.get(GregorianCalendar.MONTH);
        int birthMonth = birthDay.get(GregorianCalendar.MONTH);
        if ( checkMonth < birthMonth ) {
            years --;
        } else  if (checkMonth == birthMonth
                && checkDay.get(GregorianCalendar.DAY_OF_MONTH) < birthDay.get(GregorianCalendar.DAY_OF_MONTH)) {
            // отдельный случай - в случае равенства месяцев, но меньшего дня месяца в дате проверки - корректируем
            years --;
        }
        System.out.println(years);
        return years;
    }
    public static int getMonthsBYInt(final int months) {
        if (months < 13 && months > 0) {
            switch (months) {
                case 1: return Calendar.JANUARY;
                case 2: return Calendar.FEBRUARY;
                case 3: return Calendar.MARCH;
                case 4: return Calendar.APRIL;
                case 5: return Calendar.MAY;
                case 6: return Calendar.JUNE;
                case 7: return Calendar.JULY;
                case 8: return Calendar.AUGUST;
                case 9: return Calendar.SEPTEMBER;
                case 10: return Calendar.OCTOBER;
                case 11: return Calendar.NOVEMBER;
                case 12: return Calendar.DECEMBER;
            }
        }
        return months;
    }
}
