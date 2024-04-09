package guessequation.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.SwingUtilities;

import guessequation.modle.GuessModle;
import guessequation.view.GameView;
import guessequation.view.View;

public class GameController {
	private ArrayList<Character> list = new ArrayList<>();
	private HashMap<Character,Integer> map = new HashMap<Character,Integer>();
	private GameView view;
	private GuessModle modle;
	public GameController(GameView view,GuessModle modle) {
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
	public boolean legal(int column) {
		String re1 =modle.getEquation(list);
		if(modle.legal(re1,column)) {
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
				// TODO �Զ����ɵķ������
				int greenSum = 0;
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
							// TODO �Զ����ɵķ������
							view.repaint(); 
						}
					});
				} catch (InvocationTargetException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}
				}
				view.setIndex(0);
				view.lineAdd();
				list.clear();
				if(greenSum == relist.size()) {
					view.won(); 
					view.initGrid(view.getColumn());			
				}
			}
			
		});
		t.start();
	}
	public void clearList() {
		list.clear();
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
