package guessequation.modle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

//Guess Modle
public class GuessModle extends ModleSubject{
	private String equation;//Represents the current equation
	private boolean displayError = false;//Display error message switch
	private boolean displayEquation = false;//Display Equation switch
	private boolean randomEquation = true;//Random generation equation switch
	private ArrayList<Character> nosylsit = new ArrayList<Character>();//Exclude symbol list
	private ArrayList<ArrayList<String>> equationList = new ArrayList<ArrayList<String>>();//List of equations of different lengths
	private File file = new File("src/resource/equations.txt");  
	private int column;//Equation length
	//initialization
	public void init() {
		for(int i=5;i<=12;i++) {
			equationList.add(new ArrayList<String>());
        }
		loadFile();
		setEquation();
	}
	
	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	//Add excluded symbols
	public void addNosylsit(char sym) {
		nosylsit.add(sym);
	}
	
	//remove excluded symbols
	public void removeNosylsit(Character sym) {
		nosylsit.remove(sym);
	}
	
	//Set the value of the equation
	public void setEquation() {
		equation = loadEquation();
	}
	
	//Generating equations
	public String loadEquation() {
        int index = 0;  
        ArrayList<String> list = equationList.get(column-5);//Current length equation list
        if(randomEquation) {
        	Random rand = new Random();
        	index = rand.nextInt(list.size());
        }
        //Traverse the current length equation list and find the equation that meets the conditions
        for(int i = index;;) {
        	String line = list.get(i);
        	boolean bnosy = true;//Indicates whether the current equation contains symbols to exclude
        	//Remove equations with specified symbols
        	for(int j=0;j<nosylsit.size();j++) {
        		if(line.indexOf(nosylsit.get(j)) != -1) {
        			bnosy = false;
        			break;
        		}
        	}
        	if(bnosy) {
            	return line;
        	}
        	i++;
        	//Traverse to the end and return to the beginning
        	if(i == list.size()) {
        		i = 0;
        	}
        	if(i == index) {
        		return "There is no equation that meets the requirements";
        	}
        }
	}
	
	//Load file, initialize equation list
	public void loadFile() {
        BufferedReader reader = null;  
        try {  
            reader = new BufferedReader(new FileReader(file));  
            String line = null;  
            //Read the equation line by line and add it to the specified list based on its length
            while ((line = reader.readLine()) != null) { 
            	if(line.length() < 13) {
            		equationList.get(line.length()-5).add(line);
            	}
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                if (reader != null) {  
                    reader.close();  
                }  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
	}
	//Obtain the current equation
	public String getEquation() {
		if(displayEquation) {
			return "Now Equation:"+this.equation;
		}else {
			return "";
		}
	}
	
	//Is the display error turned on
	public boolean isDisplayError() {
		return displayError;
	}
	
	//Set display error switch
	public boolean setDisplayError() {
		if(this.displayError) {
			this.displayError = false;
		}else {
			this.displayError = true;
		}
		return this.displayError;
	}

	//Is the display equation turned on
	public boolean isDisplayEquation() {
		return displayEquation;
	}

	//Set display equation switch
	public boolean setDisplayEquation() {
		if(this.displayEquation) {
			this.displayEquation = false;
		}else {
			this.displayEquation = true;
		}
		notifyObservers();//Notify all observers
		return this.displayEquation;
	}

	//Returns the switch for a random equation
	public boolean isRandomEquation() {
		return randomEquation;
	}

	//Set the switch for stochastic equations
	public boolean setRandomEquation() {
		if(this.randomEquation) {
			this.randomEquation = false;
		}else {
			this.randomEquation = true;
		}
		return this.randomEquation;
	}

//	
//	public ArrayList<String> getEquationList(ArrayList<Character> lstr) {
//		ArrayList<String> lrec = new ArrayList<>(); 
//		int upindex = 0;
//		String temp = "";
//		for(int i=0;i<lstr.size();i++) {
//			if(lstr.get(i) == '+') {
//				if(upindex != i) {
//					lrec.add(temp);
//				}
//				temp = "";
//				lrec.add("+");
//				upindex = i+1;
//			}else if(lstr.get(i) == '-') {
//				if(upindex != i) {
//					lrec.add(temp);
//				}
//				temp = "";
//				lrec.add("-");
//				upindex = i+1;
//			}else if(lstr.get(i) == '*') {
//				if(upindex != i) {
//					lrec.add(temp);
//				}
//				temp = "";
//				lrec.add("*");
//				upindex = i+1;
//			}else if(lstr.get(i) == '/') {
//				if(upindex != i) {
//					lrec.add(temp);
//				}
//				temp = "";
//				lrec.add("/");
//				upindex = i+1;
//			}else if(lstr.get(i) == '=') {
//				if(upindex != i) {
//					lrec.add(temp);
//				}
//				temp = "";
//				lrec.add("=");
//				upindex = i+1;
//			}else {
//				temp += lstr.get(i);
//			}
//		}
//		lrec.add(temp);
//		return lrec;
//	}
//	
	//Retrieve a string from the passed in character set
	public String getEquation(ArrayList<Character> lstr) {
		String temp = "";
		for(int i=0;i<lstr.size();i++) {
			temp += lstr.get(i);
		}
		return temp;
	}
	//Check if the input equation meets the standard
	public String legal(String str,int column) {
		int lsum = 0,upindex = 0,rsum = 0;
		if(equation.equals("There is no equation that meets the requirements")) {
			return equation;
		}
		ArrayList<Character> slist = new ArrayList<>();//Store operation symbols
		ArrayList<Integer> ilist = new ArrayList<>();//Storing Numbers
		//Determine if the length is qualified
		if(str.length() != column) {
			return "Equation length is less than "+column+"!";
		}
		//Determine whether the operation symbol is qualified
		if(str.indexOf('=') == -1||(str.indexOf('+') == -1&&str.indexOf('-') == -1
				&&str.indexOf('*') == -1&&str.indexOf('/') == -1)) {
			return "One or more symbols of \"=\", \"+\", \"-\", \"*\", \"/\" are missing!";
		}
		
		//Parse character sets, extract symbols and numbers, and store them in a list
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i) == '+') {
				slist.add('+');
				if(upindex != i)
					ilist.add(Integer.valueOf(str.substring(upindex, i)));
				upindex = i+1;
			}else if(str.charAt(i) == '-') {
				slist.add('-');
				if(upindex != i)
					ilist.add(Integer.valueOf(str.substring(upindex, i)));
				upindex = i+1;
			}else if(str.charAt(i) == '*') {
				slist.add('*');
				if(upindex != i)
					ilist.add(Integer.valueOf(str.substring(upindex, i)));
				upindex = i+1;
			}else if(str.charAt(i) == '/') {
				slist.add('/');
				if(upindex != i)
					ilist.add(Integer.valueOf(str.substring(upindex, i)));
				upindex = i+1;
			}else if(str.charAt(i) == '=') {
				slist.add('=');
				if(upindex != i)
					ilist.add(Integer.valueOf(str.substring(upindex, i)));
				upindex = i+1;
			}else if(i == str.length()-1) {
				ilist.add(Integer.valueOf(str.substring(upindex)));
			}
		}
		//Determine if the equation format is correct
		if(slist.size() + 1 != ilist.size()) {
			return "Equation format error!";
		}
		
		//Handling multiplication and division
		for(int i=0;i<slist.size();i++) {
			if(slist.get(i) == '*') {
				int temp = ilist.get(i)*ilist.get(i+1);
				ilist.set(i+1, temp);
				ilist.remove(i);
				slist.remove(i);
				i=i-1;
			}else if(slist.get(i) == '/') {
				if(ilist.get(i+1) == 0) {
					return "The divisor cannot be 0";
				}
				int temp = ilist.get(i)/ilist.get(i+1);
				ilist.set(i+1, temp);
				ilist.remove(i);
				slist.remove(i);
				i=i-1;
			}
		}
		int index = 0;
		int startIndex = 0;
		//Processing addition and subtraction
		while(true) {
			int sum = 0;//Operation result
			for(int i=startIndex;i<slist.size();i++) {
				if(i == startIndex && i<slist.size()) {
					if(slist.get(startIndex) == '+') {
						sum = ilist.get(index)+ilist.get(index+1);
					}else if(slist.get(startIndex) == '-') {
						sum = ilist.get(index)-ilist.get(index+1);
					}else if(slist.get(startIndex) == '=') {
						lsum = ilist.get(index);
						startIndex = i+1;
						index++;
						break;
					}
					index = index+2;
				}else {
					if(slist.get(i) == '+') {
						sum += ilist.get(index);
					}else if(slist.get(i) == '-') {
						sum -= ilist.get(index);
					}else if(slist.get(i) == '=') {
						lsum = sum;
						startIndex = i+1;
						if(startIndex >= slist.size()) {
							sum = ilist.get(index);
							index++;
						}
						break;
					}
					index++;
				}
			}
			if(index >= ilist.size()) {
				rsum = sum;
				break;
			}
			if(startIndex >= slist.size()) {
				rsum = ilist.get(index);
				break;
			}
		}
		//Judging whether the left and right sides of the equation are equal
		if(lsum == rsum) {
			return "OK";
		}else {
			return "The left and right sides of the equation are not equal!";
		}
	}

	//Check if the guessed equation is correct,
	/*
	 * -1 indicates that the character has never appeared, 
	 * 1 indicates that the character appears and is positioned correctly, 
	 * and 2 indicates that the character appears and is positioned incorrectly
	 * 
	 */
	public ArrayList<Integer> guessModle(ArrayList<Character> inlist){
		ArrayList<Integer> relist = new ArrayList<Integer>();
		String sline = equation;
		for(int i = 0;i<inlist.size();i++) {
			int rec = sline.indexOf(inlist.get(i));
			boolean nowIndex = inlist.get(i) == sline.charAt(i);
			if(rec == -1) {
				relist.add(0);
			}else if(nowIndex) {
				relist.add(1);
			}else if(rec != -1 && !nowIndex){
				relist.add(2);
			}
		}
		return relist;
	}
}
