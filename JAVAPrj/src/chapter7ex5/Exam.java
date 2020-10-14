package chapter7ex5;

public class Exam {
	public Exam() { //(扁夯)积己磊
		this(0,0,0);
	}
	
	public Exam(int kor, int eng, int math) {//OverLoad 积己磊
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	//己利
	private int kor;
	private int eng;
	private int math;
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

		return kor+eng+math;
	}
	public float avg() {

		return total()/3.0f;
	}
		
}
