public class Program
{
	public static void main(String[] args) {
		/*
		 * int kor1, kor2, kor3; int total; float avg;
		 * 
		 * 
		 * kor1 = 50; kor2 = 70; kor3 = 80;
		 * 
		 * total = kor1 + kor2 + kor3; avg = total / 3.0f;
		 * 
		 * 
		 * System.out.printf("totla is %d\n", total); System.out.printf("avg is %f\n",
		 * avg);
		 */
		
		L1:
		for(int j=0; j<100; j++) {
			for(int i = 0 ; i<100; i++) {
				if(i+1>5) //여기서 프로그램을 끝내고 싶다.
					break L1;
				System.out.printf("%d", i+1);	
			}
		System.out.println();
		}
		System.out.println("안녕~~");
	
	}
}