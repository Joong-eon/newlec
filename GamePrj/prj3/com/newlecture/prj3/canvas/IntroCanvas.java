package com.newlecture.prj3.canvas;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import com.newlecture.prj3.GameFrame;
import com.newlecture.prj3.entity.Button;
import com.newlecture.prj3.entity.IntroBackground;

public class IntroCanvas extends Canvas {

	private Button button;
	private Button button2;
	private Button[] buttons;
	private IntroBackground background;
	public static Canvas instance;
	
	public IntroCanvas() {
		instance = this;
		background = new IntroBackground();
		button = new Button(10,10,200,50,"Hello~!");
		button2 = new Button(10,100,200,50,"bye~!");
		buttons = new Button[2];
		buttons[0] = button;
		buttons[1] = button2;
				
		addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				
//				for(int i = 0; i<2; i++) {
//					if(buttons[i].contains(x,y))
						try {
							GameFrame.instance.switchCanvas(IntroCanvas.this, ActionCanvas.class);
						} catch (InstantiationException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IllegalAccessException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
//					JOptionPane.showMessageDialog(IntroCanvas.this, "클릭 : "+ i);// null값을 넣으면 바탕화면에 메세지, IntroCanvas.this를 넣으면 캔버스에 메세지
//				}
				super.mouseClicked(e);
			}
		});
	}
	
	public void paint(Graphics g) {
		Image buf = this.createImage(this.getWidth(), getHeight());
		Graphics bg = buf.getGraphics();
		
		background.paint(bg);
		button.paint(bg);
		button2.paint(bg);
		
		g.drawImage(buf, 0, 0, this);
	}
	
	public void update(Graphics g) {
	
		paint(g);
	}
	
}
