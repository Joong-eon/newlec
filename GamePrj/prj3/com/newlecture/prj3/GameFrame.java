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

		//윈도우 리스너
		addWindowListener(new WindowAdapter() {	
			@Override
			//윈도우의 x를 눌렀을때
			public void windowClosing(WindowEvent e) {
						
				//새로운 창이뜸
				int input = JOptionPane.showConfirmDialog(GameFrame.this , "요기가 본문이오", "요기가 제목이오" , JOptionPane.OK_CANCEL_OPTION);
				System.out.println(input);
				
				if(input == JOptionPane.OK_OPTION)
					System.exit(0);
				
//				Object[] options = { "굿", "베드" };
//				JOptionPane.showOptionDialog(null, "Click OK to continue", "Warning",
//						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
//						null, options, options[0]);
			}
			
		});
	}
	
	public void switchCanvas(Canvas oldCanvas, Class newCanvas) throws InstantiationException, IllegalAccessException {
		
		Canvas canvas = (Canvas)newCanvas.newInstance();
		add(canvas);
		//화면 전환 후 포커스...마우스를 따로 클릭하지 않아도 캐릭터를 키보드로 움직일 수 있음
		canvas.setFocusable(true);
		canvas.requestFocus();
		
		//화면 전환 후 화면이 바뀌지 않았지만 배경과 우주선을 이동하게 함
		if(canvas instanceof ActionCanvas)
			((ActionCanvas)canvas).start();
		
		revalidate();//유효한지 다시 확인함
		
		//remove(oldCanvas);
		oldCanvas.setVisible(false); //둘 중 하나 쓰면 됨
		//내린 이유는 원래 지우고 새로운 화면을 띄우는데, 내림으로써 새화면을 띄우고 지우니까 중간에 하얗게 뜨는 화면(공백상태)이 사라짐 
	}
}
