package org.example;
import org.example.interfaces.SalaryStrategy;
import org.example.interfaces.User;
import lombok.*;

@Getter @Setter
public class Staff extends Person implements User {
    private String position;
    private double hourlyRate;
    private int hoursWorked;
    private SalaryStrategy salaryStrategy;

    public Staff(String name, String position, double hourlyRate, SalaryStrategy salaryStrategy) {
        super(name);
        this.position = position;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = 0;
        this.salaryStrategy = salaryStrategy;
    }

    public void addHoursWorked(int hours) {
        this.hoursWorked += hours;
        System.out.println(this.getName() + " has now worked " + this.hoursWorked + " hours.");
    }

    public double paySalary() {
        double salary = salaryStrategy.calculateSalary(hoursWorked, hourlyRate);
        System.out.println(this.getName() + " earned a salary of: $" + salary);
        hoursWorked = 0;
        return salary;
    }

    @Override
    public void addMoney(double amount) { }

    @Override
    public void deductMoney(double amount) { }

    @Override
    public double getMoney() { return 0.0; }

    @Override
    public void setMoney(double amount) { }
}

