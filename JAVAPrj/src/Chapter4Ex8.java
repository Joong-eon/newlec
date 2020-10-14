import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;


public class Chapter4Ex8 {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("C:\\Newlec\\workspace\\data3.txt");
		Scanner scan = new Scanner(fis);

		//	   int[] nums1 = new int[] {1,2,3,4,5};
		//	   int[] nums2 = {6,7,8};
		//	   
		//	   int[][]nums= new int[2][];
		//	   nums[0]= nums1;
		//	   nums[1]= nums2;
		//	   
		//	   nums[0][2]=40;
		//	   //[][][][][]
		//	   //[][][]
		//	   
		//	   int[][]numss= new int[][] {{1,2,3,4,5}, {6,7,8,9}};


		int[] lengths = {8,5,9};
		int[][] gs = new int[lengths.length][];

		for(int i=0; i<lengths.length; i++) {
			int cnt = lengths[i];
			gs[i]= new int[cnt];
		}//gs[0]=8/gs[1]=5/gs[2]=9

		for(int i =0; i<gs.length; i++) {
			String line = scan.nextLine();
			String[] kors = line.split(",");

			for(int j=0; j<kors.length; j++) {
				gs[i][j] = Integer.parseInt(kors[j]);
			}
		}


		scan.close();
		fis.close();
		//정렬---------------------------------------------------
//반마다 내림차순
		for(int i=0; i<lengths.length; i++) {
			int size = gs[i].length;
			for(int k=0; k<size; k++) {
				for(int j=0; j<size-1-k; j++) {
					if(gs[i][j]<gs[i][j+1]) {
						int room;
						room= gs[i][j];
						gs[i][j]= gs[i][j+1];
						gs[i][j+1]= room;
					}
				}
			}
		}
//반의 내림차순
		for(int j=0; j<gs.length; j++) {
			for(int i=0; i<gs.length-1-j; i++) {
				if(gs[i][0]<gs[i+1][0]) {
					int [] room = gs[i];
					gs[i] = gs[i+1];
					gs[i+1] = room;
				}
			}
		}
	//gs[0].length=9, gs[1].length=8, gs[2].length=5

		//출력---------------------------------------------------
		for(int i=0; i<gs.length; i++) {
			int size = gs[i].length;//i=0=>9, i=1=>8, i=2=>5

			for(int j=0; j<size; j++) {
				System.out.printf("%d", gs[i][j]);
				if(j+1<size)//size : 9
					System.out.printf(", ");
			}
			System.out.println();
		}


	}

}