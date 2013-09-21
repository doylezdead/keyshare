package server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class ServerListener implements ActionListener {

	public JFrame Gui;

	public ServerListener(JFrame g) {

		Gui = g;

	}

	/**
	 * @param args
	 */
	public void actionPerformed(ActionEvent e) {
		Gui.setVisible(false);

	}

	// Start of Constructor.

}
