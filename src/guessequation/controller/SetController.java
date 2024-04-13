package guessequation.controller;

import java.util.HashMap;

import javax.swing.JButton;

import guessequation.modle.GuessModle;
import guessequation.view.SetView;

//Controller for setting interface
public class SetController {
	private GuessModle modle;
	private SetView sv;
	private HashMap<Integer,Character> map = new HashMap<Integer,Character>();//The corresponding serial number for storing symbols
	//Constructor Initializers 
	public SetController(GuessModle modle, SetView sv) {
		super();
		this.modle = modle;
		this.sv = sv;
		sv.setOffOn(0, modle.isDisplayError());
		sv.setOffOn(1, modle.isDisplayEquation());
		sv.setOffOn(2, modle.isRandomEquation());
		map.put(13,'+');
		map.put(14,'-');
		map.put(15,'*');
		map.put(16,'/');
	}
	
	//Interface for symbolic buttons
	public void updateSetAirth(int c,JButton button1) {
		boolean v = sv.updateSetAirth(c, button1);
		if(v) {
			modle.removeNosylsit(map.get(c));
		}else {
			modle.addNosylsit(map.get(c));
		}
		modle.setEquation();//Regenerate equation
		modle.notifyObservers();//Notify all observers
	}
	
	//Equation length button interface
	public void updateSetNum(int num,JButton button1) {
		sv.updateSetNum(num, button1);
	}
	
	//DisplayError button interface
	public void setDisplayError() {
		boolean v = modle.setDisplayError();
		sv.setOffOn(0, v);
	}
	
	//DisplayEquation button interface
	public void setDisplayEquation() {
		boolean v = modle.setDisplayEquation();
		sv.setOffOn(1, v);
	}
	//RandomEquation button interface
	public void setRandomEquation() {
		boolean v = modle.setRandomEquation();
		sv.setOffOn(2, v);
	}
	//Restart button interface
	public void disableRestart() {
		sv.disableRestart();
	}
	//Enable restart button
	public void enableRestart() {
		sv.enableRestart();
	}
}
