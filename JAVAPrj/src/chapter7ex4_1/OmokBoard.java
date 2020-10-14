package chapter7ex4_1;

public class OmokBoard {
	
	char[][] buf = new char[20][20];
	
	public OmokBoard() {
		for(int y=1; y<=20; y++)
			for(int x=1; x<=20; x++)
				buf[y-1][x-1] = '¦«';
	}
	
	public void print() {
		for(int y=1; y<=20; y++) {
			for(int x=1; x<=20; x++)
				System.out.print(buf[y-1][x-1]);
			
			System.out.println();
		}
	}
	
	public void put(Omok omok) {
		
	}
}
