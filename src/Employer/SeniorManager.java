package Employer;

import Utils.PersonalInformationCreated;

/**
 * Created by myasnikov
 * on 23.05.2017.
 */
public class SeniorManager extends Employer {
    private static int count = 0;
    public SeniorManager() {
        this(PersonalInformationCreated.createStandard());
    }
    public SeniorManager(PersonalInformation personalInformation) {
        super(TypeEmployer.SENIOR_MANAGER, personalInformation);

        count++;
    }
}
