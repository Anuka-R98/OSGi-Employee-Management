package com.osgi.emp.service.publisher;

public interface EmployeeManagementService {
	    
    // Method to add a new employee to the system
    void addEmployee(String name, double salary);
    
    // Method to remove an employee from the system
    void removeEmployee(String id);
    
    // Method to retrieve an employee's information by their ID
    void searchEmployee(String id);
    
    // Method to add working hours for an employee
    void addWorkingHours(String id, double hours);
    
    // Method to generate a salary for an employee
    double generateSalary(String id);

}
