package chapter6ex2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Program2 {

	public static void main(String[] args) throws IOException {

		int[] nums = load();

		printSum(nums);

		printEvenNumberCount(nums);

		for(int i=0; i<nums.length; i++) {
			System.out.printf("%d ",nums[i]);
		}

	}

	static void printEvenNumberCount(int[] nums) {
		int count = 0;   
		int size = nums.length;
		for(int i=0; i<size; i++)
			if(nums[i]%2 == 0)
				count++;
		System.out.println(count);
	}



	static void printSum(int[] nums) {
		int size = nums.length;
		int sum = 0;
		for(int i=0; i<size ; i++)
			sum += nums[i];
		System.out.println(sum);
	}

	static int[]load() throws IOException{
		FileInputStream fis = new FileInputStream("C:\\Newlec\\workspace\\data.txt");      
		Scanner scan = new Scanner(fis);      

		int size = scan.nextInt();
		int[] nums = new int[size];


		for(int i=0; i<size; i++) {
			nums[i] = scan.nextInt();
		}

		scan.close();
		fis.close();
		return nums;
	}
}
