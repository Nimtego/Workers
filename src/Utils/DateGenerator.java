package Utils;

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
        return years;
    }
}
