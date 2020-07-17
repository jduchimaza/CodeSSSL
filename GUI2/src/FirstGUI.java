import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class FirstGUI implements ActionListener {
	
	private static JTextField userText;
	private static JPasswordField pwText;
	private static JButton button;
	private static JLabel success;

	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		frame.setSize(300,320); // width, height
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.add(panel);
		
		panel.setLayout(null); //to be determined
		
		JLabel userLabel = new JLabel("User:");
		userLabel.setBounds(10, 20, 80, 25); //x,y,width,height
		panel.add(userLabel);
		
		//JTextField userText = new JTextField(20);
		userText = new JTextField(20);
		userText.setBounds(100, 20, 165, 25);
		panel.add(userText);
		
		JLabel pwLabel = new JLabel("Password:");
		pwLabel.setBounds(10, 50, 80, 25);
		panel.add(pwLabel);
		
		//JPasswordField pwText = new JPasswordField(20);
		pwText = new JPasswordField(20);
		pwText.setBounds(100,50,165,25);
		panel.add(pwText);
		
		//JButton button = new JButton();
		button = new JButton();
		button.setBounds(10, 80, 80, 25);
		button.setText("Log in");
		button.addActionListener(new FirstGUI());
		panel.add(button);
		
		//JLabel success = new JLabel("");
		success = new JLabel("");
		success.setBounds(10, 110, 300, 25);
		panel.add(success);
		
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		//System.out.println("button clicked");
		String user = userText.getText();
		String password = pwText.getText();
		//System.out.println(user + ", " + password);
		if(user.equals("One") && password.equals("Two")) {
			success.setText("Password accepted");
		}
		else {
			success.setText("DENIED");
		}
	}

}
