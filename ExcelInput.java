package trial;
import javax.swing.*;

import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

public class ExcelInput extends JPanel
{
	private static JTextField textField;
	static boolean fileOpened;
	static JLabel label;
	static String filePath;
	/**
	 * @wbp.parser.entryPoint
	 */
	public ExcelInput(final JFrame frame)
	{
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.setBounds(0, 0, 155, 29);
		
		label = new JLabel("");
        label.setBounds(54, 40, 400, 78);
        
        add(label);
		
		setLayout(null);
		add(btnBrowse);
		
		fileOpened = false;
		
		btnBrowse.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				final JFileChooser fileChooser = new JFileChooser();
				fileChooser.setBounds(0, 78, 500, 400);
				int returnVal = fileChooser.showOpenDialog(ExcelInput.this);
				
				if (returnVal == JFileChooser.APPROVE_OPTION){
					File file = fileChooser.getSelectedFile();
					filePath = file.getPath();
					fileOpened = true;
					label.setText(filePath);
					System.out.println(filePath);
					
				}
				System.out.println("browse clicked");
			}
		});
		
		JButton btnOpen = new JButton("Open");
		btnOpen.setBounds(160,250,155,29);
		
		setLayout(null);
		add(btnOpen);
		
		btnOpen.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (fileOpened) {
					System.out.println("open clicked");
					frame.setVisible(false);
					CreatorScreen.createAndShowCreator(filePath);
				}
			}
		});
		
		
		
		
		
	}
	
	public static void createAndShowExcelInput()
	{
		
		
		final JFrame frame = new JFrame("Uploader");
		frame.getContentPane().add(new ExcelInput(frame));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(310, 300);
		frame.setVisible(true);

		
	}
	
	
}
