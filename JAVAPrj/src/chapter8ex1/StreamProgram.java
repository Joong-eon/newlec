package chapter8ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamProgram {

	public static void main(String[] args) {
		List<Integer> nums = new ArrayList<>();
		
		Random rand = new Random();
		for(int i = 0; i<49; i++) {
			nums.add(rand.nextInt(256));			
		}
		
//		for(int i = 0; i<50; i++)          이렇게 하지말기
//			System.out.println(nums);
		
		for(int n : nums) 
			System.out.println(n);
		
		System.out.println("======================================================================================");
		
		//필터링
		//매핑
		//정렬
		
		List <Integer> list1 = nums
		.stream()
		.filter(n->n>100)
		.collect(Collectors.toList());
		
//		.filter(new Predicate<Integer>() {
//			@Override
//			public boolean test(Integer n) {
//				// TODO Auto-generated method stub
//			return n>100;
//			}
//		}).collect(Collectors.toList());

		for(int n : list1)
			System.out.println(n);
	}

}
