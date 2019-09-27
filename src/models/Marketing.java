package models;

import java.util.ArrayList;
import utilities.GenderType;

public class Marketing extends Employee {

    private final ArrayList<String> listOfCustomers = new ArrayList<>();
    private static int budget = 100_000;

    public Marketing(double salary, String name, String birthdate, GenderType gender) {
        super(salary, name, birthdate, gender);
    }

    public ArrayList<String> getListOfCustomers() {
        return listOfCustomers;
    }

    public static int getBudget() {
        return budget;
    }

    public static void setBudget(int budget) {
        if (budget < 0) {
            System.out.println("Not enough budget");
        } else {
            Marketing.budget = budget;
        }
    }

    @Override
    public double bonus() {
        double bonus = employeeBonusBase + 300 * listOfCustomers.size();
        return bonus;
    }
    @Override
    public void printExtraInfo() {
        System.out.println("       Number of customers: " + listOfCustomers.size()+"\n");
        System.out.println("       List of customers:");
        for (String customer : listOfCustomers) {
            
            System.out.println("       "+customer);
            
        }
    }
    


}
