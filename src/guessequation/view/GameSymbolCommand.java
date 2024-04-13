package guessequation.view;

import javax.swing.ImageIcon;

//GameSymbol command
public class GameSymbolCommand extends Command {

	private ImageIcon icon;//Symbol image
	private char str;//Number or operator
	
	public GameSymbolCommand(ImageIcon icon, char str,Action ac) {
		super();
		this.icon = icon;
		this.str = str;
		this.ac = ac;
	}

	@Override
	public void execute() {
		// TODO 自动生成的方法存根
		ac.symbol(icon, str);
	}

}
