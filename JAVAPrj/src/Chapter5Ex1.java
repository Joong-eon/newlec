import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;


public class Chapter5Ex1 {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("C:\\Newlec\\workspace\\data4.txt");
		Scanner scan = new Scanner(fis, "UTF-8");

		int[] ids = new int[6];
		String [] names = new String[6];
		int[] kors = new int[6];

		int count = 0;
		{
			int i=0;
			while(scan.hasNextLine()) {
				String line = scan.nextLine();
				String [] tokens = line.split(",");
				ids[i] = Integer.parseInt(tokens[0]);
				names[i] = tokens[1];
				kors[i] = Integer.parseInt(tokens[2]);
				i++;
			}
			count = i;
		}

		scan.close();
		fis.close();

		for(int i=0; i<count; i++) {
			System.out.printf("id:%d 이름 :%s, 점수 :%d", ids[i], names[i], kors[i]);
			System.out.println();
		}
	}

}