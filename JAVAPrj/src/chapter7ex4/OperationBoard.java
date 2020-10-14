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
//      System.out.printf("현재 순서 %s / %s / 아이템-○x100 ●x99",this.turn,this.myColor,);
//            
//            //(오목판 출력 20x20)
//            //현재 순서 화이트 / 내꺼 / 아이템-○x100 ●x99
//            //> (x, Y값) :   );
//   }
}