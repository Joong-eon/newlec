package com.newlecture.prj4;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServerProgram {
	static int outSize = 0;
	//private static ArrayList<String> users = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		boolean isRunning = true;
		Socket[] sockets = new Socket[30];
		int socketSize = 0;
		PrintStream[] outs = new PrintStream[30];
		
		
		ServerSocket svrSock = new ServerSocket(10000);
		System.out.println("Server Started...");
		ArrayList<String> users = new ArrayList<>();
		while(isRunning) {
			
			Socket sock = svrSock.accept();
			sockets[socketSize++] = sock;
			System.out.println("손님이 왔습니다.");
			
			new Thread(new Runnable() {//익명클래스
				
				@Override
				public void run() {
					// 스레드로 새로운 흐름을 만들 것임
					OutputStream nos;
					try {
						nos = sock.getOutputStream();
						InputStream nis = sock.getInputStream();
						PrintStream nout = new PrintStream(nos, true,"UTF-8");
						
						outs[outSize++]  = nout;//젼역변수를 사용하는 이유 : 스레드로 다른 실행주기로 빠지게되면
						//비동기형으로 실행되므로 메인스레드의 변수를 쓸수 없다. 하지만 좋은방법이 아니다. 데이터구조를 정리해서 다른 방법으로 해야한다.
						Scanner nscan = new Scanner(nis,"UTF-8");

						String line;
						
						do {

							line = nscan.nextLine();// blocking 함수. 이걸 하염없이 기다리고 있음 다른 사용자의 연결을 받을수가 없음
							
							String[] tokens = line.split(",");
							
							int type = Integer.parseInt(tokens[0]);
							
							switch(type) {
							case 1:
								//현재 접속자 정보를 users콜렉션에 담고 
								String name = tokens[1];
								users.add(name);
								//user콜랙션의 목록을 csv 문자열로 만들어서
								//현재 접속중인 사용자에게 뿌린다.
								String userNames = "1,";
								for(int i=0;i<users.size();i++) {
									userNames += users.get(i);
									if(i != users.size()-1)
										userNames += ",";
								}
								
								for(int i=0;i<outSize;i++) {
									outs[i].println(userNames);//이상태에서는 입력중에 메시지가 오는 문제가 생김.
								}
								
								break;
							case 2:
								break;
							case 3:
								for(int i=0;i<outSize;i++)
									outs[i].println("3,"+tokens[1]);
								break;
							}/*
							for(int i=0;i<outSize;i++) {
								outs[i].println(msg);//이상태에서는 입력중에 메시지가 오는 문제가 생김.
							}*/

						} while (!line.equals("bye"));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				}
				
			}).start();//쓰레드 생성하고 바로 실행
		}
		
		
		
		//System.out.println("connected from " + svrSock.getLocalSocketAddress());
	}

}
