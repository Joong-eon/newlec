import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Chapter3Ex5StringPromgram {

	public static void main(String[] args) throws IOException {

		// 정수, 실수, 문자, 부울 값
		// 문자열 : 문자들의 열 : 'h', 'e' ,'l' ,'l', 'o', 0, 'h', 'i', 0
		// "hello" -> 'h', 'e' ,'l' ,'l', 'o', 0
		// 값?(x) -> 문자열은 도구로 본다.

		// 문자열은 객체입니다. 객체는 도구이며 도구는 new를 통해서만 만들며
		// 그러한 도구들은 모두 기능을 함수로 내장하고 있다.

		String x = new String("hello");
		String y = "hello"; // 번역기
		// 객체는 그 자체가 방임
		String name = "dragon"; // name은 참조변수일뿐 dragon이 공간임--> new String("dragon");
		char ch = 'A'; // ch는 값변수임

		FileInputStream fis = new FileInputStream("C:\\Newlec\\workspace/data.txt");
		Scanner scan = new Scanner(fis);

		// ['1','2','3',32,'4','5','6',13,'7','8','9']
		String line;
		String word;
		String aaa;

		
		/*
		 * word = scan.next(); //스페이스 또는 엔터를 만날 때까지 읽어온다.
		 * System.out.println(word); //
		 * word = ['1','2','3',0] =>"123"
		 * 
		 * //[32,'4','5','6',13,'7','8','9']
		 * 
		 * line = scan.nextLine();//엔터(13)를 만날 때까지 읽어온다.
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

			//긍정적인 문장의 조건 : 읽어온 값이 50보다 큰 값만 출력 
			/* if (num>50) 
			 * System.out.println(num);
			 */

			//부정적으로 판단한 조건 : 50보다 작거나 같은 값은 출력x
			/*
			 * if(num<=50) 
			 * 	continue; 
			 * System.out.println(num);
			 */

			// 1. 짝수 번째 값을 출력하기
			/*
			 * if(i+1%2==0)      -------> i%2==1 이렇게 해도 되지만 인덱스와 순서를 맞추고, 보기 편하게 하기 위해서 
			 *  System.out.println(num); 
			 * i++;
			 */

			// 2. 짝수면서 50보다 큰 값만 출력하시오.
			/*
			 * if(i+1%2==0 && num>50)
				 *  System.out.println(num); 
				 *  i++;
				 */
			 
			 // 3. 4번째부터 출력하기
				
				
				 /*if(i+1>=4)
				  *System.out.println(num); 
				  *i++;
				 */
				 
			 // 4. 4번째까지 출력하기
				/*
				 * if(i+1<=4)
				 *  System.out.println(num); 
				 *  i++;
				 */
		}
		
		
		fis.close();
	}

}
