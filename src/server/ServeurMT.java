package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurMT extends Thread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ServeurMT().start();

	}
	
	public void run() {
		try {
			ServerSocket ss =new ServerSocket(1234);
			while(true) {
				Socket socket = ss.accept();
				new Conversation(socket).start();
				
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	class Conversation extends Thread{
		private Socket socket;
		public Conversation(Socket s) {
			this.socket = s;
			
		}
		public void run ()
		{
			
		}
	}

}
