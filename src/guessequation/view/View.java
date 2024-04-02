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
		// TODO �Զ����ɵķ������
		// ����һ��JFrame����
		JFrame frame = new JFrame("Button Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���ô��ڹر�ʱ�Ĳ���
		frame.setSize(800, 600); // ���ô��ڴ�С
		// ���� FlowLayout ʵ��������ˮƽ�ʹ�ֱ���  
        FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 5, 0);
        JPanel panelts = new JPanel();
		panelts.setBackground(Color.WHITE); 
		panelts.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		// ����һ��JPanel��壬���ڷ��ð�ť
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);  
		frame.add(panel); // �������ӵ�������
		panel.add(panelts);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
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
				for (int i = 0; i < 7; i++) {
					// ����һ��JLabel����ʾͼƬ
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
			// �����Զ���ͼƬ
			ImageIcon icon1 = new ImageIcon(ImageIO.read(new File("src/resource/number1.png")));
			// ����һ����ť
			JButton button1 = new JButton();
			button1.setPreferredSize(dbutton);
			button1.setIcon(icon1);
			button1.setBorderPainted(false); // �����ư�ť�߿�
			button1.setContentAreaFilled(false); // ����䰴ť�������򱳾�
			panel2.add(button1); // ����ť��ӵ������
			// Ϊ��ť��ӵ���¼�������
			button1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// �ڵ����ťʱ��ʾһ���ַ�
					JOptionPane.showMessageDialog(frame, "Hello, World!");
				}
			});
			// �����Զ���ͼƬ
			ImageIcon icon2 = new ImageIcon(ImageIO.read(new File("src/resource/number2.png")));
			// ����һ����ť
			JButton button2 = new JButton();
			button2.setPreferredSize(dbutton);
			button2.setIcon(icon2);
			button2.setBorderPainted(false); // �����ư�ť�߿�
			button2.setContentAreaFilled(false); // ����䰴ť�������򱳾�
			panel2.add(button2); // ����ť��ӵ������
			// �����Զ���ͼƬ
			ImageIcon icon3 = new ImageIcon(ImageIO.read(new File("src/resource/number3.png")));
			// ����һ����ť
			JButton button3 = new JButton();
			button3.setPreferredSize(dbutton);
			button3.setIcon(icon3);
			button3.setBorderPainted(false); // �����ư�ť�߿�
			button3.setContentAreaFilled(false); // ����䰴ť�������򱳾�
			panel2.add(button3); // ����ť��ӵ������
			// �����Զ���ͼƬ
			ImageIcon icon4 = new ImageIcon(ImageIO.read(new File("src/resource/number4.png")));
			// ����һ����ť
			JButton button4 = new JButton();
			button4.setPreferredSize(dbutton);
			button4.setIcon(icon4);
			button4.setBorderPainted(false); // �����ư�ť�߿�
			button4.setContentAreaFilled(false); // ����䰴ť�������򱳾�
			panel2.add(button4); // ����ť��ӵ������
			// �����Զ���ͼƬ
			ImageIcon icon5 = new ImageIcon(ImageIO.read(new File("src/resource/number5.png")));
			// ����һ����ť
			JButton button5 = new JButton();
			button5.setPreferredSize(dbutton);
			button5.setIcon(icon5);
			button5.setBorderPainted(false); // �����ư�ť�߿�
			button5.setContentAreaFilled(false); // ����䰴ť�������򱳾�
			panel2.add(button5); // ����ť��ӵ������
			// �����Զ���ͼƬ
			ImageIcon icon6 = new ImageIcon(ImageIO.read(new File("src/resource/number6.png")));
			// ����һ����ť
			JButton button6 = new JButton();
			button6.setPreferredSize(dbutton);
			button6.setIcon(icon6);
			button6.setBorderPainted(false); // �����ư�ť�߿�
			button6.setContentAreaFilled(false); // ����䰴ť�������򱳾�
			panel2.add(button6); // ����ť��ӵ������
			// �����Զ���ͼƬ
			ImageIcon icon7 = new ImageIcon(ImageIO.read(new File("src/resource/number7.png")));
			// ����һ����ť
			JButton button7 = new JButton();
			button7.setPreferredSize(dbutton);
			button7.setIcon(icon7);
			button7.setBorderPainted(false); // �����ư�ť�߿�
			button7.setContentAreaFilled(false); // ����䰴ť�������򱳾�
			panel2.add(button7); // ����ť��ӵ������
			// �����Զ���ͼƬ
			ImageIcon icon8 = new ImageIcon(ImageIO.read(new File("src/resource/number8.png")));
			// ����һ����ť
			JButton button8 = new JButton();
			button8.setPreferredSize(dbutton);
			button8.setIcon(icon8);
			button8.setBorderPainted(false); // �����ư�ť�߿�
			button8.setContentAreaFilled(false); // ����䰴ť�������򱳾�
			panel2.add(button8); // ����ť��ӵ������
			// �����Զ���ͼƬ
			ImageIcon icon9 = new ImageIcon(ImageIO.read(new File("src/resource/number9.png")));
			// ����һ����ť
			JButton button9 = new JButton();
			button9.setPreferredSize(dbutton);
			button9.setIcon(icon9);
			button9.setBorderPainted(false); // �����ư�ť�߿�
			button9.setContentAreaFilled(false); // ����䰴ť�������򱳾�
			panel2.add(button9); // ����ť��ӵ������
			// �����Զ���ͼƬ
			ImageIcon icon0 = new ImageIcon(ImageIO.read(new File("src/resource/number0.png")));
			// ����һ����ť
			JButton button0 = new JButton();
			button0.setPreferredSize(dbutton);
			button0.setIcon(icon0);
			button0.setBorderPainted(false); // �����ư�ť�߿�
			button0.setContentAreaFilled(false); // ����䰴ť�������򱳾�
			panel2.add(button0); // ����ť��ӵ������
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(frame, "Error loading image: " + e.getMessage());
		}

		JPanel panel3 = new JPanel();
		panel3.setBackground(Color.WHITE);  
		panel3.setLayout(layout);
		// ����һ����ť
		JButton button11 = new JButton("<-");
		panel3.add(button11); // ����ť��ӵ������
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

		panel.add(panel2);
		panel.add(panel3);
		// ��ʾ����
		frame.setVisible(true);
	}

}
