package guessequation.view;

import javax.imageio.ImageIO;
import javax.swing.*;

import guessequation.controller.GameController;
import guessequation.controller.SetController;
import guessequation.controller.StatisticsController;
import guessequation.modle.GuessModle;
import guessequation.modle.StatisticsModle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class View {
//	private ArrayList<JLabel> ajl = new ArrayList<JLabel>();
//	private ArrayList<JPanel> ajp = new ArrayList<JPanel>();
//	private ArrayList<ImageIcon> greyajbi = new ArrayList<ImageIcon>();
//	private ArrayList<ImageIcon> rajbi = new ArrayList<ImageIcon>();
//	private ArrayList<ImageIcon> yellowajbi = new ArrayList<ImageIcon>();
//	private ArrayList<ImageIcon> greenajbi = new ArrayList<ImageIcon>();
//	private ArrayList<JButton> setbut1 = new ArrayList<JButton>();
//	private ArrayList<Integer> setbut2 = new ArrayList<Integer>();
//	private GuessModle gm = new GuessModle();
//	private GameController gc = new GameController(this, gm);
//	public int index = 0;// 当前操作的数字位置
//	public int line = 0;// 当前操作的数字位置
//	private JFrame frame;
//	private JPanel panel;
//	private int column;
//	public View() {
//		frame = new JFrame("Button Example");
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置窗口关闭时的操作
//		frame.setSize(800, 600); // 设置窗口大小
//		frame.setBackground(Color.WHITE);
//	}
//	public GameController getGuessController() {
//		return gc;
//	}
//	public int getColumn() {
//		return column;
//	}
//	public void setColumn(int column) {
//		this.column = column;
//	}
//	public void switchImage(ImageIcon icon) {
//		ajl.get(this.line * column + this.index).setIcon(icon);
//	}
//	public void forward(ImageIcon icon) {
//		if (this.index < column) {
//			switchImage(icon);
//			this.index++;
//		}
//	}
//	public void backward(ImageIcon icon) {
//		if (index > 0) {
//			index--;
//			switchImage(icon);
//		}
//	}
//	public void redImage(int num) {
//		forward(rajbi.get(num));
//	}
//	public void yellowImage(int num) {
//		forward(yellowajbi.get(num));
//	}
//	public void greyImage(int num) {
//		forward(greyajbi.get(num));
//	}
//	public void greenImage(int num) {
//		forward(greenajbi.get(num));
//	}
//	public void creatButton(JPanel panel,ImageIcon icon,char str,Dimension dbutton) {
//		JButton button1 = new JButton();
//		button1.setPreferredSize(dbutton);
//		button1.setIcon(icon);
//		button1.setBorderPainted(false); // 不绘制按钮边框
//		button1.setContentAreaFilled(false); // 不填充按钮内容区域背景
//		panel.add(button1); // 将按钮添加到面板中
//		// 为按钮添加点击事件监听器
//		button1.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				forward(icon);
//				gc.add(str);
//			}
//		});
//	}
//	public void initgrid(int column) {
//		ajl.clear();
//		ImageIcon icon = new ImageIcon("src/resource/1.png");
//		for (int j = 0; j < 6; j++) {
//			JPanel panel1 = ajp.get(j);
//			panel1.removeAll();
//			panel1.setBackground(Color.WHITE);
//			panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
//			for (int i = 0; i < column; i++) {
//				// 创建一个JLabel来显示图片
//				JLabel label = new JLabel(icon);
//				label.setPreferredSize(new Dimension(57, 57));
//				ajl.add(label);
//				panel1.add(label);
//			}
//		}
//	}
//	public void prompt() {
//		JOptionPane.showMessageDialog(frame, "Equation error!");
//	}
//	public void init(int column) {
//		this.column = column;
//		gm.init(1);
//		
//		// 创建 FlowLayout 实例并设置水平和垂直间距
//		FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 5, 0);
//		JTabbedPane tabbedPane = new JTabbedPane();  
//		tabbedPane.setUI(new CustomTabbedPaneUI());
//		//tabbedPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT); 
//		JPanel tab1Pane1 = new JPanel();  
//		JPanel panelts = new JPanel();
//		tab1Pane1.setBackground(Color.WHITE);
//        JPanel tab2Panel = new JPanel();  
//        tab2Panel.setBackground(Color.WHITE);
//        JPanel panel_2= new JPanel();
//		panelts.setBackground(Color.WHITE);
//		panelts.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
//		panel = new JPanel();
//		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
//		panel_2.setBackground(Color.WHITE);
//		JPanel setpanel= new JPanel();
//		setpanel.setBackground(Color.WHITE);
//		setpanel.setLayout(layout);
//		ImageIcon setinfo1Icon = new ImageIcon("src/resource/setinfo1.png"); 
//		JLabel setinfo1label1 = new JLabel(setinfo1Icon);
//		//setinfo1label1.setPreferredSize(new Dimension(372, 50));
//		setpanel.add(setinfo1label1);
//		panel_2.add(setpanel);
//		JPanel setnumpanel= new JPanel();
//		setnumpanel.setLayout(layout);
//		setnumpanel.setBackground(Color.WHITE);
//		for(int i=5;i<13;i++) {
//			ImageIcon icon1 = new ImageIcon("src/resource/set"+i+".png");
//			JButton button1 = new JButton();
//			button1.setPreferredSize(new Dimension(34, 32));
//			button1.setIcon(icon1);
//			button1.setBorderPainted(false); // 不绘制按钮边框
//			button1.setContentAreaFilled(false); // 不填充按钮内容区域背景
//			setnumpanel.add(button1); // 将按钮添加到面板中
//			setbut1.add(button1);
//			int c = i;
//			// 为按钮添加点击事件监听器
//			button1.addActionListener(new ActionListener() {
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					for(int i=5;i<13;i++) {
//						JButton button = setbut1.get(i-5);
//						ImageIcon icon = new ImageIcon("src/resource/set"+i+".png");
//						button.setIcon(icon);
//					}
//					ImageIcon icon1 = new ImageIcon("src/resource/setgreen"+c+".png");
//					button1.setIcon(icon1);
//					initgrid(c);
//				}
//			});
//		}
//		panel_2.add(setnumpanel);
//		JPanel setpanel2= new JPanel();
//		setpanel2.setBackground(Color.WHITE);
//		setpanel2.setLayout(layout);
//		ImageIcon setinfo2Icon = new ImageIcon("src/resource/setinfo2.png"); 
//		JLabel setinfo1label2 = new JLabel(setinfo2Icon);
//		//setinfo1label1.setPreferredSize(new Dimension(372, 50));
//		setpanel2.add(setinfo1label2);
//		panel_2.add(setpanel2);
//		JPanel setnumpanel2= new JPanel();
//		setnumpanel2.setLayout(layout);
//		setnumpanel2.setBackground(Color.WHITE);
//		for(int i=13;i<17;i++) {
//			ImageIcon icon1 = new ImageIcon("src/resource/setgreen"+i+".png");
//			JButton button1 = new JButton();
//			button1.setPreferredSize(new Dimension(34, 32));
//			button1.setIcon(icon1);
//			button1.setBorderPainted(false); // 不绘制按钮边框
//			button1.setContentAreaFilled(false); // 不填充按钮内容区域背景
//			setnumpanel2.add(button1); // 将按钮添加到面板中
//			setbut2.add(1);
//			int c = i;
//			// 为按钮添加点击事件监听器
//			button1.addActionListener(new ActionListener() {
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					if(setbut2.get(c-13) == 1 && setbut2.stream().filter(v -> v == 1).count() > 1) {
//						ImageIcon icon = new ImageIcon("src/resource/set"+c+".png");
//						button1.setIcon(icon);
//						setbut2.set(c-13, 0);
//					}else {
//						ImageIcon icon1 = new ImageIcon("src/resource/setgreen"+c+".png");
//						button1.setIcon(icon1);
//						setbut2.set(c-13, 1);
//					}
//				}
//			});
//		}
//		panel_2.add(setnumpanel2);
//		tab2Panel.add(panel_2);
//		panel.setBackground(Color.WHITE);
//		frame.add(tabbedPane, BorderLayout.CENTER);  
//		panel.add(panelts);
//		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
//		Dimension dbutton = new Dimension(57, 57);
//		try {
//			// 加载图片
//			BufferedImage image = ImageIO.read(new File("src/resource/1.png")); // 替换为你的图片路径
//			ImageIcon icon = new ImageIcon(image);
//			JPanel panelt = new JPanel();
//			ImageIcon tab1Icon = new ImageIcon("src/resource/n+.png");  
//	        ImageIcon tab2Icon = new ImageIcon("src/resource/set.png");  
//	        tabbedPane.setBackground(Color.WHITE);
//	        tabbedPane.setBorder(null);
//	        tabbedPane.addTab(null, tab1Icon, tab1Pane1, "游戏");
//	        tabbedPane.addTab(null, tab2Icon, tab2Panel, "设置");
//	        
//	        //tabbedPane.addTab("标签1", panel); 
//	        //tabbedPane.addTab("标签2", tab2Panel);  
//			panelt.setBackground(Color.WHITE);
//			panelt.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
//			for (int j = 0; j < 6; j++) {
//				JPanel panel1 = new JPanel();
//				panel1.setBackground(Color.WHITE);
//				panel1.setLayout(layout);
//				for (int i = 0; i < column; i++) {
//					// 创建一个JLabel来显示图片
//					JLabel label = new JLabel(icon);
//					label.setPreferredSize(dbutton);
//					ajl.add(label);
//					panel1.add(label);
//				}
//				ajp.add(panel1);
//				panel.add(panel1);
//			}
//			panel.add(panelt);
//			JPanel panel2 = new JPanel();
//			panel2.setBackground(Color.WHITE);
//			panel2.setLayout(layout);
//			for(int i=0;i<15;i++) {
//				String img1 = "src/resource/green"+i+".png";
//				String img2 = "src/resource/yellow"+i+".png";
//				String img3 = "src/resource/grey"+i+".png";
//				
//				ImageIcon icont1 = new ImageIcon(ImageIO.read(new File(img1)));
//				ImageIcon icont2 = new ImageIcon(ImageIO.read(new File(img2)));
//				if(i != 14) {
//					ImageIcon icont3 = new ImageIcon(ImageIO.read(new File(img3)));
//					greyajbi.add(icont3);
//				}
//				yellowajbi.add(icont2);
//				greenajbi.add(icont1);
//				
//			}
//			
//			// 加载自定义图片
//			ImageIcon icon1 = new ImageIcon(ImageIO.read(new File("src/resource/number1.png")));
//			// 创建一个按钮
//			creatButton(panel2, icon1,'1',dbutton);
//			// 加载自定义图片
//			ImageIcon icon2 = new ImageIcon(ImageIO.read(new File("src/resource/number2.png")));
//			// 创建一个按钮
//			creatButton(panel2, icon2,'2',dbutton);
//			// 加载自定义图片
//			ImageIcon icon3 = new ImageIcon(ImageIO.read(new File("src/resource/number3.png")));
//			// 创建一个按钮
//			creatButton(panel2, icon3,'3',dbutton);
//			// 加载自定义图片
//			ImageIcon icon4 = new ImageIcon(ImageIO.read(new File("src/resource/number4.png")));
//			// 创建一个按钮
//			creatButton(panel2, icon4,'4',dbutton);
//			// 加载自定义图片
//			ImageIcon icon5 = new ImageIcon(ImageIO.read(new File("src/resource/number5.png")));
//			creatButton(panel2, icon5,'5',dbutton);
//			// 加载自定义图片
//			ImageIcon icon6 = new ImageIcon(ImageIO.read(new File("src/resource/number6.png")));
//			creatButton(panel2, icon6,'6',dbutton);
//			// 加载自定义图片
//			ImageIcon icon7 = new ImageIcon(ImageIO.read(new File("src/resource/number7.png")));
//			creatButton(panel2, icon7,'7',dbutton);
//			// 加载自定义图片
//			ImageIcon icon8 = new ImageIcon(ImageIO.read(new File("src/resource/number8.png")));
//			creatButton(panel2, icon8,'8',dbutton);
//			// 加载自定义图片
//			ImageIcon icon9 = new ImageIcon(ImageIO.read(new File("src/resource/number9.png")));
//			creatButton(panel2, icon9,'9',dbutton);
//			// 加载自定义图片
//			ImageIcon icon0 = new ImageIcon(ImageIO.read(new File("src/resource/number0.png")));
//			// 创建一个按钮
//			creatButton(panel2, icon0,'0',dbutton);
//
//			JPanel panel3 = new JPanel();
//			panel3.setBackground(Color.WHITE);
//			panel3.setLayout(layout);
//			Dimension dbutton2 = new Dimension(118, 58);
//			// 创建一个按钮
//			JButton button11 = new JButton();
//			ImageIcon iconback = new ImageIcon(ImageIO.read(new File("src/resource/back.png")));
//			button11.setPreferredSize(dbutton2);
//			button11.setIcon(iconback);
//			button11.setBorderPainted(false); // 不绘制按钮边框
//			button11.setContentAreaFilled(false); // 不填充按钮内容区域背景
//			panel3.add(button11); // 将按钮添加到面板中
//			// 为按钮添加点击事件监听器
//			button11.addActionListener(new ActionListener() {
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					backward(icon);
//					gc.remove();
//				}
//			});
//			Dimension dbutton1 = new Dimension(64, 55);
//			// 创建一个按钮
//			ImageIcon iconsum = new ImageIcon(ImageIO.read(new File("src/resource/sum.png")));
//			creatButton(panel3, iconsum,'+',dbutton1);
//			// 创建一个按钮
//			ImageIcon iconreduce = new ImageIcon(ImageIO.read(new File("src/resource/reduce.png")));
//			creatButton(panel3, iconreduce,'-',dbutton1);
//			// 创建一个按钮
//			ImageIcon iconride = new ImageIcon(ImageIO.read(new File("src/resource/ride.png")));
//			creatButton(panel3, iconride,'*',dbutton1);
//			// 创建一个按钮
//			ImageIcon iconexcept = new ImageIcon(ImageIO.read(new File("src/resource/except.png")));
//			creatButton(panel3, iconexcept,'/',dbutton1);
//			// 创建一个按钮
//			ImageIcon iconequal = new ImageIcon(ImageIO.read(new File("src/resource/equal.png")));
//			creatButton(panel3, iconequal,'=',dbutton1);
//			// 创建一个按钮
//			JButton button17 = new JButton();
//			ImageIcon iconenter = new ImageIcon(ImageIO.read(new File("src/resource/enter.png")));
//			button17.setPreferredSize(dbutton2);
//			button17.setIcon(iconenter);
//			button17.setBorderPainted(false); // 不绘制按钮边框
//			button17.setContentAreaFilled(false); // 不填充按钮内容区域背景
//			panel3.add(button17); // 将按钮添加到面板中
//			button17.addActionListener(new ActionListener() {
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					// 在点击按钮时显示一串字符
//					// JOptionPane.showMessageDialog(frame, "Hello, World!");
//					if(gc.legal()) {
//						index = 0;
//						gc.guess();
//						index = 0;
//						line++;
//					}else {
//						prompt();
//					}
//				}
//			});
//
//			panel.add(panel2);
//			panel.add(panel3);
//			tab1Pane1.add(panel);
//			// 显示窗口
//			frame.setVisible(true);
//			initgrid(column);
//		} catch (IOException e) {
//			e.printStackTrace();
//			JOptionPane.showMessageDialog(frame, "Error loading image: " + e.getMessage());
//		}
//		
//	}


	public static void main(String[] args) {
		Action ac = new Action();
		GameView gv = new GameView(5,ac);
		SetView sv = new SetView(5,ac);
		HelpView hv = new HelpView();
		StatisticsView stv = new StatisticsView();
		StatisticsModle smodle = new StatisticsModle();
		StatisticsController sc = new StatisticsController(smodle, stv);
		smodle.addObserver(sc);
		smodle.notifyObservers();
		stv.setSc(sc);
		stv.setColumn(gv.getColumn());
		GuessModle gm = new GuessModle();
		GameController gc = new GameController(gv, gm,smodle);
		gm.creatEquation(1);
		gm.addObserver(gc);
		gm.notifyObservers();
		MainView mv = new MainView(gm, gc);
		SetController sec = new SetController(gm, sv);
		ac.setGc(gc);
		ac.setSc(sec);
		ac.setStv(stv);
		ImageIcon tab1Icon = new ImageIcon("src/resource/n+.png");
		ImageIcon tab2Icon = new ImageIcon("src/resource/statistics.png");
		ImageIcon tab3Icon = new ImageIcon("src/resource/set.png");
		ImageIcon tab4Icon = new ImageIcon("src/resource/help.png");
		mv.addTab(gv, tab1Icon, "游戏");
		mv.addTab(stv, tab2Icon, "统计");
		mv.addTab(sv, tab3Icon, "设置");
		mv.addTab(hv, tab4Icon, "帮助");
//		View v = new View(); 
//		v.init(5);
		

//		GuessModle gm = new GuessModle();
//		String str = "1+12*5=61";
//		ArrayList<Character> lstr = new ArrayList<Character>();
//		gm.init(1);
//		for(int i = 0;i<str.length();i++) {
//			lstr.add(str.charAt(i));
//		}
//		String re1 =gm.getEquation(lstr);
//		System.out.println(re1);
//		ArrayList<String> lstr1 = gm.getEquationList(lstr);
//		for(int i = 0;i<lstr1.size();i++) {
//			System.out.println(lstr1.get(i));
//		}
//		ArrayList<Integer> relist = gm.guessModle(lstr1);
//		for(int i = 0;i<relist.size();i++) {
//			System.out.println(relist.get(i));
//		}
//		for(int i = 0;i<10;i++) {
//			System.out.println(gm.creatFun(6));
//		}
	}

}
