package ast;

public class Asset extends Entity{

	String name;
	Resource value;
	Type type = new AssetType();

	public Asset(String n) {
		name = n;
		value = new Resource(0);
	}

	public Asset(String n, int v) {
		name = n;
		value = new Resource(v);
	}

	public void setCalcValue(float d) {
		value.add(d) ;
		value.move(d) ;
	}
	
	public void setValue(float d) {
		value.add(d) ;
	}

	public float getValue() {
		return value.getAmount() ;
	}

	public Type getType() {
		return type;
	}
	
	public String getId() {
		return name;
	}

	public void printAsset() {

		System.out.println("Asset " + name + ": " + value.getAmount());

	}

}
