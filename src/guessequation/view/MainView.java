package guessequation.view;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import guessequation.controller.GuessController;
import guessequation.modle.GuessModle;

public class MainView {
	private GuessModle gm;
	private GuessController gc;
	private JFrame frame;
	private JTabbedPane tabbedPane;
	public MainView(GuessModle gm, GuessController gc) {
		frame = new JFrame("Button Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置窗口关闭时的操作
		frame.setSize(800, 680); // 设置窗口大小
		frame.setBackground(Color.WHITE);
		this.gm = gm;
		this.gc = gc;
		init();
	}

	public GuessController getGuessController() {
		return gc;
	}



	public void addTab(JPanel jtab,ImageIcon tabImg,String info) {
		tabbedPane.addTab(null, tabImg, jtab, info);
	}
	
	public void init() {
		tabbedPane = new JTabbedPane();
		tabbedPane.setUI(new CustomTabbedPaneUI());
		frame.add(tabbedPane, BorderLayout.CENTER);
//		ImageIcon tab1Icon = new ImageIcon("src/resource/n+.png");
//		ImageIcon tab2Icon = new ImageIcon("src/resource/set.png");
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBorder(null);
//		tabbedPane.addTab(null, tab1Icon, tab1Pane1, "游戏");
//		tabbedPane.addTab(null, tab2Icon, tab2Panel, "设置");

		frame.setVisible(true);
	}

}
