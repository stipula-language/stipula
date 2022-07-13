package ast;

public class Asset extends Entity{

	String name;
	float rawvalue;
	Type type = new AssetType();

	public Asset() {
		name = "";
		rawvalue = 0;
	}

	public Asset(String n) {
		name = n;
		rawvalue = 0;
	}

	public Asset(String n, int v) {
		name = n;
		rawvalue = v;
	}

	public Asset(float v) {
		name = "";
		rawvalue = v;
	}

	public void setCalcValue(float d) {
		rawvalue = d ;
	}

	public void increase(float val) {
		rawvalue = rawvalue + val;
	}

	public void move(float val, Asset d) {
		if(val<=rawvalue){
			rawvalue = rawvalue - val;
			d.increase(val);
		}
		else {
			throw new AssetException("Erroneous withdraw") ;
		}
	}

	public void withdraw(Party d, float val) {
		if(val<=rawvalue){
			rawvalue = rawvalue - val;
			d.setValueAsset(val);
		}
		else {
			throw new AssetException("Erroneous withdraw") ;
		}
	}

	public float getValue() {
		return rawvalue ;
	}

	public Type getType() {
		return type;
	}

	public String getId() {
		return name;
	}

	public void printAsset() {

		System.out.println("Asset " + name + ": " + rawvalue);

	}

}
