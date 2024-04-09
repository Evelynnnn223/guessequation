package guessequation.modle;

import java.util.ArrayList;

public class StatisticsModle {
	private int gamesPlayed=0;
	private int gamesWon = 0;
	private double percentageWin = 0;
	private int bestTry = 0;
	private int currentStreak = 0;
	private int maxStreak = 0;
	private ArrayList<Integer> list = new ArrayList<Integer>();
	private ArrayList<Integer> tlist = new ArrayList<Integer>();
	private ArrayList<Double> dlist = new ArrayList<Double>();
	public StatisticsModle() {
		for (int i = 0; i < 12; i++) {  
            list.add(0); 
            tlist.add(0); 
            dlist.add(0.0);
        }  
	}
	public void setList(int index,int value) {
		tlist.set(index, value);
	}
	public ArrayList<Integer> getList(){
		return list;
	}
	public int getGamesPlayed() {
		return gamesPlayed;
	}
	public void addGamesPlayed() {
		this.gamesPlayed++;
	}
	public int getGamesWon() {
		return gamesWon;
	}
	public void addGamesWon() {
		this.gamesWon++;
	}
	public double getPercentageWin() {
		return percentageWin;
	}
	public void setPercentageWin(double percentageWin) {
		this.percentageWin = percentageWin;
	}
	public int getBestTry() {
		return bestTry;
	}
	public void setBestTry(int column) {
		double max = 0;
		double tmax = 0;
		for (int i = 0; i < 12; i++) {
			if(dlist.get(i) == 1.0) {
				return;
			}
			if(tlist.get(i)*1.0/column == 1.0) {
				tmax = max+1;
				break;
			}
			max += dlist.get(i); 
			tmax += tlist.get(i)*1.0/column; 
        }  
		if(max < tmax) {
			this.bestTry = gamesPlayed;
			for (int i = 0; i < 12; i++) {  
				list.set(i,tlist.get(i)); 
				dlist.set(i, tlist.get(i)*1.0/column);
	        }
		}
	}
	public int getCurrentStreak() {
		return currentStreak;
	}
	public void setCurrentStreak(int currentStreak) {
		this.currentStreak = currentStreak;
	}
	public int getMaxStreak() {
		return maxStreak;
	}
	public void setMaxStreak(int maxStreak) {
		this.maxStreak = maxStreak;
	}
	public int getCorrectNumber(int index) {
		return list.get(index);
	}
	public void initCorrectNumberList() {
		for(int i =0;i<tlist.size();i++) {
			setList(i,0);
		}
	}
}
