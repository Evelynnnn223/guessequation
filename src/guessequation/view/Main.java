package guessequation.view;

import javax.swing.*;

import guessequation.controller.GameController;
import guessequation.controller.SetController;
import guessequation.controller.StatisticsController;
import guessequation.modle.GuessModle;
import guessequation.modle.StatisticsModle;

public class Main {

	public static void main(String[] args) {
		Action ac = new Action();
		GameView gv = new GameView(5,ac);
		SetView sv = new SetView(gv.getColumn(),ac);
		HelpView hv = new HelpView();
		StatisticsView stv = new StatisticsView();
		StatisticsModle smodle = new StatisticsModle();
		StatisticsController sc = new StatisticsController(smodle, stv);
		smodle.addObserver(sc);
		smodle.notifyObservers();
		stv.setColumn(gv.getColumn());
		GuessModle gm = new GuessModle();
		GameController gc = new GameController(gv, gm,smodle);
		gm.setColumn(gv.getColumn());
		gm.init();
		gm.addObserver(gc);
		gm.notifyObservers();
		MainView mv = new MainView(gm, gc);
		SetController sec = new SetController(gm, sv);
		ac.setGc(gc);
		ac.setSc(sec);
		ac.setStc(sc);
		ImageIcon tab1Icon = new ImageIcon("src/resource/n+.png");
		ImageIcon tab2Icon = new ImageIcon("src/resource/statistics.png");
		ImageIcon tab3Icon = new ImageIcon("src/resource/set.png");
		ImageIcon tab4Icon = new ImageIcon("src/resource/help.png");
		mv.addTab(gv, tab1Icon, "游戏");
		mv.addTab(stv, tab2Icon, "统计");
		mv.addTab(sv, tab3Icon, "设置");
		mv.addTab(hv, tab4Icon, "帮助");
	}

}
