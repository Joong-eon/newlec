package com.newlecture.prj4;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class ClientFrame extends JFrame {
	
	private PaintCanvas canvas;
	private ChatPanel panel;
	private Button btnSend;
	
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem mExit;
	private JMenuItem mSettings;
	
	private JMenu mnServer;
	private JMenuItem mConnect;
	private JMenuItem mClose;
	
	private Socket socket;
	
	private Scanner nscan;
	private PrintStream nout;
	private String nickName;
	
	public ClientFrame() {
		
		btnSend = new Button("send");
		canvas = new PaintCanvas();
		add(canvas);
		
		panel = new ChatPanel();
		panel.setPreferredSize(new Dimension(300,0));
		panel
//		.setListener(new btnEventListener() {
//			
//			@Override
//			public void onSend(String chatMsg) {
//				// TODO Auto-generated method stub
//				panel.setOutputText("\n"+chatMsg);
//				
//			}
//		});
		.setListener(chatMsg->{nout.println("3,"+nickName+" : "+chatMsg);});
		add(panel,BorderLayout.LINE_END);
		
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnFile = new JMenu("Menu");
		menuBar.add(mnFile);
		
		mExit = new JMenuItem("Exit");
		mSettings = new JMenuItem("settings");
		mnFile.add(mExit);
		mnFile.add(mSettings);
		
		mSettings.addActionListener((e)->{
			this.nickName = JOptionPane.showInputDialog("대화명을 입력하세요.");
		});
		
		mExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		mnServer = new JMenu("Server");
		menuBar.add(mnServer);
		
		mConnect = new JMenuItem("Connect");
		mConnect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					socket = new Socket("192.168.0.70",10000);
					
					if(socket.isConnected()) {
						InputStream nis = socket.getInputStream();
						OutputStream nos = socket.getOutputStream();
						
						nscan = new Scanner(nis,"UTF-8");
						nout = new PrintStream(nos, true,"UTF-8");//연결되자마자 버퍼를 만들어서
						
						nout.println("1,"+nickName);
						
						//메세지를 받기위해 대기해야함
						
						new Thread(new Runnable() {
							@Override
							public void run() {//다른 스레드에서 계속 메시지를 받아옴
								while(nscan.hasNextLine()) {
									//데이터를 받아오는 곳. 식별을 위한 메타데이터 필요
									
									String msg = nscan.nextLine();
									String[] tokens = msg.split(",");
									
									int type = Integer.parseInt(tokens[0]);
									
									switch(type) {
									case 1:
										//Set<String> set = new HashSet<>();
										//중복값을 제거하기위해(멤버변수일때 효율적)
										
										String names = "";
										for(int i=0;i<tokens.length-1;i++) {
											names += tokens[i+1];
											if(i != tokens.length-2)
												names+=",";
										}
										panel.setUserNames(names);
										
										
										break;
									case 2:
										break;
									case 3:
										panel.setOutputText(tokens[1]);
										break;
									}
									
									
									
									//접속자 데이터를 받았을때
									// - newlec.dragon.hoho
									
									/*
									 {
									 	"type":1,
									 	"list":["newlec","dragon","hoho"]
									 } 
									 */
									
									//게임(그림판,오목) 등의 데이터를 받았을 때
									// - x1,y1,x2,y2
									
									/*
									 {
									 	"type":2,
									 	"data":{"x1":10,"y1":10,"x2":100,"y2":100}
									 } 
									 */
									
									//채팅데이터를 받았을때
									// - msg
									
									/*
									 {
									 	"type":3,
									 	"msg":"hello~~"
									 } 
									 */
									
//									panel.setOutputText(msg);
									//panel.setOutputText();
								}
							}
						}).start();
						
						canvas.setActive();
						
						panel.setOutputText("서버에 연결되었습니다.\n");
					}
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mClose = new JMenuItem("Close");
		mnServer.add(mConnect);
		mnServer.add(mClose);
		
		//add(btnSend,BorderLayout.LINE_END);//default layout은 borderLayout
		setSize(800,500);
		
		addWindowListener(new WindowAdapter() {
			
		
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		
		});
	}
}
