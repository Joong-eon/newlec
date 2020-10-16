package com.newlecture.prj3.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.newlecture.prj2.canvas.ActionCanvas;
import com.newlecture.prj3.canvas.IntroCanvas;

public class IntroBackground extends Item{

	private int width = 360;
	private int height = 1200;
	
	private static Image img;

	
	static {
		try {
			img = ImageIO.read(new File("res/bgimage.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public IntroBackground() {		
		this(0,0, "res/bgimage.jpg");
		// TODO Auto-generated constructor stub
	}

	public IntroBackground(double x, double y, String imgSrc) {
		super(x, y, imgSrc);

		Image img = getImg();
		
		width = img.getWidth(null);
		height = img.getHeight(null);
		
	}

	@Override
	public void paint(Graphics g) {
		//Image img = getImg();
		double x = getX();
		double y = getY();
		g.drawImage(img, (int)x, (int)y, IntroCanvas.instance);
//		int offsetY = this.offsetY;
//
//		g.drawImage(img, (int)x, (int)y-offsetY, ActionCanvas.instance);//-600->0
//		g.drawImage(img, (int)x, (int)y-offsetY-1200, ActionCanvas.instance);
	}

	@Override
	public void update() {
		// y값의 변화를 주도하고
//		timeoutForMoving--;
//		if(timeoutForMoving == 0) {
//			moving = 1;
//			offsetY -= moving;
//			timeoutForMoving = 1;
//			double x = this.getX();
//			double y = this.getY()-offsetY;
//			if(y<=0)
//				this.move(x,y);
//		}
		/*
		if((this.getDx() - 0.1 <= this.getX() && getX() <= this.getDx() + 0.1) && 
				(this.getDy() - 0.1 <= getY() && getY() <= this.getDy() + 0.1)) {			
			this.setVx(0);
			this.setVy(0);
			this.setMovIndex(0);
		}

		this.setX(this.getX()+this.getVx());
		this.setY(this.getY()+this.getVy());*/
		
	}

	@Override
	protected Image getImage() {
		// TODO Auto-generated method stub
		return img;
	}

}
