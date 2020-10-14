package lotto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.Scanner;

public class Lotto {
	static Scanner scan = new Scanner(System.in);

	public static void AutoNumber() throws FileNotFoundException, UnsupportedEncodingException {
		System.out.println("��������������������������������������������������������������������������������������������������������");
		System.out.println("��                1.Lotto ��ȣ �ڵ� ����                                ��");
		System.out.println("��������������������������������������������������������������������������������������������������������");

		System.out.print("���� ���� : ");
		int count = scan.nextInt();
		int[][] lottoNums = new int[count][6];
		Random rd = new Random();

		System.out.println("����������������������������������������������������������������������������������������������������������");
		System.out.println("���ε��� ��                    �ζǹ�ȣ                                      ��");
		System.out.println("����������������������������������������������������������������������������������������������������������");
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
			for(int j=0; j<lottoNums.length;j++) {
				for(int k=0; k<lottoNums.length-1-j; k++)
					if(lottoNums[i][k]>lottoNums[i][k+1]) {
						int temp;
						temp = lottoNums[i][k];
						lottoNums[i][k] = lottoNums[i][k+1];
						lottoNums[i][k+1] = temp;
					}
			}
		}


		for(int i=0; i<count; i++) {	
			System.out.printf("��  %2d ��     %2d   %2d   %2d   %2d   %2d   %2d             ��\n", i+1,
					lottoNums[i][0], lottoNums[i][1], lottoNums[i][2], lottoNums[i][3], lottoNums[i][4], lottoNums[i][5]);
		}
		System.out.println("����������������������������������������������������������������������������������������������������������");
		System.out.println();
		System.out.println("1. �����ϱ�");
		System.out.println("2. �����޴��� ����");
		System.out.println(">");

		int menu1 = scan.nextInt();
		switch(menu1) {
		case 1:
			//�޸��忡 ������ ������ �ٽ� ���α׷��� ������ �� ���� ������� ����...
			FileOutputStream fos = new FileOutputStream("res/�ζ�.txt");
			PrintStream out = new PrintStream(fos, true, "UTF-8");
			for(int i=0; i<count; i++) {
				out.printf("%2d��° �ڵ� �ζ� ��ȣ : %2d, %2d, %2d, %2d, %2d, %2d \n",i+1,
						lottoNums[i][0], lottoNums[i][1], lottoNums[i][2], lottoNums[i][3], lottoNums[i][4], lottoNums[i][5]);
			}
			System.out.println("����Ǿ����ϴ�.");
			break;
		case 2:
			break;
		}
	}

	public static void ManualNumber() throws FileNotFoundException, UnsupportedEncodingException {
		System.out.println("��������������������������������������������������������������������������������������������������������");
		System.out.println("��                2.Lotto ��ȣ ���� ����                                ��");
		System.out.println("��������������������������������������������������������������������������������������������������������");
		System.out.println("��ȣ�� �Է��ϼ���. (�� : 6, 7, 12, 20, 40, 45");
		System.out.println("(��, �׸� �Է��Ϸ��� -1�� �Է��ϼ���.");
		System.out.println(">");

		int[][]lottoNums2 = null;
		int[][] tmep = null;
		boolean stop = true;
		int size = 0;

		while(stop) {
			int num= scan.nextInt() ;
			if(num==-1) {
				stop= false;
				break;
			}
			else if(0<num&&num<46) {
				if (size == 0) {
					lottoNums2 = new int[size + 1][6];
				}
				else {
					tmep = new int[size+1][6];
					for(int i = 0; i < size; i++) {
						for(int j = 0; j < 6; j++) {
							tmep[i][j] = lottoNums2[i][j];
						}
					}
					lottoNums2 = tmep;
				}
				lottoNums2[size][0]=num;
				for(int i=0; i<5;i++) {
					int num2 = scan.nextInt();
					lottoNums2[size][i+1]=num2;
					for(int j=0; j<=i; j++) {
						if(lottoNums2[size][j]==lottoNums2[size][i+1]) {
							i--;
							System.out.println("�ߺ��� �����Դϴ�.");
						}
					}
				}
				size++;
				for(int i =0; i<size; i++) {
					for(int j=0; j<lottoNums2.length;j++) {
						for(int k=0; k<lottoNums2.length-1-j; k++)
							if(lottoNums2[i][k]>lottoNums2[i][k+1]) {
								int temp;
								temp = lottoNums2[i][k];
								lottoNums2[i][k] = lottoNums2[i][k+1];
								lottoNums2[i][k+1] = temp;
							}
					}
				}

				System.out.print(">");
			}
			else
				System.out.println("1~45�� ���ڸ� �Է����ּ���.");
		}
		//�ζ� ���� ��ȣ ��� �� ����	
		System.out.println("����������������������������������������������������������������������������������������������������������");
		System.out.println("���ε��� ��                    �ζǹ�ȣ                                      ��");
		System.out.println("����������������������������������������������������������������������������������������������������������");
		for(int i=0; i<size; i++) {
			System.out.printf("��  %2d ��     %2d   %2d   %2d   %2d   %2d   %2d             ��\n", i+1,
					lottoNums2[i][0], lottoNums2[i][1], lottoNums2[i][2], lottoNums2[i][3], lottoNums2[i][4], lottoNums2[i][5]);
		}
		System.out.println("����������������������������������������������������������������������������������������������������������");
		System.out.println();
		System.out.println("1. �����ϱ�");
		System.out.println("2. �����޴��� ����");
		System.out.println(">");

		int menu2 = scan.nextInt();
		switch(menu2) {
		case 1:
			FileOutputStream fos = new FileOutputStream("res/�ζ�.txt");
			PrintStream out = new PrintStream(fos, true, "UTF-8");
			for(int i=0; i<size; i++) {
				out.printf("%2d��° �ڵ� �ζ� ��ȣ : %2d, %2d, %2d, %2d, %2d, %2d\n",i+1,
						lottoNums2[i][0], lottoNums2[i][1], lottoNums2[i][2], lottoNums2[i][3], lottoNums2[i][4], lottoNums2[i][5]);
			}
			System.out.println("����Ǿ����ϴ�.");
			break;

		case 2:
			break;
		}

	}

	public static void PrintNumber() throws IOException {
		System.out.println("��������������������������������������������������������������������������������������������������������");
		System.out.println("��                3.�� Lotto ��ȣ ����                                   ��");
		System.out.println("��������������������������������������������������������������������������������������������������������");
		//������ �ζ� ��ȣ �����ֱ�
		FileInputStream fis = new FileInputStream("C:\\Newlec\\workspace\\�ζ�.txt");
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
		fis.close();
	}
}
