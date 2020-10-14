import java.io.IOException;

public class Chapter3Ex6TestProgram {

	public static void main(String[] args) throws IOException {

		for(int y=0; y<=11 ; y++) {
			if(y==0 || y==11)
				System.out.print(' ');
			else if(y>=1 && y<=10)
				System.out.print(y%10);
			
			for(int x = 0; x<=10 ; x++) 
				if(y==0)
					System.out.print('¦¨');
				else if(y==11)
					System.out.print('¦ª');
				else
						System.out.print('¦«');
				
			if(y==0 || y==11)
				System.out.println(' ');
			else if(y>=1 && y<=10)
				System.out.println(y%10);
		}
	
			
	}

}
