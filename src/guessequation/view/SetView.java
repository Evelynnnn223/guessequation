package guessequation.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SetView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4083200629505710917L;
	private ArrayList<JButton> setbut1 = new ArrayList<JButton>();//Equation Length Button List
	private ArrayList<Integer> setbut2 = new ArrayList<Integer>();//Equation Length Button Status List
	private HashMap<Integer,JButton> map = new HashMap<Integer,JButton>();//Operator and corresponding number map
	private Action ac;
	private JButton rbutton1 = new JButton();//restart button
	//Constructor Initializers
	public SetView(int num,Action ac) {
		this.ac = ac;
		init(num);
	}
	public void setAc(Action ac) {
		this.ac = ac;
	}

	public ArrayList<JButton> getSetbut1() {
		return setbut1;
	}

	public ArrayList<Integer> getSetbut2() {
		return setbut2;
	}
	//Processing of clicking the exclude symbol button
	public boolean updateSetAirth(int c,JButton button1) {
		if(setbut2.get(c-13) == 1 && setbut2.stream().filter(v -> v == 1).count() > 1) {
			ImageIcon icon = new ImageIcon("src/resource/set"+c+".png");
			button1.setIcon(icon);
			setbut2.set(c-13, 0);
			return false;
		}else {
			ImageIcon icon1 = new ImageIcon("src/resource/setgreen"+c+".png");
			button1.setIcon(icon1);
			setbut2.set(c-13, 1);
			return true;
		}
	}
	//Processing of clicking on the equation length button
	public void updateSetNum(int num,JButton button1) {
		for(int i=5;i<13;i++) {
			JButton button = setbut1.get(i-5);
			ImageIcon icon = new ImageIcon("src/resource/set"+i+".png");
			button.setIcon(icon);
		}
		ImageIcon icon1 = new ImageIcon("src/resource/setgreen"+num+".png");
		button1.setIcon(icon1);
	}
	//create button
	public void creatButton(JPanel panel,String str,Command command,int num) {
		JPanel setnumpanel3= new JPanel();
		FlowLayout blayout = new FlowLayout(FlowLayout.CENTER, 150, 5);
		setnumpanel3.setLayout(blayout);
		setnumpanel3.setBackground(Color.WHITE);
		Font font1 = new Font("΢���ź�", Font.BOLD, 20);  
		JLabel label1 = new JLabel(str);  
		label1.setFont(font1);
		JPanel ptext= new JPanel();
		ptext.setLayout(new FlowLayout(FlowLayout.LEFT));
		ptext.setBackground(Color.WHITE);
		ptext.setPreferredSize(new Dimension(200, 40)); 
		ptext.add(label1);
		setnumpanel3.add(ptext);
		JButton dbutton1 = new JButton();
		dbutton1.setPreferredSize(new Dimension(50, 26));
		dbutton1.setBorderPainted(false); // Do not draw button borders
		dbutton1.setContentAreaFilled(false); //Unfill button content area background
		ButtonListener bl = new ButtonListener(command);//Set button click command
		// Add a click event listener to the button
		dbutton1.addActionListener(bl);
		map.put(num, dbutton1);
		setnumpanel3.add(dbutton1); // Add buttons to the panel
		panel.add(setnumpanel3);
	}
	public void setOffOn(int num,boolean v) {
		JButton button = map.get(num);
		ImageIcon dicon1 = new ImageIcon("src/resource/OFF.png");
		ImageIcon dicon2 = new ImageIcon("src/resource/ON.png");
		if(v) {
    		button.setIcon(dicon2); // Set icon on mouse click
    	}else {
    		button.setIcon(dicon1); // Set icon on mouse click
    	}
	}
	
	//Enable Restart button
	public void enableRestart() {
		rbutton1.setEnabled(true);
	}
	//Disable Restart button
	public void disableRestart() {
		rbutton1.setEnabled(false);
	}
	//Initialize interface
	public void init(int column) {
		this.setBackground(Color.WHITE);
		// Create a FlowLayout instance and set horizontal and vertical spacing
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 5, 0);
        JPanel tab2Panel = new JPanel();  
        tab2Panel.setBackground(Color.WHITE);
        JPanel panel_2= new JPanel();
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		panel_2.setBackground(Color.WHITE);
		JPanel setpanel= new JPanel();
		setpanel.setBackground(Color.WHITE);
		setpanel.setLayout(layout);
		ImageIcon setinfo1Icon = new ImageIcon("src/resource/setinfo1.png"); 
		JLabel setinfo1label1 = new JLabel(setinfo1Icon);
		//setinfo1label1.setPreferredSize(new Dimension(372, 50));
		setpanel.add(setinfo1label1);
		panel_2.add(setpanel);
		JPanel setnumpanel= new JPanel();
		setnumpanel.setLayout(layout);
		setnumpanel.setBackground(Color.WHITE);
		for(int i=5;i<13;i++) {
			ImageIcon icon1;
			if(i == column) {
				icon1 = new ImageIcon("src/resource/setgreen"+i+".png");
			}else {
				icon1 = new ImageIcon("src/resource/set"+i+".png");
			}
			JButton button1 = new JButton();
			button1.setPreferredSize(new Dimension(34, 32));
			button1.setIcon(icon1);
			button1.setBorderPainted(false); // Do not draw button borders
			button1.setContentAreaFilled(false); // Unfill button content area background
			setnumpanel.add(button1); // Add buttons to the panel
			setbut1.add(button1);
			Command cgroove = new SetGrooveCommand(i, button1, ac);
			ButtonListener bcgroove = new ButtonListener(cgroove);
			// Add a click event listener to the button
			button1.addActionListener(bcgroove);
		}
		panel_2.add(setnumpanel);
		JPanel setpanel2= new JPanel();
		setpanel2.setBackground(Color.WHITE);
		setpanel2.setLayout(layout);
		ImageIcon setinfo2Icon = new ImageIcon("src/resource/setinfo2.png"); 
		JLabel setinfo1label2 = new JLabel(setinfo2Icon);
		setpanel2.add(setinfo1label2);
		panel_2.add(setpanel2);
		JPanel setnumpanel2= new JPanel();
		setnumpanel2.setLayout(layout);
		setnumpanel2.setBackground(Color.WHITE);
		for(int i=13;i<17;i++) {
			ImageIcon icon1 = new ImageIcon("src/resource/setgreen"+i+".png");
			JButton button1 = new JButton();
			button1.setPreferredSize(new Dimension(34, 32));
			button1.setIcon(icon1);
			button1.setBorderPainted(false); // Do not draw button borders
			button1.setContentAreaFilled(false); // Unfill button content area background
			setnumpanel2.add(button1); // Add buttons to the panel
			setbut2.add(1);
			Command arithmentic = new SetArithmeticCommand(i, button1, ac);
			ButtonListener barithmentic = new ButtonListener(arithmentic);
			// Add a click event listener to the button
			button1.addActionListener(barithmentic);
		}
		panel_2.add(setnumpanel2);
		Command dpcommand = new DisplayErrorCommand(ac);
		creatButton(panel_2,"Display Error",dpcommand,0);
		Command decommand = new DisplayEquationCommand(ac);
		creatButton(panel_2,"Display Equation",decommand,1);
		Command recommand = new RandomEquationCommand(ac);
		creatButton(panel_2,"Random Equation",recommand,2);
		
		ImageIcon ricon = new ImageIcon("src/resource/restart.png");
		ImageIcon hotricon = new ImageIcon("src/resource/hotrestart.png");
		rbutton1 = new JButton();
		JPanel repanel= new JPanel();
		repanel.setBackground(Color.WHITE);
		rbutton1.setPreferredSize(new Dimension(267, 60));
		rbutton1.setIcon(ricon);
		rbutton1.setBorderPainted(false); // Do not draw button borders
		rbutton1.setContentAreaFilled(false); // Unfill button content area background
		rbutton1.setEnabled(false);
		repanel.add(rbutton1); 
		panel_2.add(repanel); // Add buttons to the panel
		rbutton1.addMouseListener(new MouseAdapter() {  
            @Override  
            public void mousePressed(MouseEvent e) {  
                rbutton1.setIcon(hotricon); // Set icon on mouse click
            }  
  
            @Override  
            public void mouseReleased(MouseEvent e) {  
                rbutton1.setIcon(ricon); // Set hover icon when mouse is released
            }  
            @Override  
            public void mouseEntered(MouseEvent e) {  
                // When the mouse enters the button area, set the hovering icon
                rbutton1.setIcon(hotricon);  
            }  
  
            @Override  
            public void mouseExited(MouseEvent e) {  
                // When the mouse enters the button area, set the hovering icon
                rbutton1.setIcon(ricon);  
            }  
        });  
		Command rcommand = new RestartCommand(ac);
		ButtonListener rbl = new ButtonListener(rcommand);
		// Add a click event listener to the button
		rbutton1.addActionListener(rbl);
		tab2Panel.add(panel_2);
		this.add(tab2Panel);
	}
		
}
