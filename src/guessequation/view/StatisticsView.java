package guessequation.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import guessequation.controller.StatisticsController;

public class StatisticsView extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3821312922188605274L;  
	private Color greyColor = Color.decode("#e7ebf2");//gray background
	private Color greenColor = Color.decode("#2fc1a5");//Green statistical chart
	private ArrayList<Integer> list;//Score List
	private ArrayList<Double> dlist;//Score percentage list
	private BufferedImage imageTitli; //Load title image
	private int column;//Equation length
	private int gamesPlayed=0;//Number of games played
	private int gamesWon = 0;//Number of games Won
	private double percentageWin = 0;//percentage of games Won
	private int bestTry = 0;//Number of times with the best grades
	private int currentStreak = 0;//current streak
	private int maxStreak = 0;//max streak
	
	//Constructor Initializers
	public StatisticsView() {
		init();
	}

	public int getColumn() {
		return column;
	}
	
	public ArrayList<Integer> getList() {
		return list;
	}
	public void setList(ArrayList<Integer> list) {
		this.list = list;
	}
	
	public ArrayList<Double> getDlist() {
		return dlist;
	}
	public void setDlist(ArrayList<Double> dlist) {
		this.dlist = dlist;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	
	public void setGreyColor(Color greyColor) {
		this.greyColor = greyColor;
		repaint();
	}

	public void setGreenColor(Color greenColor) {
		this.greenColor = greenColor;
		repaint();
	}

	public void setImageTitli(BufferedImage imageTitli) {
		this.imageTitli = imageTitli;
		repaint();
	}

	public void setGamesPlayed(int gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
		repaint();
	}

	public void setGamesWon(int gamesWon) {
		this.gamesWon = gamesWon;
		repaint();
	}

	public void setPercentageWin(double percentageWin) {
		this.percentageWin = percentageWin;
		repaint();
	}

	public void setBestTry(int bestTry) {
		this.bestTry = bestTry;
		repaint();
	}

	public void setCurrentStreak(int currentStreak) {
		this.currentStreak = currentStreak;
		repaint();
	}

	public void setMaxStreak(int maxStreak) {
		this.maxStreak = maxStreak;
		repaint();
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	//Draw the number above
	public void drawNum(Graphics g,int x,int y,String str,int num) {
		Graphics2D g2d = (Graphics2D) g;  
		  
        // Set anti aliasing to improve the quality of graphics
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);  
  
        // Set the background color to light gray
        g2d.setColor(greyColor);  
  
        // Draw a rounded rectangle
        int width = 200, height = 100, arcWidth = 20, arcHeight = 20;  
        g2d.fillRoundRect(x, y, width, height, arcWidth, arcHeight);  
  
        // Set the font to bold and set the font size
        Font font = new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 40);  
        g2d.setFont(font);  
  
        // Set the font color to black
        g2d.setColor(Color.BLACK);  
  
        String snum = String.valueOf(num);
        // Calculate the drawing position of numbers
        FontMetrics fm = g2d.getFontMetrics();  
        int textX = x + (width - fm.stringWidth(snum)) / 2;  
        int textY = y + ((height - fm.getHeight()) / 2) + fm.getAscent()-10;  
        // Draw numbers on a rounded rectangle
        g2d.drawString(snum, textX, textY);  
        Font font1 = new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14);  
        g2d.setFont(font1);  
        FontMetrics fm1 = g2d.getFontMetrics();  
        int textX1 = x + (width - fm1.stringWidth(str)) / 2;  
        int textY1 = y + ((height - fm1.getHeight()) / 2) + fm1.getAscent()+30;   
        
        g2d.drawString(str, textX1, textY1);  
	}

	@Override  
    protected void paintComponent(Graphics g) {  
        super.paintComponent(g);  
        drawNum(g,70,50,"Games Played",gamesPlayed);
        drawNum(g,290,50,"Games Won",gamesWon);
        drawNum(g,510,50,"% of Wins",(int)percentageWin);
        drawNum(g,70,170,"Best Try",bestTry);
        drawNum(g,290,170,"Current Streak",currentStreak);
        drawNum(g,510,170,"Max Streak",maxStreak);
        g.drawImage(imageTitli, 284, 290, this);
        drawBarChart(g,100,362,1,list.get(0),dlist.get(0));
        drawBarChart(g,100,397,2,list.get(1),dlist.get(1));
        drawBarChart(g,100,432,3,list.get(2),dlist.get(2));
        drawBarChart(g,100,467,4,list.get(3),dlist.get(3));
        drawBarChart(g,100,502,5,list.get(4),dlist.get(4));
        drawBarChart(g,100,537,6,list.get(5),dlist.get(5));
    }  
	
	//Draw a bar chart
	public void drawBarChart(Graphics g,int x,int y,int num,int quantity,double percentage) {
		Graphics2D g2d = (Graphics2D) g;
		int width = 580, height = 25, arcWidth = 30, arcHeight = 30;  
		// Set up anti aliasing rendering
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);  
        // ÉèÖÃ×ÖÌåÎªºÚÌå²¢ÉèÖÃ×ÖÌå´óÐ¡  
        Font font = new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14);  
        g2d.setFont(font);  
        String str1 = "#"+num;  
        // Set the font to bold and set the font size
        g2d.setColor(Color.BLACK); 
        FontMetrics fm = g2d.getFontMetrics();  
        int textY = y + ((height - fm.getHeight()) / 2) + fm.getAscent();
        g2d.drawString(str1, x-30, textY);  
        // Create a rectangle with arc edges
        int pwidth = (int) (width*percentage);
        RoundRectangle2D rect = new RoundRectangle2D.Double(x, y, width, height, arcWidth, arcHeight);  
        RoundRectangle2D grect = new RoundRectangle2D.Double(x, y, pwidth, height, arcWidth, arcHeight);  
        // Set the fill color to light gray
        g2d.setColor(greyColor);  
        g2d.fill(rect); //filled rectangle
        g2d.setColor(greenColor);  
        g2d.fill(grect); // filled rectangle
        g2d.setColor(Color.BLACK); 
        g2d.drawString(String.valueOf(quantity), x+width+10, textY); 
        Font gfont = new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 14);  
        g2d.setFont(gfont);  
        if(percentage*100 > 0) {
        	g2d.setColor(Color.WHITE); 
        	String sp = (int)(percentage*100)+"%";
        	FontMetrics fmg = g2d.getFontMetrics();  
            int textWidth = fmg.stringWidth(sp);  
        	g2d.drawString(sp, x+pwidth-textWidth-10, textY); 
        }else {
        	String sp = (int)(percentage*100)+"%";
        	g2d.drawString(sp, x+10, textY); 
        }
        
	}

	//Initialize interface
	public void init() {
		this.setBackground(Color.WHITE);
		try {  
            // ¼ÓÔØÍ¼Æ¬  
            imageTitli = ImageIO.read(new File("src/resource/stitle.png")); // Ìæ»»ÎªÄãµÄÍ¼Æ¬Â·¾¶  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
	}
}
