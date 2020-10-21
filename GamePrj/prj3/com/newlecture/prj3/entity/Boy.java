package com.newlecture.prj3.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.newlecture.prj3.canvas.ActionCanvas;

public class Boy extends Item {

	//	private double x;
	//	private double y;
	//	
	//	// �ִϸ��̼��� ���� ����
	//	private double vx;
	//	private double vy;
	//	private double dx;
	//	private double dy;
	//	
	//	private double width;
	//	private double height;
	//	private  Image img;
	//	
	//	private int movIndex = 0;
	//	private int speed = 3;
	//	private int walkTempo = 6;

	private final int UP = 1004; //final : ���� ������ �ʴ� Ư���� ���� ���ϰ� ���� ��   ������ �ƴ� ����� �ʿ��� ��                          
	private final int DOWN = 1005; //�빮�ڷ� ������ ���� ����� ������Ŵ
	private final int LEFT = 1006;
	private final int RIGHT = 1007;
	
	private BackMoveListener moveListener;

//	private int N = 0;
//	private int S = 0;
//	private int W = 0;
//	private int E = 0;

	private static Image img; // static :  (����) (�����տ���)������ �ν��Ͻ��� �ƴ� ���������� ó�� , ��������(�޼ҵ� �ۿ� static���� ������ ���Ÿ� (int x)������ �ƴ϶� �����Ѱ��ϻ�             

	static {			//����ƽ ������. ���α׷��� �ε� �ɶ� �� �ѹ��� ����Ǵ� ���� ������
		//(�Լ� �տ���)static : 
		try {
			img = ImageIO.read(new File("res/boy.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public void setMoveListener(BackMoveListener moveListener) {
		this.moveListener = moveListener;
	}

	public Boy() {
		this(100,100);
	}

	public Boy(double x, double y) {
		super(x, y, 64, 96, "res/boy.png");
	}

	//	public void move(double x, double y) {
	////		this.x = x;
	////		this.y = y;
	//		this.dx = x;
	//		this.dy = y;
	//		
	//		// ������ �ӵ��� �̵��ϴ� ��������
	//		double w = this.dx - this.x;
	//		double h = this.dy - this.y;
	//		double d = Math.sqrt(w*w + h*h);
	//		this.vx = w/d*speed;
	//		this.vy = h/d*speed;
	//		
	//		// ������ �ð����� �̵��ϴ� ��������
	//		//this.vx = (this.dx - this.x) / 15;
	//		//this.vy = (this.dy - this.y) / 15;
	//		
	////		this.x = x;
	////		this.y = y;
	//	}

	public void update() {

		double x = getX();
		double y = getY();
		double dx = getDx();
		double dy = getDy();//y-1
		double vx = getVx();
		double vy = getVy();//-1
		int movIndex = getMovIndex();

		// �������� �ڽ��� ����� ���� ��
		if((dx - 0.5 <= x && x <= dx + 0.5) && 
				(dy - 0.5 <= y && y <= dy + 0.5)) {			
			vx = 0;
			vy = 0;
			movIndex = 0;
		}

		x += vx;
		y += vy;

		this.setX(x);
		this.setY(y);
		this.setVx(vx);
		this.setVy(vy);
		this.setMovIndex(movIndex);

		if(moveListener != null) {
			//System.out.println(1);
			moveListener.onMove();
//			moveListener = null;                           
		}
	}

	public void paint(Graphics g) {//bg

		int w = (int)this.getWidth();
		int h = (int)this.getHeight();
		int x1 = (int)this.getX() - w/2;
		int y1 = (int)this.getY()- h+13;
		int x2 = x1+w;
		int y2 = y1+h;
		int walkTempo = getWalkTempo();
		int movIndex = getMovIndex();
		Image img = getImg();
		double vx = getVx();
		double vy = getVy();//-1

		if(vx != 0 || vy != 0) {
			if(walkTempo == 0) {
				movIndex++;
				movIndex = movIndex % 4;

				walkTempo = 6;
			}
			else
				walkTempo--;
		}

		int offsetX = movIndex*w;

		//		System.out.printf("index:%d, offset:%d\n", movIndex, offsetX);
		g.drawImage(img, x1, y1, x2, y2, 
				0+offsetX, 0, 0+w+offsetX, h, ActionCanvas.instance);
		setWalkTempo(walkTempo);
		setMovIndex(movIndex);
	}

	public boolean isSelected(int x, int y) {
		int w = (int)this.getWidth();
		int h = (int)this.getHeight();
		int x1 = (int)this.getX() - w/2;
		int y1 = (int)this.getY()- h+13;
		int x2 = x1+w;
		int y2 = y1+h;

		if((x1  < x && x < x2)  
				&& (y1 < y && y < y2))
			return true;
		return false;
	}

	@Override
	protected Image getImage() {
		// TODO Auto-generated method stub
		return img;
	}

	public void move(int key) {

		double x = this.getX();
		double y = this.getY();
		switch(key) {
		case UP:
			if(this.getHeight()<=y) {
				this.move(x , y-1);
			}
			break;

		case DOWN:
			if(y<=600-this.getHeight())
				this.move(x, y+1);
			break;

		case LEFT:
			if(this.getWidth()<=x)
				this.move(x-1,y);
			break;

		case RIGHT:
			if(x<=360-this.getWidth())
				this.move(x+1,y);
			break;
		default:
		}	
	}

	public Missile fire() {
		Missile missile = new Missile();
		
		double x = getX();
		double y = getY();
		
		missile.setX(x+20);
		missile.setY(y-10);
		
		return missile;
	}
}
