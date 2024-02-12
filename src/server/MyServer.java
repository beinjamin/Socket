package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

	public static void main(String[] args) throws IOException {
		ServerSocket ss=new ServerSocket(1234);
		System.out.print("J attend une connexion...");
		Socket s = ss.accept();

	}

}
