package guessequation.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class View {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		// 创建一个JFrame窗口
		JFrame frame = new JFrame("Button Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置窗口关闭时的操作
		frame.setSize(800, 600); // 设置窗口大小
		// 创建 FlowLayout 实例并设置水平和垂直间距  
        FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 5, 0);
        JPanel panelts = new JPanel();
		panelts.setBackground(Color.WHITE); 
		panelts.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		// 创建一个JPanel面板，用于放置按钮
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);  
		frame.add(panel); // 将面板添加到窗口中
		panel.add(panelts);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
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
				for (int i = 0; i < 7; i++) {
					// 创建一个JLabel来显示图片
					JLabel label = new JLabel(icon);
					panel1.add(label);
				}
				panel.add(panel1);
			}
			panel.add(panelt);
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(frame, "Error loading image: " + e.getMessage());
		}
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.WHITE);  
		panel2.setLayout(layout);
		try {
			Dimension dbutton = new Dimension(57, 57);
			// 加载自定义图片
			ImageIcon icon1 = new ImageIcon(ImageIO.read(new File("src/resource/number1.png")));
			// 创建一个按钮
			JButton button1 = new JButton();
			button1.setPreferredSize(dbutton);
			button1.setIcon(icon1);
			button1.setBorderPainted(false); // 不绘制按钮边框
			button1.setContentAreaFilled(false); // 不填充按钮内容区域背景
			panel2.add(button1); // 将按钮添加到面板中
			// 为按钮添加点击事件监听器
			button1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// 在点击按钮时显示一串字符
					JOptionPane.showMessageDialog(frame, "Hello, World!");
				}
			});
			// 加载自定义图片
			ImageIcon icon2 = new ImageIcon(ImageIO.read(new File("src/resource/number2.png")));
			// 创建一个按钮
			JButton button2 = new JButton();
			button2.setPreferredSize(dbutton);
			button2.setIcon(icon2);
			button2.setBorderPainted(false); // 不绘制按钮边框
			button2.setContentAreaFilled(false); // 不填充按钮内容区域背景
			panel2.add(button2); // 将按钮添加到面板中
			// 加载自定义图片
			ImageIcon icon3 = new ImageIcon(ImageIO.read(new File("src/resource/number3.png")));
			// 创建一个按钮
			JButton button3 = new JButton();
			button3.setPreferredSize(dbutton);
			button3.setIcon(icon3);
			button3.setBorderPainted(false); // 不绘制按钮边框
			button3.setContentAreaFilled(false); // 不填充按钮内容区域背景
			panel2.add(button3); // 将按钮添加到面板中
			// 加载自定义图片
			ImageIcon icon4 = new ImageIcon(ImageIO.read(new File("src/resource/number4.png")));
			// 创建一个按钮
			JButton button4 = new JButton();
			button4.setPreferredSize(dbutton);
			button4.setIcon(icon4);
			button4.setBorderPainted(false); // 不绘制按钮边框
			button4.setContentAreaFilled(false); // 不填充按钮内容区域背景
			panel2.add(button4); // 将按钮添加到面板中
			// 加载自定义图片
			ImageIcon icon5 = new ImageIcon(ImageIO.read(new File("src/resource/number5.png")));
			// 创建一个按钮
			JButton button5 = new JButton();
			button5.setPreferredSize(dbutton);
			button5.setIcon(icon5);
			button5.setBorderPainted(false); // 不绘制按钮边框
			button5.setContentAreaFilled(false); // 不填充按钮内容区域背景
			panel2.add(button5); // 将按钮添加到面板中
			// 加载自定义图片
			ImageIcon icon6 = new ImageIcon(ImageIO.read(new File("src/resource/number6.png")));
			// 创建一个按钮
			JButton button6 = new JButton();
			button6.setPreferredSize(dbutton);
			button6.setIcon(icon6);
			button6.setBorderPainted(false); // 不绘制按钮边框
			button6.setContentAreaFilled(false); // 不填充按钮内容区域背景
			panel2.add(button6); // 将按钮添加到面板中
			// 加载自定义图片
			ImageIcon icon7 = new ImageIcon(ImageIO.read(new File("src/resource/number7.png")));
			// 创建一个按钮
			JButton button7 = new JButton();
			button7.setPreferredSize(dbutton);
			button7.setIcon(icon7);
			button7.setBorderPainted(false); // 不绘制按钮边框
			button7.setContentAreaFilled(false); // 不填充按钮内容区域背景
			panel2.add(button7); // 将按钮添加到面板中
			// 加载自定义图片
			ImageIcon icon8 = new ImageIcon(ImageIO.read(new File("src/resource/number8.png")));
			// 创建一个按钮
			JButton button8 = new JButton();
			button8.setPreferredSize(dbutton);
			button8.setIcon(icon8);
			button8.setBorderPainted(false); // 不绘制按钮边框
			button8.setContentAreaFilled(false); // 不填充按钮内容区域背景
			panel2.add(button8); // 将按钮添加到面板中
			// 加载自定义图片
			ImageIcon icon9 = new ImageIcon(ImageIO.read(new File("src/resource/number9.png")));
			// 创建一个按钮
			JButton button9 = new JButton();
			button9.setPreferredSize(dbutton);
			button9.setIcon(icon9);
			button9.setBorderPainted(false); // 不绘制按钮边框
			button9.setContentAreaFilled(false); // 不填充按钮内容区域背景
			panel2.add(button9); // 将按钮添加到面板中
			// 加载自定义图片
			ImageIcon icon0 = new ImageIcon(ImageIO.read(new File("src/resource/number0.png")));
			// 创建一个按钮
			JButton button0 = new JButton();
			button0.setPreferredSize(dbutton);
			button0.setIcon(icon0);
			button0.setBorderPainted(false); // 不绘制按钮边框
			button0.setContentAreaFilled(false); // 不填充按钮内容区域背景
			panel2.add(button0); // 将按钮添加到面板中
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(frame, "Error loading image: " + e.getMessage());
		}

		JPanel panel3 = new JPanel();
		panel3.setBackground(Color.WHITE);  
		panel3.setLayout(layout);
		// 创建一个按钮
		JButton button11 = new JButton("<-");
		panel3.add(button11); // 将按钮添加到面板中
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

		panel.add(panel2);
		panel.add(panel3);
		// 显示窗口
		frame.setVisible(true);
	}

}
