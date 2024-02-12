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
				new Conversation(socket, nombreClient).start();
				
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	class Conversation extends Thread{
		private Socket socket;
		private int numeroClient;
		public Conversation(Socket s, int num) {
			this.socket = s;
			this.numeroClient = num;
		}
		public void run ()
		{
			try {
				InputStream is = socket.getInputStream();
				InputStreamReader isr=new InputStreamReader(is);
				BufferedReader br=new BufferedReader(isr);
				
				
				OutputStream os=socket.getOutputStream();
				PrintWriter pw=new PrintWriter(os,true);
				String IP=socket.getRemoteSocketAddress().toString();
				System.out.println ("Connexion du client numero" +numeroClient );
				
				pw.println("Bienvenue vous etes le client numero" +numeroClient);
				
				
				while(true) {
					String req=br.readLine();
					System.out.println("Le client avec l adresse IP " +IP+ " a envoyer une requette" +req);
					pw.println(req.length());
					
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}

}
