package ast;

public class Field extends Entity{

	String name;
	float value = 0;
	String valueStr = null;
	boolean valueBool ;
	Type type = null;

	public Field(String n) {
		name = n;
		value = 0;
	}

	public Field(String n, float v) {
		name = n;
		value = v;
	}

	public void setValue(float val) {
		value = val;
	}

	public void setValueBool(boolean val) {
		valueBool = val;
	}
	
	public void setType(Type t) {
		type = t;
	}
	
	public Type getType() {
		return type;
	}
	
	public void setValueStr(String s)
	{
		valueStr = s;
	}
	public float getValue() {
		return value;
	}

	public String getValueStr() {
		return valueStr;
	}
	
	public String getId() {
		return name;
	}

	public void printField() {
		if(type!=null && (type instanceof StringType)) {
			System.out.println(type.getTypeName()+ " " + name + ": " + valueStr);
		}
		else if(type instanceof TimeType && valueStr!=null) {
			System.out.println(type.getTypeName()+ " " + name + ": " + valueStr);
		}
		else if(type!=null && type instanceof BooleanType) {
			System.out.println(type.getTypeName()+ " " + name + ": " + valueBool);
		}
		else if(value!=0){
			System.out.println(type.getTypeName()+ " " + name + ": " + value);
		}
		else if(type!=null) {
			System.out.println(type.getTypeName()+ " " + name);
		}
		else {
			System.out.println(name);
		}
	}
}
