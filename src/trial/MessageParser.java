package trial;
import java.util.HashMap;


public class MessageParser {
	
	public static Part[] MessageParser(String inputMessage, HashMap<Integer,String[]> dictionary) {
		String[] messageBlocks = inputMessage.split("-");
		Part[] parts = new Part[messageBlocks.length];
		
		for(int i = 0; i < messageBlocks.length; i++) {
			//For the even parts, the part will consist of the message passed in 
			if(i%2 == 0) {
				Part part = new Part(false);
				part.setMessage(messageBlocks[i]);
				parts[i] = part;
			}
			//For odd parts, the part will consist of the user input
			else {
				Part part = new Part(true);
			    int fieldNumber = Integer.parseInt(messageBlocks[i]);
			    //If the fieldNumber is a boolean, then create part for boolean 
			    if(dictionary.containsKey(fieldNumber)) {
			    	part.setUserStringOrBool(false);
			    	part.setIndexUserInput(fieldNumber);
			    	part.setBoolValues(dictionary.get(fieldNumber));
			    }
			    //Current field is a string
			    else {
			    	part.setUserStringOrBool(true);
			    	part.setIndexUserInput(fieldNumber);
			    }
			    parts[i] = part;
			}
		}
		return parts;
	}
}
