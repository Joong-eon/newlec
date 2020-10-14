package chapter7ex2;


public class Program2 {

	public static void main(String[] args) {
	
		Exam exam = new Exam();
		exam.setKor(30);
		
		System.out.printf("kor : %d, eng : %d, math : %d\n",
				exam.getKor(), exam.getEng(), exam.getMath());

	}
}