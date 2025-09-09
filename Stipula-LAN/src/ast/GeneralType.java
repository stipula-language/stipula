package ast;

public class GeneralType extends Type{
	
	int val = 0;
	
	public GeneralType() {
		type = "Type";
	}
	
	public GeneralType(int n){
		val = n;
		type = "Type"+String.valueOf(n);
	}
	
	public int getNumberType() {
		return val;
	}
	
}
