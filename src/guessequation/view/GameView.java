package guessequation.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import guessequation.controller.GuessController;
import guessequation.modle.GuessModle;

public class GameView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 615688341641039725L;
	private ArrayList<JLabel> ajl = new ArrayList<JLabel>();
	private ArrayList<JPanel> ajp = new ArrayList<JPanel>();
	private ArrayList<ImageIcon> greyajbi = new ArrayList<ImageIcon>();
	private ArrayList<ImageIcon> yellowajbi = new ArrayList<ImageIcon>();
	private ArrayList<ImageIcon> greenajbi = new ArrayList<ImageIcon>();
	private Action ac;
	private int index = 0;// ��ǰ����������λ��
	private int line = 0;// ��ǰ����������λ��
	private int column;
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
	public void switchImage(ImageIcon icon) {
		JLabel jl = ajl.get(this.line * column + this.index);
		jl.setIcon(icon);
//		Runnable run = new Runnable() {  
//		    @Override  
//		    public void run() {  
//		        // ����UI���...  
//		    	jl.repaint();  
//		    }  
//		};
//		ajl.get(this.line * column + this.index).updateUI();
//		ajl.get(this.line * column + this.index).revalidate();  
//		ajl.get(this.line * column + this.index).repaint();
//		SwingUtilities.invokeLater();
//		try {
//			SwingUtilities.invokeAndWait(run);
//		} catch (InvocationTargetException e) {
//			// TODO �Զ����ɵ� catch ��
//			e.printStackTrace();
//		} catch (InterruptedException e) {
//			// TODO �Զ����ɵ� catch ��
//			e.printStackTrace();
//		}
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
		Command csymbol = new GameSymbolCommand(icon, str, ac);
		ButtonListener bsymbol = new ButtonListener(csymbol);
		// Ϊ��ť��ӵ���¼�������
		button1.addActionListener(bsymbol);
	}
	public void initgrid(int column) {
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
				// ����һ��JLabel����ʾͼƬ
				JLabel label = new JLabel(icon);
				label.setPreferredSize(new Dimension(57, 57));
				ajl.add(label);
				panel1.add(label);
			}
		}
	}
	public void init(int column) {
		this.column = column;
		this.setBackground(Color.WHITE);
		// ���� FlowLayout ʵ��������ˮƽ�ʹ�ֱ���
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 5, 0);
		//tabbedPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT); 
		JPanel panelts = new JPanel();
		panelts.setBackground(Color.WHITE);
		panelts.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.add(panelts);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		Dimension dbutton = new Dimension(57, 57);
			// ����ͼƬ
			ImageIcon icon = new ImageIcon("src/resource/1.png");
			JPanel panelt = new JPanel();
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
				if(i != 14) {
					ImageIcon icont3 = new ImageIcon(img3);
					greyajbi.add(icont3);
				}
				yellowajbi.add(icont2);
				greenajbi.add(icont1);
				
			}
			
			// �����Զ���ͼƬ
			ImageIcon icon1 = new ImageIcon("src/resource/number1.png");
			// ����һ����ť
			creatButton(panel2, icon1,'1',dbutton);
			// �����Զ���ͼƬ
			ImageIcon icon2 = new ImageIcon("src/resource/number2.png");
			// ����һ����ť
			creatButton(panel2, icon2,'2',dbutton);
			// �����Զ���ͼƬ
			ImageIcon icon3 = new ImageIcon("src/resource/number3.png");
			// ����һ����ť
			creatButton(panel2, icon3,'3',dbutton);
			// �����Զ���ͼƬ
			ImageIcon icon4 = new ImageIcon("src/resource/number4.png");
			// ����һ����ť
			creatButton(panel2, icon4,'4',dbutton);
			// �����Զ���ͼƬ
			ImageIcon icon5 = new ImageIcon("src/resource/number5.png");
			creatButton(panel2, icon5,'5',dbutton);
			// �����Զ���ͼƬ
			ImageIcon icon6 = new ImageIcon("src/resource/number6.png");
			creatButton(panel2, icon6,'6',dbutton);
			// �����Զ���ͼƬ
			ImageIcon icon7 = new ImageIcon("src/resource/number7.png");
			creatButton(panel2, icon7,'7',dbutton);
			// �����Զ���ͼƬ
			ImageIcon icon8 = new ImageIcon("src/resource/number8.png");
			creatButton(panel2, icon8,'8',dbutton);
			// �����Զ���ͼƬ
			ImageIcon icon9 = new ImageIcon("src/resource/number9.png");
			creatButton(panel2, icon9,'9',dbutton);
			// �����Զ���ͼƬ
			ImageIcon icon0 = new ImageIcon("src/resource/number0.png");
			// ����һ����ť
			creatButton(panel2, icon0,'0',dbutton);

			JPanel panel3 = new JPanel();
			panel3.setBackground(Color.WHITE);
			panel3.setLayout(layout);
			Dimension dbutton2 = new Dimension(118, 58);
			// ����һ����ť
			JButton button11 = new JButton();
			ImageIcon iconback = new ImageIcon("src/resource/back.png");
			button11.setPreferredSize(dbutton2);
			button11.setIcon(iconback);
			button11.setBorderPainted(false); // �����ư�ť�߿�
			button11.setContentAreaFilled(false); // ����䰴ť�������򱳾�
			panel3.add(button11); // ����ť��ӵ������
			Command cback = new GameBackCommand(icon, ac);
			ButtonListener bback = new ButtonListener(cback);
			// Ϊ��ť��ӵ���¼�������
			button11.addActionListener(bback);
			Dimension dbutton1 = new Dimension(64, 55);
			// ����һ����ť
			ImageIcon iconsum = new ImageIcon("src/resource/sum.png");
			creatButton(panel3, iconsum,'+',dbutton1);
			// ����һ����ť
			ImageIcon iconreduce = new ImageIcon("src/resource/reduce.png");
			creatButton(panel3, iconreduce,'-',dbutton1);
			// ����һ����ť
			ImageIcon iconride = new ImageIcon("src/resource/ride.png");
			creatButton(panel3, iconride,'*',dbutton1);
			// ����һ����ť
			ImageIcon iconexcept = new ImageIcon("src/resource/except.png");
			creatButton(panel3, iconexcept,'/',dbutton1);
			// ����һ����ť
			ImageIcon iconequal = new ImageIcon("src/resource/equal.png");
			creatButton(panel3, iconequal,'=',dbutton1);
			// ����һ����ť
			JButton button17 = new JButton();
			ImageIcon iconenter = new ImageIcon("src/resource/enter.png");
			button17.setPreferredSize(dbutton2);
			button17.setIcon(iconenter);
			button17.setBorderPainted(false); // �����ư�ť�߿�
			button17.setContentAreaFilled(false); // ����䰴ť�������򱳾�
			panel3.add(button17); // ����ť��ӵ������
			Command center = new GameEnterCommand(ac);
			ButtonListener benter = new ButtonListener(center);
			button17.addActionListener(benter);
			panel.add(panel2);
			panel.add(panel3);
			this.add(panel);
			initgrid(column);
	}
	public void prompt() {
		JOptionPane.showMessageDialog(this, "Equation error!");
	}
}
