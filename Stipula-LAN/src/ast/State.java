package ast;

public class State{

	String name;
	
	public State(String n) {
		name = n;
	}
	
	public String getId() {
		return name;
	}
	
	public void printState() {
		System.out.println(name);
	}
	
}