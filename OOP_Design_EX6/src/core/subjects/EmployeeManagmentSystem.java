package core.subjects;

import java.util.ArrayList;
import java.util.List;

import core.domain.Employee;
import core.observer.IObserver;

public class EmployeeManagmentSystem implements ISubject {

	private Employee employee;
	private String message;
	private List<IObserver> observers;
	
	@Override
	public void registerObserver(IObserver observer) {
		if (observers == null) {
			observers = new ArrayList<IObserver>();
		}
		observers.add(observer);
	}
	
	
	public void hireEmployee(Employee employee) {
		message = employee.getName() + " Hired...";
		notifyObservers();
	}


	@Override
	public void removeObserver(IObserver observer) {
		if (observers == null) { return; }
		observers.remove(observer);
	}



	@Override
	public void notifyObservers() {
		for (IObserver iObserver : observers) {
			iObserver.callMe(message);
		}
	}
}
