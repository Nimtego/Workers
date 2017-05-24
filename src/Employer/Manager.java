package Employer;

import Utils.PersonalInformationCreated;

import java.util.List;

/**
 * Created by myasnikov
 * on 23.05.2017.
 */
public class Manager extends Employer {
    private static int count = 0;
    List<Worker> workerList;

    public Manager() {
        this(PersonalInformationCreated.createStandard());
    }
    public Manager(PersonalInformation personalInformation) {
        super(TypeEmployer.MANAGER, personalInformation);
        count++;
    }
    public List<Worker> getWorkerList() {
        return workerList;
    }

    public void setWorkerList(List<Worker> workerList) {
        this.workerList = workerList;
    }
    public boolean addWorker(Worker worker) {
        return workerList.add(worker);
    }
    public boolean remove(Worker worker) {
        return workerList.remove(worker);
    }
}
