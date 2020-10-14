package chapter7ex4_1;

public class Omok {
	private int color; // black 0, white 1
	private int x;
	private int y;
	
	public Omok() {
		color = 0; //black color
	}
	
	public void print() {
		switch(color){
		case 0: // black
			System.out.print("¡Ü");
			break;
		case 1: // white
			System.out.print("¡Û");
			break;
		}
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
}
