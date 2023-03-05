package com.osgi.emp.service.consumer;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import com.osgi.emp.service.publisher.EmployeeManagementImpl;
import com.osgi.emp.service.publisher.EmployeeManagementService;

public class ServiceActivator implements BundleActivator {
	
	ServiceReference serviceReference;

	public void start(BundleContext context) throws Exception {
		
		System.out.println("=================================.Dominos Pizza Store Employee Consumer Started.==================================");
		System.out.println(" ");
		/* Attach referred service */
		serviceReference = context.getServiceReference(EmployeeManagementService.class.getName());
		EmployeeManagementService empMsP = (EmployeeManagementService)context.getService(serviceReference);
		
		
	    final String ADD_EMPLOYEE = "1";
	    final String REMOVE_EMPLOYEE = "2";
	    final String SEARCH_EMPLOYEE = "3";
	    final String ADD_WORKING_HOURS = "4";
	    final String GENERATE_SALARY = "5";
	    final String EXIT = "6";

	    	
	    	EmployeeManagementImpl employeeManager = new EmployeeManagementImpl();
	        Scanner scanner = new Scanner(System.in);

	        String choice;
	        do {
	        	System.out.println("\r\n"
	        			+ "  ____   ___  __  __ ___ _   _  ___  _       ____ ___ __________   _      ____  _____ ______     _____ ____ _____ \r\n"
	        			+ " |  _ \\ / _ \\|  \\/  |_ _| \\ | |/ _ \\( )___  |  _ \\_ _|__  /__  /  / \\    / ___|| ____|  _ \\ \\   / /_ _/ ___| ____|\r\n"
	        			+ " | | | | | | | |\\/| || ||  \\| | | | |// __| | |_) | |  / /  / /  / _ \\   \\___ \\|  _| | |_) \\ \\ / / | | |   |  _|  \r\n"
	        			+ " | |_| | |_| | |  | || || |\\  | |_| | \\__ \\ |  __/| | / /_ / /_ / ___ \\   ___) | |___|  _ < \\ V /  | | |___| |___ \r\n"
	        			+ " |____/ \\___/|_|  |_|___|_| \\_|\\___/  |___/ |_|  |___/____/____/_/   \\_\\ |____/|_____|_| \\_\\ \\_/  |___\\____|_____|\r\n"
	        			+ "                                                                                                                  \r\n"
	        			+ "");
	            System.out.println("Domino's Pizza's Employee Manager Menu:" + "\n");
	            System.out.println("1. Add Employee");
	            System.out.println("2. Remove Employee");
	            System.out.println("3. Search Employee");
	            System.out.println("4. Add Working Hours");
	            System.out.println("5. Generate Salary");
	            System.out.println("6. Exit");
	            System.out.println(" ");
	            System.out.print("Enter your choice : ");
	            choice = scanner.nextLine();

	            switch (choice) {
	                case ADD_EMPLOYEE:
	                    System.out.print("Enter employee name : ");
	                    String name = scanner.nextLine();
	                    System.out.print("Enter employee salary : ");
	                    double salary = Double.parseDouble(scanner.nextLine());
	                    employeeManager.addEmployee(name, salary);
	                    System.out.println(" ");
	                    break;
	                case REMOVE_EMPLOYEE:
	                    System.out.print("Enter employee ID : ");
	                    String removeId = scanner.nextLine();
	                    employeeManager.removeEmployee(removeId);
	                    System.out.println(" ");
	                    break;
	                case SEARCH_EMPLOYEE:
	                    System.out.print("Enter employee ID : ");
	                    String searchId = scanner.nextLine();
	                    employeeManager.searchEmployee(searchId);
	                    System.out.println(" ");
	                    break;
	                case ADD_WORKING_HOURS:
	                    System.out.print("Enter employee ID : ");
	                    String workingHoursId = scanner.nextLine();
	                    System.out.print("Enter working hours: ");
	                    double workingHours = Double.parseDouble(scanner.nextLine());
	                    employeeManager.addWorkingHours(workingHoursId, workingHours);
	                    System.out.println(" ");
	                    break;
	                case GENERATE_SALARY:
	                    System.out.print("Enter employee ID : ");
	                    String salaryId = scanner.nextLine();
	                    employeeManager.generateSalary(salaryId);
	                    System.out.println(" ");
	                    break;
	                case EXIT:
	                	System.out.println(" ");
	                    System.out.println("Exiting Employee Manager");
	                    stop(context);
	                    System.out.println(" ");
	                    break;
	                default:
	                    System.out.println("Invalid choice!");
	                    System.out.println(" ");
	                    break;
	            }
	        } while (!choice.equals(EXIT));

	        scanner.close();
	        
	    }

	public void stop(BundleContext context) throws Exception {
		
		System.out.println(" ");
		System.out.println("<----------Dominos Pizza Service Stopped---------->");
		System.out.println(" ");
		/* Detach referred service */
		context.ungetService(serviceReference); 
	}

}
