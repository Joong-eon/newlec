package com.newlecture.prj3;

import java.awt.Canvas;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

import com.newlecture.prj3.canvas.ActionCanvas;
import com.newlecture.prj3.canvas.IntroCanvas;

public class GameFrame extends Frame {

	public static GameFrame instance;
	private IntroCanvas introCanvas;
	private ActionCanvas canvas;

	public GameFrame() {
		instance = this;
		//Canvas canvas = new PuzzleCanvas();

		introCanvas = new IntroCanvas();
		add(introCanvas);

		//		canvas = new ActionCanvas();
		//		canvas.start();
		//		
		setSize(360, 600);
		setVisible(true);	
		//		add(canvas);

		//������ ������
		addWindowListener(new WindowAdapter() {	
			@Override
			//�������� x�� ��������
			public void windowClosing(WindowEvent e) {
						
				//���ο� â�̶�
				int input = JOptionPane.showConfirmDialog(GameFrame.this , "��Ⱑ �����̿�", "��Ⱑ �����̿�" , JOptionPane.OK_CANCEL_OPTION);
				System.out.println(input);
				
				if(input == JOptionPane.OK_OPTION)
					System.exit(0);
				
//				Object[] options = { "��", "����" };
//				JOptionPane.showOptionDialog(null, "Click OK to continue", "Warning",
//						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
//						null, options, options[0]);
			}
			
		});
	}
	
	public void switchCanvas(Canvas oldCanvas, Class newCanvas) throws InstantiationException, IllegalAccessException {
		
		Canvas canvas = (Canvas)newCanvas.newInstance();
		add(canvas);
		//ȭ�� ��ȯ �� ��Ŀ��...���콺�� ���� Ŭ������ �ʾƵ� ĳ���͸� Ű����� ������ �� ����
		canvas.setFocusable(true);
		canvas.requestFocus();
		
		//ȭ�� ��ȯ �� ȭ���� �ٲ��� �ʾ����� ���� ���ּ��� �̵��ϰ� ��
		if(canvas instanceof ActionCanvas)
			((ActionCanvas)canvas).start();
		
		revalidate();//��ȿ���� �ٽ� Ȯ����
		
		//remove(oldCanvas);
		oldCanvas.setVisible(false); //�� �� �ϳ� ���� ��
		//���� ������ ���� ����� ���ο� ȭ���� ���µ�, �������ν� ��ȭ���� ���� ����ϱ� �߰��� �Ͼ�� �ߴ� ȭ��(�������)�� ����� 
	}
}
