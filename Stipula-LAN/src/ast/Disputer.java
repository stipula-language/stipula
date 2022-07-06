package ast;

public class Disputer extends Entity{

	String name;
	String userId ;
	Resource valueAsset = new Resource(0);
	float value = 0;
	String valueStr = "";

	public Disputer(String n) {
		name = n;
	}

	public void setUserId(String s) {
		userId = s;
	}

	public String getUserId() {
		return userId;
	}
	public void setValue(float v) {
		value = v;
	}

	public void setValueAsset(float v) {
		valueAsset.add(v);
	}
	

	public void setValueStr(String s) {
		valueStr = s ;
	}

	public float getValue() {
		return value;
	}

	public float getValueAsset() {
		return valueAsset.getAmount() ;
	}

	public String getValueStr() {
		return valueStr  ;
	}

	public String getId() {
		return name;
	}

	public void printDisputer() {
		if(value == 0 && valueAsset.getAmount() == 0 && valueStr.equals("")) {
			System.out.println(name);
		}
		else if(value!=0  && valueAsset.getAmount() == 0 && valueStr.equals("")) {
			System.out.println(name +":");
			System.out.print('\t');
			System.out.print('\t');
			System.out.println("value "+value);
		}
		else if(value!=0 && valueAsset.getAmount()!=0 && valueStr.equals("")) {
			System.out.println(name +":");
			System.out.print('\t');
			System.out.print('\t');
			System.out.println("value "+value);
			System.out.print('\t');
			System.out.print('\t');
			System.out.println("asset value "+valueAsset);
		}
		else if(value!=0 && valueAsset.getAmount()!=0 && !valueStr.equals("")) {
			System.out.println(name +":");
			System.out.print('\t');
			System.out.print('\t');
			System.out.println("value "+value);
			System.out.print('\t');
			System.out.print('\t');
			System.out.println("asset value "+valueAsset);
			System.out.print('\t');
			System.out.print('\t');
			System.out.println("string value "+valueStr);
		}
		else if(value==0 && valueAsset.getAmount()!=0 && !valueStr.equals("")) {
			System.out.println(name +":");
			System.out.print('\t');
			System.out.print('\t');
			System.out.println("asset value "+valueAsset);
			System.out.print('\t');
			System.out.print('\t');
			System.out.println("string value "+valueStr);
		}
		else if(value==0 && valueAsset.getAmount()==0 && !valueStr.equals("")) {
			System.out.println(name +":");
			System.out.print('\t');
			System.out.print('\t');
			System.out.println("string value "+valueStr);
		}
		else if(value!=0 && valueAsset.getAmount()==0 && !valueStr.equals("")) {
			System.out.println(name +":");
			System.out.print('\t');
			System.out.print('\t');
			System.out.println("value "+value);
			System.out.print('\t');
			System.out.print('\t');
			System.out.println("string value "+valueStr);
		}
		else if(value==0 && valueAsset.getAmount()!=0 && valueStr.equals("")) {
			System.out.println(name +":");
			System.out.print('\t');
			System.out.print('\t');
			System.out.println("asset value "+valueAsset);
		}
	}
}
