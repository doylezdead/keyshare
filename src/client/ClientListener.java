package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class ClientListener implements ActionListener {

	private JFrame gui;
	private ClientGUI Client;
	private boolean initiated = false;
	protected String address;

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

			address = Client.IP.getText();
			// Client cli = (new Client(address));
			Client.IP.setEditable(false);
			new MapGUI();
		}
		initiated = true;

	}
}
