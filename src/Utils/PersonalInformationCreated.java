package Utils;

import Employer.PersonalInformation;

import java.util.GregorianCalendar;

import static Utils.UserInput.*;

/**
 * Created by myasnikov
 * on 24.05.2017.
 */
public class PersonalInformationCreated {
    public static PersonalInformation createStandard() {
        PersonalInformation personalInformation = PersonalInformation.personalInformationBuilder()
                                                                    .name(inputString("Enter name"))
                                                                    .surname(inputString("Enter surname"))
                                                                    .dateOfBirth(inputDate("Enter date(day.month.year)"))
                                                                    .dateOfAcceptance(new GregorianCalendar())
                                                                    .description("&&&").build();
        return personalInformation;
    }
}
