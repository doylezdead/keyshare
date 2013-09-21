package server;

import java.net.*;
import java.io.*;

public class Server {
	public static void main(String[] args){
		String data = "This is test data";
		try {
			ServerSocket srvr = new ServerSocket(13337);
			Socket skt = srvr.accept();
			System.out.print("Server has connected!\n");
			PrintWriter out = new PrintWriter(skt.getOutputStream(), true);
			System.out.print("Sending string: '" + data + "'\n");
			out.print(data);
			out.close();
			skt.close();
			srvr.close();
		}
		catch(Exception e) {
			System.out.print("Whoops! It didn't work!\n");
		}
	}
}
