package com.newlecture.prj3;

import java.awt.Canvas;
import java.awt.Frame;

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
	}
	
	public void switchCanvas(Canvas oldCanvas, Class newCanvas) throws InstantiationException, IllegalAccessException {
		//remove(oldCanvas);
		oldCanvas.setVisible(false); //�� �� �ϳ� ���� ��
		
		add((Canvas)newCanvas.newInstance());
		
		revalidate();//��ȿ���� �ٽ� Ȯ����
	}
}
