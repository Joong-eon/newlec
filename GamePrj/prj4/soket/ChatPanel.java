package soket;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ChatPanel extends Panel {
	
	private TextArea textBox;
	private Panel inputPanel;
	private TextArea inputTextBox;
	private Button btnSend;
	private ChatListener chatListener;
	
	public ChatPanel() {
		setLayout(new BorderLayout());
		
		textBox = new TextArea();
		textBox.setEditable(false);
		inputPanel = new Panel();
		inputPanel.setPreferredSize(new Dimension(0,100));
		inputPanel.setLayout(new BorderLayout());
		
		add(textBox);
		add(inputPanel, BorderLayout.PAGE_END);
		
//		add(inputTextBox);
		inputTextBox = new TextArea();
		inputPanel.add(inputTextBox);
		
		btnSend = new Button("Send");
		//inputPanel.add(btnSend, BorderLayout.LINE_END);
		btnSend.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//1.
				String chatMsg = inputTextBox.getText();
				chatListener.onSend(chatMsg);
			}
		});
		inputPanel.add(btnSend, BorderLayout.LINE_END);
	}

	public void setOutText(String msg) {
		textBox.append(msg + "\n");
	}

	public void setChatListener(ChatListener chatListener) {
		this.chatListener = chatListener;
	}
}
