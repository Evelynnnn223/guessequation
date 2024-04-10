package guessequation.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import guessequation.controller.GameController;
import guessequation.controller.SetController;
import guessequation.controller.StatisticsController;

public class Action {
	private GameController gc;
	private SetController sc;
	private StatisticsController stc;

	public void setGc(GameController gc) {
		this.gc = gc;
	}

	public void setSc(SetController sc) {
		this.sc = sc;
	}
	

	public void setStc(StatisticsController stc) {
		this.stc = stc;
	}

	public Action() {
		super();
	}

	public void enter() {
		if(gc.legal(gc.getViewColumn())) {
			gc.guess();
		}
	}
	public void symbol(ImageIcon icon,char str) {
		gc.add(str,icon);
	}
	
	public void backward(ImageIcon icon) {
		gc.remove(icon);
	}
	public void groove(int num,JButton button1) {
		sc.updateSetNum(num,button1);
		gc.initGrid(num);
		gc.clearList();
		stc.setColumn(num);
	}
	public void arithmetic(int c,JButton button1) {
		sc.updateSetAirth(c, button1);
	}
	
	public void displayError() {
		sc.setDisplayError();
	}
	public void displayEquation() {
		sc.setDisplayEquation();
	}
	public void randomEquation() {
		sc.setRandomEquation();
	}
}
