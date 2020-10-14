package OOP_Practice;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		GoBoard goBoard = new GoBoard();
		StatusBoard status = new StatusBoard();
		StoneBowl bowl1 = new StoneBowl(); //흑돌
		StoneBowl bowl2 = new StoneBowl(); //백돌
		
		int x,y;
		int curColor=0;
		
		goBoard.print();
		bowl1.print();
		bowl2.setStoneColor(1);
		bowl2.print();
		System.out.println();
		status.print();
		System.out.println();
		
		Scanner scan = new Scanner(System.in);
		
		int count =0;
		while(count < 20) {
			if(curColor == 0) {
				System.out.print("돌을 놓을 위치를 입력하시오 예) x,y");
				String inputString = scan.nextLine();
				x = Integer.parseInt(inputString.split(",")[0]);
				y = Integer.parseInt(inputString.split(",")[1]);
				
				Stone s = bowl1.pickedStone();
				s.setX(x);
				s.setY(y);
				goBoard.put(s);
				goBoard.print();
				bowl1.print();
				bowl2.print();
				System.out.println();
				status.setMyColor(1);
				status.setTurn(1);
				status.print();
				curColor++;
			}
			else {
				System.out.print("돌을 놓을 위치를 입력하시오 예) x,y");
				String inputString = scan.nextLine();
				x = Integer.parseInt(inputString.split(",")[0]);
				y = Integer.parseInt(inputString.split(",")[1]);
				
				Stone s = bowl2.pickedStone();
				s.setX(x);
				s.setY(y);
				goBoard.put(s);
				goBoard.print();
				bowl1.print();
				bowl2.print();
				System.out.println();
				status.setMyColor(0);
				status.setTurn(0);
				status.print();
				curColor--;
			}
			count++;
		}
		scan.close();
	}
}
