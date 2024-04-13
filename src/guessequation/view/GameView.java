package guessequation.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

import guessequation.controller.GameController;
import guessequation.modle.GuessModle;

public class GameView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 615688341641039725L;
	private ArrayList<JLabel> ajl = new ArrayList<JLabel>();//List of images in the grid
	private ArrayList<JPanel> ajp = new ArrayList<JPanel>();//Grid panels for each row
	private ArrayList<ImageIcon> greyajbi = new ArrayList<ImageIcon>();//Gray image
	private ArrayList<ImageIcon> yellowajbi = new ArrayList<ImageIcon>();//yellow image
	private ArrayList<ImageIcon> greenajbi = new ArrayList<ImageIcon>();//green image
	private ArrayList<JButton> abut = new ArrayList<JButton>();//All button list
	private ArrayList<ImageIcon> abutIcon = new ArrayList<ImageIcon>();//List of all button images
	private ArrayList<ImageIcon> adefbutIcon = new ArrayList<ImageIcon>();//All buttons default image list
	private Action ac;//Command executor
	private int index = 0;// The number position of the current operation
	private int line = 0;// Number of rows for the current operation
	private int column;//Equation length
	private JPanel ptext = new JPanel();//Display panel for equations
	//Constructor Initializers
	public GameView(int num,Action ac) {
		this.ac = ac;
		init(num);
	}
	public void setAc(Action ac) {
		this.ac = ac;
	}
	public int getIndex() {
		return index;
	}

	public void indexAdd() {
		this.index++;
	}
	
	public void setIndex(int index) {
		this.index = index;
	}

	public int getLine() {
		return line;
	}

	public void lineAdd() {
		this.line++;
	}
	
	public void setLine(int line) {
		this.line = line;
	}

	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	
	//Replace the image
	public void switchImage(ImageIcon icon) {
		JLabel jl = ajl.get(this.line * column + this.index);
		jl.setIcon(icon);
	}
	
	//Replace the current location image
	public boolean forward(ImageIcon icon) {
		if (this.index < column) {
			switchImage(icon);
			this.index++;
			return true;
		}
		return false;
	}
	
	//Backspace, swap the current position image back to default
	public void backward(ImageIcon icon) {
		if (index > 0) {
			index--;
			switchImage(icon);
		}
	}
	
	//The current position displays a yellow image
	public void yellowImage(int num) {
		forward(yellowajbi.get(num));
		changeKeybord(num, yellowajbi.get(num));
	}
	//The current position displays a grey image
	public void greyImage(int num) {
		forward(greyajbi.get(num));
		changeKeybord(num, greyajbi.get(num));
	}
	//The current position displays a green image
	public void greenImage(int num) {
		forward(greenajbi.get(num));
		changeKeybord(num, greenajbi.get(num));
	}
	//Replace keyboard image
	public void changeKeybord(int num,ImageIcon icon) {
		JButton but = abut.get(num);
		abutIcon.set(num, icon);
		but.setIcon(icon);
	}
	//Restore keyboard image
	public void defKeybord() {
		for(int i=0;i<abut.size();i++) {
			changeKeybord(i, adefbutIcon.get(i));
		}
	}
	//creat button
	public void creatButton(JPanel panel,ImageIcon icon,ImageIcon hoticon,char str,Dimension dbutton) {
		JButton button1 = new JButton();
		button1.setPreferredSize(dbutton);
		button1.setIcon(icon);
		button1.setBorderPainted(false); // Do not draw button borders
		button1.setContentAreaFilled(false); // Unfill button content area background
		panel.add(button1); // Add buttons to the panel
		Command csymbol = new GameSymbolCommand(icon, str, ac);
		ButtonListener bsymbol = new ButtonListener(csymbol);
		// Add a click event listener to the button
		button1.addActionListener(bsymbol);
		abut.add(button1);
		abutIcon.add(icon);
		adefbutIcon.add(icon);
		int index = abutIcon.size()-1;
		// Add a mouse listener to the button
        button1.addMouseListener(new MouseAdapter() {  
            @Override  
            public void mousePressed(MouseEvent e) {  
                button1.setIcon(hoticon); //Set icon on mouse click
            }  
  
            @Override  
            public void mouseReleased(MouseEvent e) {  
                button1.setIcon(abutIcon.get(index)); // Set hover icon when mouse is released
            }  
            @Override  
            public void mouseEntered(MouseEvent e) {  
                // When the mouse enters the button area, set the hovering icon
                button1.setIcon(hoticon);  
            }  
  
            @Override  
            public void mouseExited(MouseEvent e) {  
                // When the mouse leaves the button area, set the icon for the normal state
                button1.setIcon(abutIcon.get(index));  
            }  
        });  
	}
	
	//Reinitialize Page
	public void initGrid(int column) {
		this.line = 0;
		this.index = 0;
		this.column = column;
		ajl.clear();
		ImageIcon icon = new ImageIcon("src/resource/1.png");
		for (int j = 0; j < 6; j++) {
			JPanel panel1 = ajp.get(j);
			panel1.removeAll();
			panel1.setBackground(Color.WHITE);
			panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			for (int i = 0; i < column; i++) {
				// Create a JLabel to display images
				JLabel label = new JLabel(icon);
				label.setPreferredSize(new Dimension(57, 57));
				ajl.add(label);
				panel1.add(label);
			}
		}
		defKeybord();
	}
	
	//Display Equation
	public void displayEquation(String equation) {
		ptext.removeAll();
		Font font1 = new Font("微软雅黑", Font.BOLD, 20);  
		JLabel label1 = new JLabel(equation);  
		label1.setFont(font1);
		ptext.setBackground(Color.WHITE);
		ptext.add(label1);
	}
	
	//Initialize Page
	public void init(int column) {
		this.column = column;
		this.setBackground(Color.WHITE);
		// Create a FlowLayout instance and set horizontal and vertical spacing
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 5, 0);
		//tabbedPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT); 
		JPanel panelts = new JPanel();
		panelts.setBackground(Color.WHITE);
		panelts.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.add(panelts);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		Dimension dbutton = new Dimension(55, 57);
			// load picture
			ImageIcon icon = new ImageIcon("src/resource/1.png");
			JPanel panelt = new JPanel();
			panelt.setBackground(Color.WHITE);
			panelt.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
			for (int j = 0; j < 6; j++) {
				JPanel panel1 = new JPanel();
				panel1.setBackground(Color.WHITE);
				panel1.setLayout(layout);
				for (int i = 0; i < column; i++) {
					// Create a JLabel to display images
					JLabel label = new JLabel(icon);
					label.setPreferredSize(dbutton);
					ajl.add(label);
					panel1.add(label);
				}
				ajp.add(panel1);
				panel.add(panel1);
			}
			panel.add(panelt);
			JPanel panel2 = new JPanel();
			panel2.setBackground(Color.WHITE);
			panel2.setLayout(layout);
			for(int i=0;i<15;i++) {
				String img1 = "src/resource/green"+i+".png";
				String img2 = "src/resource/yellow"+i+".png";
				String img3 = "src/resource/grey"+i+".png";
				
				ImageIcon icont1 = new ImageIcon(img1);
				ImageIcon icont2 = new ImageIcon(img2);
				ImageIcon icont3 = new ImageIcon(img3);
				greyajbi.add(icont3);
				yellowajbi.add(icont2);
				greenajbi.add(icont1);
				
			}
			// Load custom images
			ImageIcon icon0 = new ImageIcon("src/resource/number0.png");
			ImageIcon hoticon0 = new ImageIcon("src/resource/hotnumber0.png");
			// Create a button
			creatButton(panel2, icon0,hoticon0,'0',dbutton);
			// Load custom images
			ImageIcon icon1 = new ImageIcon("src/resource/number1.png");
			ImageIcon hoticon1 = new ImageIcon("src/resource/hotnumber1.png");
			// Create a button
			creatButton(panel2, icon1,hoticon1,'1',dbutton);
			// Load custom images
			ImageIcon icon2 = new ImageIcon("src/resource/number2.png");
			ImageIcon hoticon2 = new ImageIcon("src/resource/hotnumber2.png");
			// Create a button
			creatButton(panel2, icon2,hoticon2,'2',dbutton);
			// Load custom images
			ImageIcon icon3 = new ImageIcon("src/resource/number3.png");
			ImageIcon hoticon3 = new ImageIcon("src/resource/hotnumber3.png");
			// Create a button
			creatButton(panel2, icon3,hoticon3,'3',dbutton);
			// Load custom images
			ImageIcon icon4 = new ImageIcon("src/resource/number4.png");
			ImageIcon hoticon4 = new ImageIcon("src/resource/hotnumber4.png");
			// Create a button
			creatButton(panel2, icon4,hoticon4,'4',dbutton);
			// Load custom images
			ImageIcon icon5 = new ImageIcon("src/resource/number5.png");
			ImageIcon hoticon5 = new ImageIcon("src/resource/hotnumber5.png");
			creatButton(panel2, icon5,hoticon5,'5',dbutton);
			// Load custom images
			ImageIcon icon6 = new ImageIcon("src/resource/number6.png");
			ImageIcon hoticon6 = new ImageIcon("src/resource/hotnumber6.png");
			creatButton(panel2, icon6,hoticon6,'6',dbutton);
			// Load custom images
			ImageIcon icon7 = new ImageIcon("src/resource/number7.png");
			ImageIcon hoticon7 = new ImageIcon("src/resource/hotnumber7.png");
			creatButton(panel2, icon7,hoticon7,'7',dbutton);
			// Load custom images
			ImageIcon icon8 = new ImageIcon("src/resource/number8.png");
			ImageIcon hoticon8 = new ImageIcon("src/resource/hotnumber8.png");
			creatButton(panel2, icon8,hoticon8,'8',dbutton);
			// Load custom images
			ImageIcon icon9 = new ImageIcon("src/resource/number9.png");
			ImageIcon hoticon9 = new ImageIcon("src/resource/hotnumber9.png");
			creatButton(panel2, icon9,hoticon9,'9',dbutton);
			// Load custom images
			

			JPanel panel3 = new JPanel();
			panel3.setBackground(Color.WHITE);
			panel3.setLayout(layout);
			Dimension dbutton2 = new Dimension(118, 58);
			// Create a button
			JButton button11 = new JButton();
			ImageIcon iconback = new ImageIcon("src/resource/back.png");
			ImageIcon hoticonback = new ImageIcon("src/resource/hotback.png");
			button11.setPreferredSize(dbutton2);
			button11.setIcon(iconback);
			button11.setBorderPainted(false); // Do not draw button borders
			button11.setContentAreaFilled(false); // Unfill button content area background
			button11.addMouseListener(new MouseAdapter() {  
	            @Override  
	            public void mousePressed(MouseEvent e) {  
	                button11.setIcon(hoticonback); //Set icon on mouse click
	            }  
	  
	            @Override  
	            public void mouseReleased(MouseEvent e) {  
	                button11.setIcon(iconback); // Set hover icon when mouse is released
	            }  
	            @Override  
	            public void mouseEntered(MouseEvent e) {  
	                // When the mouse enters the button area, set the hovering icon
	                button11.setIcon(hoticonback);  
	            }  
	  
	            @Override  
	            public void mouseExited(MouseEvent e) {  
	                // When the mouse leaves the button area, set the icon for the normal state
	                button11.setIcon(iconback);  
	            }  
			});
			panel3.add(button11); // Add buttons to the panel
			Command cback = new GameBackCommand(icon, ac);
			ButtonListener bback = new ButtonListener(cback);
			// Add a click event listener to the button
			button11.addActionListener(bback);
			Dimension dbutton1 = new Dimension(64, 55);
			// Create a button
			ImageIcon iconsum = new ImageIcon("src/resource/sum.png");
			ImageIcon hoticonsum = new ImageIcon("src/resource/hotsum.png");
			creatButton(panel3, iconsum,hoticonsum,'+',dbutton1);
			// Create a button
			ImageIcon iconreduce = new ImageIcon("src/resource/reduce.png");
			ImageIcon hoticonreduce = new ImageIcon("src/resource/hotreduce.png");
			creatButton(panel3, iconreduce,hoticonreduce,'-',dbutton1);
			// Create a button
			ImageIcon iconride = new ImageIcon("src/resource/ride.png");
			ImageIcon hoticonride = new ImageIcon("src/resource/hotride.png");
			creatButton(panel3, iconride,hoticonride,'*',dbutton1);
			// Create a button
			ImageIcon iconexcept = new ImageIcon("src/resource/except.png");
			ImageIcon hoticonexcept = new ImageIcon("src/resource/hotexcept.png");
			creatButton(panel3, iconexcept,hoticonexcept,'/',dbutton1);
			// Create a button
			ImageIcon iconequal = new ImageIcon("src/resource/equal.png");
			ImageIcon hoticonequal = new ImageIcon("src/resource/hotequal.png");
			creatButton(panel3, iconequal,hoticonequal,'=',dbutton1);
			// Create a button
			JButton button17 = new JButton();
			ImageIcon iconenter = new ImageIcon("src/resource/enter.png");
			ImageIcon hoticonenter = new ImageIcon("src/resource/hotenter.png");
			button17.setPreferredSize(dbutton2);
			button17.setIcon(iconenter);
			button17.setBorderPainted(false); // Do not draw button borders
			button17.setContentAreaFilled(false); // Unfill button content area background
			button17.addMouseListener(new MouseAdapter() {  
	            @Override  
	            public void mousePressed(MouseEvent e) {  
	                button17.setIcon(hoticonenter); //Set icon on mouse click
	            }  
	  
	            @Override  
	            public void mouseReleased(MouseEvent e) {  
	                button17.setIcon(iconenter); // Set hover icon when mouse is released
	            }  
	            @Override  
	            public void mouseEntered(MouseEvent e) {  
	                // When the mouse enters the button area, set the hovering icon
	                button17.setIcon(hoticonenter);  
	            }  
	  
	            @Override  
	            public void mouseExited(MouseEvent e) {  
	                // When the mouse leaves the button area, set the icon for the normal state
	                button17.setIcon(iconenter);  
	            }  
			});
			panel3.add(button17); // Add buttons to the panel
			Command center = new GameEnterCommand(ac);
			ButtonListener benter = new ButtonListener(center);
			button17.addActionListener(benter);
			panel.add(panel2);
			panel.add(panel3);
			this.add(panel);
			this.add(ptext);
			initGrid(column);
	}
	
	//Message Popup
	public void prompt(String str) {
		JOptionPane.showMessageDialog(this, str);
	}
	public void won() {
		prompt("       🏆 win the game!");
	}
	public void fail() {
		prompt("       fail the game!");
	}
}
