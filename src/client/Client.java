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
	
	
	public InputReader ir = null;
	public ObjectOutputStream oos = null;
	
	public Client(MapGUI map, String addr){
		address = addr;
		this.run(map,addr,ir);
	}
	
	public Client getInstance(){
		return this;
	}
	



	public void run(MapGUI map, String addr, InputReader ir){
		System.out.println("RUNNING");
		for (int i = 0; i <= 1; i++) {
			try {
				
				System.out.println(address);
				Socket skt = new Socket("192.168.43.14", 13337);


				oos = new ObjectOutputStream(skt.getOutputStream());		
				
				ir = new InputReader(map, this);
				
				while(true){
					Thread.sleep(15);
					
					if(ir.commands[0]==20){
						break;
					}
				}
				

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
		//new Client("localhost", new InputReader()).start();
	}
}
