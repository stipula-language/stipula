package ast;

public class Disputer extends Entity{

	String name;
	String userId ;
	
	public Disputer(String n) {
		name = n;
	}
	
	public void setUserId(String s) {
		userId = s;
	}
	
	public String getUserId() {
		return userId;
	}
	
	
	public String getId() {
		return name;
	}
	
	public void printDisputer() {
		System.out.println(name);
	}
}
