import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Chapter3Ex5StringPromgram {

	public static void main(String[] args) throws IOException {

		// ����, �Ǽ�, ����, �ο� ��
		// ���ڿ� : ���ڵ��� �� : 'h', 'e' ,'l' ,'l', 'o', 0, 'h', 'i', 0
		// "hello" -> 'h', 'e' ,'l' ,'l', 'o', 0
		// ��?(x) -> ���ڿ��� ������ ����.

		// ���ڿ��� ��ü�Դϴ�. ��ü�� �����̸� ������ new�� ���ؼ��� �����
		// �׷��� �������� ��� ����� �Լ��� �����ϰ� �ִ�.

		String x = new String("hello");
		String y = "hello"; // ������
		// ��ü�� �� ��ü�� ����
		String name = "dragon"; // name�� ���������ϻ� dragon�� ������--> new String("dragon");
		char ch = 'A'; // ch�� ��������

		FileInputStream fis = new FileInputStream("C:\\Newlec\\workspace/data.txt");
		Scanner scan = new Scanner(fis);

		// ['1','2','3',32,'4','5','6',13,'7','8','9']
		String line;
		String word;
		String aaa;

		
		/*
		 * word = scan.next(); //�����̽� �Ǵ� ���͸� ���� ������ �о�´�.
		 * System.out.println(word); //
		 * word = ['1','2','3',0] =>"123"
		 * 
		 * //[32,'4','5','6',13,'7','8','9']
		 * 
		 * line = scan.nextLine();//����(13)�� ���� ������ �о�´�.
		 * System.out.println(line);
		 * //['4','5','6',0] => "456"
		 * 
		 * //['7','8','9']
		 * 
		 * aaa = scan.nextLine();
		 * System.out.println(aaa); 
		 //['7','8','9',0] => "789" */
		 

		int num;
		int i = 0;

		while(scan.hasNextInt()) {
			num = scan. nextInt();

			//�������� ������ ���� : �о�� ���� 50���� ū ���� ��� 
			/* if (num>50) 
			 * System.out.println(num);
			 */

			//���������� �Ǵ��� ���� : 50���� �۰ų� ���� ���� ���x
			/*
			 * if(num<=50) 
			 * 	continue; 
			 * System.out.println(num);
			 */

			// 1. ¦�� ��° ���� ����ϱ�
			/*
			 * if(i+1%2==0)      -------> i%2==1 �̷��� �ص� ������ �ε����� ������ ���߰�, ���� ���ϰ� �ϱ� ���ؼ� 
			 *  System.out.println(num); 
			 * i++;
			 */

			// 2. ¦���鼭 50���� ū ���� ����Ͻÿ�.
			/*
			 * if(i+1%2==0 && num>50)
				 *  System.out.println(num); 
				 *  i++;
				 */
			 
			 // 3. 4��°���� ����ϱ�
				
				
				 /*if(i+1>=4)
				  *System.out.println(num); 
				  *i++;
				 */
				 
			 // 4. 4��°���� ����ϱ�
				/*
				 * if(i+1<=4)
				 *  System.out.println(num); 
				 *  i++;
				 */
		}
		
		
		fis.close();
	}

}
