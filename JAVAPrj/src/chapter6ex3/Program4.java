package chapter6ex3;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Program4 {

	public static void main(String[] args) throws IOException {

		NumList list = new NumList();	      
		list.size = 0;
		list.nums = null;

		load(list);

		int total = sum(list);

		int count = getEvenNumberCount(list);

		for(int i=0; i<list.nums.length; i++) {
			System.out.printf("%d ",list.nums[i]);
		}
		System.out.println();
		System.out.println(total);
		System.out.println(count);
	}

	static int getEvenNumberCount(NumList list) {
		int count = 0;      
	      for(int i=0; i<list.size; i++)
	         if(list.nums[i]%2 == 0)
	            count++;
	      
		return count;
	}



	static int sum(NumList list) {
		int sum = 0;
	      for(int i=0; i<list.size; i++)
	         sum += list.nums[i];
		return sum;
	}

	static void load(NumList list) throws IOException {

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
