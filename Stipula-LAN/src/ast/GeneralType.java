package ast;

public class GeneralType extends Type{
	
	public GeneralType() {
		type = "Type";
	}
	
	public GeneralType(int n){
		type = "Type"+String.valueOf(n);
	}
}
