package guessequation.controller;

import java.util.HashMap;

import javax.swing.JButton;

import guessequation.modle.GuessModle;
import guessequation.view.SetView;

public class SetController {
	private GuessModle modle;
	private SetView sv;
	private HashMap<Integer,Character> map = new HashMap<Integer,Character>();
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
	public void updateSetAirth(int c,JButton button1) {
		boolean v = sv.updateSetAirth(c, button1);
		if(v) {
			modle.removeNosylsit(map.get(c));
		}else {
			modle.addNosylsit(map.get(c));
		}
		modle.setEquation();
		modle.notifyObservers();
	}
	public void updateSetNum(int num,JButton button1) {
		sv.updateSetNum(num, button1);
	}
	public void setDisplayError() {
		boolean v = modle.setDisplayError();
		sv.setOffOn(0, v);
	}
	public void setDisplayEquation() {
		boolean v = modle.setDisplayEquation();
		sv.setOffOn(1, v);
	}
	public void setRandomEquation() {
		boolean v = modle.setRandomEquation();
		sv.setOffOn(2, v);
	}
}
