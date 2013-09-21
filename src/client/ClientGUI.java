package client;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class ClientGUI {

	protected JButton start;

	public ClientGUI() {

		JFrame cGui = new JFrame();

		// set up grid layout with rows and columns equal to size.
		cGui.setLayout(new GridLayout(2, 1));

		// make the program terminate when the window is closed
		cGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// give the window a title
		cGui.setTitle("Client Initiator");

		// set the size of the window
		cGui.setSize(500, 400);

		JTextField IP = new JTextField("Enter a remote IP address");
		start = new JButton("Start");

		start.addActionListener(new ClientListener(this, cGui));

		cGui.add(IP);
		cGui.add(start);

		cGui.setVisible(true);

	}
}
