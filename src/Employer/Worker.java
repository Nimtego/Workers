package Employer;

import Utils.PersonalInformationCreated;

/**
 * Created by myasnikov
 * on 23.05.2017.
 */
public class Worker extends Employer {
    private Employer owner;
    public Worker() {
        this(PersonalInformationCreated.createStandard());
    }
    public Worker(PersonalInformation personalInformation) {
        super(TypeEmployer.WORKER, personalInformation);
    }
    public Employer getOwner() {
        return owner;
    }
    public void setOwner(Employer owner) {
        this.owner = owner;
    }
}
