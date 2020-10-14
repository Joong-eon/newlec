package chapter7ex4_3;

import java.util.Scanner;


public class Program {

	public static void main(String[] args) {

		int turnOmokColor =0;
		int turn =0;
		OmokBoard omokBoard = new OmokBoard();
		OmokBowl blackBowl = new OmokBowl();
		OmokBowl whiteBowl = new OmokBowl();
		StatusBoard statusBoard = new StatusBoard();
		blackBowl.setOmokColor(0);
		whiteBowl.setOmokColor(1);
		statusBoard.setMyOmokColor(0);
		statusBoard.setTurnOmokColor(turnOmokColor);

		while(true) {
			// 초기 화면 출력
			if(turn ==0)
				omokBoard.print();
			statusBoard.print();
			blackBowl.print();
			whiteBowl.print();
			System.out.println();

			Scanner scan = new Scanner(System.in);
			System.out.println("x sp y>>");
			String line = scan.nextLine();
			String[] tokens = line.split(" ");
			int x = Integer.parseInt(tokens[0]);
			int y = Integer.parseInt(tokens[1]);

			//현재 차례에 해당되는 그릇에게 달라고 한다.
			Omok omok;
			if(turnOmokColor == 0) {
				omok = blackBowl.next();
				turnOmokColor++;
			}
			else {
				omok = whiteBowl.next();
				turnOmokColor--;
			}

			omok.setX(x);
			omok.setY(y);

			omokBoard.put(omok);

		}
	}

}
