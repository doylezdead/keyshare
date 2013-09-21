package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class ClientListener implements ActionListener {

	private JFrame gui;
	private ClientGUI Client;
	private boolean initiated = false;
	private boolean jbutton;
	protected String address;

	/**
	 * @param args
	 */
	public ClientListener(ClientGUI b, JFrame g, boolean button) {
		gui = g;
		Client = b;
		jbutton = button;

	}

	public void actionPerformed(ActionEvent e) {
		if (initiated == true) {

		}

		else {
			if (jbutton == true) {
				Client.start.setText("Switch");
			} else if (jbutton == false) {
				address = Client.IP.getText();
				Client cli = (new Client(address)).start();
			}
			initiated = true;

		}
	}

}
