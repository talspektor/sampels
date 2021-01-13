package core.observer;

public class PayrollDepartment implements IObserver {

	@Override
	public void callMe(String message) {
		System.out.println("Call PayrollDepartment");
		System.out.println(message);
	}

}
