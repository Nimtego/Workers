package Employer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by myasnikov
 * on 24.05.2017.
 */
public class Department {
    private String name;
    private List<Employer> listOfWorkers;
    private String description;

    public Department(String name, String description) {
        this(name, new ArrayList<>(), description);
    }

    public Department(String name, List<Employer> listOfWorkers, String description) {
        this.name = name;
        this.listOfWorkers = listOfWorkers;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employer> getListOfWorkers() {
        return listOfWorkers;
    }

    public void setListOfWorkers(List<Employer> listOfWorkers) {
        this.listOfWorkers = listOfWorkers;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
