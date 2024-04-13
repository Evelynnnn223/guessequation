package guessequation.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import guessequation.controller.GameController;
import guessequation.controller.SetController;
import guessequation.controller.StatisticsController;

//Class for executing actions
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

	//Click enter button action
	public void enter() {
		if(gc.legal(gc.getViewColumn())) {
			gc.guess();
			sc.enableRestart();
		}
	}
	
	//The action of clicking on the number and operation symbol buttons
	public void symbol(ImageIcon icon,char str) {
		gc.add(str,icon);
	}
	
	//Click backward button action
	public void backward(ImageIcon icon) {
		gc.remove(icon);
	}
	
	//Action of clicking the set equation length button
	public void groove(int num,JButton button1) {
		sc.updateSetNum(num,button1);
		gc.initGrid(num);
		gc.clearList();
		stc.setColumn(num);
		sc.disableRestart();
	}
	
	//Click restart button action
	public void restart() {
		gc.initGrid(gc.getViewColumn());
		gc.clearList();
		sc.disableRestart();
	}
	
	//Click the exclude operation symbol button action
	public void arithmetic(int c,JButton button1) {
		sc.updateSetAirth(c, button1);
		gc.initGrid(gc.getViewColumn());
		gc.clearList();
		sc.disableRestart();
	}
	
	//Click DisplayError button action
	public void displayError() {
		sc.setDisplayError();
	}
	
	//Click DisplayEquation button action
	public void displayEquation() {
		sc.setDisplayEquation();
	}
	
	//Click RandomEquation button action
	public void randomEquation() {
		sc.setRandomEquation();
		gc.initGrid(gc.getViewColumn());
		gc.clearList();
		sc.disableRestart();
	}
}
