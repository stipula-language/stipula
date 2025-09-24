package ast;

public class Party extends Entity{

	String name;
	String userId = null;
	Asset valueAsset = new Asset();
	float value = 0;
	String valueStr = "";

	public Party(String n) {
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
		valueAsset.increase(v);
	}
	
	public void setValueAssetCalc(float v) {
		valueAsset.setCalcValue(v);
	}
	
	public void moveAsset(Party d, float val) {
		valueAsset.withdraw(d,val);
	}

	public void setValueStr(String s) {
		valueStr = s ;
	}

	public float getValue() {
		return value;
	}

	public float getValueAsset() {
		return valueAsset.getValue() ;
	}

	public String getValueStr() {
		return valueStr  ;
	}

	public String getId() {
		return name;
	}
	
	public Asset getAsset() {
		return valueAsset;
	}

	public void printParty() {
		if(value == 0 && valueAsset.getValue() == 0 && valueStr.equals("")) {
			System.out.println(name);
		}
		else if(value!=0  && valueAsset.getValue() == 0 && valueStr.equals("")) {
			System.out.println(name +":");
			System.out.print('\t');
			System.out.print('\t');
			System.out.println("value "+value);
		}
		else if(value!=0 && valueAsset.getValue()!=0 && valueStr.equals("")) {
			System.out.println(name +":");
			System.out.print('\t');
			System.out.print('\t');
			System.out.println("value "+value);
			System.out.print('\t');
			System.out.print('\t');
			System.out.println("asset value "+valueAsset.getValue());
		}
		else if(value!=0 && valueAsset.getValue()!=0 && !valueStr.equals("")) {
			System.out.println(name +":");
			System.out.print('\t');
			System.out.print('\t');
			System.out.println("value "+value);
			System.out.print('\t');
			System.out.print('\t');
			System.out.println("asset value "+valueAsset.getValue());
			System.out.print('\t');
			System.out.print('\t');
			System.out.println("string value "+valueStr);
		}
		else if(value==0 && valueAsset.getValue()!=0 && !valueStr.equals("")) {
			System.out.println(name +":");
			System.out.print('\t');
			System.out.print('\t');
			System.out.println("asset value "+valueAsset.getValue());
			System.out.print('\t');
			System.out.print('\t');
			System.out.println("string value "+valueStr);
		}
		else if(value==0 && valueAsset.getValue()==0 && !valueStr.equals("")) {
			System.out.println(name +":");
			System.out.print('\t');
			System.out.print('\t');
			System.out.println("string value "+valueStr);
		}
		else if(value!=0 && valueAsset.getValue()==0 && !valueStr.equals("")) {
			System.out.println(name +":");
			System.out.print('\t');
			System.out.print('\t');
			System.out.println("value "+value);
			System.out.print('\t');
			System.out.print('\t');
			System.out.println("string value "+valueStr);
		}
		else if(value==0 && valueAsset.getValue()!=0 && valueStr.equals("")) {
			System.out.println(name +":");
			System.out.print('\t');
			System.out.print('\t');
			System.out.println("asset value "+valueAsset.getValue());
		}
	}
}
