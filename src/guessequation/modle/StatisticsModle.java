package guessequation.modle;

import java.util.ArrayList;

//Statistics Modle
public class StatisticsModle extends ModleSubject{
	private int gamesPlayed=0;//Number of games played
	private int gamesWon = 0;//Number of games won
	private double percentageWin = 0;//percentage of games won
	private int bestTry = 0;//Number of best grades
	private int currentStreak = 0;//current streak
	private int maxStreak = 0;//max streak
	private ArrayList<Integer> list = new ArrayList<Integer>();//Number of best grades list
	private ArrayList<Integer> tlist = new ArrayList<Integer>();//temp grades list
	private ArrayList<Double> dlist = new ArrayList<Double>();//percentage of best grades list
	//Constructor Initializers 
	public StatisticsModle() {
		for (int i = 0; i < 12; i++) {  
            list.add(0); 
            tlist.add(0); 
            dlist.add(0.0);
        }  
	}
	
	public ArrayList<Double> getDlist() {
		return dlist;
	}

	public void setDlist(ArrayList<Double> dlist) {
		this.dlist = dlist;
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
	
	//set number of best grades
	public void setBestTry(int column) {
		double max = 0;//Historical best score
		double tmax = 0;//Current grades
		//Compare the accuracy of each attempt
		for (int i = 0; i < 12; i++) {
			//The historical best score has a 100% accuracy rate in the current number of attempts
			if(dlist.get(i) == 1.0) {
				return;
			}
			//The current score has a 100% accuracy rate in the current number of attempts
			if(tlist.get(i)*1.0/column == 1.0) {
				tmax = max+1;
				break;
			}
			max += dlist.get(i); 
			tmax += tlist.get(i)*1.0/column; 
        } 
		//The current score is even better than the historical best score
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
	
	//Reinitialize the best score list
	public void initCorrectNumberList() {
		for(int i =0;i<tlist.size();i++) {
			setList(i,0);
		}
	}
}
