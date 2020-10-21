package chapter8ex1;

import java.util.Iterator;

public class ObjectList implements Iterable {//Iterable를 임플리먼트한다는건 interface를 지켜야하는데 이미 지킴->Iterator
	private Object[] list;
	private int size;
	private int max;
	private int amount;

	public ObjectList() {
		this(3);
	}

	public ObjectList(int capacity) {//집중화
		amount = 5;
		max = capacity;
		list = new Object[max];
		size = 0;

	}

	public void add(Object n) {
		if(max >= size) {
			Object[] temp = new Object [max+amount];
			for(int i = 0; i<max; i++) {
				temp[i] = list[i];
			}
			list = temp;
			max+=amount;
		}
		list[size++] = n;
	}
	public Object get(int index) {
		return list[index];
	}
	
	public class ObjectIterator implements Iterator{
		private int index;

		public boolean hasNext() {
			if(index < size)
				return true;
			return false;
		}

		public Object next() {
			// TODO Auto-generated method stub
			return list[index++];
		}
		

	}
	//	public void reset() {
	//		index = 0;
	//		
	//	}

	public Iterator iterator() {
//		ObjectIterator oi = this.new ObjectIterator(); //this 생략가능
		return new ObjectIterator();
	}
}
