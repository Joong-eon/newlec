package OOP_Practice;

public class StatusBoard {
	/*상황판에 필요한 요소
	 myColor, turn 속성
	 속성 초기화
	 setMyColor(), setTurn() 메소드
	  print()
	  
	 */
	
	private int myColor;//초기화 하고자 하는 속성(데이터)를 선언
	private int turn;
	
	public StatusBoard() {//생성자
		this.myColor = 0; // black 초기화
		this.turn = 0;
	}

	public void setMyColor(int myColor) {//내 돌의 색을 변경하기 위한 setter
		this.myColor = myColor;
	}

	public void setTurn(int turn) { // 현재 차례를 변경하기 위한 setter
		this.turn = turn;
	}
	
	public void print() {//내 돌의 색과 현재 차례를 출력
		char my = '●';//기본값을 black으로 하고, 
		char t = '●';
		
		if(this.myColor == 1)//내 돌의 색이 white일 경우에 변경
			my = '○';
		
		if(this.turn == 1) 
			t = '○';
		
		System.out.printf("내 돌 : %c , 현재 차례 : %c",my, t);
	}
	
	
}
