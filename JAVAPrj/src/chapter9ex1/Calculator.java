package chapter9ex1;

public class Calculator {

//	private int x;
//	private int y;
//
//	public Calculator(int x, int y) {
//		this.x = x;
//		this.y = y;
//	}
//	public  int add() {
//		// TODO Auto-generated method stub
//		return x+y;
//	}
//
//	public int sub() {
//		// TODO Auto-generated method stub
//		return x-y;
//	}

	public static int add(int x, int y) throws TooBicNumber  {
		if(x>1000 || y>1000) {
			throw new TooBicNumber();
		}
			
			
		return x+y;
	}
	
	public static int sub(int x, int y) throws NegativeNumber {
		if(x<y)
			throw new NegativeNumber();
		return x-y;
	}
	
	public static int multi(int x, int y) {
		
		return x*y;
	}
	
	public static int div(int x, int y) {
		
		return x/y;
	}

}
