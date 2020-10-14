package chapter6ex2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws IOException {

		int[] nums = load();

		int total = sum(nums);

		int count = getEvenNumberCount(nums);

		for(int i=0; i<nums.length; i++) {
			System.out.printf("%d ",nums[i]);
		}
		System.out.println();
		System.out.println(total);
		System.out.println(count);
	}

	static int getEvenNumberCount(int[] nums) {
		int count = 0;   
		int size = nums.length;
		for(int i=0; i<size; i++)
			if(nums[i]%2 == 0)
				count++;
		return count;
	}



	static int sum(int[] nums) {
		int size = nums.length;
		int sum = 0;
		for(int i=0; i<size ; i++)
			sum += nums[i];
		return sum;
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
