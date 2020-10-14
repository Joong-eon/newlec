package lotto;


import java.io.IOException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws IOException  {
		Scanner scan = new Scanner(System.in);
		EXIT:
			while(true) {
				System.out.println("┌──────────────────────────────────────────────────┐");
				System.out.println("│                  Lotto 관리 프로그램                                 │");
				System.out.println("└──────────────────────────────────────────────────┘");
				System.out.println("1. 번호 자동 생성");
				System.out.println("2. 번호 수동 생성");
				System.out.println("3. 내 로또 번호보기");
				System.out.println("4. 종료");
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
					System.out.println("대박나세요~");
					break EXIT;
				default:
					System.out.println("1~4번을 입력해주세요.");
				}
			}
	}
}
