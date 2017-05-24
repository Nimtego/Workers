package View;

import Employer.*;
import Employer.Organization;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by myasnikov
 * on 23.05.2017.
 */
public class View {
    public static int typeEmp() {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Vvedite\n 1) Worker\n 2) Manager\n 3) Senior manager");
            int tmp;
            try {
                tmp = Integer.parseInt(bf.readLine());
            } catch (Exception e) {
                continue;
            }
            if (tmp > 0 && tmp <= 3)
                return tmp;
        }
    }
    public static void print(Organization organization) {
        for (TypeEmployer key : organization.getListEmployer().keySet()) {
            System.out.println("Position: " +"\"" + key +"\"");
            System.out.println("          ");
            for (Employer emp : organization.getListEmployer().get(key)) {
                System.out.println(emp);
                System.out.println("------");
            }
        }
    }
}
