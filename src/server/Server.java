package server;

import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @author Ryan Doyle, Sven Stroven, Chris Coppernoll
 * 
 * 
 */

public class Server extends Thread {

	public Server() {
		this.run();
	}

	public void run() {
		WorkerRobot robot = new WorkerRobot();
		try {

			System.out.println("Waiting for connections ...");
			ServerSocket srvr = new ServerSocket(13337);

			Socket skt = srvr.accept();
			System.out.print("Client has connected to the server!!!\n");

			ObjectInputStream ois = new ObjectInputStream(skt.getInputStream()); // skt's
																					// input
																					// stream

			PrintWriter out = new PrintWriter(skt.getOutputStream(), true); // skt's
																			// output
																			// stream

			int[] readArray = null;

			while (true) {
				Thread.sleep(5);
				readArray = (int[]) ois.readObject();
				for (int i = 0; i < readArray.length; i++) {
					System.out.println(readArray[i]);
				}

				if (readArray[0] == 10)
					break;

				robot.work(readArray);

			}

			out.close(); //
			skt.close(); // close all resources
			srvr.close(); //
		} catch (Exception e) {
			e.printStackTrace();// "No connection found\n");
		}
	}

	public static void main(String[] args) {
		new Server().start(); // line to put

	}
}
