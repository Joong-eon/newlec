package chapter7ex4;

public class Program {

   public static void main(String[] args) {

      GoBoard goBoard = new GoBoard();
      OperationBoard opBoard = new OperationBoard();      //��Ȳ��
      GoContainer whiteCon = new GoContainer("white");      //��� ���� ��� �׸�
      GoContainer blackCon = new GoContainer("Black");      //�˻� ���� ��� ��
      //goBoard.print();//������ ���
      print(goBoard, opBoard, whiteCon, blackCon);
      
      
   }
   
   public static void  print(GoBoard goBoard, OperationBoard opBoard, GoContainer whiteCon, GoContainer blackCon) {
      for(int i=0;i<goBoard.size;i++) {
         for(int j=0;j<goBoard.size;j++) {
            System.out.print(goBoard.stone[i][j]);
         }
         System.out.println();
      }
      System.out.printf("���� ���� %s / ���� �� %s / ������-��x%d ��x%d",opBoard.getTurn(), opBoard.getMyColor(), whiteCon.count, blackCon.count);
   }

}