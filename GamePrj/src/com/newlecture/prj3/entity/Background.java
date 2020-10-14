package com.newlecture.prj3.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.newlecture.prj2.canvas.ActionCanvas;

public class Background extends Item{

	private int width = 360;
	private int height = 1200;
	private int timeoutForMoving = 60;
	private int offsetY = height - 600;
	private int  moving;
	private static Image img;

	
	static {
		try {
			img = ImageIO.read(new File("res/space.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Background() {		
		this(0,0, "res/space.jpg");
		// TODO Auto-generated constructor stub
	}

	public Background(double x, double y, String imgSrc) {
		super(x, y, imgSrc);

		Image img = getImg();
		//		int w = img.getWidth(ActionCanvas.instance);
		//		System.out.println(w);
	}

	@Override
	public void paint(Graphics g) {
		Image img = getImg();
		double x = getX();
		double y = getY();
		int offsetY = this.offsetY;

		g.drawImage(img, (int)x, (int)y-offsetY, ActionCanvas.instance);//-600->0
		g.drawImage(img, (int)x, (int)y-offsetY-1200, ActionCanvas.instance);
	}

	@Override
	public void update() {
		// y값의 변화를 주도하고
		timeoutForMoving--;
		if(timeoutForMoving == 0) {
			moving = 1;
			offsetY -= moving;
			timeoutForMoving = 1;
			double x = this.getX();
			double y = this.getY()-offsetY;
			if(y<=0)
				this.move(x,y);

		}
	}

	@Override
	protected Image getImage() {
		// TODO Auto-generated method stub
		return img;
	}

}
