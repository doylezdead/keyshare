package client;
import java.io.*;
import java.net.*;

/**
 * 
 * @author Ryan Doyle, Sven Stroven, Chris Coppernoll
 * 
 *
 */
public class Client {
	public static void main(String[] args){
		for (int i = 0; i <= 1; i++) {
			try {
				Socket skt = new Socket("192.168.43.14", 13337);
				BufferedReader in = new BufferedReader(new InputStreamReader(skt.getInputStream()));
				PrintWriter out = new PrintWriter(skt.getOutputStream(), true);

				out.println("sending keypresses to server");

				while (!in.ready()) {}
				System.out.println(in.readLine()); // Read one line and output it

				in.close();
				skt.close();
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
