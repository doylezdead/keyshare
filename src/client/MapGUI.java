package client;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class MapGUI {

	/**
	 * @param args
	 */
	public MapGUI() {
		JFrame mGui = new JFrame();

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		mGui.setSize(dim);
		mGui.setVisible(true);
		// set up grid layout with rows and columns equal to size.

		// make the program terminate when the window is closed
		mGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// give the window a title
		mGui.setTitle("Client Initiator");

		// set the size of the window

		// TODO Auto-generated method stub

	}

}
