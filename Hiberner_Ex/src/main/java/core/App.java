package core;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import core.entities.Employee;

public class App {

	public static void main(String[] args) {
		// Configuration object holds all configuration data from file and classes
				Configuration cfg = new Configuration().configure().addAnnotatedClass(Employee.class);

				// SessionFactory - gives us session objects - connection
				try (SessionFactory factory = cfg.buildSessionFactory();) {
					System.out.println("hibernate runs");
					
					Session session = factory.getCurrentSession();
					Employee employee = new Employee("one", "employee", "company1");
					// save 1 employee
					session.beginTransaction();
					session.save(employee); // persist an object
					session.getTransaction().commit(); // flush operations to the database
					// save 10 employees
					session.beginTransaction();
					for (int i = 0; i < 10; i++) {
						employee = new Employee("name_" + i, "lastName_" + i, "company_" + i);
						session.save(employee);
					}
					session.getTransaction().commit();
					
					// get employee
					session.beginTransaction();
					Employee employeeFromDB = session.get(Employee.class, employee.getId());
					session.getTransaction().commit();
					System.out.println(employeeFromDB);
				}
	}
}
