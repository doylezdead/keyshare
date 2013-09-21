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
<<<<<<< HEAD
	
	
	public InputReader ir = null;
	public ObjectOutputStream oos = null;
	
	public Client(MapGUI map, String addr){
		address = addr;
		this.run(map,addr,ir);
=======

	public Client(String addr, InputReader ir) {
		address = addr;
		this.run(addr, ir);
>>>>>>> 6f926541ed152a5da8d7c82e7f7cccafb02d13ad
	}

	public Client getInstance() {
		return this;
	}

<<<<<<< HEAD

	public void run(MapGUI map, String addr, InputReader ir){
=======
	public void run(String addr, InputReader ir) {
>>>>>>> 6f926541ed152a5da8d7c82e7f7cccafb02d13ad
		System.out.println("RUNNING");
		for (int i = 0; i <= 1; i++) {
			try {
				
				System.out.println(address);
				Socket skt = new Socket("192.168.43.14", 13337);

<<<<<<< HEAD

				oos = new ObjectOutputStream(skt.getOutputStream());		
				
				ir = new InputReader(map, this);
				
				while(true){
					Thread.sleep(15);
					
					if(ir.commands[0]==20){
=======
				Socket skt = new Socket(address, 13337);

				ObjectOutputStream oos = new ObjectOutputStream(
						skt.getOutputStream());

				while (true) {
					Thread.sleep(5);
					oos.writeObject(ir.commands);
					if (ir.commands[0] == 20) {
>>>>>>> 6f926541ed152a5da8d7c82e7f7cccafb02d13ad
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
<<<<<<< HEAD
	
	
	public static void main(String[] args){
		//new Client("localhost", new InputReader()).start();
=======

	public static void main(String[] args) {
		new Client("localhost", new InputReader()).start();
>>>>>>> 6f926541ed152a5da8d7c82e7f7cccafb02d13ad
	}
}
