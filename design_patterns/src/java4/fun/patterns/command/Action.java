package java4.fun.patterns.command;

public class Action {
	
	public void onStoreData(Object action){
		Command command = (Command) action;
		command.execute();
	}
	
}
