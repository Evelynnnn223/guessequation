package guessequation.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SetView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4083200629505710917L;
	private ArrayList<JButton> setbut1 = new ArrayList<JButton>();
	private ArrayList<Integer> setbut2 = new ArrayList<Integer>();
	private Action ac;
	public SetView(int num,Action ac) {
		this.ac = ac;
		init(num);
	}
	public void setAc(Action ac) {
		this.ac = ac;
	}
	public ArrayList<JButton> getSetbut1() {
		return setbut1;
	}

	public ArrayList<Integer> getSetbut2() {
		return setbut2;
	}

	public void init(int column) {
		this.setBackground(Color.WHITE);
		// 创建 FlowLayout 实例并设置水平和垂直间距
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 5, 0);
        JPanel tab2Panel = new JPanel();  
        tab2Panel.setBackground(Color.WHITE);
        JPanel panel_2= new JPanel();
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		panel_2.setBackground(Color.WHITE);
		JPanel setpanel= new JPanel();
		setpanel.setBackground(Color.WHITE);
		setpanel.setLayout(layout);
		ImageIcon setinfo1Icon = new ImageIcon("src/resource/setinfo1.png"); 
		JLabel setinfo1label1 = new JLabel(setinfo1Icon);
		//setinfo1label1.setPreferredSize(new Dimension(372, 50));
		setpanel.add(setinfo1label1);
		panel_2.add(setpanel);
		JPanel setnumpanel= new JPanel();
		setnumpanel.setLayout(layout);
		setnumpanel.setBackground(Color.WHITE);
		for(int i=5;i<13;i++) {
			ImageIcon icon1;
			if(i == column) {
				icon1 = new ImageIcon("src/resource/setgreen"+i+".png");
			}else {
				icon1 = new ImageIcon("src/resource/set"+i+".png");
			}
			JButton button1 = new JButton();
			button1.setPreferredSize(new Dimension(34, 32));
			button1.setIcon(icon1);
			button1.setBorderPainted(false); // 不绘制按钮边框
			button1.setContentAreaFilled(false); // 不填充按钮内容区域背景
			setnumpanel.add(button1); // 将按钮添加到面板中
			setbut1.add(button1);
			Command cgroove = new SetGrooveCommand(i, button1, ac);
			ButtonListener bcgroove = new ButtonListener(cgroove);
			// 为按钮添加点击事件监听器
			button1.addActionListener(bcgroove);
		}
		panel_2.add(setnumpanel);
		JPanel setpanel2= new JPanel();
		setpanel2.setBackground(Color.WHITE);
		setpanel2.setLayout(layout);
		ImageIcon setinfo2Icon = new ImageIcon("src/resource/setinfo2.png"); 
		JLabel setinfo1label2 = new JLabel(setinfo2Icon);
		//setinfo1label1.setPreferredSize(new Dimension(372, 50));
		setpanel2.add(setinfo1label2);
		panel_2.add(setpanel2);
		JPanel setnumpanel2= new JPanel();
		setnumpanel2.setLayout(layout);
		setnumpanel2.setBackground(Color.WHITE);
		for(int i=13;i<17;i++) {
			ImageIcon icon1 = new ImageIcon("src/resource/setgreen"+i+".png");
			JButton button1 = new JButton();
			button1.setPreferredSize(new Dimension(34, 32));
			button1.setIcon(icon1);
			button1.setBorderPainted(false); // 不绘制按钮边框
			button1.setContentAreaFilled(false); // 不填充按钮内容区域背景
			setnumpanel2.add(button1); // 将按钮添加到面板中
			setbut2.add(1);
			Command arithmentic = new SetArithmeticCommand(i, button1, ac);
			ButtonListener barithmentic = new ButtonListener(arithmentic);
			// 为按钮添加点击事件监听器
			button1.addActionListener(barithmentic);
		}
		panel_2.add(setnumpanel2);
		tab2Panel.add(panel_2);
		this.add(tab2Panel);
	}
		
}
