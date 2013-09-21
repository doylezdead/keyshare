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
		String data = "I'm pushing back to the client(disconnect or something)";
		try {
			
			System.out.println("Waiting for connections ...");
			ServerSocket srvr = new ServerSocket(13337);
			
			Socket skt = srvr.accept();
			System.out.print("Client has connected to the server!!!\n");
			
			ObjectInputStream ois = new ObjectInputStream(skt.getInputStream());	//skt's input stream
			
			PrintWriter out = new PrintWriter(skt.getOutputStream(), true);			//skt's output stream
			
			
			out.print(data);														
			int[] readArray = (int[])ois.readObject();
			for(int i=0;i<readArray.length;i++){
				System.out.print(readArray[i] + ",");
			}
			
			
			out.close();		//
			skt.close();		// close all resources
			srvr.close();		//
		}
		catch(Exception e) {
			e.printStackTrace();//"No connection found\n");
		}
	}
}
