import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Chapter4Ex4 {

   public static void main(String[] args) throws IOException {
            
     //���ڿ� �迭
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
//----------------------���� ��ġ-------------------------
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
//----------------�� ��ġ--------------------
		int teamCount = 0; //�� ����
		int div = 4; //���� �ο�
		int total = list.length;
		
		for (int i =0; i<27; i++) {
		   
		   if(i%div==0) {
			   teamCount++;
			   if(teamCount<(total/div)+1)
				   System.out.printf("---%d��---\n", teamCount);
			   else 
					System.out.println("---��α�---"); 
		   } 
		   System.out.println(list[i]);
	   }
			   
	 //���ο� ���� ���� ���� �����ϴ� ����
	   //Random rand = new Random();
	   //System.out.println(rand.nextInt());
	   //System.out.println(rand.nextInt(6)+1);               //7�� ���� 0~6�� ������ 6+1�� 1~6�� ����
	   
		
	   //-----------------------------------
		//�ݺ����� ����� ���̸�
		//�ε����� �̿��ؼ� ���ڸ������ ��
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