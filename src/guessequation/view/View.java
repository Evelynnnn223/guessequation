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
	public int index = 0;// 当前操作的数字位置
	public int line = 0;// 当前操作的数字位置
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
		button1.setBorderPainted(false); // 不绘制按钮边框
		button1.setContentAreaFilled(false); // 不填充按钮内容区域背景
		panel.add(button1); // 将按钮添加到面板中
		// 为按钮添加点击事件监听器
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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置窗口关闭时的操作
		frame.setSize(800, 600); // 设置窗口大小
		// 创建 FlowLayout 实例并设置水平和垂直间距
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 5, 0);
		JPanel panelts = new JPanel();
		panelts.setBackground(Color.WHITE);
		panelts.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frame.add(panel); // 将面板添加到窗口中
		panel.add(panelts);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		dbutton = new Dimension(57, 57);
		try {
			// 加载图片
			BufferedImage image = ImageIO.read(new File("src/resource/1.png")); // 替换为你的图片路径
			ImageIcon icon = new ImageIcon(image);
			JPanel panelt = new JPanel();
			panelt.setBackground(Color.WHITE);
			panelt.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
			for (int j = 0; j < 6; j++) {
				JPanel panel1 = new JPanel();
				panel1.setBackground(Color.WHITE);
				panel1.setLayout(layout);
				for (int i = 0; i < column; i++) {
					// 创建一个JLabel来显示图片
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

			// 加载自定义图片
			ImageIcon icon1 = new ImageIcon(ImageIO.read(new File("src/resource/number1.png")));
			// 创建一个按钮
			creatButton(panel2, icon1);
			// 加载自定义图片
			ImageIcon icon2 = new ImageIcon(ImageIO.read(new File("src/resource/number2.png")));
			// 创建一个按钮
			creatButton(panel2, icon2);
			// 加载自定义图片
			ImageIcon icon3 = new ImageIcon(ImageIO.read(new File("src/resource/number3.png")));
			// 创建一个按钮
			creatButton(panel2, icon3);
			// 加载自定义图片
			ImageIcon icon4 = new ImageIcon(ImageIO.read(new File("src/resource/number4.png")));
			// 创建一个按钮
			creatButton(panel2, icon4);
			// 加载自定义图片
			ImageIcon icon5 = new ImageIcon(ImageIO.read(new File("src/resource/number5.png")));
			creatButton(panel2, icon5);
			// 加载自定义图片
			ImageIcon icon6 = new ImageIcon(ImageIO.read(new File("src/resource/number6.png")));
			creatButton(panel2, icon6);
			// 加载自定义图片
			ImageIcon icon7 = new ImageIcon(ImageIO.read(new File("src/resource/number7.png")));
			creatButton(panel2, icon7);
			// 加载自定义图片
			ImageIcon icon8 = new ImageIcon(ImageIO.read(new File("src/resource/number8.png")));
			creatButton(panel2, icon8);
			// 加载自定义图片
			ImageIcon icon9 = new ImageIcon(ImageIO.read(new File("src/resource/number9.png")));
			creatButton(panel2, icon9);
			// 加载自定义图片
			ImageIcon icon0 = new ImageIcon(ImageIO.read(new File("src/resource/number0.png")));
			// 创建一个按钮
			creatButton(panel2, icon0);

			JPanel panel3 = new JPanel();
			panel3.setBackground(Color.WHITE);
			panel3.setLayout(layout);
			// 创建一个按钮
			JButton button11 = new JButton("<-");
			panel3.add(button11); // 将按钮添加到面板中
			// 为按钮添加点击事件监听器
			button11.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					backward(icon);
				}
			});
			// 创建一个按钮
			JButton button12 = new JButton("+");
			panel3.add(button12); // 将按钮添加到面板中
			// 创建一个按钮
			JButton button13 = new JButton("-");
			panel3.add(button13); // 将按钮添加到面板中
			// 创建一个按钮
			JButton button14 = new JButton("x");
			panel3.add(button14); // 将按钮添加到面板中
			// 创建一个按钮
			JButton button15 = new JButton("/");
			panel3.add(button15); // 将按钮添加到面板中
			// 创建一个按钮
			JButton button16 = new JButton("=");
			panel3.add(button16); // 将按钮添加到面板中
			// 创建一个按钮
			JButton button17 = new JButton("enter");
			panel3.add(button17); // 将按钮添加到面板中
			button17.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// 在点击按钮时显示一串字符
					// JOptionPane.showMessageDialog(frame, "Hello, World!");
					index = 0;
					line++;
				}
			});

			panel.add(panel2);
			panel.add(panel3);
			// 显示窗口
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
