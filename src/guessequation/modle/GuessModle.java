package guessequation.modle;

import java.util.ArrayList;
import java.util.Random;

public class GuessModle {
	private ArrayList<String> list = new ArrayList<>();
	
	public void init(int size) {
		String s1 = "1+2=3";
		list.add(s1);
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
	public boolean legal(String str,int column) {
		int lsum = 0,upindex = 0,rsum = 0;
		ArrayList<Character> slist = new ArrayList<>();
		ArrayList<Integer> ilist = new ArrayList<>();
		
		if(str.length() != column || str.indexOf('=') == -1||(str.indexOf('+') == -1&&str.indexOf('-') == -1
				&&str.indexOf('*') == -1&&str.indexOf('/') == -1)) {
			return false;
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
				ilist.add(Integer.valueOf(str.substring(i)));
			}
		}
//		if(upindex < str.length())
//			result = Integer.valueOf(str.substring(upindex));
		if(slist.size() + 1 != ilist.size()) {
			return false;
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
			return true;
		}else {
			return false;
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
		String sline = list.get(0);
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
