package chapter7ex4_3;

public class OmokBowl {

	private int omokColor;	
	private int omokSize;

	public OmokBowl() {
		omokColor = 0; // black
		omokSize = 100;
	}

	public void print() {
		char img = '°‹';

		if(omokColor == 1) //»Úªˆ¿Ã∏È
			img = '°€';

		System.out.printf("%c[%d] ", img, omokSize);
	}

	public int getOmokColor() {
		return omokColor;
	}

	public void setOmokColor(int omokColor) {
		this.omokColor = omokColor;
	}

	public int getOmokSize() {
		return omokSize;
	}

	public void setOmokSize(int omokSize) {
		this.omokSize = omokSize;
	}

	public Omok next() {

		Omok omok = new Omok();
		omokSize--;
		return omok;
	}



}
