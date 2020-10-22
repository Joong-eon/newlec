package chapter8ex1;

import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import chapter7ex6.Exam;


//1.콜렉션이란?
//-가변길이 저장소
//2.열거 서비스란?
//-인덱스를 사용하지 않고 값을 반복적으로 꺼내는 서비스 next()/hasNext()
//3. 반복자(Iterator)란?
//-스레드에 안전한 열거 서비스를 제공하기 위한 열거 객체
//4. foreach 구문이란?
//-콜렉션을 순회해주는 반복문

public class Program {

	private static void printData(ObjectList list) {
//		while(list.hasNext())
//			System.out.println("fn "+ list.next());
	}

	public static void main(String[] args) {
		
		Set set = new HashSet();
		List list = new ArrayList();
		Map map = new HashMap();
		
		set.add("haha");
		set.add(3);
		set.add(3.0);
		
		for(Object o : set)
			System.out.println(o);
		
		list.add("haha");
		list.add(3);
		list.add(3.0);
		
		for(Object o : set)
			System.out.println(o);
		
		System.out.println(list.get(2));
		
		map.put("번호", 1);
		map.put("제목", "오늘의 시작은 컬렉션");
		map.put("작성자", "홍길동");
		
		for(Object key : map.keySet())
			System.out.println("key: " + key + " Value: " + map.get(key));
		
//		for(Object value : map.values())
//			System.out.println(value);
		
		//Iterate
//		ObjectList list = new ObjectList();
		
//		ObjectList.ObjectIterator it = list.new ObjectIterator();//바깥쪽 클래스의 인스턴스로 생성
		
		//ArrayList list = new ArrayList();
		
		//ObjectList.ObjectIterator it = list.iterator();
		
		
		
//		while(it.hasNext()) //메인 스레드
//			System.out.println("main " + it.next());
				
//		for(int i = 0; i<100 ; i++) {
//			list.add("data : " + (i+1));
//		}
//		//다른 줄에서 입력(스레드사용)
//		new Thread(new Runnable() { //보조 스레드
//
//			public void run() {
////				printData(list);
//			}
//		}).start();

		//Iterator it = list.iterator();
		
//		while(it.hasNext()) //메인 스레드
//			System.out.println("main " + it.next());
		
//		for(Object d : list)
//			System.out.println(d);
		
		//열거 서비스
//		list.reset(); 리셋사용 안 한대...
//		while(list.hasNext()) //메인 스레드
//			System.out.println("main " + list.next());

	}

}
