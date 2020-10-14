import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;


public class Chapter4Ex7 {

   public static void main(String[] args) throws IOException {
	   
	   FileInputStream fis = new FileInputStream("C:\\Newlec\\workspace\\data2.txt");
	   Scanner scan = new Scanner(fis);
	   
	  
	   
	   //等檜攪 煎萄
	   int row = 3;
	   int col = 9;
	   int[][] kors = new int[row][col];
	   {
		   int j=0;
		   while(scan.hasNextLine()) {
			   String line = scan.nextLine();
			   String[] tokens = line.split(",");
			   for(int i=0; i<col; i++) {
				   kors [j][i]= Integer.parseInt(tokens[i]);
			   }
			   j++;
		   }
	   }	
	   scan.close();
	   fis.close();
		
	   //檜離錳 寡翮擊 檜辨и 識薄婁 ゎ敕擊 掘ж晦
	   int[] totals= new int[row];
	   float[] avgs = new float[row];

	   for(int j=0; j<row; j++) {
		   for(int i=0; i<col; i++){
			   totals[j] += kors[j][i];
			   avgs[j] = (float)totals[j]/col;
		   }
	   }
	   
	   int total = 0;
	   for(int i =0; i<3; i++) {
		   total+=totals[i];
	   }
	   float avg = (float)total/(row*col);

	   //撩瞳轎溘
	   System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
	   System.out.println("弛             撩瞳轎溘                          弛");
	   System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
	   for(int j=0; j<row; j++) {
		   System.out.printf("%d奩 識薄: %d, ゎ敕: %5.2f\n",j+1, totals[j], avgs[j] );
	   }
	   System.out.printf("識 識薄 : %d, 識 ゎ敕: %5.2f\n", total, avg);
	   
	   
	   
   }

}