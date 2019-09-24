package staffmanagementproject;

import java.util.Locale;
import java.util.Scanner;
import models.Developer;
import models.Employee;
import models.Marketing;
import models.Technician;
import models.WebDesigner;

public class StaffManagementProject {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Locale.setDefault(new Locale("sv", "SE"));
        EmployeeManagement.loadDb();
        mainMenu();
    }

    private static void mainMenu() {
        boolean loop = true;
        while (loop) {
            System.out.println("--------------");
            System.out.println("Staff Management Project");
            System.out.println("1. Employee management");
            System.out.println("2. Employee statistics");
            System.out.println("0. Exit");
            System.out.println("--------------");
            System.out.println("Make a choice");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    managementMenu();
                    break;
                case 2:
                    statisticsMenu();
                    break;
                case 0:
                    loop = false;
                    break;
                default:
                    System.out.println("Wrong choice!");
            }

        }
    }

    private static void managementMenu() {
        boolean loop = true;
        while (loop) {
            System.out.println("--------------");
            System.out.println("Employee Management");
            System.out.println("1. Add employee");
            System.out.println("2. Remove employee");
            System.out.println("3. Show all employees");
            System.out.println("4. Show employee");
            System.out.println("5. Update employee");
            System.out.println("0. Return to Main Menu");
            System.out.println("--------------");
            System.out.println("Make a choice");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    EmployeeManagement.addEmployee();
                    break;
                case 2:
                    System.out.println("Remove employee");
                    System.out.println("1. By ID");
                    System.out.println("2. By Name");
                    choice = sc.nextInt();
                    sc.nextLine();
                    switch (choice) {
                        case 1:
                            EmployeeManagement.removeEmployeeById();
                            break;
                        case 2:
                            EmployeeManagement.removeEmployeeByName();
                            break;
                        default:
                            System.out.println("Wrong choice");
                            break;
                    }
                    break;
                case 3:
                    EmployeeManagement.showAllEmployees();
                    break;
                case 4:
                    System.out.println("Enter Employee ID");
                    int ID = sc.nextInt();
                    EmployeeManagement.showEmployeeByID(ID);
                    break;
                case 5:
                    updateMenu();
                    break;
                case 0:
                    loop = false;
                    break;
                default:
                    System.out.println("Wrong choice!");

            }
        }
    }

    private static void updateMenu() {

        System.out.println("Update employee information");
        System.out.print("Enter Employee ID: ");
        int ID = sc.nextInt();
        Employee employee = EmployeeManagement.showEmployeeByID(ID);
        if (employee == null) {
            return;
        }
        
        System.out.println("1: Update name");
        System.out.println("2. Update salary");
        System.out.println("3: Update birthdate");
        System.out.println("4. Update gender");
        if (employee instanceof Developer) {
            System.out.println("5. Update programming language");
            System.out.println("6. Update developer level");
        } else if (employee instanceof Technician) {
            System.out.println("5. Update number of servers");
        } else if (employee instanceof WebDesigner) {
            System.out.println("5. Add or remove websites");
        } else if (employee instanceof Marketing) {
            System.out.println("5. Add or remove customers");
            System.out.println("6. Spend budget");
        }
        System.out.println("0. Return to Management Menu");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                EmployeeManagement.updateNameOfEmployee(ID);
                break;
            case 2:
                EmployeeManagement.updateSalaryOfEmployee(ID);
                break;
            case 3:
                EmployeeManagement.updateBirthdate(ID);
                break;
            case 4:
                EmployeeManagement.updateGenderOfEmployee(ID);
                break;
            case 5:
                if (employee instanceof Developer) {
                    EmployeeManagement.updateDeveloperProgLanguage(employee);
                } else if (employee instanceof Technician) {
                    EmployeeManagement.updateTechnicianNServers(employee);
                } else if (employee instanceof WebDesigner) {
                    EmployeeManagement.updateWebsites(employee);
                } else if (employee instanceof Marketing) {
                    EmployeeManagement.updateCustomers(employee);
                }
                break;

            case 6:
                if (employee instanceof Developer) {
                    EmployeeManagement.updateDeveloperLevel(employee);
                } else if (employee instanceof Marketing) {
                    EmployeeManagement.updateBudget(employee);
                } else {
                    System.out.println("Wrong choice, try again");
                }
                break;
            case 0:
                break;
            default:
                System.out.println("Wrong choice, try again");
                break;
        }
    }

    private static void statisticsMenu() {
        boolean loop = true;
        while (loop) {
            System.out.println("--------------");
            System.out.println("Employee Statistics");
            System.out.println("1. Show total employees");
            System.out.println("2. Show salary data");
            System.out.println("3. Bonus data");
            System.out.println("4. Ages data");
            System.out.println("5. Gender data");
            System.out.println("0. Exit");
            System.out.println("--------------");
            System.out.println("Make a choice");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    EmployeeStatistics.numberOfEmployees();
                    break;
                case 2:
                    System.out.println("Salary data: ");
                    System.out.println("1. Highest salary");
                    System.out.println("2. Lowest salary");
                    System.out.println("3. Average ");
                    System.out.println("4. Show all salaries");
                    choice = sc.nextInt();
                    switch (choice) {
                        case 1:
                            EmployeeStatistics.maxSalary();
                            break;
                        case 2:
                            EmployeeStatistics.minSalary();
                            break;
                        case 3:
                            EmployeeStatistics.averageSalary();
                            break;
                        case 4:
                            EmployeeStatistics.allSalaries();
                            break;
                        default:
                            System.out.println("Not a valid input, try agian");
                            break;
                    }
                    break;
                case 3:
                    EmployeeStatistics.sumBonus();
                    break;
                case 4:
                    EmployeeStatistics.showAges();
                    break;
                case 5:
                    EmployeeStatistics.showGenders();
                    break;
                case 0:
                    loop = false;
                    break;
                default:
                    System.out.println("Wrong choice!");

            }
        }

    }

}
