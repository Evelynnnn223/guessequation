package guessequation.view;

//GameEnter command
public class GameEnterCommand extends Command {
	public GameEnterCommand(Action ac) {
		super();
		this.ac = ac;
	}
	@Override
	public void execute() {
		// TODO �Զ����ɵķ������
		ac.enter();
	}

}
