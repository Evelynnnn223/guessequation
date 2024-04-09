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
	private BufferedImage image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);  
	private Graphics2D g2d = image.createGraphics();  
	private Color greyColor = Color.decode("#e7ebf2");
	private Color greenColor = Color.decode("#2fc1a5");
	private BufferedImage imageTitli; 
	private int column;
	private int gamesPlayed=0;
	private int gamesWon = 0;
	private int percentageWin = 0;
	private int bestTry = 0;
	private int currentStreak = 0;
	private int maxStreak = 0;
	private StatisticsController sc;
	public StatisticsView() {
		init();
	}
	public void drawBk() {
		// ���ñ���ɫΪ��ɫ  
        g2d.setColor(Color.WHITE);  
        // �������ͼ��Ϊ��ɫ  
        g2d.fillRect(0, 0, image.getWidth(), image.getHeight()); 
	}
	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}
	
	public void setSc(StatisticsController sc) {
		this.sc = sc;
	}
	//	
//	public void setImage(BufferedImage image) {
//		this.image = image;
//		repaint();
//	}
//
//	public void setG2d(Graphics2D g2d) {
//		this.g2d = g2d;
//		repaint();
//	}
//
//	public void setGreyColor(Color greyColor) {
//		this.greyColor = greyColor;
//		repaint();
//	}
//
//	public void setGreenColor(Color greenColor) {
//		this.greenColor = greenColor;
//		repaint();
//	}
//
//	public void setImageTitli(BufferedImage imageTitli) {
//		this.imageTitli = imageTitli;
//		repaint();
//	}
//
//	public void setGamesPlayed(int gamesPlayed) {
//		this.gamesPlayed = gamesPlayed;
//		repaint();
//	}
//
//	public void setGamesWon(int gamesWon) {
//		this.gamesWon = gamesWon;
//		repaint();
//	}
//
//	public void setPercentageWin(int percentageWin) {
//		this.percentageWin = percentageWin;
//		repaint();
//	}
//
//	public void setBestTry(int bestTry) {
//		this.bestTry = bestTry;
//		repaint();
//	}
//
//	public void setCurrentStreak(int currentStreak) {
//		this.currentStreak = currentStreak;
//		repaint();
//	}
//
//	public void setMaxStreak(int maxStreak) {
//		this.maxStreak = maxStreak;
//		repaint();
//	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public void drawNum(Graphics g,int x,int y,String str,int num) {
		Graphics2D g2d = (Graphics2D) g;  
		  
        // ���ÿ�����Ը���ͼ�ε�����  
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);  
  
        // ���ñ���ɫΪǳ��ɫ  
        g2d.setColor(greyColor);  
  
        // ����һ��Բ�ǳ�����  
        int width = 200, height = 100, arcWidth = 20, arcHeight = 20;  
        g2d.fillRoundRect(x, y, width, height, arcWidth, arcHeight);  
  
        // ��������Ϊ���岢���������С  
        Font font = new Font("΢���ź�", Font.BOLD, 40);  
        g2d.setFont(font);  
  
        // ����������ɫΪ��ɫ  
        g2d.setColor(Color.BLACK);  
  
        String snum = String.valueOf(num);
        // �������ֵĻ���λ��  
        FontMetrics fm = g2d.getFontMetrics();  
        int textX = x + (width - fm.stringWidth(snum)) / 2;  
        int textY = y + ((height - fm.getHeight()) / 2) + fm.getAscent()-10;  
        // ��Բ�ǳ������ϻ�������  
        g2d.drawString(snum, textX, textY);  
        Font font1 = new Font("΢���ź�", Font.PLAIN, 14);  
        g2d.setFont(font1);  
        FontMetrics fm1 = g2d.getFontMetrics();  
        int textX1 = x + (width - fm1.stringWidth(str)) / 2;  
        int textY1 = y + ((height - fm1.getHeight()) / 2) + fm1.getAscent()+30;   
        
        g2d.drawString(str, textX1, textY1);  
	}
	@Override  
    protected void paintComponent(Graphics g) {  
        super.paintComponent(g);  
        drawNum(g,70,50,"Games Played",sc.getGamesPlayed());
        drawNum(g,290,50,"Games Won",sc.getGamesWon());
        drawNum(g,510,50,"% of Wins",(int)sc.getPercentageWin());
        drawNum(g,70,170,"Best Try",sc.getBestTry());
        drawNum(g,290,170,"Current Streak",sc.getCurrentStreak());
        drawNum(g,510,170,"Max Streak",sc.getMaxStreak());
        g.drawImage(imageTitli, 284, 290, this);
        drawBarChart(g,100,362,1,sc.getCorrectNumber(0),sc.getAccuracy(0));
        drawBarChart(g,100,397,2,sc.getCorrectNumber(1),sc.getAccuracy(1));
        drawBarChart(g,100,432,3,sc.getCorrectNumber(2),sc.getAccuracy(2));
        drawBarChart(g,100,467,4,sc.getCorrectNumber(3),sc.getAccuracy(3));
        drawBarChart(g,100,502,5,sc.getCorrectNumber(4),sc.getAccuracy(4));
        drawBarChart(g,100,537,6,sc.getCorrectNumber(5),sc.getAccuracy(5));
    }  
	public void drawBarChart(Graphics g,int x,int y,int num,int quantity,double percentage) {
		Graphics2D g2d = (Graphics2D) g;
		int width = 580, height = 25, arcWidth = 30, arcHeight = 30;  
		// ���ÿ������Ⱦ  
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);  
        // ��������Ϊ���岢���������С  
        Font font = new Font("΢���ź�", Font.PLAIN, 14);  
        g2d.setFont(font);  
        String str1 = "#"+num;  
        // ����������ɫΪ��ɫ  
        g2d.setColor(Color.BLACK); 
        FontMetrics fm = g2d.getFontMetrics();  
        int textY = y + ((height - fm.getHeight()) / 2) + fm.getAscent();
        g2d.drawString(str1, x-30, textY);  
        // ����һ������Բ���ߵľ���  
        int pwidth = (int) (width*percentage/100);
        RoundRectangle2D rect = new RoundRectangle2D.Double(x, y, width, height, arcWidth, arcHeight);  
        RoundRectangle2D grect = new RoundRectangle2D.Double(x, y, pwidth, height, arcWidth, arcHeight);  
        // ���������ɫΪǳ��ɫ  
        g2d.setColor(greyColor);  
        g2d.fill(rect); // ������  
        g2d.setColor(greenColor);  
        g2d.fill(grect); // ������  
        g2d.setColor(Color.BLACK); 
        g2d.drawString(String.valueOf(quantity), x+width+10, textY); 
        Font gfont = new Font("΢���ź�", Font.BOLD, 14);  
        g2d.setFont(gfont);  
        if(percentage > 0) {
        	g2d.setColor(Color.WHITE); 
        	String sp = (int)percentage+"%";
        	g2d.drawString(sp, x+pwidth-40, textY); 
        }else {
        	String sp = (int)percentage+"%";
        	g2d.drawString(sp, x+10, textY); 
        }
        
	}
	public void init() {
		this.setBackground(Color.WHITE);
		JPanel tabPanel = new JPanel();  
		try {  
            // ����ͼƬ  
            imageTitli = ImageIO.read(new File("src/resource/stitle.png")); // �滻Ϊ���ͼƬ·��  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
//		tabPanel.setBackground(Color.WHITE);
//		drawBk();
//		drawNum(g2d,70,50,"Games Played",9);
//        drawNum(g2d,290,50,"Games Won",2);
//        drawNum(g2d,510,50,"% of Wins",44);
//        drawNum(g2d,70,170,"Best Try",9);
//        drawNum(g2d,290,170,"Current Streak",2);
//        drawNum(g2d,510,170,"Max Streak",44);
//        drawBarChart(80,335,1,0);
//        drawBarChart(80,300,2,0);
//        drawBarChart(80,370,3,0);
//        drawBarChart(80,405,4,0);
//        drawBarChart(80,440,5,0);
//        drawBarChart(80,475,6,0);
//        ImageIcon icon = new ImageIcon(image);  
//        // ����һ��JLabel������ͼ��  
//        JLabel label = new JLabel(icon);  
//        tabPanel.add(label);
//        this.add(tabPanel);
	}
}
