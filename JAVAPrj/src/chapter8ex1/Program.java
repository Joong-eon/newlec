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


//1.�ݷ����̶�?
//-�������� �����
//2.���� ���񽺶�?
//-�ε����� ������� �ʰ� ���� �ݺ������� ������ ���� next()/hasNext()
//3. �ݺ���(Iterator)��?
//-�����忡 ������ ���� ���񽺸� �����ϱ� ���� ���� ��ü
//4. foreach �����̶�?
//-�ݷ����� ��ȸ���ִ� �ݺ���

public class Program {

	private static void printData(ObjectList list) {
//		while(list.hasNext())
//			System.out.println("fn "+ list.next());
	}

	public static void main(String[] args) {
		
		List<ArrayList<Integer>> list1 = new ArrayList<>();  //�տ� Array���� ��
		list1.add(new ArrayList<Integer>());
		list1.add(new ArrayList<Integer>());
		list1.add(new ArrayList<Integer>());
		
		List<HashMap<Integer,String>> list2 = new ArrayList<>();  
		list2.add(new HashMap<Integer,String>());
		list2.add(new HashMap<Integer,String>());
		list2.add(new HashMap<Integer,String>());
		
		
		
		
		GList<Integer> glist = new GList<>();
		glist.add(7);
		
		
		Set<Object> set = new HashSet<>(); //(�ּ����� ����)<-Set<Object> set = new HashSet<Object>();
		List<Object> list = new ArrayList<>();
		Map<String,Object> map = new HashMap<>();
		
		set.add("haha");
		set.add(3);
		set.add(3);
		set.add(3.0);
		
		for(Object o : set)
			System.out.println(o);
		
		list.add("haha");
		list.add(3);
		list.add(3.0);
		
		for(Object o : set)
			System.out.println(o);
		
		System.out.println(list.get(2)); //�������� ��Ʈ���̶�� System.out.println(list.get(2).split(",")); ����
		
		map.put("��ȣ", 1);
		map.put("����", "������ ������ �÷���");
		map.put("�ۼ���", "ȫ�浿");
		
		for(Object key : map.keySet())
			System.out.println("key: " + key + " Value: " + map.get(key));
		
		for(Object value : map.values())
			System.out.println(value);
		
		//Iterate
//		ObjectList list = new ObjectList();
//		ObjectList.ObjectIterator it = list.new ObjectIterator();//�ٱ��� Ŭ������ �ν��Ͻ��� ����
		
		//ArrayList list = new ArrayList();
		//ObjectList.ObjectIterator it = list.iterator();
		
//		while(it.hasNext()) //���� ������
//			System.out.println("main " + it.next());
				
//		for(int i = 0; i<100 ; i++) {
//			list.add("data : " + (i+1));
//		}
//		//�ٸ� �ٿ��� �Է�(��������)
//		new Thread(new Runnable() { //���� ������
//
//			public void run() {
////				printData(list);
//			}
//		}).start();

		//Iterator it = list.iterator();
		
//		while(it.hasNext()) //���� ������
//			System.out.println("main " + it.next());
		
//		for(Object d : list)
//			System.out.println(d);
		
		//���� ����
//		list.reset(); ���»�� �� �Ѵ�...
//		while(list.hasNext()) //���� ������
//			System.out.println("main " + list.next());

	}

}
