package trial;

public class Part {
	boolean isUserInput;
	String message;
	boolean userStringOrBool;
	int indexUserInput;
	String[] boolValues = new String[2];
	
	public Part(boolean isField) {
		this.isUserInput = isField;
	}

	public boolean isUserInput() {
		return isUserInput;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isUserStringOrBool() {
		return userStringOrBool;
	}

	public void setUserStringOrBool(boolean userStringOrBool) {
		this.userStringOrBool = userStringOrBool;
	}

	public int getIndexUserInput() {
		return indexUserInput;
	}

	public void setIndexUserInput(int indexUserInput) {
		this.indexUserInput = indexUserInput;
	}

	public String[] getBoolValues() {
		return boolValues;
	}

	public void setBoolValues(String[] boolValues) {
		this.boolValues = boolValues;
	}
}
