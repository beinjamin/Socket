package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurMT extends Thread {
	private int nombreClient;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ServeurMT().start();

	}
	
	public void run() {
		try {
			ServerSocket ss =new ServerSocket(1234);
			System.out.println ("Demarrage du serveur .....");
			
			while(true) {
				Socket socket = ss.accept();
				++nombreClient;
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
			try {
				InputStream is = socket.getInputStream();
				InputStreamReader isr=new InputStreamReader(is);
				BufferedReader br=new BufferedReader(isr);
				
				
				OutputStream os=socket.getOutputStream();
				PrintWriter pw=new PrintWriter(os,true);
				
				
				while(true) {
					String req=br.readLine();
					pw.println(req.length());
					
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}

}
