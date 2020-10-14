package chapter6ex4;

import java.io.IOException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws IOException {

		NumList list = new NumList();	      
		list.size = 0;
		list.nums = null;

		NumList.load(list);

		EXIT:
		while(true) {

			System.out.println("<<메뉴>>");
			System.out.println("1. 값 추가");
			System.out.println("2. 총합 출력");
			System.out.println("3. 짝수의 갯수를 출력");
			System.out.println("4. 종료");

			Scanner scan = new Scanner(System.in);
			int menu = scan.nextInt();

			switch(menu) {
			case 1:
				System.out.print("값추가 >");
				int num = scan.nextInt();
				NumList.add(list, num);
				break;

			case 2:
				int total = NumList.sum(list);
				System.out.println(total);
				break;

			case 3:
				int count = NumList.getEvenNumberCount(list);
				System.out.println(count);
				break;

			case 4:
				System.out.println("끝!!");
				break EXIT;

			default:
				
				System.out.println("1~4까지 입력하세요!!");	
			}
		}
	}


	

}
