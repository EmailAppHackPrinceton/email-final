package trial;

public class Field {
	boolean isString = false;
	boolean boolField;
	String stringField;
	public Field(boolean isString) {
		this.isString = isString;
	}
	
	public boolean isString() {
		return isString;
	}
	
	public void setString(String string) {
		stringField = string;
	}
	
	public String getString() {
		return stringField;
	}
	
	public void setBool(Boolean bool) {
		boolField = bool;
	}
	
	public boolean getBool() {
		return boolField;
	}
}
