package guessequation.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class View {
	public ArrayList<JLabel> ajl = new ArrayList<JLabel>();
	private ArrayList<ImageIcon> ajbi = new ArrayList<ImageIcon>();
	private ArrayList<ImageIcon> rajbi = new ArrayList<ImageIcon>();
	private ArrayList<ImageIcon> yajbi = new ArrayList<ImageIcon>();
	private ArrayList<ImageIcon> gajbi = new ArrayList<ImageIcon>();
	public int index = 0;// ��ǰ����������λ��
	public int line = 0;// ��ǰ����������λ��
	private JFrame frame;
	private JPanel panel;
	private int column;
	private Dimension dbutton;
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
		forward(yajbi.get(num));
	}
	public void greenImage(int num) {
		forward(gajbi.get(num));
	}
	public void creatButton(JPanel panel,ImageIcon icon) {
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
			}
		});
	}
	public void init(int column) {
		this.column = column;
		frame = new JFrame("Button Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���ô��ڹر�ʱ�Ĳ���
		frame.setSize(800, 600); // ���ô��ڴ�С
		// ���� FlowLayout ʵ��������ˮƽ�ʹ�ֱ���
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 5, 0);
		JPanel panelts = new JPanel();
		panelts.setBackground(Color.WHITE);
		panelts.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frame.add(panel); // �������ӵ�������
		panel.add(panelts);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		dbutton = new Dimension(57, 57);
		try {
			// ����ͼƬ
			BufferedImage image = ImageIO.read(new File("src/resource/1.png")); // �滻Ϊ���ͼƬ·��
			ImageIcon icon = new ImageIcon(image);
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
				panel.add(panel1);
			}
			panel.add(panelt);
			JPanel panel2 = new JPanel();
			panel2.setBackground(Color.WHITE);
			panel2.setLayout(layout);

			// �����Զ���ͼƬ
			ImageIcon icon1 = new ImageIcon(ImageIO.read(new File("src/resource/number1.png")));
			// ����һ����ť
			creatButton(panel2, icon1);
			// �����Զ���ͼƬ
			ImageIcon icon2 = new ImageIcon(ImageIO.read(new File("src/resource/number2.png")));
			// ����һ����ť
			creatButton(panel2, icon2);
			// �����Զ���ͼƬ
			ImageIcon icon3 = new ImageIcon(ImageIO.read(new File("src/resource/number3.png")));
			// ����һ����ť
			creatButton(panel2, icon3);
			// �����Զ���ͼƬ
			ImageIcon icon4 = new ImageIcon(ImageIO.read(new File("src/resource/number4.png")));
			// ����һ����ť
			creatButton(panel2, icon4);
			// �����Զ���ͼƬ
			ImageIcon icon5 = new ImageIcon(ImageIO.read(new File("src/resource/number5.png")));
			creatButton(panel2, icon5);
			// �����Զ���ͼƬ
			ImageIcon icon6 = new ImageIcon(ImageIO.read(new File("src/resource/number6.png")));
			creatButton(panel2, icon6);
			// �����Զ���ͼƬ
			ImageIcon icon7 = new ImageIcon(ImageIO.read(new File("src/resource/number7.png")));
			creatButton(panel2, icon7);
			// �����Զ���ͼƬ
			ImageIcon icon8 = new ImageIcon(ImageIO.read(new File("src/resource/number8.png")));
			creatButton(panel2, icon8);
			// �����Զ���ͼƬ
			ImageIcon icon9 = new ImageIcon(ImageIO.read(new File("src/resource/number9.png")));
			creatButton(panel2, icon9);
			// �����Զ���ͼƬ
			ImageIcon icon0 = new ImageIcon(ImageIO.read(new File("src/resource/number0.png")));
			// ����һ����ť
			creatButton(panel2, icon0);

			JPanel panel3 = new JPanel();
			panel3.setBackground(Color.WHITE);
			panel3.setLayout(layout);
			// ����һ����ť
			JButton button11 = new JButton("<-");
			panel3.add(button11); // ����ť��ӵ������
			// Ϊ��ť��ӵ���¼�������
			button11.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					backward(icon);
				}
			});
			// ����һ����ť
			JButton button12 = new JButton("+");
			panel3.add(button12); // ����ť��ӵ������
			// ����һ����ť
			JButton button13 = new JButton("-");
			panel3.add(button13); // ����ť��ӵ������
			// ����һ����ť
			JButton button14 = new JButton("x");
			panel3.add(button14); // ����ť��ӵ������
			// ����һ����ť
			JButton button15 = new JButton("/");
			panel3.add(button15); // ����ť��ӵ������
			// ����һ����ť
			JButton button16 = new JButton("=");
			panel3.add(button16); // ����ť��ӵ������
			// ����һ����ť
			JButton button17 = new JButton("enter");
			panel3.add(button17); // ����ť��ӵ������
			button17.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// �ڵ����ťʱ��ʾһ���ַ�
					// JOptionPane.showMessageDialog(frame, "Hello, World!");
					index = 0;
					line++;
				}
			});

			panel.add(panel2);
			panel.add(panel3);
			// ��ʾ����
			frame.setVisible(true);
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(frame, "Error loading image: " + e.getMessage());
		}
	}


	public static void main(String[] args) {
		View v = new View();
		v.init(6);
	}

}
