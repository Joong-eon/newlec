package chapter7ex7;

	//��ü : ExamConsole, Exam
	//���� : Program->ExamConsole<>Exam
	//������ : Ʋ�� ����ϴ� ������, ���ļ� ����ϱ�
public class Program {

	public static void main(String[] args) {
		NewlecExam exam = new NewlecExam(1,2,1,2);
		System.out.printf("total: %d, avg: %f\n", exam.total(), exam.avg());
	}

}
