package chapter7ex4_2;

public class OmokBowl {
	
	int omokColor;
	int omokSize;
	
	public OmokBowl() {
		omokColor = 0; //0�� black
		omokSize = 100;
		
	}
	
	public int getOmokColor() {
		return omokColor;
	}

	public void setOmokColor(int omokColor) {
		this.omokColor = omokColor;
	}

	public void print() {
	
		char img = '��';
		if(omokColor == 1)
			img = '��';

		System.out.printf(" %c %d\n", img, omokSize);
	}
	
	
	
	
	
	
	
	
//	private int omokColor;
//	private int omokSize;
//	
//	public OmokBowl() {
//		omokColor = 0; //0�� black
//		omokSize = 100;
//	}
//	public void print() {
//		char img = '��';
//		
//		if(omokColor ==1)
//			img = '��';
//		System.out.printf("%c [%d]", img, omokSize);
//	}
//	public int getOmokColor() {
//		return omokColor;
//	}
//	public void setOmokColor(int omokColor) {
//		this.omokColor = omokColor;
//	}

}
