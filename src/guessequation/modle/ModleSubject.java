package guessequation.modle;

import java.util.ArrayList;

import guessequation.controller.ControllerObserver;

public class ModleSubject {
	protected ArrayList<ControllerObserver> list = new ArrayList<ControllerObserver>();
	public void addObserver(ControllerObserver observer) {
		list.add(observer);
	}
	public void removeObserver(ControllerObserver observer) {
    	list.remove(observer);
    }
	public void notifyObservers() {
    	for(ControllerObserver observer : list) {
    		observer.updata();
    	}
    }
}
