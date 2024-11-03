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



    @Override
    public void addMoney(double amount) { }

  

    @Override
    public double getMoney() { return 0.0; }

    @Override
    public void setMoney(double amount) { }
}

