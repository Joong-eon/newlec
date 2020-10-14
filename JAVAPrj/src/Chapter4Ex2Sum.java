

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Chapter4Ex2Sum {

   public static void main(String[] args) throws IOException {
            
      
      //---- 데이터를 로드 --------------------------------------------------
      FileInputStream fis = new FileInputStream("C:\\Newlec\\workspace\\data.txt");      
      Scanner scan = new Scanner(fis);      
      
      // 어?? 이상한데? 뭔가 비효율적인데?
      int size = scan.nextInt();
      int[] nums = new int[size];
      
      
      // 배열에 데이터를 읽어(로드)온다.
      for(int i=0; i<size; i++) {
         nums[i] = scan.nextInt();
      }
      
      fis.close();
      
      //--- 데이터 조작 ------------------------------------------------
      
      // 1. 데이터의 총합을 구하시오.
      // 2. 짝수의 개수를 출력하시오.
      
      // 배열의 데이터의 총합?을 구하실 수 있겠습니꽈?
      // int sum = nums[0] + nums[1] + nums[2] + nums[3] ......; // 개수가 정해져 있고 변화가 없다면 오케이, 하지만..
      
      // [60 70 90 100 75 24 23 80 90]
      
      // 합을 구하는 코드
      int sum = 0;
      for(int i=0; i<size; i++)
         sum += nums[i];
      
      System.out.println(sum);
            
      // 짝수의 수를 구하는 코드      
      int count = 0;      
      for(int i=0; i<size; i++)
         if(nums[i]%2 == 0)
            count++;
      
      System.out.println(count);   
      
      // [60 70 90 100 75 24 23 80 90]
      // [23 24 60 70 75 80 90 90 100]
      
      // 정렬 =========================      
      
      // 출력
      for(int i=0; i<size; i++)
         System.out.printf("%d ", nums[i]);
      
      System.out.println();
            
      // [60 70 90 100 75 24 23 80 90]
      // 1pass : [60 70 90 90 75 24 23 80 100]
      // 2       : [60 70 90 90 75 24 23 90 100]
      
      for(int j=0; j<size-1; j++)
         // 1pass
         for(int i=0; i<size - 1-j; i++) {
            //[i]<->[i+1] 를 비교해서 만약에 [i]가 더 크면
            // 교체
            if(nums[i]>nums[i+1]) {
               int temp;
               temp = nums[i]; // 사과를 접시에 옮긴다.
               nums[i] = nums[i+1];
               nums[i+1] = temp;
            }
         }
      


      
      
      // 출력[23 70 90 100 75 24 60 80 90]
      for(int i=0; i<size; i++)
         System.out.printf("%d ", nums[i]);
      
      System.out.println();
      
//      for(int i=0; i<size; i++) {
//         
//      }
         
      
      
      // ----- 데이터를 저장 -----------------------------
      
      //FileOutputStream fos = new FileOutputStream("res/result.txt");
      //fos.close();
   }

}