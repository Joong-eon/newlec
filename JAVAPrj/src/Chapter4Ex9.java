import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;


public class Chapter4Ex9 {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("C:\\Newlec\\workspace\\img1.cmp");
		FileOutputStream fos = new FileOutputStream("C:\\Newlec\\workspace\\img1-reverse.cmp");
		Scanner scan = new Scanner(fis, "UTF-8");
		PrintStream out = new PrintStream(fos, true, "UTF-8"); //출력 스트림
		
		String  line = scan.nextLine();
		String[] str = line.split("");

		scan.close();
		fis.close();

		int size = line.length();//19
		
//		for(int i=0; i<((size/2)); i++) {
//			int lastNum = size-i-1;
//			String room;
//			room= str[i];
//			str[i]= str[lastNum];
//			str[lastNum]= room;	
//		}
		
		for(int i=0; i<size; i++) {
			System.out.printf("%s", str[i]);
		}
		System.out.println();
		for(int i=0; i<size; i++) {
			out.printf("%s", str[size-i-1]);// 데이터 저장
		}
		System.out.println();
		System.out.println("작업완료");
		
//		for(int i=0; i<size; i++) {
//			byte[] temp = str[size-1-i].getBytes();
//			fos.write(temp);
//		}
//		fos.close();
	}

}