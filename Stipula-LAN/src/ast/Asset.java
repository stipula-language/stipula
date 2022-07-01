package ast;

public class Asset extends Entity{

	String name;
	float value=0;
	Type type = new AssetType();

	public Asset(String n) {
		name = n;
		value = 0;
	}

	public Asset(String n, int v) {
		name = n;
		value = v;
	}

	public void setValue(float d) {
		value = d;

	}

	public float getValue() {
		return value;
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
