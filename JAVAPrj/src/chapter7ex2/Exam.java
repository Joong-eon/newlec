package chapter7ex2;

public class Exam {
   private int kor;
   private int eng;
   private int math;

   public int total() {
      return kor+ eng + math;
   }
   
   public float avg() {
      return total()/3.0f;
   }
   
   public void print() {
      System.out.printf("kor:%d, eng:%d, math:%d\n", kor, eng, math);
   }

public int getKor() {
	return kor;
}

public void setKor(int kor) {
	this.kor = kor;
}

public int getEng() {
	return eng;
}

public void setEng(int eng) {
	this.eng = eng;
}

public int getMath() {
	return math;
}

public void setMath(int math) {
	this.math = math;
}
   
}