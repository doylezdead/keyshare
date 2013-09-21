package client;
import java.io.*;
import java.net.*;

/**
 * 
 * @author Ryan Doyle, Sven Stroven, Chris Coppernoll
 * 
 *
 */
public class Client extends Thread {
	String address = null;
	
	public Client(String addr){
		address = addr;
		new Client().start();
	}
	

	public Client() {
		// TODO Auto-generated constructor stub
	}


	public void run(String addr){
		System.out.println("RUNNING");
		for (int i = 0; i <= 1; i++) {
			try {

				InputReader ir = new InputReader();


				Socket skt = new Socket(address, 13337);


				ObjectOutputStream oos = new ObjectOutputStream(skt.getOutputStream());		
				
				
				

				skt.close();
				oos.close();
				break;
			}
			catch(Exception e) {
				if (i == 0) {
					System.out.println("Reattempting connection, wait 10 seconds.");
					try {
						Thread.sleep(10000);
					} 
					catch (InterruptedException e1) {

					}
				}

				else {
					System.out.println("Could not find connection");
				}
			}
		}
	}
	
	
	public static void main(String[] args){
		
	}
}
