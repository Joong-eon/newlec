package chapter7ex2;

import java.util.Random;


public class Program {

	public static void main(String[] args) {
	
		/*
		 * 1. �˸��� : ���� ������ �׸�(��������� �׸�)-��ƼƼ:��ü
		 * 2. ���� : �˸��̵��� ������ �ִ��� ����������..�ؼ� �˸��̵��� �������ִ� ����
		 * 3. ������ : ������� �Է�/����� �����ִ� ����� ������ӽ�
		 */
		
		// �˸���
		//int[] lotto = new int[6];
		Lotto lotto = new Lotto();

		//��ȣ�� ���� gen
		//Lotto.gen(lotto);	//static method
		lotto.gen(); 		//intance method
		// ��ȣ�� ��� print   
		lotto.print();

		// ��ȣ�� ���� sort
		lotto.sort();

		// ��ȣ�� ��� print
		lotto.print();

	}
}