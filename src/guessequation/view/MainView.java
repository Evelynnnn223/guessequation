package guessequation.view;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import guessequation.controller.GameController;
import guessequation.modle.GuessModle;

public class MainView {
	private GameController gc;
	private JFrame frame;
	private JTabbedPane tabbedPane;
	public MainView(GuessModle gm, GameController gc) {
		frame = new JFrame("Guess Equation");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 690); // Set window size
		frame.setBackground(Color.WHITE);
		this.gc = gc;
		init();
	}

	public GameController getGuessController() {
		return gc;
	}

	//Add Tabs
	public void addTab(JPanel jtab,ImageIcon tabImg,String info) {
		tabbedPane.addTab(null, tabImg, jtab, info);
	}
	
	//Initialize window
	public void init() {
		tabbedPane = new JTabbedPane();
		tabbedPane.setUI(new CustomTabbedPaneUI());
		frame.add(tabbedPane, BorderLayout.CENTER);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBorder(null);
		frame.setVisible(true);
	}

}
