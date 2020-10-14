package chapter7ex5;

import java.util.Scanner;

public class ExamConsole {
	
	private Exam exam;
	
	public ExamConsole() {
		exam = new Exam(0,0,0);
	}
	
	public void input() {
		Scanner scan = new Scanner(System.in);
		System.out.print("kor: ");
		int kor = scan.nextInt();
		System.out.print("eng: ");
		int eng = scan.nextInt();
		System.out.print("math: ");
		int math = scan.nextInt();

		exam = new Exam(kor, eng, math);
	}

	public void print() {
		System.out.printf("kor: %d, eng: %d, math: %d, total: %d, avg: %f\n",
				exam.getKor(), exam.getEng(), exam.getMath(),
				exam.total(), exam.avg());
	}
}
