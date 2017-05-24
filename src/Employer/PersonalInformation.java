package Employer;

import Utils.DateGenerator;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by myasnikov
 * on 24.05.2017.
 */
public class PersonalInformation {

    private String name;
    private String surname;
    private int age;
    private Calendar dateOfBirth;
    private Calendar dateOfAcceptance;
    private String description;

    private PersonalInformation() {}
    public static PersonalInformationBuilder personalInformationBuilder() {
        return new PersonalInformation().new PersonalInformationBuilder();
    }

    //Builder iner
    public class PersonalInformationBuilder {
        private PersonalInformationBuilder() {
        }
        public PersonalInformationBuilder name(String name) {
            PersonalInformation.this.name = name;
            return this;
        }
        public PersonalInformationBuilder surname(String surname) {
            PersonalInformation.this.surname = surname;
            return this;
        }
        public PersonalInformationBuilder dateOfBirth(GregorianCalendar dateOfBirth) {
            PersonalInformation.this.dateOfBirth = dateOfBirth;
            return this;
        }
        public PersonalInformationBuilder dateOfAcceptance(GregorianCalendar dateOfAcceptance) {
            PersonalInformation.this.dateOfAcceptance = dateOfAcceptance;
            return this;
        }
        public PersonalInformationBuilder description(String description) {
            PersonalInformation.this.description = description;
            return this;
        }

        public PersonalInformation build() {
            PersonalInformation personalInformation = new PersonalInformation();
            personalInformation.name = PersonalInformation.this.name;
            personalInformation.surname = PersonalInformation.this.surname;
            personalInformation.dateOfBirth = PersonalInformation.this.dateOfBirth;
            personalInformation.dateOfAcceptance = PersonalInformation.this.dateOfAcceptance;
            personalInformation.description = PersonalInformation.this.description;
            if (personalInformation.dateOfBirth != null &&
                    personalInformation.dateOfAcceptance != null &&
                    personalInformation.dateOfBirth.before(personalInformation.dateOfAcceptance) )
                personalInformation.age = DateGenerator.generateAge((GregorianCalendar) dateOfBirth);

            return personalInformation;
        }

    }
//---------------------------------
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAge() {
        return String.valueOf(age);
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDateOfBirth() {
        return dateOfBirth.getTime().toString();
    }

    public void setDateOfBirth(Calendar dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfAcceptance() {
        return String.valueOf(dateOfAcceptance);
    }

    public void setDateOfAcceptance(Calendar dateOfAcceptance) {
        this.dateOfAcceptance = dateOfAcceptance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
