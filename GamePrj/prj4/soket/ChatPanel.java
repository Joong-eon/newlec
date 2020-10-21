package soket;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

public class ChatPanel extends Panel {
	
	private TextArea textBox;
	private Panel inputPanel;
	private TextArea inputTextBox;
	private Button btnSend;
	
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
		inputPanel.add(btnSend, BorderLayout.LINE_END);

	}

	public void setOutText(String string) {
		// TODO Auto-generated method stub
		
	}
	
	

}
