package chapter7ex4_1;

//학습내용
//객체지향 프로그래밍
//1.용어 이해
//2.견본을 봐야해 : 오목 프로그램


public class Program {

	public static void main(String[] args) {
		OmokBoard omokBoard = new OmokBoard();
		StatusBoard statusBoard = new StatusBoard();
		OmokBowl bowl = new OmokBowl();
		
		
		int x, y;
		
		int turnIndex = 0;
		
		// 초기 기본화면 출력
		omokBoard.print();
		statusBoard.print();
		bowl.print();
		
		
		
		
	}

}
