import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;


public class Chapter4Ex1Array {

	
	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Newlec\\workspace\\data.txt");
		FileOutputStream fos = new FileOutputStream("C:\\Newlec\\workspace\\data-copy.txt");
		Scanner scan = new Scanner(fis);
		
		// 1. ����(int) �迭 nums��� �̸����� ���� 10��¥�� �迭�� �������ּ���.
		
		int [] nums = new int[10];
		
		for(int i=0; i<8; i++) {
			//2. nums �迭 ù��° ��ġ��  data.txt���� ù��° ��(60)�� �о ��������.
			nums[i] = scan.nextInt();
			System.out.printf("%d ", nums[i]);
		}

		
		fis.close();
		fos.close();
		
	}
}
