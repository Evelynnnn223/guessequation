package guessequation.view;

public class RestartCommand extends Command {

	public RestartCommand(Action ac) {
		// TODO �Զ����ɵĹ��캯�����
		this.ac = ac;
	}

	@Override
	public void execute() {
		// TODO �Զ����ɵķ������
		ac.restart();
	}

}
