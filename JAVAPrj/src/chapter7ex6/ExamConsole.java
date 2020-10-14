package chapter7ex6;

import java.util.Scanner;

// 부품
// dependency
// 구성요소로써의 부품(dependency) - has a (상속)관계

// 생명주기와 객체의 관계
//composition  has a 관계 - 일체형
//association  				   - 분리형


public class ExamConsole {
	
	// 부품으로 객체를 가짐으로써 그의 능력을 상속 받는 has a 상속
	private Exam exam; // ExamConsole의 구성 (부품)이다.
	
	public ExamConsole() {
		exam = new Exam(0, 0, 0);
	}

	
	
	public void setExam(Exam exam) {
		this.exam = exam;
	}



	public void input() {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("kor:");
		int kor = scan.nextInt();
		System.out.print("eng:");
		int eng = scan.nextInt();
		System.out.print("math:");
		int math = scan.nextInt();
		
		//exam = new Exam(kor, eng, math);
		exam.setKor(kor);
		exam.setEng(eng);
		exam.setMath(math);
	}

	public void print() {
		System.out.printf("kor : %d, eng : %d, math: %d, total : %d, avg : %f\n",
				exam.getKor(), exam.getEng(), exam.getMath(),
				exam.total(), exam.avg());
	}
	
}
