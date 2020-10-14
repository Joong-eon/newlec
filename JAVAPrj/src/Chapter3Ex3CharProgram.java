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
		//ȸ���� ���� A~13 ��° ���������� A~MA~M���ʹ�  ���� if���� ������� �ʱ�
		int k =0;
		while(k<alphaSize) {
			//���⼭ �ݺ���
			//1. Ư���� �ݺ����� �ε����� �ִ�. �� ���� �̿��ض�
			//2. 1�� ���� �Ǵ� �ε����� �������� ����� �� �־���� �Ѵ�.
			//-�� : A-Z ->Z-A
			//fos. write('A'+alphaSize - k);
			//3. �ݺ������� ȸ�������� ����϶� A~M A~M���ʹ�... �� if���� �����������
			fos.write('A'+(k%13));
			k++;
		}
		
		fos.flush();
		
		fos.close();
		
	}

}
