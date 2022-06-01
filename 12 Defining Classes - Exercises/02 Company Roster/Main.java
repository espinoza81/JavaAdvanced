package CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int line = Integer.parseInt(console.nextLine());
        Map<String, Department> departmentList = new HashMap<>();
        while (line-- > 0){
            String[] token = console.nextLine().split("\\s+");
            Employee singleEmployee = null;
            String name = token[0];
            double salary = Double.parseDouble(token[1]);
            String position = token[2];
            String department = token[3];

            if(token.length==4) {
                singleEmployee = new Employee(name, salary, position, department);

            }
            if(token.length==6) {
                singleEmployee = new Employee(name, salary, position, department, token[4], Integer.parseInt(token[5]));

            }
            if(token.length==5) {
                if(token[4].chars().allMatch(Character::isDigit)){
                    singleEmployee = new Employee(name, salary, position, department, Integer.parseInt(token[4]));
                } else {
                    singleEmployee = new Employee(name, salary, position, department, token[4]);
                }
            }

            departmentList.putIfAbsent(department, new Department(department));
            Department temp = departmentList.get(department);
            temp.updateSell(temp, salary, singleEmployee);
        }
        Optional<Department> temp = departmentList.values().stream().max(Comparator.comparing(Department::getAverageSalary));
        System.out.println("Highest Average Salary: " + temp.get().getName());
        temp.get().getDepartmentEmployers().stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).forEach(System.out::println);
    }
}
