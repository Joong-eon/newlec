import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReadProgram {

	public static void main(String[] args) throws IOException {
	
		FileInputStream fis = new FileInputStream("C:\\Newlec\\workspace\\img1.bmp");
		fis.read();
		fis.read();
		
		int b1 =  fis.read();
		int b2 =  fis.read();
		int b3 =  fis.read();
		int b4 =  fis.read();
		
		int size = (b4 & 0xff) << 24 |   //[0][0][0][b1] ->[b1][0][0][0]
				   (b3 & 0xff) << 16 |   //[0][0][0][b2] ->[0][b2][0][0]
				   (b2 & 0xff) << 8  |   //[0][0][0][b3] ->[0][0][b3][0]
				   (b1 & 0xff) ;          //[0][0][0][b4]
		//[b1][b2][b3][b4] : BE => [b4][b3][b2][b1] : LE
		//0x정수 ==16진수 정수   f=1111 => 1111 1111
		
		System.out.printf("file size is %d\n", size);
	}

}
