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
		//������Ʈ(���� �ڷ���)
		//Object x = 3;
		//Object x = new Integer(3);
		//Integer x = new Integer(3);
		//Integer x = 3;
		//		int x =3;
		//		
		//		int y = 4;
		//		
		//		int z = x+y;

		//�迭�� �÷����� ����
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
		//���� ����
		//				while(list.hasNext())
		//					System.out.println(list.next());


		//Iterate
//		ObjectList list = new ObjectList();
		
//		ObjectList.ObjectIterator it = list.new ObjectIterator();//�ٱ��� Ŭ������ �ν��Ͻ��� ����
		ArrayList list = new ArrayList();
		//ObjectList.ObjectIterator it = list.iterator();
		
		
		
//		while(it.hasNext()) //���� ������
//			System.out.println("main " + it.next());
		
		for(Object d : list)
			System.out.println(d);
		
		
		
		for(int i = 0; i<100 ; i++) {
			list.add("data : " + (i+1));
		}
		//�ٸ� �ٿ��� �Է�(��������)
		new Thread(new Runnable() { //���� ������

			public void run() {
//				printData(list);
			}
		}).start();

		//Iterator it = list.iterator();
		
//		while(it.hasNext()) //���� ������
//			System.out.println("main " + it.next());
		
		for(Object d : list)
			System.out.println(d);
		//���� ����
//		list.reset(); ���»�� �� �Ѵ�...
//		while(list.hasNext()) //���� ������
//			System.out.println("main " + list.next());

	}

}
