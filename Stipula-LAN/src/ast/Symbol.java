package ast;

class Symbol {
	private String name, type, value;

	public Symbol(String inputName, String inputType, String inputValue) {
		this.name = inputName;
		this.type = inputType;
		this.value =inputValue;
	}

	public String getName() {
		return this.name;
	}

	public String getType() {
		return this.type;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String inputValue) {
		this.value = inputValue;
	}

}