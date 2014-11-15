package trial;
import java.util.ArrayList;
import java.util.HashMap;


public class MessageGenerator {
	
	static public void MessageGenerator(String testMessage, HashMap<Integer,String[]> dictionary) {
		ExcelReader.readExcelSheet("");
		Part[] parts = MessageParser.MessageParser(testMessage, dictionary);
		
		for(int i = 0; i < ExcelReader.people.size(); i++) {
			ArrayList<Field> person = ExcelReader.people.get(i);
			String message = "";
			for(int j = 0; j < parts.length; j++) {
				Part part = parts[j];
				
				//If the part is not from the user, then use the message
				if(part.isUserInput() == false) {
					message = message.concat(part.getMessage());
				}
				
				//If the part is from the user, then use the input from the person
				else {
					int index = part.getIndexUserInput();
					//Current part is a boolean
					if(part.isUserStringOrBool() == false) {
						if(person.get(index).getBool() == true) {
							message = message.concat(part.getBoolValues()[0]);
						}
						else {
							message = message.concat(part.getBoolValues()[1]);
						}					
					}
					//Current part is a string
					else {
						message = message.concat(person.get(index).getString());
					}
				}
			}
			System.out.println(message);
		}
	}

}
