package guessequation.view;

public class RandomEquationCommand extends Command {

	public RandomEquationCommand(Action ac) {
		// TODO �Զ����ɵĹ��캯�����
		this.ac = ac;
	}

	@Override
	public void execute() {
		// TODO �Զ����ɵķ������
		ac.randomEquation();
	}

}
