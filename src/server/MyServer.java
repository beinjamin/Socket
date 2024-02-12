package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

	public static void main(String[] args) throws IOException {
		try (ServerSocket ss = new ServerSocket(1234)) {
			System.out.print("J attend une connexion...");
			Socket s = ss.accept();
			
			InputStream is=s.getInputStream();
			OutputStream os = s.getOutputStream();
			
			System.out.print("J attend que le client envoi un octet");
			int nb=is.read();
			System.out.print("J ai recu un nombre " +nb);

			int res=nb*5;
			System.out.print("J envoi la reponse" +res);

			os.write(res);
			s.close();
		}
	}

}
