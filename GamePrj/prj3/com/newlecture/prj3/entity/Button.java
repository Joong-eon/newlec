package com.newlecture.prj3.entity;

import java.awt.Color;
import java.awt.Graphics;

public class Button {

	private double x;
	private double y;
	private double width;
	private double height;
	private String text;
	
	public Button() {
		this(0,0,200,50, "Click");
	}
	public Button(double x, double y, double width, double height, String text) {
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.text = text;
	}
	
	
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.pink);
		g.fillRoundRect((int)x, (int)y, (int)width, (int)height, 20, 20);
		
		g.setColor(Color.BLACK);
		g.drawString(text, (int)x+10, (int)y+30);
		
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
