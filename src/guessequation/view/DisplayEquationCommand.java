package guessequation.view;

//DisplayEquation command
public class DisplayEquationCommand extends Command {

	public DisplayEquationCommand(Action ac) {
		// TODO �Զ����ɵĹ��캯�����
		this.ac = ac;
	}

	@Override
	public void execute() {
		// TODO �Զ����ɵķ������
		ac.displayEquation();
	}

}
