package com.osgi.emp.service.publisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;


public class EmpServiceActivator implements BundleActivator {

	ServiceRegistration publishServiceRegistration;

	public void start(BundleContext context) throws Exception {
		
		System.out.println("<-- Employee Management Service (Provider) Started -->");
		EmployeeManagementService empMsP = new EmployeeManagementImpl();
		
		/* Registering services */
		publishServiceRegistration = context.registerService(EmployeeManagementService.class.getName(), empMsP, null);

	}

	public void stop(BundleContext context) throws Exception {
		
		System.out.println("<-- Employee Management Service (Provider) Stopped -->");
		
		/* Unregistering services */
		publishServiceRegistration.unregister();

	}

}
