package Employer;

import Utils.IdCreator;

import java.util.*;

/**
 * Created by myasnikov
 * on 23.05.2017.
 */
public class Organization {
    String name;
    private Map<TypeEmployer, List<Employer>> employerList;

    public Organization() {
        this(null);
    }
    public Organization(Map<TypeEmployer, List<Employer>> employerList) {
        if (employerList == null) {
            employerList = new HashMap<>();
        }
        this.employerList = employerList;
        this.name = "ORG";
    }
    public boolean addEmployer(Employer employer) {
        if (employer.getId() != null && checkId(employer.getId()))
            return false;
        if (employer.getId() == null)
            employer.setId(IdCreator.createID());
        if (!employerList.containsKey(employer.getTypeEmployer()))
            employerList.put(employer.getTypeEmployer(), new ArrayList<>());
        employerList.get(employer.getTypeEmployer()).add(employer);
        return true;
    }
    private boolean checkId(final Long id) {
        for (List<Employer> value : employerList.values()) {
            for (Employer emp : value) {
                if (Objects.equals(emp.getId(), id)) {
                    return false;
                }
            }
        }
        return true;
    }
    public Map<TypeEmployer, List<Employer>> getListEmployer() {
        return employerList;
    }
    public boolean removeEmployerById(final Long id) {
        for (List<Employer> value : employerList.values()) {
            for (Employer emp : value) {
                if (Objects.equals(emp.getId(), id)) {
                    value.remove(emp);
                }
            }
        }
        return false;
    }
    public boolean removeEmployerByemployer(final Employer employer) {
        return employerList.get(employer.getTypeEmployer()).remove(employer);
    }
}
