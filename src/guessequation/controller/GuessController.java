package guessequation.controller;

import java.util.ArrayList;

import guessequation.modle.GuessModle;
import guessequation.view.View;

public class GuessController {
	private ArrayList<String> list = new ArrayList<>();
	private View view;
	private GuessModle modle;
	public GuessController(View view,GuessModle modle) {
		this.view = view;
		this.modle = modle;
	}
	public void guess(int line) {
		ArrayList<Integer> relist = modle.guessModle(line, list);
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
	public void add(String str) {
		list.add(str);
	}
	public void remove() {
		list.remove(list.size()-1);
	}
}
