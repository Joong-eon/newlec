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

			System.out.println("<<�޴�>>");
			System.out.println("1. �� �߰�");
			System.out.println("2. ���� ���");
			System.out.println("3. ¦���� ������ ���");
			System.out.println("4. ����");

			Scanner scan = new Scanner(System.in);
			int menu = scan.nextInt();

			switch(menu) {
			case 1:
				System.out.print("���߰� >");
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
				System.out.println("��!!");
				break EXIT;

			default:
				
				System.out.println("1~4���� �Է��ϼ���!!");	
			}
		}
	}


	

}
