package trial;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class MessageCenter extends JPanel {
	
	static String text;
	static HashMap<Integer,String[]> d;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public MessageCenter(JFrame f){
		final JTextArea msg = new JTextArea("Enter Message Here");
		msg.setBounds(20,20,500,300);
		msg.setLineWrap(true);
//		msg.setA
//		msg.se
		
		JButton send = new JButton("Click to Send Email");
		send.setBounds(20,350,500,400);
		
		setLayout(null);
		add(msg);
		add(send);
		
		send.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				text = msg.getText();
				MessageGenerator.MessageGenerator(text, d);
				for(int i = 0; i < ExcelReader.people.size(); i++) {
					String email = ExcelReader.people.get(i).get(1).getString();
					String d = MessageGenerator.messages.get(i);
					EmailSender.sendEmail(email, d);
				}
				
			}
		});
		
	}
	
	public static void createAndShowMessageCenter(HashMap<Integer,String[]> dict){
		d = dict;
		JFrame f = new JFrame("Message Body");
        f.getContentPane().add(new MessageCenter(f));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(600, 600);
		f.setVisible(true);
	}
}
