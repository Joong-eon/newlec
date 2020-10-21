package chapter8ex1;

import java.awt.geom.Area;
import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.Iterator;

import chapter7ex6.Exam;

public class Program {

	private static void printData(ObjectList list) {
//		while(list.hasNext())
//			System.out.println("fn "+ list.next());
	}

	public static void main(String[] args) {
		//오브젝트(공통 자료형)
		//Object x = 3;
		//Object x = new Integer(3);
		//Integer x = new Integer(3);
		//Integer x = 3;
		//		int x =3;
		//		
		//		int y = 4;
		//		
		//		int z = x+y;

		//배열과 컬렉션의 차이
		//		Object[] data = new Object[10];
		//		
		//		data[0] = "hello";
		//		data[1] = 3;
		//		data[2] = new Exam();
		//		
		//		for(int i = 0; i<data.length; i++) {
		//			System.out.println(data[i]);

		//		ObjectList list = new ObjectList();
		//		list.add("Hello");
		//		list.add(3);
		//		list.add(new Exam());

		//		for(int i= 0; i<3; i++)
		//			System.out.println(list.get(i));
		//열거 서비스
		//				while(list.hasNext())
		//					System.out.println(list.next());


		//Iterate
//		ObjectList list = new ObjectList();
		
//		ObjectList.ObjectIterator it = list.new ObjectIterator();//바깥쪽 클래스의 인스턴스로 생성
		ArrayList list = new ArrayList();
		//ObjectList.ObjectIterator it = list.iterator();
		
		
		
//		while(it.hasNext()) //메인 스레드
//			System.out.println("main " + it.next());
		
		for(Object d : list)
			System.out.println(d);
		
		
		
		for(int i = 0; i<100 ; i++) {
			list.add("data : " + (i+1));
		}
		//다른 줄에서 입력(스레드사용)
		new Thread(new Runnable() { //보조 스레드

			public void run() {
//				printData(list);
			}
		}).start();

		//Iterator it = list.iterator();
		
//		while(it.hasNext()) //메인 스레드
//			System.out.println("main " + it.next());
		
		for(Object d : list)
			System.out.println(d);
		//열거 서비스
//		list.reset(); 리셋사용 안 한대...
//		while(list.hasNext()) //메인 스레드
//			System.out.println("main " + list.next());

	}

}
