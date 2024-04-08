package guessequation.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import guessequation.controller.GuessController;

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
		GuessController gc = view.getGuessController();
		if(gc.legal()) {
			gc.guess();
		}else {
			gv.prompt();
		}
	}
	public void symbol(ImageIcon icon,char str) {
		GuessController gc = view.getGuessController();
		gv.forward(icon);
		gc.add(str);
	}
	
	public void backward(ImageIcon icon) {
		GuessController gc = view.getGuessController();
		gv.backward(icon);
		gc.remove();
	}
	public void groove(int num,JButton button1) {
		for(int i=5;i<13;i++) {
			JButton button = sv.getSetbut1().get(i-5);
			ImageIcon icon = new ImageIcon("src/resource/set"+i+".png");
			button.setIcon(icon);
		}
		ImageIcon icon1 = new ImageIcon("src/resource/setgreen"+num+".png");
		button1.setIcon(icon1);
		gv.initgrid(num);
	}
	public void arithmetic(int c,JButton button1) {
		if(sv.getSetbut2().get(c-13) == 1 && sv.getSetbut2().stream().filter(v -> v == 1).count() > 1) {
			ImageIcon icon = new ImageIcon("src/resource/set"+c+".png");
			button1.setIcon(icon);
			sv.getSetbut2().set(c-13, 0);
		}else {
			ImageIcon icon1 = new ImageIcon("src/resource/setgreen"+c+".png");
			button1.setIcon(icon1);
			sv.getSetbut2().set(c-13, 1);
		}
	}
}
