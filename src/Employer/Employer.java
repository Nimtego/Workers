package Employer;

import java.util.Calendar;

/**
 * Created by myasnikov
 * on 23.05.2017.
 */
public abstract class Employer {
    private TypeEmployer typeEmployer;
    private Long id;
    private Department department;
    private PersonalInformation personalInformation;

    public Employer(TypeEmployer typeEmployer, PersonalInformation personalInformation) {
        this.typeEmployer = typeEmployer;
        this.personalInformation = personalInformation;
    }

    public String getName() {
        return personalInformation.getName();
    }

    public void setName(String name) {
        personalInformation.setName(name);
    }

    public String getSurname() {
        return personalInformation.getSurname();
    }

    public void setSurname(String surname) {
        personalInformation.setSurname(surname);
    }

    public String getAge() {
        return personalInformation.getAge();
    }

    public String getDateOfBirth() {
        return personalInformation.getDateOfBirth();
    }

    public void setDateOfBirth(Calendar dateOfBirth) {
        personalInformation.setDateOfBirth(dateOfBirth);
    }

    public String getDateOfAcceptance() {
        return personalInformation.getDateOfAcceptance();
    }

    public void setDateOfAcceptance(Calendar dateOfAcceptance) {
        personalInformation.setDateOfAcceptance(dateOfAcceptance);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return personalInformation.getDescription();
    }

    public void setDescription(String description) {
        personalInformation.setDescription(description);
    }

    public TypeEmployer getTypeEmployer() {
        return typeEmployer;
    }

    public void setTypeEmployer(TypeEmployer typeEmployer) {
        this.typeEmployer = typeEmployer;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(" ID ")
                .append(id)
                .append("\n")
                .append(" Name ")
                .append(personalInformation.getName())
                .append(" Surname ")
                .append(personalInformation.getSurname())
                .append(" Age ")
                .append(personalInformation.getAge())
                .toString();

    }
}
