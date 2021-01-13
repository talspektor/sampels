package core.subjects;

import core.observer.IObserver;

public interface ISubject {
	void registerObserver(IObserver observer);
	void removeObserver(IObserver observer);
	void notifyObservers();
}
