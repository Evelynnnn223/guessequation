package guessequation.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import guessequation.modle.GuessModle;

public class ModleTest {

	private GuessModle gm;
	@Before
	public void setUp() throws Exception {
		gm = new GuessModle();
		gm.setColumn(5);
		gm.setRandomEquation();//Set fixed equation state
		gm.init();
	}

	//Test whether the equation can be obtained after turning on the displayEquation switch
	@Test
	public void test1() {
		String sequation1 = gm.getEquation();
		assertTrue(sequation1.length() == 0);
		gm.setDisplayEquation();//Set to display equation status
		String sequation2 = gm.getEquation();
		assertTrue(sequation2.length() > 0);
	}
	
	//Test the correctness of the guessing method through a correct equation and an incorrect equation
	@Test
	public void test2() {
		String gequation = "1+1=2";//Correct equation
		ArrayList<Character> glist = new ArrayList<>();
		for(int i=0;i<gequation.length();i++) {
			glist.add(gequation.charAt(i));
		}
		ArrayList<Integer> lrc = gm.guessModle(glist);
		//Is the result all 1
		for(Integer i: lrc) {
			assertEquals(1, i.intValue());
		}
		gequation = "2+3=5";//Correct equation error
		glist.clear();
		for(int i=0;i<gequation.length();i++) {
			glist.add(gequation.charAt(i));
		}
		ArrayList<Integer> lrc2 = gm.guessModle(glist);
		int num1 = 0,num2 = 0,num0 = 0;//Correct, incorrect position, not appearing
		for(Integer i: lrc2) {
			if(i == 1) {
				num1++;
			}else if(i == 2) {
				num2++;
			}else if(i == 0) {
				num0++;
			}
		}
		//Is the number correct
		assertEquals(num1, 2);
		assertEquals(num2, 1);
		assertEquals(num0, 2);
	}
	
	//Test the method of determining whether an equation is valid
	@Test
	public void test3() {
		gm.setDisplayError();//Set display error message status
		String gequation = "1+1=2";//Correct equation
		String r1 = gm.legal(gequation, gm.getColumn());
		assertEquals(r1, "OK");
		String gequatione1 = "1+1=3";//Correct equation error
		String r2 = gm.legal(gequatione1, gm.getColumn());
		assertEquals(r2, "The left and right sides of the equation are not equal!");
		String gequatione2 = "111=3";//Correct equation error
		String r3 = gm.legal(gequatione2, gm.getColumn());
		assertEquals(r3, "One or more symbols of \"=\", \"+\", \"-\", \"*\", \"/\" are missing!");
		String gequatione3 = "1+=3";//Correct equation error
		String r4 = gm.legal(gequatione3, gm.getColumn());
		assertEquals(r4, "Equation length is less than "+gm.getColumn()+"!");
		String gequatione4 = "1/0=3";//Correct equation error
		String r5 = gm.legal(gequatione4, gm.getColumn());
		assertEquals(r5, "The divisor cannot be 0");
		String gequatione5 = "1++=3";//Correct equation error
		String r6 = gm.legal(gequatione5, gm.getColumn());
		assertEquals(r6, "Equation format error!");
	}

}
