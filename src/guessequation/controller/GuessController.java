package guessequation.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.SwingUtilities;

import guessequation.modle.GuessModle;
import guessequation.view.GameView;
import guessequation.view.View;

public class GuessController {
	private ArrayList<Character> list = new ArrayList<>();
	private HashMap<Character,Integer> map = new HashMap<Character,Integer>();
	private GameView view;
	private GuessModle modle;
	public GuessController(GameView view,GuessModle modle) {
		this.view = view;
		this.modle = modle;
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
	public boolean legal() {
		String re1 =modle.getEquation(list);
		if(modle.legal(re1)) {
			return true;
		}else {
			return false;
		}
	}
	public void guess() {
//		ArrayList<String> als = modle.getEquationList(list);
		view.setIndex(0);
		ArrayList<Integer> relist = modle.guessModle(list);
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO 自动生成的方法存根
				for(int i = 0;i<relist.size();i++) {
					int value = relist.get(i);
					char ind = list.get(i);
					if(value == 0) {
						view.greyImage(map.get(ind));
					}else if(value == 1) {
						view.greenImage(map.get(ind));
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
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				}
				view.setIndex(0);
				view.lineAdd();
				list.clear();
			}
			
		});
		t.start();
	}
	public void add(char str) {
		list.add(str);
	}
	public void remove() {
		if(!list.isEmpty()) {
			list.remove(list.size()-1);
		}
	}
}
