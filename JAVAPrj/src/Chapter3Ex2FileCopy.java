import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Chapter3Ex2FileCopy {

	
	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Newlec\\workspace\\img1.bmp");
		//FileInputStream ��ü�� fis��� �̸����� �����Ͻÿ�. �� �� ������...bmp�̴�.
		FileOutputStream fos = new FileOutputStream("C:\\Newlec\\workspace\\img1-copy.bmp");
		//FileoutputStream ��ü�� fos��� �̸����� �����Ͻÿ�. �� �� ������...bmp�̴�.
		while(true){
			
			int b = fis.read();
			//fis ��ü�� read �Լ��� �̿��ؼ� 1����Ʈ�� �д´�. �װ��� ������ ���� b�� ��´�.
			//=fis ���ۿ��� 1����Ʈ�� �о ������ ���� b�� ��´�
			/*���࿡ b == -1�̸�
			������ (1. while�� ����� �ϴ� ��� / 2. ���μ����� ���� ����)*/
			
			if (b == -1)
				break;
			
			fos.write(b);
			//fos ��ü�� write �Լ��� �̿��ؼ� b�� �ִ� 1����Ʈ�� ��´�.
			//=fos ��ü�� b�� ���� ����(��´�.)
		}
	}
}
