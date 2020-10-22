package soket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientConsoleProgram {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket sock = new Socket("192.168.0.3", 10000);
		OutputStream nos = sock.getOutputStream();
		InputStream nis = sock.getInputStream();

		PrintStream out = new PrintStream(nos, true);
		Scanner nscan = new Scanner(nis);
		Scanner scan = new Scanner(System.in);
		String s;
		do {
			s = scan.nextLine();
			System.out.print(s);

			out.println("Supervisor : " + s);
		}while(!s.equals("bye"));

		out.close();
		scan.close();
		nscan.close();
		nis.close();
		nos.close();
		sock.close();
	}
}

