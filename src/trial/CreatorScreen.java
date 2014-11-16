package trial;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;


public class CreatorScreen extends JPanel

{
	/*static void addIt(JTabbedPane tabbedPane, String text) {
    JLabel label = new JLabel(text);
    JButton button = new JButton(text);
    JPanel panel = new JPanel();
    //panel.add(label);
    //panel.add(button);
    tabbedPane.addTab(text, panel);
   // tabbedPane.setTabComponentAt(tabbedPane.getTabCount() - 1, new JTextField(text));
  }
*/
/*takes in fieldname, already existing tabbedpane, and already existing arraylist*/
	
 	static void addBoolPanel(String fname, JTabbedPane tabbedPane, ArrayList aaa,ArrayList bbb)
 	{
 		JTextField ttext = new JTextField("whatyouwanttosayiftrue");
 		aaa.add(ttext);
 		JTextField ftext = new JTextField("whatyouwanttosayiffalse");
 		bbb.add(ftext);
 		JPanel panel = new JPanel();
 		panel.add(ttext);
 		panel.add(ftext);
 		tabbedPane.addTab(fname,panel);
 	}
 	
 /*	static void addStrPanel(String fname, JTabbedPane tabbedPane, ArrayList aaa, ArrayList bbb)
 	{
 		JTextField otext = new JTextField("whatyouwanttosaywithinfo");
 		aaa.add(otext);
 		bbb.add(otext);
 		JPanel panel = new JPanel();
 		panel.add(otext);
 		tabbedPane.addTab(fname,panel);
 	}*/
 	static void addStrPanel(String fname, JTabbedPane tabbedPane, ArrayList aaa, ArrayList bbb)
 	{
 		JTextField otext = new JTextField("whatyouwanttosaywithinfo");
 		aaa.add(otext);
 		bbb.add(otext);
 		//JPanel panel = new JPanel();
 		//panel.add(otext);
 		//tabbedPane.addTab(fname,panel);
 	}
  public static void createAndShowCreator(String filename) {
    JFrame f = new JFrame("Creator Screen");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JTabbedPane tabbedPane = new JTabbedPane();
    /*addIt(tabbedPane, "Tab One");
    addIt(tabbedPane, "Tab Two");
    addIt(tabbedPane, "Tab Three");
    addIt(tabbedPane, "Tab Four");
    addIt(tabbedPane, "Tab Five");*/
    
    /*use filename to get two arrays */
    
    ArrayList <JTextField> trues = new ArrayList();
    ArrayList <JTextField> falses = new ArrayList();
    
    ExcelReader.readExcelSheet(filename);
    
    for(int i = 0; i < ExcelReader.property.size();i++)
    {
    	if (ExcelReader.property.get(i).equals("B"))
    	{
    		addBoolPanel(ExcelReader.fieldNames.get(i),tabbedPane,trues,falses);
    	}
    	else
    	{
    		addStrPanel(ExcelReader.fieldNames.get(i),tabbedPane,trues,falses);
    	}
    }
    
    f.add(tabbedPane, BorderLayout.CENTER);
    JButton button = new JButton("next");
    f.add(button,BorderLayout.SOUTH);
    button.addActionListener(new ActionListener() 
    {
		public void actionPerformed(ActionEvent e) 
		{
			HashMap <Integer,String[]> dictionary = new HashMap <Integer,String[]>();
			for(int i = 0; i < ExcelReader.property.size();i++)
			{
				if (ExcelReader.property.get(i).equals("B"))
				{
					String [] pair = {trues.get(i).getText(),falses.get(i).getText()};
					dictionary.put(i,pair);
				}
			}
			//Positioner.createAndShowPositioner();
//			String testMessage = "Hi, My name is -0-. My email is -1-. -2-. You owe -3- dollars. -4-. "
//					+ "Your favorite team is -5-. -6-.";
			//hide frame
			//call MessageCenter
			//set String msg = MessageCenter()
			//call MessageGenerator(msg,dictionary)
			f.setVisible(false);
			MessageCenter.createAndShowMessageCenter(dictionary);
		}
	});
    f.setSize(300, 200);
    f.setVisible(true);  	
  }
  
	
	
}
