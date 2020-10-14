package chapter7ex1;

import java.util.Random;

public class Program {

   public static void main(String[] args) {
      
      /*
       * 1. 알맹이 : 값을 가지는 그릇(개념단위의 그릇)-엔티티:개체
       * 2. 서비스 : 알맹이들을 가지고 있던지 가져오던지..해서 알맹이들을 제공해주는 서비스
       * 3. 껍데기 : 사용자의 입력/출력을 도와주는 사용자 인터페ㅣ스
       */
      
      // 알맹이
      int[] lotto = new int[6];

      
      //번호를 생성 gen
      Random rand = new Random();
      for(int i=0; i<6; i++)
         lotto[i] = rand.nextInt(45)+1;
      
      // 번호를 출력 print
      for(int i=0; i<6; i++)
         System.out.printf("%d ", lotto[i]);
      
      System.out.println();   
      
      
      // 번호를 정렬 sort
      for(int j=0; j<5; j++)
         for(int i=0; i<5-j; i++) 
            if(lotto[i] > lotto[i+1]) {
               int temp = lotto[i];
               lotto[i] = lotto[i+1];
               lotto[i+1] = temp;
            }
         
            
      
      // 번호를 출력 print
      for(int i=0; i<6; i++)
         System.out.printf("%d ", lotto[i]);
      
      System.out.println();
      
      
   }

}