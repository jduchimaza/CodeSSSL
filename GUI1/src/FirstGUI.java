import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FirstGUI implements ActionListener {
	
	private int count = 0;
	private JLabel label;
	private JFrame frame;
	private JPanel panel;
	
	public FirstGUI() {
		 frame = new JFrame(); // create a frame
		
		JButton button = new JButton("Click Me"); // create button
		button.addActionListener(this);
		label = new JLabel("Number of clicks: 0"); // create label
		
		// setup panel
		panel = new JPanel(); // create a jpanel
		panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30)); // let them play with setBorder
		panel.setLayout(new GridLayout(0,1));
		panel.add(button); // add the button to the panel
		panel.add(label); // add the label to the panel
	
		
		// add this panel to the frame
		frame.add(panel, BorderLayout.CENTER);
		// say what happens when you close the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// add a title to the bar on the frame
		frame.setTitle("First GUI");
		// size to fit the frame to the panel
		frame.pack();
		// make new frame visible or invisible
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// we are doing everything in a GUI object, so just put this in the main method and forget about it for now.
		new FirstGUI();
		
	}

	public void actionPerformed(ActionEvent e) {
		count++;
		label.setText("Number of clicks: " + count);
		
	}
}