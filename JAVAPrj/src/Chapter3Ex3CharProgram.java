import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Chapter3Ex3CharProgram {

	public static void main(String[] args) throws IOException {
		
		
		FileOutputStream fos = new FileOutputStream("C:\\Newlec\\workspace\\data.txt");
		
		fos.write(3);
		fos.write(65); //  65 -> A
		fos.write(66); //  66 -> B
		fos.write(67); //  67 -> C
		fos.write('A'+1); //B
		
		int alphaSize = 'Z' - 'A' +1; // 26
		int i = 0;
		while(i< alphaSize) {
			//
			fos.write('A'+ i);
			i++;}
		System.out.println();
		//----------------------------------------------
		
		int j = 0;
		while(j<alphaSize) {
			fos.write('Z'-j);
			j++;
		}
		
		//-------------------------------
		//회귀형 순서 A~13 번째 순차적으로 A~MA~M부터는  조건 if문을 사용하지 않기
		int k =0;
		while(k<alphaSize) {
			//여기서 반복해
			//1. 특정수 반복에는 인덱스가 있다. 그 값을 이용해라
			//2. 1씩 증가 되는 인덱스를 역순으로 사용할 수 있어야하 한다.
			//-예 : A-Z ->Z-A
			//fos. write('A'+alphaSize - k);
			//3. 반복적으로 회귀형으로 출력하라 A~M A~M부터는... 단 if문은 사용하지말기
			fos.write('A'+(k%13));
			k++;
		}
		
		fos.flush();
		
		fos.close();
		
	}

}
