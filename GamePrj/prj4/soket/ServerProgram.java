package soket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import org.omg.CosNaming.IstringHelper;

public class ServerProgram {
	static int outSize = 0;

	public static void main(String[] args) throws IOException {

		boolean isRunning = true;
		Socket[] sockets = new Socket[30];
		int socketSize = 0;
		PrintStream[] outs = new PrintStream[30];
		

		ServerSocket svrSock = new ServerSocket(10000);
		System.out.println("Server Stated...");
		
		while(isRunning) {
			
		Socket sock = svrSock.accept();
		sockets[socketSize] = sock;
		socketSize++;

		System.out.println("손님이 왔습니다.");

		//==============================
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

				OutputStream nos;
				try {
					nos = sock.getOutputStream();
					InputStream nis = sock.getInputStream();
					PrintStream nout = new PrintStream(nos, true);
					
					Scanner nscan = new Scanner(nis);
					Scanner scan = new Scanner(System.in);
					outs[outSize] = nout;
					outSize++;
					
					String msg;
					do {
						msg = nscan.nextLine();
						//nout.println(msg);
						for(int i =0; i<outSize; i++)
							outs[i].println(msg);
						
						System.out.println(msg);
					}while(!msg.equals("bye"));

					scan.close();
					nscan.close();
					nis.close();
					nos.close();
					sock.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				


			}
		})
		.start();

		}
	}

}
