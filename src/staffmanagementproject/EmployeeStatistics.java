package staffmanagementproject;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.YEARS;
import java.util.ArrayList;
import java.util.Collections;
import models.Developer;
import models.Employee;
import models.Marketing;
import models.Technician;
import models.WebDesigner;
import static staffmanagementproject.EmployeeManagement.employeeList;
import static utilities.GenderType.*;

public class EmployeeStatistics {

    public static void numberOfEmployees() {
        System.out.println("\nTotal number of employees: " + employeeList.size());
        int developers = 0, webDesigners = 0, technicians = 0, marketing = 0;
        for (Employee employee : employeeList) {
            if (employee instanceof Developer) {
                developers++;
            } else if (employee instanceof WebDesigner) {
                webDesigners++;
            } else if (employee instanceof Technician) {
                technicians++;
            } else if (employee instanceof Marketing) {
                marketing++;
            }
        }
        System.out.println("Number of Developers: " + developers);
        System.out.println("Number of Web Designers: " + webDesigners);
        System.out.println("Number of Technician: " + technicians);
        System.out.println("Number of Marketing employees: " + marketing);
    }

    public static void allSalaries() {
        System.out.println("\nAll salaries:\n");
        ArrayList<Employee> sortedEmployeeList = new ArrayList<>(employeeList);

        Collections.sort(sortedEmployeeList);
        System.out.println("ID");
        for (Employee currentEmployee : sortedEmployeeList) {

            String[] nameSplit = currentEmployee.getName().split(" ");
            System.out.println(fixLength(Integer.toString(currentEmployee.getID()), 5)
                    + fixLength(nameSplit[0], 10) + fixLength(nameSplit[1], 12)
                    + String.format("%,.2f", currentEmployee.getSalary()));
        }
    }

    public static void averageSalary() {
        double averageSalary = 0;
        for (Employee employee : employeeList) {
            averageSalary += employee.getSalary();
        }
        double sum = averageSalary / employeeList.size();
        System.out.printf("Average salary: %,.2f\n", sum);
    }

    public static void maxSalary() {
        int max = 0;
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getSalary() > employeeList.get(max).getSalary()) {
                max = i;
            }
        }
        System.out.printf(employeeList.get(max).getName() + " %,.2f\n", employeeList.get(max).getSalary());
    }

    public static void minSalary() {
        int min = 0;
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getSalary() < employeeList.get(min).getSalary()) {
                min = i;
            }
        }
        System.out.printf(employeeList.get(min).getName() + " %,.2f\n", employeeList.get(min).getSalary());
    }

    public static void sumBonus() {
        double totBonus = 0;
        System.out.println("Name:                Bonus:");
        for (Employee currentEmployee : employeeList) {
            System.out.println(String.format("%-20s %,.2f", currentEmployee.getName(), currentEmployee.bonus()));
            totBonus += currentEmployee.bonus();
        }
        System.out.println("---------------");
        System.out.printf("Total Bonus: %,.2f\n", totBonus);

    }

    public static void showAges() {
        double totAge = 0;
        System.out.println("Name:                Age:");
        for (Employee employee : employeeList) {
            LocalDate x = employee.getBirthdate();
            LocalDate y = LocalDate.now();
            long ageInYears = YEARS.between(x, y);
            totAge += ageInYears;
            System.out.println(String.format("%-20s %d", employee.getName(), ageInYears));
        }
        System.out.println("---------------");
        System.out.printf("Average age at company: %.1f\n", totAge / employeeList.size());
    }

    public static void showGenders() {
        int women = 0, men = 0, unknown = 0;
        for (Employee employee : employeeList) {
            if (employee.getGender() == MALE) {
                men++;
            } else if (employee.getGender() == FEMALE) {
                women++;
            } else if (employee.getGender() == UNKNOWN) {
                unknown++;
            }
        }
        double porcentage = 100.0 / (men + women + unknown);
        System.out.println("Number of men: " + men + " (" + String.format("%.2f", men * porcentage) + "%)");
        System.out.println("Number of women: " + women + " (" + String.format("%.2f", women * porcentage) + "%)");
        if (unknown > 0) {
            System.out.println("Number of people with unknown gender: " + unknown + " (" + String.format("%.2f", unknown * porcentage) + "%)");

        }
    }

    private static String fixLength(String s, int i) {
        if (s.length() < i) {
            for (int j = s.length(); j < i; j++) {
                s = s + " ";
            }
            return s;
        } else if (s.length() == i) {
            return s + " ";
        }else 
           return  s.substring(0, i)+" ";
    }

}
