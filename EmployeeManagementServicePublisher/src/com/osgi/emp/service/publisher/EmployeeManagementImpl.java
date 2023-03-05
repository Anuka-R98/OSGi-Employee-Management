package com.osgi.emp.service.publisher;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmployeeManagementImpl implements EmployeeManagementService {
    private Map<String, Double> employeeMap;

    /* employee object initialization */
    public EmployeeManagementImpl() {
        employeeMap = new HashMap<>();
    }
    
    /* adding employee details */
    @Override
    public void addEmployee(String name, double salary) {
        String id = generateId();
        employeeMap.put(id, salary);
        System.out.println("Employee Added !!!");
        System.out.println("+--------+----------------------+----------+");
        System.out.println("|  ID    |    Employee Name     |  Salary  |");
        System.out.println("+--------+----------------------+----------+");
        System.out.println(String.format("|  %-5s |  %-20s | $%7.2f |", id, name, salary));
        System.out.println("+--------+----------------------+----------+");
        System.out.println(" ");
    }
    
    /* generate unique employee id starting with EMP */
    private String generateId() {
        return "EMP" + (employeeMap.size() + 1);
    }

    /* removing employee */
    @Override
    public void removeEmployee(String id) {
        try {
            if (employeeMap.containsKey(id)) {
                employeeMap.remove(id);
                System.out.println(" ");
                System.out.println("\nEmployee removed successfully! \nEmployee ID: " + id);
                System.out.println(" ");
            } else {
                throw new Exception("Employee not found!"  + "\n");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    /* search employee */
    @Override
    public void searchEmployee(String id) {
        try {
            if (employeeMap.containsKey(id)) {
            	System.out.println(" ");
            	System.out.println("Employee found !!!");
            	System.out.println("+-------------+--------+");
            	System.out.println("| Employee ID | Salary |");
            	System.out.println("+-------------+--------+");
            	System.out.printf("| %-12s| %-7.2f|%n", id, employeeMap.get(id));
            	System.out.println("+-------------+--------+");
                System.out.println(" ");
            } else {
                throw new Exception("Employee not found!" + "\n");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /* adding working hours for an employee */
    @Override
    public void addWorkingHours(String id, double hours) {
        try {
            if (employeeMap.containsKey(id)) {
                double currentSalary = employeeMap.get(id);
                double newSalary = currentSalary + (hours * 10); //assuming hourly rate of $10
                employeeMap.put(id, newSalary);
                System.out.println(" ");
                System.out.println("Working hours added !!!");
                System.out.format("+-----------+----------------+----------------+----------------+%n");
                System.out.format("| %-9s | %-14s | %-14s | %-14s |%n", "Employee ID", "Current Salary", "Working Hours", "New Salary");
                System.out.format("+-----------+----------------+----------------+----------------+%n");
                System.out.format("| %-9s | $%-13.2f | %-14.2f | $%-13.2f |%n", id, currentSalary, hours, newSalary);
                System.out.format("+-----------+----------------+----------------+----------------+%n");
                System.out.println(" ");
            } else {
                throw new Exception("Employee not found!" + "\n");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    /* generate salary for employee */
    @Override
    public double generateSalary(String id) {
        try {
            if (employeeMap.containsKey(id)) {
                double salary = employeeMap.get(id);
                System.out.println(" ");
                System.out.println("Salary generated !!!");
                System.out.println("+-------------+--------+");
                System.out.println("| Employee ID | Salary |");
                System.out.println("+-------------+--------+");
                System.out.printf("| %-11s| %.2f  |\n", id, salary);
                System.out.println("+-------------+--------+");
                System.out.println(" ");
                return salary;
            } else {
                throw new Exception("Employee not found!" + "\n");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
   
}