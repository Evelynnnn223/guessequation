package guessequation.view;

//DisplayError command
public class DisplayErrorCommand extends Command {

	public DisplayErrorCommand(Action ac) {
		super();
		// TODO �Զ����ɵĹ��캯�����
		this.ac = ac;
	}

	@Override
	public void execute() {
		// TODO �Զ����ɵķ������
		ac.displayError();
	}

}
