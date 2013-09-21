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
		try {
			Socket skt = new Socket("192.168.43.14", 13337);
			BufferedReader in = new BufferedReader(new InputStreamReader(skt.getInputStream()));
			PrintWriter out = new PrintWriter(skt.getOutputStream(), true);

			out.println("push back to server");

			while (!in.ready()) {}
			System.out.println(in.readLine()); // Read one line and output it

			
			
			
			
			in.close();
			skt.close();
		}
		catch(Exception e) {
			System.out.print("Whoops! It didn't work!\n");
		}
	}

}
