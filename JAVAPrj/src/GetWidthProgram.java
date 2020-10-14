import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GetWidthProgram {

	public static void main(String[] args) throws IOException {
	
		FileInputStream fis = new FileInputStream("C:\\Newlec\\workspace\\img1.bmp");
		
		//fis.readNBytes(18);
		
		/*
		 * fis.read(); fis.read(); fis.read(); fis.read(); fis.read(); fis.read();
		 * fis.read(); fis.read(); fis.read(); fis.read(); fis.read(); fis.read();
		 * fis.read(); fis.read(); fis.read(); fis.read(); fis.read(); fis.read(); 18¹ø
		 */
		
		int b1 = fis.read();
		int b2 = fis.read();
		int b3 = fis.read();
		int b4 = fis.read();
		
		int width = (b4 & 0xff) << 24 |   //[0][0][0][b1] ->[b1][0][0][0]
				   (b3 & 0xff) << 16 |   //[0][0][0][b2] ->[0][b2][0][0]
				   (b2 & 0xff) << 8  |   //[0][0][0][b3] ->[0][0][b3][0]
				   (b1 & 0xff) ;          //[0][0][0][b4]
		//[b1][b2][b3][b4] : BE => [b4][b3][b2][b1] : LE
		
		System.out.printf("file size is %d\n", width);
		
		int x = 5;
		int y;
		
		x++;//6
		y= ++x;//y=x=7
		System.out.println(y);
		y= x++;//y=7 x=8
		System.out.println(y);
		System.out.println(x);
	}

}
