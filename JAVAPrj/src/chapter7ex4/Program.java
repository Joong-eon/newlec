package chapter7ex4;

public class Program {

   public static void main(String[] args) {

      GoBoard goBoard = new GoBoard();
      OperationBoard opBoard = new OperationBoard();      //상황판
      GoContainer whiteCon = new GoContainer("white");      //흰색 돌을 답는 그릇
      GoContainer blackCon = new GoContainer("Black");      //검색 돌을 답는 그
      //goBoard.print();//보드판 출력
      print(goBoard, opBoard, whiteCon, blackCon);
      
      
   }
   
   public static void  print(GoBoard goBoard, OperationBoard opBoard, GoContainer whiteCon, GoContainer blackCon) {
      for(int i=0;i<goBoard.size;i++) {
         for(int j=0;j<goBoard.size;j++) {
            System.out.print(goBoard.stone[i][j]);
         }
         System.out.println();
      }
      System.out.printf("현재 순서 %s / 나의 돌 %s / 아이템-○x%d ●x%d",opBoard.getTurn(), opBoard.getMyColor(), whiteCon.count, blackCon.count);
   }

}