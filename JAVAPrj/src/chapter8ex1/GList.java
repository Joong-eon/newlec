package chapter8ex1;

import java.util.Iterator;

public class GList <병수>{
	private 병수[] list;
	private int size;
	private int max;
	private int amount;

	public GList() {
		this(3);
	}

	public GList(int capacity) {//집중화
		amount = 5;
		max = capacity;
		list = (병수[]) new Object[max];
		size = 0;

	}

	public void add(병수 n) {
		if(max >= size) {
			병수[] temp = (병수[]) new Object [max+amount];
			for(int i = 0; i<max; i++) {
				temp[i] = list[i];
			}
			list = temp;
			max+=amount;
		}
		list[size++] = n;
	}
	public 병수 get(int index) {
		return list[index];
	}
	
	public class ObjectIterator implements Iterator{
		private int index;

		public boolean hasNext() {
			if(index < size)
				return true;
			return false;
		}

		public 병수 next() {
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
