package CompanyRoster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    String name;
    List <Employee> departmentEmployers = new ArrayList<>();
    double averageSalary = 0;
    double allSalary = 0;


    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Employee> getDepartmentEmployers() {
        return departmentEmployers;
    }

    public double getAverageSalary() {
        return averageSalary;
    }

    public void setAverageSalary(double averageSalary) {
        this.averageSalary = averageSalary;
    }

    public double getAllSalary() {
        return allSalary;
    }

    public void setAllSalary(double salary) {
        this.allSalary += salary;
    }

    public void updateSell(Department temp, double salary, Employee singleEmployee) {
        temp.getDepartmentEmployers().add(singleEmployee);
        temp.setAllSalary(salary);
        double averageSalary = temp.getAllSalary()/temp.getDepartmentEmployers().size();
        temp.setAverageSalary(averageSalary);
    }
}
