package guessequation.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

import guessequation.modle.GuessModle;
import guessequation.modle.StatisticsModle;
import guessequation.view.GameView;
import guessequation.view.View;
//Controller of game page
public class GameController implements ControllerObserver{
	private ArrayList<Character> list = new ArrayList<>();//List of equation characters entered
	private HashMap<Character,Integer> map = new HashMap<Character,Integer>();//Sequence number corresponding to equation characters
	private GameView view;
	private GuessModle modle;
	private StatisticsModle smodle;
	//Constructor Initializers 
	public GameController(GameView view,GuessModle modle,StatisticsModle smodle) {
		this.view = view;
		this.modle = modle;
		this.smodle = smodle;
		map.put('0',0);
		map.put('1',1);
		map.put('2',2);
		map.put('3',3);
		map.put('4',4);
		map.put('5',5);
		map.put('6',6);
		map.put('7',7);
		map.put('8',8);
		map.put('9',9);
		map.put('+',10);
		map.put('-',11);
		map.put('*',12);
		map.put('/',13);
		map.put('=',14);
	}
	//Check whether the equation meets the standard
	public boolean legal(int column) {
		String re1 =modle.getEquation(list);
		String rec = modle.legal(re1,column);
		if(rec.equals("OK")) {
			return true;
		}else {
			if(modle.isDisplayError()) {
				prompt(rec);
			}
			return false;
		}
	}
	//Equation guessing method
	public void guess() {
		view.setIndex(0);
		ArrayList<Integer> relist = modle.guessModle(list);
		//Real time update interface
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO 自动生成的方法存根
				int greenSum = 0;//Correct quantity
				//Traverse the result list and output different colored numbers to the interface
				for(int i = 0;i<relist.size();i++) {
					int value = relist.get(i);
					char ind = list.get(i);
					if(value == 0) {
						view.greyImage(map.get(ind));
					}else if(value == 1) {
						view.greenImage(map.get(ind));
						greenSum++;
					}else if(value == 2) {
						view.yellowImage(map.get(ind));
					}
					try {
					SwingUtilities.invokeAndWait(new Runnable() {
						
						@Override
						public void run() {
							// TODO 自动生成的方法存根
							view.repaint(); 
						}
					});
				} catch (InvocationTargetException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				}
				smodle.setList(view.getLine(), greenSum);
				view.setIndex(0);
				view.lineAdd();
				list.clear();
				if(greenSum == relist.size()) {//Guess correctly
					view.won(); 
					view.initGrid(view.getColumn());
					if(!modle.isDisplayError()) {
						smodle.addGamesPlayed();//Game count+1
						smodle.addGamesWon();//Game Won+1
						smodle.setPercentageWin((smodle.getGamesWon()*1.0/smodle.getGamesPlayed())*100);//Set winning rate
						smodle.setBestTry(view.getColumn());//Set the best score frequency serial number
						smodle.notifyObservers();//Notify all observers
						smodle.initCorrectNumberList();//Reinitialize the correct number list
					}
					modle.setColumn(view.getColumn());//Reset equation length
					modle.setEquation();//Regenerate equation
					modle.notifyObservers();//Notify all observers
				}else if(greenSum != relist.size() && view.getLine() >= 6) {//Guessing is incorrect 6 times
					view.fail(); 
					view.initGrid(view.getColumn());
					if(!modle.isDisplayError()) {
						smodle.addGamesPlayed();
						smodle.setPercentageWin((smodle.getGamesWon()*1.0/smodle.getGamesPlayed())*100);
						smodle.setBestTry(view.getColumn());
						smodle.notifyObservers();
						smodle.initCorrectNumberList();
					}
					modle.setColumn(view.getColumn());
					modle.setEquation();
					modle.notifyObservers();
				}
			}
			
		});
		t.start();
	}
	//Clear list content
	public void clearList() {
		list.clear();
	}
	//Add content to the list
	public void add(char str,ImageIcon icon) {
		if(view.forward(icon)) {
			list.add(str);
		}
	}
	//Delete List Content
	public void remove(ImageIcon icon) {
		if(!list.isEmpty()) {
			list.remove(list.size()-1);
			view.backward(icon);
		}
	}
	//Display prompt messages
	public void prompt(String str) {
		view.prompt(str);
	}
	//Reinitialize the program
	public void initGrid(int column) {
		view.initGrid(column);
		modle.setColumn(view.getColumn());
		modle.setEquation();
		modle.notifyObservers();
	}
	
	//Obtain equation length
	public int getViewColumn() {
		return view.getColumn();
	}
	//Observer Mode Update Method
	@Override
	public void updata() {
		// TODO 自动生成的方法存根
		view.displayEquation(modle.getEquation());
	}
}
