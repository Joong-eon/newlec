package chapter6ex4;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class NumList {
	int size = 0;
	int[] nums;
	//�迭�� �Լ��� �����ϰ� �Ǿ���.
	// �迭�� �����ϴ� ���� : �迭 + ���º��� -> ����� Ŭ����
	// ����� Ŭ�������� ������ ������ ���� �˰������� add
	// �Լ��� ��� Ŭ������ �ϳ��� ���� ���� �������� ���뿡 ���ؼ� �˾ƺ�����.
	public static void add(NumList list, int num) {
		//		������ ���ڶ�� ������ �÷��ִ� �۾�
		//		1. list.nums.length���� 5�� �� ū �迭 temp�� �غ��Ѵ�.
		//		2. ���� list.nums�迭�� �ִ� ������ temp������ �̵���Ų��.
		//		3.temp�� �����ϴ� �迭�� list.nums�� ������Ų��.

		if(list.nums.length <= list.size) {
			int[] temp = new int [list.size + 5];
			for(int i=0; i<list.size; i++) {
				temp[i]= list.nums[i];
			}
			list.nums = temp;
		}
		list.nums[list.size]=num;
		list.size++;

	}

	public static int getEvenNumberCount(NumList list) {
		int count = 0;      
		for(int i=0; i<list.size; i++)
			if(list.nums[i]%2 == 0)
				count++;

		return count;
	}



	public static int sum(NumList list) {
		int sum = 0;
		for(int i=0; i<list.size; i++)
			sum += list.nums[i];
		return sum;
	}

	public static void load(NumList list) throws IOException {

		FileInputStream fis = new FileInputStream("C:\\Newlec\\workspace\\data.txt");      
		Scanner scan = new Scanner(fis);      

		// ��?? �̻��ѵ�? ���� ��ȿ�����ε�?
		//int size = scan.nextInt();
		//int[] nums = new int[size];
		list.size = scan.nextInt();
		list.nums = new int[list.size];

		// �迭�� �����͸� �о�(�ε�)�´�.
		for(int i=0; i<list.size; i++) {
			list.nums[i] = scan.nextInt();
		}

		fis.close();
	}

}
