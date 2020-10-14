package chapter7ex3;

import java.awt.Canvas;
import java.awt.Component;
import java.awt.Frame;

public class GameFrame extends Frame{
	
	Canvas canvas;
	
	public GameFrame() {
		canvas = new GameCanvas();
		this.add(canvas);
	}
	
}
