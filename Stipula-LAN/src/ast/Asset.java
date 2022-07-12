package ast;

public class Asset extends Entity{

	String name;
	float value;
	Type type = new AssetType();

	public Asset() {
		name = "";
		value = 0;
	}

	public Asset(String n) {
		name = n;
		value = 0;
	}

	public Asset(String n, int v) {
		name = n;
		value = v;
	}

	public Asset(float v) {
		name = "";
		value = v;
	}

	public void setCalcValue(float d) {
		value = d ;
	}

	public void increase(float val) {
		value = value + val;
	}

	public void move(float val, Asset d) {
		if(val<=value){
			value = value - val;
		}
		else {
			throw new IllegalArgumentException("Cannot withdraw more assets than owned.");
		}
		d.increase(val);
	}

	public void withdraw(Party d, float val) {
		if(val<=value){
			value = value - val;
		}
		else {
			throw new IllegalArgumentException("Cannot withdraw more assets than owned.");
		}
		d.setValueAsset(val);
	}

	public float getValue() {
		return value ;
	}

	public Type getType() {
		return type;
	}

	public String getId() {
		return name;
	}

	public void printAsset() {

		System.out.println("Asset " + name + ": " + value);

	}

}
