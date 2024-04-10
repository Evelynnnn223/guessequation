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
	}
	public void updateSetAirth(int c,JButton button1) {
		sv.updateSetAirth(c, button1);
	}
	public void updateSetNum(int num,JButton button1) {
		sv.updateSetNum(num, button1);
	}
}
