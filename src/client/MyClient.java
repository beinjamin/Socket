package client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MyClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.print("Je me connecte ou serveur ");
		Socket socket=new Socket("localhost",1234);
		InputStream  is=socket.getInputStream();
		OutputStream os=socket.getOutputStream();
		
		/*
		 * Saisir les nombre ou clavier
		 */
		Scanner scanner=new Scanner(System.in);
		System.out.print("Donner un nombre");
		int nb=scanner.nextInt();
		
		System.out.println("J envoi le nombre " +nb+"au serveur");
		os.write(nb);
		
		System.out.println("J attend la reponse du serve...");
		int rep=is.read();
		System.out.println("J envoi la reponse" +rep);
	
	}

}
