package client;

import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * 
 * @author Ryan Doyle, Sven Stroven, Christopher Coppernoll
 * 
 * 
 */
public class Client extends Thread {
	String address = null;

	public Client(String addr, InputReader ir) {
		address = addr;
		this.run(addr, ir);
	}

	public Client getInstance() {
		return this;
	}

	public void run(String addr, InputReader ir) {
		System.out.println("RUNNING");
		for (int i = 0; i <= 1; i++) {
			try {

				Socket skt = new Socket(address, 13337);

				ObjectOutputStream oos = new ObjectOutputStream(
						skt.getOutputStream());

				while (true) {
					Thread.sleep(5);
					oos.writeObject(ir.commands);
					if (ir.commands[0] == 20) {
						break;
					}
				}

				skt.close();
				oos.close();
				break;
			} catch (Exception e) {
				if (i == 0) {
					System.out
							.println("Reattempting connection, wait 10 seconds.");
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e1) {

					}
				}

				else {
					System.out.println("Could not find connection");
				}
			}
		}
	}

	public static void main(String[] args) {
		new Client("localhost", new InputReader()).start();
	}
}
