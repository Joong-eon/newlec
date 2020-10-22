package com.newlecture.prj3.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.newlecture.prj3.canvas.ActionCanvas;

public class Missile extends Item {
	//dependency injection(di)->부품을 껴넣는다.(세터를 만들어서 부품을 주입)
	private MissileListener listener;
	
	private static Image img; 

	static { 
		try {
			img = ImageIO.read(new File("res/missile.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Missile() {
		this(0,0);
	}
	
	public Missile(double x, double y) {
		super(x, y, 20, 20, "res/missile.png");
	}
	
	@Override
	protected Image getImage() {
		// TODO Auto-generated method stub
		return img;
	}

	@Override
	public void update() {
		if(null != listener) {
			listener.onOut(this);
		}
		setY(getY()+1);
	}

	@Override
	public void paint(Graphics g) {
		int w = (int)this.getWidth();
		int h = (int)this.getHeight();
		int x1 = (int)this.getX() - w/2;
		int y1 = (int)this.getY()- h/2;
		int x2 = x1+w;
		int y2 = y1+h;
		Image img = getImg();
		
//		g.drawImage(img, x1, y1, x2, y2, 
//				0, 0, 0+w, h, ActionCanvas.instance);
		g.setColor(Color.RED);
		g.fillOval(x1, y1, w, h);
	}

	public void setListener(MissileListener listener) {
		this.listener = listener;
	}

}
