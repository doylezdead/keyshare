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
	public Client(String addr){
		for (int i = 0; i <= 1; i++) {
			try {

				InputReader ir = new InputReader();


				Socket skt = new Socket(addr, 13337);


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
		for (int i = 0; i <= 1; i++) {
			try {

				//GUI stuff here to get host n stuff


				Socket skt = new Socket("localhost", 13337);


				ObjectOutputStream oos = new ObjectOutputStream(skt.getOutputStream());		
				BufferedReader in = new BufferedReader(new InputStreamReader(skt.getInputStream()));


				int[] ints = {2,2,3,3,4,4,5,5};
				oos.writeObject(ints);
				int[] ints2 = {3,2,3,3,4,4,5,5};
				oos.writeObject(ints2);
				int[] ints3 = {4,2,3,3,4,4,5,5};
				oos.writeObject(ints3);

				//System.out.println(in.readLine());

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
}
