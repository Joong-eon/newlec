package chapter7ex6;

public class Exam {
	
	private int kor;
	private int eng;
	private int math;
	
	public Exam() {		
		this(1, 1, 1);	
	}
	
	// 오버로드(OverLoad 메소드 또는 생성자)
	public Exam(int kor, int eng, int math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
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
	public int total() {
		
		return kor + eng + math;
	}
	public float avg() {
		// TODO Auto-generated method stub
		return total()/3.0f;
	}
	
//	public void input() {
//		Scanner scan = new Scanner(System.in);	
//		System.out.print("kor:");
//		kor= scan.nextInt();
//		
//		System.out.print("eng:");
//		eng = scan.nextInt();
//		
//		System.out.print("math:");
//		math = scan.nextInt();
//	}
//	
	
	
}
