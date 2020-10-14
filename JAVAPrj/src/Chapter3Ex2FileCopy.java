import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Chapter3Ex2FileCopy {

	
	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Newlec\\workspace\\img1.bmp");
		//FileInputStream 객체를 fis라는 이름으로 생성하시오. 그 때 파일은...bmp이다.
		FileOutputStream fos = new FileOutputStream("C:\\Newlec\\workspace\\img1-copy.bmp");
		//FileoutputStream 객체를 fos라는 이름으로 생성하시오. 그 때 파일은...bmp이다.
		while(true){
			
			int b = fis.read();
			//fis 객체의 read 함수를 이용해서 1바이트를 읽는다. 그것을 정수형 변수 b에 담는다.
			//=fis 버퍼에서 1바이트를 읽어서 정수형 변수 b에 담는다
			/*만약에 b == -1이면
			끝내기 (1. while을 벗어나게 하는 방법 / 2. 프로세스를 강제 종료)*/
			
			if (b == -1)
				break;
			
			fos.write(b);
			//fos 객체에 write 함수를 이용해서 b에 있는 1바이트를 담는다.
			//=fos 객체에 b의 값을 쓴다(담는다.)
		}
	}
}
