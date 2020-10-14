
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.Scanner;

public class Practice {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException  {


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
				Scanner scan = new Scanner(System.in);
				int menu = scan.nextInt();


				switch(menu) {
				case 1:
					System.out.println("┌──────────────────────────────────────────────────┐");
					System.out.println("│                1.Lotto 번호 자동 생성                                │");
					System.out.println("└──────────────────────────────────────────────────┘");

					System.out.print("생성 개수 : ");
					int count = scan.nextInt();
					int[][] lottoNums = new int[count][6];
					Random rd = new Random();

					System.out.println("┌─────┬─────────────────────────────────────────────┐");
					System.out.println("│인덱스 │                    로또번호                                      │");
					System.out.println("├─────┼─────────────────────────────────────────────┤");
					for(int i=0; i<count; i++) {
						for(int j=0; j<6; j++) {
							lottoNums[i][j]=(rd.nextInt(45)+1);       
							for(int k=0; k<j; k++) {
								if(lottoNums[i][j]==lottoNums[i][k]) {
									j--;
									break;
								}
							}
						}
						System.out.printf("│  %2d │     %2d   %2d   %2d   %2d   %2d   %2d             │\n", i+1,
								lottoNums[i][0], lottoNums[i][1], lottoNums[i][2], lottoNums[i][3], lottoNums[i][4], lottoNums[i][5]);
					}
					System.out.println("└───────────────────────────────────────────────────┘");
					System.out.println();
					System.out.println("1. 저장하기");
					System.out.println("2. 상위메뉴로 가기");
					System.out.println(">");

					int menu1 = scan.nextInt();
					switch(menu1) {
					case 1:

						//메모장에 저장은 되지만 다시 프로그램을 돌리면 새 값이 저장되진 않음...
						FileOutputStream fos = new FileOutputStream("C:\\Newlec\\workspace\\자동로또.txt");
						PrintStream out = new PrintStream(fos, true, "UTF-8");
						for(int i=0; i<count; i++) {
							out.printf("%2d번째 자동 로또 번호 : %2d, %2d, %2d, %2d, %2d, %2d \n",i+1,
									lottoNums[i][0], lottoNums[i][1], lottoNums[i][2], lottoNums[i][3], lottoNums[i][4], lottoNums[i][5]);
						}
						System.out.println("저장되었습니다.");
						break;

					case 2:
						break;
					}
					break;

				case 2:
					System.out.println("┌──────────────────────────────────────────────────┐");
					System.out.println("│                2.Lotto 번호 수동 생성                                │");
					System.out.println("└──────────────────────────────────────────────────┘");
					System.out.println("번호를 입력하세요. (예 : 6, 7, 12, 20, 40, 45");
					System.out.println("(단, 그만 입력하려면 -1을 입력하세요.");
					System.out.println(">");
					
					int[][]lottoNums2 = null;
					int[][] tmp = null;
					boolean stop = true;
					int size = 0;

					while(stop) {
						int num= scan.nextInt() ;
						if(num==-1) {
							stop= false;
							break;
						}
						else if(0<num&&num<46) {
							if (size != 0) {
								tmp = new int[size+1][6];
								for(int i = 0; i < size; i++) {
									for(int j = 0; j < 6; j++) {
										tmp[i][j] = lottoNums2[i][j];
									}
								}
								lottoNums2 = tmp;
							}else {
								lottoNums2 = new int[size + 1][6];
							}
							lottoNums2[size][0]=num;
							for(int i=0; i<5;i++) {
								int num2 = scan.nextInt();
								lottoNums2[size][i+1]=num2;
							}

							System.out.print(">");
							size++;
						}
						else
							System.out.println("1~45의 숫자를 입력해주세요.");
					}
					//로또 수동 번호 출력 및 저장	
					System.out.println("┌─────┬─────────────────────────────────────────────┐");
					System.out.println("│인덱스 │                    로또번호                                      │");
					System.out.println("├─────┼─────────────────────────────────────────────┤");
					for(int i=0; i<size; i++) {
									System.out.printf("│  %2d │     %2d   %2d   %2d   %2d   %2d   %2d             │\n", i+1,
									lottoNums2[i][0], lottoNums2[i][1], lottoNums2[i][2], lottoNums2[i][3], lottoNums2[i][4], lottoNums2[i][5]);
					}
					System.out.println("└───────────────────────────────────────────────────┘");
					System.out.println();
					System.out.println("1. 저장하기");
					System.out.println("2. 상위메뉴로 가기");
					System.out.println(">");

					int menu2 = scan.nextInt();
					switch(menu2) {
					case 1:

						//메모장에 저장은 되지만 다시 프로그램을 돌리면 새 값이 저장되진 않음...
						FileOutputStream fos = new FileOutputStream("C:\\Newlec\\workspace\\자동로또.txt");
						PrintStream out = new PrintStream(fos, true, "UTF-8");
						for(int i=0; i<size; i++) {
							out.printf("%2d번째 자동 로또 번호 : %2d, %2d, %2d, %2d, %2d,   %2d  \n",i+1,
									lottoNums2[i][0], lottoNums2[i][1], lottoNums2[i][2], lottoNums2[i][3], lottoNums2[i][4], lottoNums2[i][5]);
						}
						System.out.println("저장되었습니다.");
						break;

					case 2:
						break;
					}
					break;

				case 3:
					System.out.println("┌──────────────────────────────────────────────────┐");
					System.out.println("│                3.내 Lotto 번호 보기                                   │");
					System.out.println("└──────────────────────────────────────────────────┘");
					//저장한 로또 번호 보여주기
					FileInputStream fis = new FileInputStream("C:\\Newlec\\workspace\\자동로또.txt");
					Scanner scan2 = new Scanner(fis,"UTF-8");
					
					while(scan2.hasNextLine()) {
						String line = scan2.nextLine();
						String[] str = line.split("");
						int size1 = str.length;
						for(int i=0; i<size1; i++) {
							System.out.printf("%s", str[i]);
						}
						System.out.println();
					}
					
					break;

				case 4:
					System.out.println("대박나세요~");
					break EXIT;
				}



			}
	}


}



