package server;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ServerGUI {

	protected JButton disconnect;

	public ServerGUI() {

		Server srv = (new Server()).start();

		// Create a new JFrame.
		JFrame gui = new JFrame();

		// set up grid layout with 1 row and column.
		gui.setLayout(new GridLayout(1, 1));

		// make the program terminate when the window is closed
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// give the window a title
		gui.setTitle("Server Control");

		// set the size of the window
		gui.setSize(250, 200);

		disconnect = new JButton("Disconnect");

		disconnect.addActionListener(new ServerListener(gui));
		gui.add(disconnect);
		gui.setVisible(true);

	}
}
