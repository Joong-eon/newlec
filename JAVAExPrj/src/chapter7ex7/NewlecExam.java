package chapter7ex7;

import chapter7ex6.Exam;

public class NewlecExam extends Exam{//Is a »ó¼Ó
	private int com;

	public NewlecExam() {
		this(1,1,1,1);
	}

	public NewlecExam(int kor, int eng, int math, int com) {
		super(kor, eng, math);
		this.com = com;
	}
	
		public int total() {
			return super.total()+com;
		}
		public float avg() {
			return total()/4.0f;
		}
	public int getCom() {
		return com;
	}

	public void setCom(int com) {
		this.com = com;
	}
}
