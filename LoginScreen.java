package trial;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

public class LoginScreen extends JPanel
{
	/**
	 * @wbp.parser.entryPoint
	 */
	public LoginScreen ()
	{
		final JTextField usr = new JTextField("Enter Email login here");
		usr.setBounds(1, 1, 300, 30);
		final JTextField pas = new JTextField("Enter password here");
		pas.setBounds(1,40,300,30);
 
		JButton button = new JButton(" >> click to open upload screen <<");
		button.setBounds(40, 90, 200, 40);
 
		setLayout(null);
		add(usr);
		add(pas);
		add(button);
 
		// Add action listener to button
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
 
				// Execute when button is pressed
				//System.out.println("You clicked the button");
 
				String getUser = usr.getText();
				String getPass = pas.getText();
				EmailSender.setEmail(getUser);
				EmailSender.setPass(getPass);
				EmailSender.createSession();
				/*EmailSender.sendEmail("dominicxcliu@gmail.com","butts");*/
				ExcelInput.createAndShowExcelInput();

			}
		});
	}
	public static void createAndShowLogin() {
        //Create and set up the window.
        JFrame frame = new JFrame("Email Login");
        frame.getContentPane().add(new LoginScreen());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(310, 300);
		frame.setVisible(true);
    }

}
