package chapter9ex1;

public class Program {

	public static void main(String[] args) {
//	Calculator cal = new Calculator(3,4);
//	//인스턴스를 이용하는 메소드
//	result = cal.add();
//	result = cal.sub();

		//인스턴스를 사용하지 않는 스태틱 메소드
		int result;
		try {
			result = Calculator.add(100,4);
			result = Calculator.sub(4,1);
		} catch (TooBicNumber e) {
			// TODO Auto-generated catch block
			System.out.println("1000이하로 입력하세요");
			e.printStackTrace();
		} catch (NegativeNumber e) {
			// TODO Auto-generated catch block
			System.out.println("음수는 앙대요");
			e.printStackTrace();
		} catch (Exception e) {// 나머지 예외 캐치
			// TODO Auto-generated catch block
			System.out.println("예외가 발생해뜨아");
			e.printStackTrace();
		} finally {//예외가 없으면 처리하는법
			System.out.println("마무리 작업");
		}

//		result = Calculator.multi(4,3);
//		result = Calculator.div(4,0);
		
		System.out.println("안냥");
	}

}
