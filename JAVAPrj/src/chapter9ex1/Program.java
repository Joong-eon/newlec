package chapter9ex1;

public class Program {

	public static void main(String[] args) {
//	Calculator cal = new Calculator(3,4);
//	//�ν��Ͻ��� �̿��ϴ� �޼ҵ�
//	result = cal.add();
//	result = cal.sub();

		//�ν��Ͻ��� ������� �ʴ� ����ƽ �޼ҵ�
		int result;
		try {
			result = Calculator.add(100,4);
			result = Calculator.sub(4,1);
		} catch (TooBicNumber e) {
			// TODO Auto-generated catch block
			System.out.println("1000���Ϸ� �Է��ϼ���");
			e.printStackTrace();
		} catch (NegativeNumber e) {
			// TODO Auto-generated catch block
			System.out.println("������ �Ӵ��");
			e.printStackTrace();
		} catch (Exception e) {// ������ ���� ĳġ
			// TODO Auto-generated catch block
			System.out.println("���ܰ� �߻��ض߾�");
			e.printStackTrace();
		} finally {//���ܰ� ������ ó���ϴ¹�
			System.out.println("������ �۾�");
		}

//		result = Calculator.multi(4,3);
//		result = Calculator.div(4,0);
		
		System.out.println("�ȳ�");
	}

}
