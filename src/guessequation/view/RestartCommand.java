package guessequation.view;

public class RestartCommand extends Command {

	public RestartCommand(Action ac) {
		// TODO 自动生成的构造函数存根
		this.ac = ac;
	}

	@Override
	public void execute() {
		// TODO 自动生成的方法存根
		ac.restart();
	}

}
