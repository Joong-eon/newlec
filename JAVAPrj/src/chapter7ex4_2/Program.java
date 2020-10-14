package chapter7ex4_2;

import chapter7ex4_1.OmokBoard;

public class Program {

	public static void main(String[] args) {

		OmokBoard omokBoard = new OmokBoard();
		OmokBowl blackBowl = new OmokBowl();
		OmokBowl whiteBowl = new OmokBowl();
		
		blackBowl.setOmokColor(0);
		whiteBowl.setOmokColor(1);
		
		
		omokBoard.print();
		blackBowl.print();
		whiteBowl.print();
	}

}
