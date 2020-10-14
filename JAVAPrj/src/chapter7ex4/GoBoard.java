package chapter7ex4;

public class GoBoard {
   String[][] stone;
   int size;
   public GoBoard() {
      size = 20;
      stone = new String[size][size];
      
      for(int i=0;i<size;i++) {
         for(int j=0;j<size;j++) {
            stone[i][j] = "¦«";
         }
      }
   }
   
   
}