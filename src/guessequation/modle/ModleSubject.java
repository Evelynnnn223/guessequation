package guessequation.modle;

import java.util.ArrayList;

import guessequation.controller.ControllerObserver;

//Subject base class
public class ModleSubject {
	protected ArrayList<ControllerObserver> list = new ArrayList<ControllerObserver>();//Observer list
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
