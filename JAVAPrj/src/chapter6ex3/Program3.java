package chapter6ex3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


/*
 * 과제 1 : 
 * load() 함수에서 로드한 데이터의 개수를
 * main 함수가 알게 하라.... 
 */

public class Program3 {
   
   public static void main(String[] args) throws IOException {
   
      // 데이터를 int[] nums 배열에 로드하는 코드를 작성하고
      
      NumList list = new NumList();
      //          list -> [[size][nums]]
      
      list.size = 0;
      list.nums = null;
      
      
      load(list);
      
      // nums 배열의 합계를 구하고
      printSum(list);
      
      // nums 값 중에서 짝수의 개수를 구하고
      printEvenNumberCount(list);
         
       ///////
      
   }

   static void printEvenNumberCount(NumList list) {
      
      //int size = nums.length;
      
      int count = 0;      
      for(int i=0; i<list.size; i++)
         if(list.nums[i]%2 == 0)
            count++;
      
      System.out.println(count);   
   }

   static void printSum(NumList list) {
      
      //int size = nums.length;
      
      int sum = 0;
      for(int i=0; i<list.size; i++)
         sum += list.nums[i];
      
      System.out.println(sum);
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