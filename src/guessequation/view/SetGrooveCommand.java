package guessequation.view;

import javax.swing.JButton;

//SetGroove command 
public class SetGrooveCommand extends Command {

	private int num;//Serial Number
	private JButton button1;//Current button
	
	public SetGrooveCommand(int num, JButton button1,Action ac) {
		super();
		this.num = num;
		this.button1 = button1;
		this.ac = ac;
	}

	@Override
	public void execute() {
		// TODO 自动生成的方法存根
		ac.groove(num, button1);
	}

}
