package guessequation.view;

import javax.swing.JButton;

//SetArithmetic command
public class SetArithmeticCommand extends Command {
	private int c;
	private JButton button1;
	
	public SetArithmeticCommand(int c, JButton button1,Action ac) {
		super();
		this.c = c;
		this.button1 = button1;
		this.ac = ac;
	}

	@Override
	public void execute() {
		// TODO �Զ����ɵķ������
		ac.arithmetic(c, button1);
	}

}
