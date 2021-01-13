package core;

public class App {

	public static void main(String[] args) {
		IObserver payrollIObserver = new PayrollDepartment();
		IObserver hRIObserver = new HRDepartment();
		
		EmployeeManagmentSystem employeeManagmentSystem = new EmployeeManagmentSystem();
		
		employeeManagmentSystem.registerObserver(hRIObserver);
		employeeManagmentSystem.registerObserver(payrollIObserver);
		
		Employee employee = new Employee("Bob");
		employeeManagmentSystem.hireEmployee(employee);
	}
}
