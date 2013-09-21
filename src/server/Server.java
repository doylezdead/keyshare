package server;

import java.net.*;
import java.io.*;

/**
 * 
 * @author Ryan Doyle, Sven Stroven, Chris Coppernoll
 * 
 *
 */

public class Server {
	public static void main(String[] args){
		String data = "I'm pushing back to the client";
		try {
			
			System.out.println("Waiting for connections ...");
			ServerSocket srvr = new ServerSocket(13337);
			Socket skt = srvr.accept();
			BufferedReader in = new BufferedReader(new InputStreamReader(skt.getInputStream()));
			ObjectInputStream ois = new ObjectInputStream(skt.getInputStream());
			System.out.print("Client has connected to the server!!!\n");
			
			
			while (!in.ready()) {} //loop to wait for reader to get ready from output of printwriter on client
			
			
			System.out.println(ois.readObject());
			PrintWriter out = new PrintWriter(skt.getOutputStream(), true);
			out.print(data);
			out.println(in.read());
			out.close();
			skt.close();
			srvr.close();
		}
		catch(Exception e) {
			System.out.print("No connection found\n");
		}
	}
}
