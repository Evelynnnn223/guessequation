package guessequation.view;

//DisplayError command
public class DisplayErrorCommand extends Command {

	public DisplayErrorCommand(Action ac) {
		super();
		// TODO 自动生成的构造函数存根
		this.ac = ac;
	}

	@Override
	public void execute() {
		// TODO 自动生成的方法存根
		ac.displayError();
	}

}
