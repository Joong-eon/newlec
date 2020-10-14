import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;


public class Chapter4Ex7 {

   public static void main(String[] args) throws IOException {
	   
	   FileInputStream fis = new FileInputStream("C:\\Newlec\\workspace\\data2.txt");
	   Scanner scan = new Scanner(fis);
	   
	  
	   
	   //������ �ε�
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
		
	   //������ �迭�� �̿��� ������ ����� ���ϱ�
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

	   //�������
	   System.out.println("��������������������������������������������������������������������");
	   System.out.println("��             �������                          ��");
	   System.out.println("��������������������������������������������������������������������");
	   for(int j=0; j<row; j++) {
		   System.out.printf("%d�� ����: %d, ���: %5.2f\n",j+1, totals[j], avgs[j] );
	   }
	   System.out.printf("�� ���� : %d, �� ���: %5.2f\n", total, avg);
	   
	   
	   
   }

}