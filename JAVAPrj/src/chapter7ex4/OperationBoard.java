package chapter7ex4;

public class OperationBoard {
   private String myColor;
   private String turn;
   
   public OperationBoard() {
      this.myColor = "White";
      this.turn = "Black";
   }

   public String getMyColor() {
      return myColor;
   }

   public void setMyColor(String myColor) {
      this.myColor = myColor;
   }

   public String getTurn() {
      return turn;
   }

   public void setTurn(String turn) {
      this.turn = turn;
   }
   
   //print()
   
//   public void print() {
//      System.out.printf("���� ���� %s / %s / ������-��x100 ��x99",this.turn,this.myColor,);
//            
//            //(������ ��� 20x20)
//            //���� ���� ȭ��Ʈ / ���� / ������-��x100 ��x99
//            //> (x, Y��) :   );
//   }
}