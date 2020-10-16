package soket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerProgram {

	public static void main(String[] args) throws IOException {
		ServerSocket svrSock = new ServerSocket(10000);
		System.out.println("Server Stated...");
		Socket sock = svrSock.accept();
		System.out.println("손님이 왔습니다.");
		
		
	OutputStream nos = sock.getOutputStream();
	InputStream nis = sock.getInputStream();
	
	PrintStream nout = new PrintStream(nos, true);
	Scanner nscan = new Scanner(nis);
	Scanner scan = new Scanner(System.in);
	String msg;
	do {
		msg = nscan.nextLine();
		System.out.println(msg);
		nout.println("나 :" +msg);
	}while(!msg.equals("bye"));
	
	
	scan.close();
	nscan.close();
	nis.close();
	nos.close();
	sock.close();

	
	}
	
}
