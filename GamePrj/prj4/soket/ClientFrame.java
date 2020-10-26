package soket;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.MenuBar;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class ClientFrame extends JFrame {

	private Socket socket;
	//메뉴 만들기
	private JMenuBar menuBar;

	private JMenu mnFile;
	private JMenuItem miExit;

	private JMenu mnServer;
	private JMenuItem miConnect;
	private JMenuItem miClose;

	private PaintCanvas canvas;
	private ChatPanel panel;
	//	private Button btnSend;
	protected Scanner nscan;
	protected PrintStream nout;
	
	private JMenuItem miSettings;
	private String nicName;


	public ClientFrame() {

		setSize(800,500);
		//메뉴바
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		//메뉴생성
		mnFile = new JMenu("Menu");
		menuBar.add(mnFile);

		mnServer = new JMenu("Server");
		menuBar.add(mnServer);
		
		miSettings = new JMenuItem("Settings");
		mnFile.add(miSettings);
		miSettings.addActionListener(new ActionListener() {
			

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				nicName = JOptionPane.showInputDialog("대화명을 입력하세요");
			}
		});
		
		
//		(e)->{
//			this.nicName = JOptionPane.showInputDialog("대화명을 입력하세요");
//		};

		//메뉴아이템 생성
		miExit = new JMenuItem("Exit");
		mnFile.add(miExit);
		miExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});

		miConnect = new JMenuItem("Connect");
		mnServer.add(miConnect);
		miConnect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					socket = new Socket("192.168.0.73",10000);
					
					if(socket.isConnected()) {

						InputStream nis = socket.getInputStream();
						OutputStream nos = socket.getOutputStream();
						nscan = new Scanner(nis);
						nout = new PrintStream(nos);
						//================
						new Thread(new Runnable() {

							@Override
							public void run() {
								// TODO Auto-generated method stub
								while(nscan.hasNextLine()){
									String line = nscan.nextLine();
									panel.setOutText(line);
								}

							}
						}).start();
						//=================
						canvas.setActive();
						panel.setOutText("서버에 연결되었습니다.");
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



		miClose = new JMenuItem("Close");
		mnServer.add(miClose);

		canvas = new PaintCanvas();
		add(canvas);

		panel = new ChatPanel();
		panel.setPreferredSize(new Dimension(300, 0));
		add(panel, BorderLayout.LINE_END);
		panel.setChatListener
		(chatMsg -> {nout.printf("%s : %s", nicName, chatMsg);}
		);

		//		btnSend = new Button("Sned");
		//add(btnSend, BorderLayout.LINE_END);

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);

			}

		});
		
		
	}
}
