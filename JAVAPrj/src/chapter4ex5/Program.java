package chapter4ex5;

public class Program {

	
	static int sum(int n) {
		
		if(n==1)
			return 3;
		int an = (3+(n-1)*7);
		
		return sum(n-1) + an;
	}
	public static void main(String[] args) {
		

		sum(3);
		System.out.println(sum(100));
	}

}
