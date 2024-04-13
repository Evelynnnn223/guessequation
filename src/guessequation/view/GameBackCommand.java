package guessequation.view;

import javax.swing.ImageIcon;

//GameBack command
public class GameBackCommand extends Command {

	private ImageIcon icon;
	
	public GameBackCommand(ImageIcon icon,Action ac) {
		super();
		this.icon = icon;
		this.ac = ac;
	}

	@Override
	public void execute() {
		// TODO 自动生成的方法存根
		ac.backward(icon);
	}

}
