package trial;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelReader {
	static ArrayList<ArrayList<Field>> people;
	static ArrayList<String> fieldNames;
	static  ArrayList<String> property;
	
    public static void readExcelSheet(String fileName) {
        try {
        	File f = new File(fileName);
        	Workbook w = Workbook.getWorkbook(f);
        	Sheet sheet = w.getSheet(0);
        	int rows = sheet.getRows();
        	int columns = sheet.getColumns();
        	people = new ArrayList<ArrayList<Field>>();
        	
        	//Generating the arraylist of field names
        	fieldNames = new ArrayList<String>();
            for(int j = 0; j < columns; j++) {
            	Cell cell = sheet.getCell(j,0);
            	String contents = cell.getContents().toString();
            	fieldNames.add(contents);
            }

            //Generating the arraylist of field types
            property = new ArrayList<String>();
            for(int j = 0; j < columns; j++) {
            	Cell cell = sheet.getCell(j,1);
            	String contents = cell.getContents().toString();
            	property.add(contents.toString());
            }

            //Generating the arraylist of people, one row per person
        	for(int i = 2; i < rows; i++) {	
        		ArrayList<Field> person = new ArrayList<Field>();
                
                //Setting the field of the people to the contents from every other cell in the same row 
                for(int j = 0; j < columns; j++) {
                  	//Stores whether the current field is a string or boolean 
                	boolean isString = true;
                    if(property.get(j).equals("B")) {
                   		isString = false;
                   	}
                   	Field tempField = new Field(isString);
                   	Cell cellField = sheet.getCell(j,i);
                   	String contentField = cellField.getContents().toString();
                   	if(tempField.isString() == true) {
                   		tempField.setString(contentField);
                   	}
                   	else {
                   		boolean boolValue = false;
                   		if(contentField.toString().equals("true")) {
                   			boolValue = true;
                   		}
                   		tempField.setBool(boolValue);
                    }
                    person.add(tempField);
        		}
                people.add(person);
        	}
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch(BiffException bfe) {
        	bfe.printStackTrace();
        }
    }

}