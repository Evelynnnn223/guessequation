package guessequation.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {

	private Command command;
	public ButtonListener(Command command) {
		this.command = command;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
		command.execute();
	}

}
