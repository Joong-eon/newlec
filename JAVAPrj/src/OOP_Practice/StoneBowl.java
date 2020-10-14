package OOP_Practice;

public class StoneBowl {
	/* StoneBowl에 필요한 요소
	  stone 100개
	  stoneColor, size(100개)
	  pickedStone() 메서드
	  print()
	  
	 */
	
	private int stoneColor;//그릇에 들어갈 돌의 색깔 저장을 위해 변수 선언
	private int size; // 그릇에 들어갈 돌의 갯수 저장을 위해 변수 선언
	private Stone[] stone; // 그릇에 실제로 들어갈 stone 객체 생성을 위한 변수 선언
	
	public StoneBowl() {//생성자
		this.stoneColor = 0; // black으로 돌 색깔 초기화
		this.size = 100; // 돌의 갯수는 100개로 초기화
		this.stone = new Stone[100]; // 돌 100개 배열 생성
		
		for(int i=0;i<size;i++) {
			this.stone[i] = new Stone(); // 각 돌의 객체 생성
			this.stone[i].setColor(this.stoneColor); // 돌의 색깔 초기화
		}
	}
	
	public void setStoneColor(int stoneColor) {//돌의 색을 변경하기 위한 setter
		this.stoneColor = stoneColor;
		for(int i=0;i<size;i++) {
			this.stone[i].setColor(stoneColor);
		}
	}
	
	public void print() {//돌의 색깔과 해당 돌의 갯수 출력
		char sc = '●';
		
		if(this.stoneColor == 1)
			sc = '○';
		
		System.out.printf("%c [%d]",sc,size);
	}
	
	public Stone pickedStone() { // 돌을 꺼냄
		Stone prot = new Stone(); //public 메소드에서 private 배열을 return하지 않기
								//위해서 복제를 위한 Stone 변수 prototype 객체 생성
		
		prot = this.stone[(size)-1];//돌 배열의 마지막 것부터 꺼냄
		this.stone[(size--)-1]= null;//사용한 돌 이 참조하는 객체가 없도록 null
		return prot;
	}
}
