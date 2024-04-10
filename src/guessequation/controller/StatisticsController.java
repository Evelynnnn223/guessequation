package guessequation.controller;

import guessequation.modle.StatisticsModle;
import guessequation.view.StatisticsView;

public class StatisticsController implements ControllerObserver{
	private StatisticsModle smodle;
	private StatisticsView sv;
	
	public StatisticsController(StatisticsModle smodle, StatisticsView sv) {
		super();
		this.smodle = smodle;
		this.sv = sv;
	}
	public void setColumn(int column) {
		sv.setColumn(column);;
	}
//	public int getGamesPlayed() {
//		return smodle.getGamesPlayed();
//	}
//
//	public int getGamesWon() {
//		return smodle.getGamesWon();
//	}
//
//	public double getPercentageWin() {
//		return smodle.getPercentageWin();
//	}
//
//	public int getBestTry() {
//		return smodle.getBestTry();
//	}
//
//	public int getCurrentStreak() {
//		return smodle.getCurrentStreak();
//	}
//
//	public int getMaxStreak() {
//		return smodle.getMaxStreak();
//	}
//
//	public void addGamesPlayed() {
//		smodle.addGamesPlayed();
//	}
//	
//	public void addGamesWon() {
//		smodle.addGamesWon();
//	}
	
//	public void setPercentageWin(int percentageWin) {
//		smodle.setPercentageWin(percentageWin);
//	}
//	
//	public void setBestTry(int column) {
//		smodle.setBestTry(column);
//	}
//	
//	public void setCurrentStreak(int currentStreak) {
//		smodle.setCurrentStreak(currentStreak);
//	}
//	
//	public void setMaxStreak(int maxStreak) {
//		smodle.setMaxStreak(maxStreak);
//	}
//	public int getCorrectNumber(int index) {
//		return smodle.getCorrectNumber(index);
//	}
//	public double getAccuracy(int index) {
//		return (getCorrectNumber(index)*1.0/sv.getColumn())*100;
//	}
//	
	@Override
	public void updata() {
		setViewGamesPlayed();
		setViewGamesWon();
		setViewPercentageWin();
		setViewBestTry();
		setViewCurrentStreak();
		setViewMaxStreak();
		setViewList();
		setViesDlist();
	}
	public void setViewGamesPlayed() {
		sv.setGamesPlayed(smodle.getGamesPlayed());
	}

	public void setViewGamesWon() {
		sv.setGamesWon(smodle.getGamesWon());
	}

	public void setViewPercentageWin() {
		sv.setPercentageWin(smodle.getPercentageWin());
	}

	public void setViewBestTry() {
		sv.setBestTry(smodle.getBestTry());
	}

	public void setViewCurrentStreak() {
		sv.setCurrentStreak(smodle.getCurrentStreak());
	}

	public void setViewMaxStreak() {
		sv.setMaxStreak(smodle.getMaxStreak());
	}
	
	public void setViewList() {
		sv.setList(smodle.getList());
	}

	public void setViesDlist() {
		sv.setDlist(smodle.getDlist());
	}
}
