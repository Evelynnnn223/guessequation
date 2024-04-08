package guessequation.view;

import javax.imageio.ImageIO;
import javax.swing.*;

import guessequation.controller.GuessController;
import guessequation.modle.GuessModle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class View {
	public ArrayList<JLabel> ajl = new ArrayList<JLabel>();
	private ArrayList<ImageIcon> greyajbi = new ArrayList<ImageIcon>();
	private ArrayList<ImageIcon> rajbi = new ArrayList<ImageIcon>();
	private ArrayList<ImageIcon> yellowajbi = new ArrayList<ImageIcon>();
	private ArrayList<ImageIcon> greenajbi = new ArrayList<ImageIcon>();
	private GuessModle gm = new GuessModle();
	private GuessController gc = new GuessController(this, gm);
	public int index = 0;// ��ǰ����������λ��
	public int line = 0;// ��ǰ����������λ��
	private JFrame frame;
	private JPanel panel;
	private int column;
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	public void switchImage(ImageIcon icon) {
		ajl.get(this.line * column + this.index).setIcon(icon);
	}
	public void forward(ImageIcon icon) {
		if (this.index < column) {
			switchImage(icon);
			this.index++;
		}
	}
	public void backward(ImageIcon icon) {
		if (index > 0) {
			index--;
			switchImage(icon);
		}
	}
	public void redImage(int num) {
		forward(rajbi.get(num));
	}
	public void yellowImage(int num) {
		forward(yellowajbi.get(num));
	}
	public void greyImage(int num) {
		forward(greyajbi.get(num));
	}
	public void greenImage(int num) {
		forward(greenajbi.get(num));
	}
	public void creatButton(JPanel panel,ImageIcon icon,char str,Dimension dbutton) {
		JButton button1 = new JButton();
		button1.setPreferredSize(dbutton);
		button1.setIcon(icon);
		button1.setBorderPainted(false); // �����ư�ť�߿�
		button1.setContentAreaFilled(false); // ����䰴ť�������򱳾�
		panel.add(button1); // ����ť��ӵ������
		// Ϊ��ť��ӵ���¼�������
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				forward(icon);
				gc.add(str);
			}
		});
	}
	public void initButton() {
		
	}
	public void prompt() {
		JOptionPane.showMessageDialog(frame, "Equation error!");
	}
	public void init(int column) {
		this.column = column;
		gm.init(1);
		frame = new JFrame("Button Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���ô��ڹر�ʱ�Ĳ���
		frame.setSize(800, 600); // ���ô��ڴ�С
		frame.setBackground(Color.WHITE);
		// ���� FlowLayout ʵ��������ˮƽ�ʹ�ֱ���
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 5, 0);
		JTabbedPane tabbedPane = new JTabbedPane();  
		tabbedPane.setUI(new CustomTabbedPaneUI());
		//tabbedPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT); 
		JPanel tab1Pane1 = new JPanel();  
		JPanel panelts = new JPanel();
		tab1Pane1.setBackground(Color.WHITE);
        JPanel tab2Panel = new JPanel();  
        
		panelts.setBackground(Color.WHITE);
		panelts.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		panel = new JPanel();
		
		tab2Panel.add(new JLabel("���ǵڶ�����ǩҳ������"));  
		
		panel.setBackground(Color.WHITE);
		frame.add(tabbedPane, BorderLayout.CENTER);  
		panel.add(panelts);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		Dimension dbutton = new Dimension(57, 57);
		try {
			// ����ͼƬ
			BufferedImage image = ImageIO.read(new File("src/resource/1.png")); // �滻Ϊ���ͼƬ·��
			ImageIcon icon = new ImageIcon(image);
			JPanel panelt = new JPanel();
			ImageIcon tab1Icon = new ImageIcon("src/resource/n+.png");  
	        ImageIcon tab2Icon = new ImageIcon("src/resource/set.png");  
	        tabbedPane.setBackground(Color.WHITE);
	        tabbedPane.setBorder(null);
	        tabbedPane.addTab(null, tab1Icon, tab1Pane1, "��Ϸ");
	        tabbedPane.addTab(null, tab2Icon, tab2Panel, "����");
	        
	        //tabbedPane.addTab("��ǩ1", panel); 
	        //tabbedPane.addTab("��ǩ2", tab2Panel);  
			panelt.setBackground(Color.WHITE);
			panelt.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
			for (int j = 0; j < 6; j++) {
				JPanel panel1 = new JPanel();
				panel1.setBackground(Color.WHITE);
				panel1.setLayout(layout);
				for (int i = 0; i < column; i++) {
					// ����һ��JLabel����ʾͼƬ
					JLabel label = new JLabel(icon);
					label.setPreferredSize(dbutton);
					ajl.add(label);
					panel1.add(label);
				}
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
				
				ImageIcon icont1 = new ImageIcon(ImageIO.read(new File(img1)));
				ImageIcon icont2 = new ImageIcon(ImageIO.read(new File(img2)));
				if(i != 14) {
					ImageIcon icont3 = new ImageIcon(ImageIO.read(new File(img3)));
					greyajbi.add(icont3);
				}
				yellowajbi.add(icont2);
				greenajbi.add(icont1);
				
			}
			
			// �����Զ���ͼƬ
			ImageIcon icon1 = new ImageIcon(ImageIO.read(new File("src/resource/number1.png")));
			// ����һ����ť
			creatButton(panel2, icon1,'1',dbutton);
			// �����Զ���ͼƬ
			ImageIcon icon2 = new ImageIcon(ImageIO.read(new File("src/resource/number2.png")));
			// ����һ����ť
			creatButton(panel2, icon2,'2',dbutton);
			// �����Զ���ͼƬ
			ImageIcon icon3 = new ImageIcon(ImageIO.read(new File("src/resource/number3.png")));
			// ����һ����ť
			creatButton(panel2, icon3,'3',dbutton);
			// �����Զ���ͼƬ
			ImageIcon icon4 = new ImageIcon(ImageIO.read(new File("src/resource/number4.png")));
			// ����һ����ť
			creatButton(panel2, icon4,'4',dbutton);
			// �����Զ���ͼƬ
			ImageIcon icon5 = new ImageIcon(ImageIO.read(new File("src/resource/number5.png")));
			creatButton(panel2, icon5,'5',dbutton);
			// �����Զ���ͼƬ
			ImageIcon icon6 = new ImageIcon(ImageIO.read(new File("src/resource/number6.png")));
			creatButton(panel2, icon6,'6',dbutton);
			// �����Զ���ͼƬ
			ImageIcon icon7 = new ImageIcon(ImageIO.read(new File("src/resource/number7.png")));
			creatButton(panel2, icon7,'7',dbutton);
			// �����Զ���ͼƬ
			ImageIcon icon8 = new ImageIcon(ImageIO.read(new File("src/resource/number8.png")));
			creatButton(panel2, icon8,'8',dbutton);
			// �����Զ���ͼƬ
			ImageIcon icon9 = new ImageIcon(ImageIO.read(new File("src/resource/number9.png")));
			creatButton(panel2, icon9,'9',dbutton);
			// �����Զ���ͼƬ
			ImageIcon icon0 = new ImageIcon(ImageIO.read(new File("src/resource/number0.png")));
			// ����һ����ť
			creatButton(panel2, icon0,'0',dbutton);

			JPanel panel3 = new JPanel();
			panel3.setBackground(Color.WHITE);
			panel3.setLayout(layout);
			Dimension dbutton2 = new Dimension(118, 58);
			// ����һ����ť
			JButton button11 = new JButton();
			ImageIcon iconback = new ImageIcon(ImageIO.read(new File("src/resource/back.png")));
			button11.setPreferredSize(dbutton2);
			button11.setIcon(iconback);
			button11.setBorderPainted(false); // �����ư�ť�߿�
			button11.setContentAreaFilled(false); // ����䰴ť�������򱳾�
			panel3.add(button11); // ����ť��ӵ������
			// Ϊ��ť��ӵ���¼�������
			button11.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					backward(icon);
					gc.remove();
				}
			});
			Dimension dbutton1 = new Dimension(64, 55);
			// ����һ����ť
			ImageIcon iconsum = new ImageIcon(ImageIO.read(new File("src/resource/sum.png")));
			creatButton(panel3, iconsum,'+',dbutton1);
			// ����һ����ť
			ImageIcon iconreduce = new ImageIcon(ImageIO.read(new File("src/resource/reduce.png")));
			creatButton(panel3, iconreduce,'-',dbutton1);
			// ����һ����ť
			ImageIcon iconride = new ImageIcon(ImageIO.read(new File("src/resource/ride.png")));
			creatButton(panel3, iconride,'*',dbutton1);
			// ����һ����ť
			ImageIcon iconexcept = new ImageIcon(ImageIO.read(new File("src/resource/except.png")));
			creatButton(panel3, iconexcept,'/',dbutton1);
			// ����һ����ť
			ImageIcon iconequal = new ImageIcon(ImageIO.read(new File("src/resource/equal.png")));
			creatButton(panel3, iconequal,'=',dbutton1);
			// ����һ����ť
			JButton button17 = new JButton();
			ImageIcon iconenter = new ImageIcon(ImageIO.read(new File("src/resource/enter.png")));
			button17.setPreferredSize(dbutton2);
			button17.setIcon(iconenter);
			button17.setBorderPainted(false); // �����ư�ť�߿�
			button17.setContentAreaFilled(false); // ����䰴ť�������򱳾�
			panel3.add(button17); // ����ť��ӵ������
			button17.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// �ڵ����ťʱ��ʾһ���ַ�
					// JOptionPane.showMessageDialog(frame, "Hello, World!");
					if(gc.legal()) {
						index = 0;
						gc.guess();
						index = 0;
						line++;
					}else {
						prompt();
					}
				}
			});

			panel.add(panel2);
			panel.add(panel3);
			tab1Pane1.add(panel);
			// ��ʾ����
			frame.setVisible(true);
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(frame, "Error loading image: " + e.getMessage());
		}
		
	}


	public static void main(String[] args) {
		
		View v = new View(); 
		v.init(12);

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
