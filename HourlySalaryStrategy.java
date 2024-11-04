package org.example;
import org.example.interfaces.SalaryStrategy;

public class HourlySalaryStrategy implements SalaryStrategy {
    @Override
    public double calculateSalary(int hoursWorked, double rate) {
        return hoursWorked * rate;
    }
}
