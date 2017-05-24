package Employer;
import Utils.PersonalInformationCreated;
import View.View;

/**
 * Created by myasnikov
 * on 23.05.2017.
 */
public class EmployerFabric {
    public static Employer generateEmployer(){
        switch (View.typeEmp()) {
            case 1:  return  worker();
            case 2:  return  manager();
            case 3:  return  seniorManager();
            default:
                System.out.println("&&&");
                break;
        }
        return null;
    }

    private static Employer worker() {
        return new Worker(PersonalInformationCreated.createStandard());
    }
    private static Employer manager() {
        return new Manager(PersonalInformationCreated.createStandard());
    }
    private static Employer seniorManager() {
        return new SeniorManager(PersonalInformationCreated.createStandard());
    }
}
