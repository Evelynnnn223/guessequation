package guessequation.controller;

import guessequation.modle.StatisticsModle;
import guessequation.view.StatisticsView;

//Game result statistics interface controller
public class StatisticsController implements ControllerObserver{
	private StatisticsModle smodle;
	private StatisticsView sv;
	//Constructor Initializers 
	public StatisticsController(StatisticsModle smodle, StatisticsView sv) {
		super();
		this.smodle = smodle;
		this.sv = sv;
	}
	
	public void setColumn(int column) {
		sv.setColumn(column);;
	}

	//Observer Mode Update Method
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
	
	//Set game count
	public void setViewGamesPlayed() {
		sv.setGamesPlayed(smodle.getGamesPlayed());
	}
	//Set the number of game victories
	public void setViewGamesWon() {
		sv.setGamesWon(smodle.getGamesWon());
	}
	//Set game victory percentage
	public void setViewPercentageWin() {
		sv.setPercentageWin(smodle.getPercentageWin());
	}
	//Set the best number of times
	public void setViewBestTry() {
		sv.setBestTry(smodle.getBestTry());
	}
	//Set Current Streak
	public void setViewCurrentStreak() {
		sv.setCurrentStreak(smodle.getCurrentStreak());
	}
	//Set Max Streak
	public void setViewMaxStreak() {
		sv.setMaxStreak(smodle.getMaxStreak());
	}
	
	//Set the best score list
	public void setViewList() {
		sv.setList(smodle.getList());
	}
	//Set the best score percentage list
	public void setViesDlist() {
		sv.setDlist(smodle.getDlist());
	}
}
