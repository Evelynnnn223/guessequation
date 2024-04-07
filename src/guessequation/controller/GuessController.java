package guessequation.controller;

import java.util.ArrayList;

import guessequation.modle.GuessModle;
import guessequation.view.View;

public class GuessController {
	private ArrayList<Character> list = new ArrayList<>();
	private View view;
	private GuessModle modle;
	public GuessController(View view,GuessModle modle) {
		this.view = view;
		this.modle = modle;
	}
	public void guess() {
		ArrayList<String> als = modle.getEquationList(list);
		ArrayList<Integer> relist = modle.guessModle(als);
		for(int i = 0;i<relist.size();i++) {
			int value = relist.get(i);
			if(value == 0) {
				view.greyImage(i);
			}else if(value == 1) {
				view.greenImage(i);
			}else if(value == 2) {
				view.yellowImage(i);
			}
		}
	}
	public void add(char str) {
		list.add(str);
	}
	public void remove() {
		list.remove(list.size()-1);
	}
}
