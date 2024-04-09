package guessequation.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import guessequation.controller.GameController;

public class Action {

	private GameView gv;
	private MainView view;
	private SetView sv;
	
	public Action() {
		super();
	}
	
	public void setGv(GameView gv) {
		this.gv = gv;
	}

	public void setView(MainView view) {
		this.view = view;
	}

	public void setSv(SetView sv) {
		this.sv = sv;
	}

	public void enter() {
		GameController gc = view.getGuessController();
		if(gc.legal()) {
			gc.guess();
		}else {
			gv.prompt();
		}
	}
	public void symbol(ImageIcon icon,char str) {
		GameController gc = view.getGuessController();
		gv.forward(icon);
		gc.add(str);
	}
	
	public void backward(ImageIcon icon) {
		GameController gc = view.getGuessController();
		gv.backward(icon);
		gc.remove();
	}
	public void groove(int num,JButton button1) {
		sv.updateSetNum(num,button1);
		GameController gc = view.getGuessController();
		gv.initGrid(num);
		gc.clearList();
	}
	public void arithmetic(int c,JButton button1) {
		sv.updateSetAirth(c, button1);
	}
}
