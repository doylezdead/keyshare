package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class ClientListener implements ActionListener {

	private JFrame gui;
	private ClientGUI Client;
	private boolean initiated = false;

	/**
	 * @param args
	 */
	public ClientListener(ClientGUI b, JFrame g) {
		gui = g;
		Client = b;

	}

	public void actionPerformed(ActionEvent e) {
		if (initiated == true) {

		}

		else {
			Client.start.setText("Switch");
			initiated = true;
		}
	}

}
