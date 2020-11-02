package com.newlecture.prj4;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.PrintStream;

import javax.swing.JTextArea;

public class ChatPanel extends Panel {
	
	//private TextField text;//한줄만 쓸수 있는것
	private TextArea text;//여러 라인 쓸수 있는것
	private Panel inputPanel;
	private Button btnSend;
	private JTextArea inputTextBox;
	private Label label;
	
	
	private btnEventListener listener;
	
	public void setListener(btnEventListener listener) {
		this.listener = listener;
	}

	public ChatPanel() {
		label = new Label();
		setLayout(new BorderLayout());//panel은 레이아웃이 Border가 아니므로
		//setPreferredSize(new Dimension(0, 200)) 이걸 하기 위해서는 바꿔줘야함
		
		label.setPreferredSize(new Dimension(0,100));
		add(label,BorderLayout.PAGE_START);
		
		text = new TextArea();
		text.setEditable(false);
		inputPanel = new Panel();
		btnSend = new Button("send");
		inputTextBox = new JTextArea();
		//btnSend.setPreferredSize(new Dimension(0,100));
		
		
		inputTextBox.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == 10) {
					
					String chatMsg = inputTextBox.getText();
					
					//int end = inputTextBox.getSelectionEnd();
					//chatMsg.replace('\n', ' ');
					listener.onSend(chatMsg.replace("\n", ""));
					inputTextBox.setText("");
					inputTextBox.setFocusable(true);
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		});
		
		inputPanel.setPreferredSize(new Dimension(0, 100));
		inputPanel.setLayout(new BorderLayout());
		inputPanel.add(inputTextBox,BorderLayout.CENTER);
		inputPanel.add(btnSend,BorderLayout.LINE_END);
		
		btnSend.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String chatMsg = inputTextBox.getText();
				listener.onSend(chatMsg);
				inputTextBox.setText("");
				inputTextBox.setFocusable(true);
			}
		});
			
		add(text);
		add(inputPanel,BorderLayout.PAGE_END);
		
	}

	public void setOutputText(String message) {
		// TODO Auto-generated method stub
		//text.setText(message);//기존에 있던 문자를 바꿔버림
		text.append(message+"\n");//계속해서 중첩
	}

	public void setUserNames(String names) {
		String[] tokens = names.split(",");
		label.setText(names+" // 현재 접속자 : "+ tokens.length + "명");
	}

}
