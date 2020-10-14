package chapter7ex7;

	//개체 : ExamConsole, Exam
	//관계 : Program->ExamConsole<>Exam
	//사용관계 : 틀로 사용하는 사용관계, 고쳐서 사용하기
public class Program {

	public static void main(String[] args) {
		NewlecExam exam = new NewlecExam(1,2,1,2);
		System.out.printf("total: %d, avg: %f\n", exam.total(), exam.avg());
	}

}
