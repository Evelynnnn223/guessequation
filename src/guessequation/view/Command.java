package guessequation.view;

//Command abstraction class
public abstract class Command {
	
	protected Action ac;//Performer Object
	
	public abstract void execute();//Execute Command
}
