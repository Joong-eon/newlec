package chapter7ex4_3;

public class OmokBoard {

	private char[][] buf;
	
	public OmokBoard() {
		buf = new char[20][20];
		for(int y=1; y<=20; y++) {
			for(int x=1; x<=20; x++)
				buf[y-1][x-1] = '¦«';
		}
	}
	public void print() {
		
		for(int y=1; y<=20; y++) {
			for(int x=1; x<=20; x++)
				System.out.print(buf[y-1][x-1]);
			
			System.out.println();
		}
		
	}

	public void put(Omok omok) {
		int x = omok.getX();
		int y = omok.getY();
		int color = omok.getColor();
		
		char omokImg = '¡Ü';
		if(color == 1) {
			omokImg = '¡Û';
		}
		buf[y][x] = omokImg;
		
	}

	
}
