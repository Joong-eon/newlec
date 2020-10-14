import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Chapter4Ex4 {

   public static void main(String[] args) throws IOException {
            
     //문자열 배열
	   int[] nums = new int[27];
	   String[] list = new String[27];
	    
	   FileInputStream fis = new FileInputStream("C:\\Newlec\\workspace\\list.txt");
	   Scanner scan = new Scanner(fis, "UTF-8");
			
	   String name;
	   {
		   int i= 0;
		   while(scan.hasNextLine()) {
			   name = scan.nextLine();
			   list[i] = name;
			   i++;
		   }
	   }
	   fis.close();
//----------------------랜덤 배치-------------------------
		{
			Random rand = new Random();
			for (int i = 0; i < 1000; i++) {
				int s = rand.nextInt(27);
				int d = rand.nextInt(27);

				String temp;
				temp = list[s];
				list[s] = list[d];
				list[d] = temp;
			}
		}
//----------------조 배치--------------------
		int teamCount = 0; //팀 갯수
		int div = 4; //팀당 인원
		int total = list.length;
		
		for (int i =0; i<27; i++) {
		   
		   if(i%div==0) {
			   teamCount++;
			   if(teamCount<(total/div)+1)
				   System.out.printf("---%d조---\n", teamCount);
			   else 
					System.out.println("---깍두기---"); 
		   } 
		   System.out.println(list[i]);
	   }
			   
	 //새로운 도구 랜덤 값을 제공하는 도구
	   //Random rand = new Random();
	   //System.out.println(rand.nextInt());
	   //System.out.println(rand.nextInt(6)+1);               //7을 쓰면 0~6이 나오고 6+1은 1~6이 나옴
	   
		
	   //-----------------------------------
		//반복문을 사용할 것이며
		//인덱스를 이용해서 숫자를출력할 것
		// 1  2  3  4  5  6  7
		// 8  9  10 11 12 13 14
		//15  16 17 18 19 20 21
		//22  23 24 25 26 27 28
		//29  30 31
		

		for(int i=1; i<=31; i++) {
			System.out.printf("%2d  ", i);
			if(i%7==0)
				System.out.println();
		}
		
		

	   
	   
   }

}