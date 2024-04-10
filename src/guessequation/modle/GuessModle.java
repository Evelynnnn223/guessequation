package guessequation.modle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class GuessModle extends ModleSubject{
	private String equation;
	private boolean displayError = true;
	private boolean displayEquation;
	private boolean randomEquation = true;
	private ArrayList<Character> nosylsit = new ArrayList<Character>();
	private ArrayList<ArrayList<String>> equationList = new ArrayList<ArrayList<String>>();
	private File file = new File("src/resource/equations.txt");  
	private int column;
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

	public void addNosylsit(char sym) {
		nosylsit.add(sym);
	}
	public void removeNosylsit(Character sym) {
		nosylsit.remove(sym);
	}
	public void setEquation() {
		equation = loadEquation();
	}
	
	public String loadEquation() {
        int index = 0;  
        ArrayList<String> list = equationList.get(column-5);
        if(randomEquation) {
        	Random rand = new Random();
        	index = rand.nextInt(list.size());
        }
        
        for(int i = index;;) {
        	String line = list.get(i);
        	boolean bnosy = true;
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
        	if(i == list.size()) {
        		i = 0;
        	}
        	if(i == index) {
        		return "There is no equation that meets the requirements";
        	}
        }
	}
	
	public void loadFile() {
        BufferedReader reader = null;  
        try {  
            reader = new BufferedReader(new FileReader(file));  
            String line = null;  
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
	public String getEquation() {
		if(displayEquation) {
			return "Now Equation:"+this.equation;
		}else {
			return "";
		}
	}
	
	public boolean isDisplayError() {
		return displayError;
	}
	
	public boolean setDisplayError() {
		if(this.displayError) {
			this.displayError = false;
		}else {
			this.displayError = true;
		}
		return this.displayError;
	}

	public boolean isDisplayEquation() {
		return displayEquation;
	}

	public boolean setDisplayEquation() {
		if(this.displayEquation) {
			this.displayEquation = false;
		}else {
			this.displayEquation = true;
		}
		notifyObservers();
		return this.displayEquation;
	}

	public boolean isRandomEquation() {
		return randomEquation;
	}

	public boolean setRandomEquation() {
		if(this.randomEquation) {
			this.randomEquation = false;
		}else {
			this.randomEquation = true;
		}
		return this.randomEquation;
	}

	public ArrayList<String> getEquationList(ArrayList<Character> lstr) {
		ArrayList<String> lrec = new ArrayList<>(); 
		int upindex = 0;
		String temp = "";
		for(int i=0;i<lstr.size();i++) {
			if(lstr.get(i) == '+') {
				if(upindex != i) {
					lrec.add(temp);
				}
				temp = "";
				lrec.add("+");
				upindex = i+1;
			}else if(lstr.get(i) == '-') {
				if(upindex != i) {
					lrec.add(temp);
				}
				temp = "";
				lrec.add("-");
				upindex = i+1;
			}else if(lstr.get(i) == '*') {
				if(upindex != i) {
					lrec.add(temp);
				}
				temp = "";
				lrec.add("*");
				upindex = i+1;
			}else if(lstr.get(i) == '/') {
				if(upindex != i) {
					lrec.add(temp);
				}
				temp = "";
				lrec.add("/");
				upindex = i+1;
			}else if(lstr.get(i) == '=') {
				if(upindex != i) {
					lrec.add(temp);
				}
				temp = "";
				lrec.add("=");
				upindex = i+1;
			}else {
				temp += lstr.get(i);
			}
		}
		lrec.add(temp);
		return lrec;
	}
	public String getEquation(ArrayList<Character> lstr) {
		String temp = "";
		for(int i=0;i<lstr.size();i++) {
			temp += lstr.get(i);
		}
		return temp;
	}
	public String legal(String str,int column) {
		int lsum = 0,upindex = 0,rsum = 0;
		ArrayList<Character> slist = new ArrayList<>();
		ArrayList<Integer> ilist = new ArrayList<>();
		if(str.length() != column) {
			return "Equation length is less than "+column+"!";
		}
		if(str.indexOf('=') == -1||(str.indexOf('+') == -1&&str.indexOf('-') == -1
				&&str.indexOf('*') == -1&&str.indexOf('/') == -1)) {
			return "One or more symbols of \"=\", \"+\", \"-\", \"*\", \"/\" are missing!";
		}
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
//		if(upindex < str.length())
//			result = Integer.valueOf(str.substring(upindex));
		if(slist.size() + 1 != ilist.size()) {
			return "Equation format error!";
		}
		int index = 0;
		int startIndex = 0;
		while(true) {
			int sum = 0;
			for(int i=startIndex;i<slist.size();i++) {
				if(i == startIndex && i<slist.size()) {
					if(slist.get(startIndex) == '+') {
						sum = ilist.get(index)+ilist.get(index+1);
					}else if(slist.get(startIndex) == '-') {
						sum = ilist.get(index)-ilist.get(index+1);
					}else if(slist.get(startIndex) == '*') {
						sum = ilist.get(index)*ilist.get(index+1);
					}else if(slist.get(startIndex) == '/') {
						sum = ilist.get(index)/ilist.get(index+1);
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
					}else if(slist.get(i) == '*') {
						sum *= ilist.get(index);
					}else if(slist.get(i) == '/') {
						sum /= ilist.get(index);
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
		}
		
		if(lsum == rsum) {
			return "OK";
		}else {
			return "The left and right sides of the equation are not equal!";
		}
	}
//	public String creatFun1(int length) {
//		Random rand = new Random();  
//        int result = rand.nextInt(100); // 生成0到99之间的随机数
//        int num1 = rand.nextInt(100);
//        int i = 1;
//        int symbol = rand.nextInt(2);
//        while(true) {
//        	String str = "";
//        	if(symbol == 0) {
//    			if(num1 % i == 0) {
//    				str = num1+"/"+i +"="+num1/i;
//    				if(str.length() > length) {
//    					num1/=10;
//    				}else if(str.length() < length) {
//    					
//    				}
//    			}
//    		}else if(symbol == 1)  {
//    			str = num1+"-"+(num1-result) +"="+result;
//    		}
//    		if(str.length() == length) {
//    			return str;
//    		}
//        }
//	}
//	public String creatFun(int length) {
//		Random rand = new Random();  
//        int result = rand.nextInt(100); // 生成0到99之间的随机数
//        int num1 = rand.nextInt(100);
//        if(num1 >= result) {
//        	int symbol = rand.nextInt(2);
//        	while(true) {
//        		String str = "";
//        		if(symbol == 0) {
//        			if(result != 0 && num1 % result == 0) {
//        				str = num1+"/"+num1/result +"="+result;
//        			}else {
//        				str = num1+"-"+(num1-result) +"="+result;
//        			}
//        		}else if(symbol == 1)  {
//        			str = num1+"-"+(num1-result) +"="+result;
//        		}
//        		if(str.length() == length) {
//        			return str;
//        		}
//        	}
//        }else if(num1 < result){
//        	while(true) {
//        		String str = "";
//        		int symbol = rand.nextInt(2);
//        		if(symbol == 0) {
//        			if(result % num1 == 0) {
//        				str = num1+"*"+result/num1 +"="+result;
//        			}
//        		}else if(symbol == 1)  {
//        			str = num1+"+"+(result - num1) +"="+result;
//        		}
//        		if(str.length() == length) {
//        			return str;
//        		}
//        	}
//        }
//        return null;
//	}
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
			}else if(rec != 1 && !nowIndex){
				relist.add(2);
			}
		}
		return relist;
	}
}
