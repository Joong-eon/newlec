package chapter5ex2;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Program {

   public static void main(String[] args) throws IOException, InterruptedException {

      FileInputStream fis = new FileInputStream("C:\\Newlec\\workspace\\data5.txt");
      Scanner scan = new Scanner(fis, "UTF-8");

      
      Member[] list = new Member[10];
      
      int count = 0;
      {
         int i=0;
         while(scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] tokens = line.split(",");
            
            
            Member m = new Member();
            
            
            m.id = Integer.parseInt(tokens[0]);
            m.uid = tokens[1];
            m.name = tokens[2];
            m.age = Integer.parseInt(tokens[3]);
            
            list[i] = m;
            
            i++;
         }
         count = i;
      }
      scan.close();
      fis.close();
      
      // 정렬... -----
      for(int j=0; j<count-1; j++) {
         for(int i=0; i<count-1-j; i++) {
           
            for(int a=0; a<count; a++) {                  
               Member m = list[a];
               
               if(a == i || a == i+1)
                  System.out.print("*");
               if(i==count-2-j && a+1>count-1-j)
             	  System.out.print("[");
               System.out.printf("%d,%s,%s,%d", 
                                       m.id,m.uid,m.name,m.age);
               if(i==count-2-j && a+1>count-1-j)
              	  System.out.print("]");
               System.out.println();
            }
            
            Thread.sleep(1000);
                        
            boolean changed = false;
            if(list[i].age > list[i+1].age) {
               Member temp = list[i];
               list[i] = list[i+1];
               list[i+1] = temp;
               changed = true;
            }
            

            
            System.out.println();
            
            for(int a=0; a<count; a++) {                  
               Member m = list[a];
               
               if(changed && (a==i || a == i+1))
                  System.out.print("-> ");
               if(i==count-2-j && a+1>count-1-j)
            	  System.out.print("[");
               System.out.printf("%d,%s,%s,%d",
                                       m.id,m.uid,m.name,m.age);   
               if(i==count-2-j && a+1>count-1-j)
             	  System.out.print("]");
               
               System.out.println();
            }
            
            for(int q=0; i<20; i++)
            System.out.println();
          
            //Thread.sleep(1000);
            
         }                                                          
      }
      
      
      // 출력 -----
      for(int i=0; i<count; i++) {
         Member m = list[i];
         System.out.printf("id:%d, uid:%s, name:%s, age:%d\n", 
                                 m.id,m.uid,m.name,m.age);
      }
      
      System.out.println("작업완료");
   }

}