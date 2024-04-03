package guessequation.modle;

import java.util.ArrayList;

public class GuessModle {
	private ArrayList<String> list = new ArrayList<>();
	
	public void init(int size) {
		
	}
	
	public ArrayList<Integer> guessModle(int line,ArrayList<String> inlist){
		ArrayList<Integer> relist = new ArrayList<Integer>();
		String sline = list.get(line);
		for(int i = 0;i<inlist.size();i++) {
			int rec = sline.indexOf(inlist.get(i));
			if(rec == -1) {
				relist.add(0);
			}else if(rec == i) {
				relist.add(1);
			}else {
				relist.add(2);
			}
		}
		return relist;
	}
}
