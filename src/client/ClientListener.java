package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class ClientListener implements ActionListener {


	private ClientGUI Client;
	public MapGUI Mapper;
	private boolean initiated = false;
	protected String address;

	/**
	 * @param args
	 */
	public ClientListener(ClientGUI b, JFrame g) {

		Client = b;

	}

	public void actionPerformed(ActionEvent e) {
		if (initiated == true) {

		}

		else {

			Client.start.setText("Switch");

			
			address = Client.IP.getText();
			
			
			
			Client.IP.setEditable(false);
			
			new MapGUI(this, address);
			//InputReader ir = new InputReader();
			
			System.out.println("Client thread worked");
		}
		initiated = true;

	}
}
