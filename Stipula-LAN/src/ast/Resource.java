package ast;

public class Resource {
	
	float amount = 0;

	public Resource(float h){
		amount = h;
	}

	public void add(float x) {
		amount = amount + x;
	}
	
	public void move(float x) {
		if(x<=amount) {
			amount = amount - x;
		}
	}
	
	public float getAmount() {
		return amount;
	}
}
