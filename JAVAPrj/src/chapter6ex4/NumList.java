package chapter6ex4;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class NumList {
	int size = 0;
	int[] nums;
	//배열을 함수에 적용하게 되었다.
	// 배열을 관리하는 목적 : 배열 + 상태변수 -> 목록형 클래스
	// 목록형 클래스에서 데이터 관리를 위한 알고리즘으로 add
	// 함수와 목록 클래스를 하나로 묶는 것으 ㅣ장점과 재사용에 대해서 알아보았음.
	public static void add(NumList list, int num) {
		//		공간이 모자라면 공간을 늘려주는 작업
		//		1. list.nums.length보다 5개 더 큰 배열 temp를 준비한다.
		//		2. 현재 list.nums배열에 있는 값들을 temp공간에 이동시킨다.
		//		3.temp가 참조하는 배열을 list.nums에 참조시킨다.

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

		// 어?? 이상한데? 뭔가 비효율적인데?
		//int size = scan.nextInt();
		//int[] nums = new int[size];
		list.size = scan.nextInt();
		list.nums = new int[list.size];

		// 배열에 데이터를 읽어(로드)온다.
		for(int i=0; i<list.size; i++) {
			list.nums[i] = scan.nextInt();
		}

		fis.close();
	}

}
