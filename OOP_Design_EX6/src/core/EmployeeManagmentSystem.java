package core;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManagmentSystem {

//	private Employee employee;
	private List<IObserver> observers;
	
	public void registerObserver(IObserver observer) {
		if (observers == null) {
			observers = new ArrayList<IObserver>();
		}
		observers.add(observer);
	}
	
	public void notifyAllDepartments(String message) {
		for (IObserver iObserver : observers) {
			iObserver.callMe(message);
		}
	}
	
	public void hireEmployee(Employee employee) {
		notifyAllDepartments(employee.getName() + " Hired...");
	}
}
