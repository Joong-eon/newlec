package lotto;


import java.io.IOException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws IOException  {
		Scanner scan = new Scanner(System.in);
		EXIT:
			while(true) {
				System.out.println("��������������������������������������������������������������������������������������������������������");
				System.out.println("��                  Lotto ���� ���α׷�                                 ��");
				System.out.println("��������������������������������������������������������������������������������������������������������");
				System.out.println("1. ��ȣ �ڵ� ����");
				System.out.println("2. ��ȣ ���� ����");
				System.out.println("3. �� �ζ� ��ȣ����");
				System.out.println("4. ����");
				System.out.println(">");
				int menu = scan.nextInt();

				switch(menu) {
				case 1:
					Lotto.AutoNumber();
					break;
				case 2:
					Lotto.ManualNumber();
					break;
				case 3:
					Lotto.PrintNumber();
					break;
				case 4:
					System.out.println("��ڳ�����~");
					break EXIT;
				default:
					System.out.println("1~4���� �Է����ּ���.");
				}
			}
	}
}
