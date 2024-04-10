package guessequation.controller;

import javax.swing.JButton;

import guessequation.modle.GuessModle;
import guessequation.view.SetView;

public class SetController {
	private GuessModle modle;
	private SetView sv;
	public SetController(GuessModle modle, SetView sv) {
		super();
		this.modle = modle;
		this.sv = sv;
		sv.setOffOn(0, modle.isDisplayError());
		sv.setOffOn(1, modle.isDisplayEquation());
		sv.setOffOn(2, modle.isRandomEquation());
	}
	public void updateSetAirth(int c,JButton button1) {
		sv.updateSetAirth(c, button1);
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
