package chapter7ex4_2;

public class OmokBoard {

	int size = 20;
	
	public void print() {
		for(int y=0; y<=size; y++) {
			for(int x=0; x<=size; x++) {
				System.out.print("¦«");
			}
			System.out.println();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	int size = 20;
//	char [][] buf = new char[size][size];
//
//	public OmokBoard() {
//		for(int y=1; y<=size; y++) {
//			for(int x=1; x<=size; x++) {
//				buf[x][y] = '¦«';
//			}
//		}
//	}
//	void print() {
//		for(int y=1; y<=size; y++) {
//			for(int x=1; x<=size; x++) {
//				System.out.printf("%c", buf[x][y]);				
//			}
//			System.out.println();
//		}
//	}
}
