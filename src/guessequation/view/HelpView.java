package guessequation.view;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

//Help Page
public class HelpView extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5531007613305072532L;
	public HelpView() {
		init();
	}
	public void init() {
		this.setBackground(Color.WHITE);
		JPanel tabPanel = new JPanel();  
        tabPanel.setBackground(Color.WHITE);
        tabPanel.setLayout(new BoxLayout(tabPanel, BoxLayout.Y_AXIS));
        JPanel imgPanel1 = new JPanel();  
        imgPanel1.setBackground(Color.WHITE);
        ImageIcon sethelp1Icon = new ImageIcon("src/resource/help1.png"); 
		JLabel sethelp1label1 = new JLabel(sethelp1Icon);
		imgPanel1.add(sethelp1label1);
		tabPanel.add(imgPanel1);
		JPanel imgPanel2 = new JPanel();  
		imgPanel2.setBackground(Color.WHITE);
        ImageIcon sethelp2Icon = new ImageIcon("src/resource/help2.png"); 
		JLabel sethelp1label2 = new JLabel(sethelp2Icon);
		imgPanel2.add(sethelp1label2);
		tabPanel.add(imgPanel2);
		this.add(tabPanel);
	}
}
