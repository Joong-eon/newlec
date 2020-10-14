package chapter6ex3;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;


//과제 1: load() 함수에서 로드한 데이터의 개수를 main함수가 알게 하라.
public class Program2 {

	public static void main(String[] args) throws IOException {

		int size =0;
		int[] nums = new int[10];
		
		load(nums, size);

		printSum(nums, size);

		printEvenNumberCount(nums, size);

		for(int i=0; i<nums.length; i++) {
			System.out.printf("%d ",nums[i]);
		}

	}

	static void printEvenNumberCount(int[] nums, int size2) {
		int count = 0;   
		int size = nums.length;
		for(int i=0; i<size; i++)
			if(nums[i]%2 == 0)
				count++;
		System.out.println(count);
	}



	static void printSum(int[] nums, int size2) {
		int size = nums.length;
		int sum = 0;
		for(int i=0; i<size ; i++)
			sum += nums[i];
		System.out.println(sum);
	}

	static int[]load(int[] nums, int size) throws IOException{
		FileInputStream fis = new FileInputStream("C:\\Newlec\\workspace\\data.txt");      
		Scanner scan = new Scanner(fis);      

		size = scan.nextInt();
		//int[] nums = new int[size];


		for(int i=0; i<size; i++) {
			nums[i] = scan.nextInt();
		}

		scan.close();
		fis.close();
		return nums;
	}
}
