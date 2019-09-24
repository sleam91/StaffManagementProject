package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import utilities.GenderType;

public abstract class Employee {

    private final int id;
    private double salary=20_000;
    private String name;
    private LocalDate birthdate;
    private GenderType gender;
    protected final double employeeBonusBase;

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static int idGenerator = 1;

    public Employee(double salary, String name, String birthdate, GenderType gender) {
        this.id = idGenerator++;
        setSalary(salary);
        this.name = name;
        this.birthdate = LocalDate.parse(birthdate, FORMATTER);
        this.gender = gender;
        this.employeeBonusBase = 1000;
    }

    public int getID() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public final void setSalary(double salary) {
        if (salary < 20000) {
            System.out.println("Too low salary, current salary is not changed");

        } else if (salary > 100000) {
            System.out.println("Too high salary, current salary is not changed");

        } else {
            this.salary = salary;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = LocalDate.parse(birthdate, FORMATTER);
    }

    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    public abstract double bonus();
    
    public abstract void printExtraInfo();

    @Override
    public String toString() {
        return "Employee ID: " + String.format("%2d", id) + " Name: " + name + " Birthdate: " + birthdate + " Salary: " + String.format("%,.2f", salary) + " Gender: " + gender + " Job title: " + this.getClass().getSimpleName().replaceAll("([^_])([A-Z])", "$1 $2") + "\n";
    }

}
