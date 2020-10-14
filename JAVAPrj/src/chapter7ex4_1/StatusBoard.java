package chapter7ex4_1;

public class StatusBoard {
	private int color;
	private int turn;
	
	public void print() {
		char imgTurn = '¡Ü';
		char imgMy = '¡Ü';
		
		if(color == 1) //Èò»öÀÌ¸é
			imgMy = '¡Ü';
		
		if(turn == 1) //Èò»öÀÌ¸é
			imgTurn = '¡Û';
		
		System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
		System.out.printf("       my Omok %c\tturn %c\n", 
									imgMy, imgTurn);
		System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}
	
	
}
