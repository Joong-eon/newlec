package OOP_Practice;

public class GoBoard {
	/*GoBoard에 필요한 요소
	 바둑판 초기화
	print()
	put(Stone stone);
	
	 */
	
	private char[][] board; // 1. 보드를 초기화 하기 위해 2차원 배열 선언
	
	public GoBoard() {//보드판 초기화(생성자)
		board = new char[20][20];
		
		for(int i=0;i<20;i++) {
			for(int j=0;j<20;j++) {
				board[i][j] = '┼';
			}
		}
	}
	
	public void print() {// 보드 출력
		for(int i=0;i<20;i++) {
			for(int j=0;j<20;j++) {
				System.out.print(this.board[i][j]);
			}System.out.println();
		}
	}
	
	public void put(Stone stone) { // stone을 인자로 받아서 stone의 색깔에 따라 배치
		char color = '●';
		
		if(stone.getColor() == 1)
			color = '○';
		
		this.board[stone.getX()-1][stone.getY()-1] = color;
	}
}
