package chapter7ex2;

import java.util.Random;

public class Lotto {
	public int[] nums;
	//초기화 함수->생성자->constructor
	Lotto() {
		this.nums = new int[6];
	}
	
	 void sort() {
		for(int j=0; j<5; j++)
			for(int i=0; i<5-j; i++) 
				if(this.nums[i] > this.nums[i+1]) {
					int temp = this.nums[i];
					this.nums[i] = this.nums[i+1];
					this.nums[i+1] = temp;
				}
	}
	
	void gen() {
		Random rand = new Random();
		for(int i=0; i<6; i++)
			this.nums[i] = rand.nextInt(45)+1;
	}

	 void print() {
		for(int i=0; i<6; i++)
			System.out.printf("%d ", this.nums[i]);
		System.out.println();   
	}
}