package core.observer;

public class HRDepartment implements IObserver {

	@Override
	public void callMe(String message) {
		System.out.println("Call HRDepartment");
		System.out.println(message);
	}

}
