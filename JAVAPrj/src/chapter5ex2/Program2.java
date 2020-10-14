package chapter5ex2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Program2 {

	public static void main(String[] args) throws IOException, InterruptedException {
		FileInputStream fis = new FileInputStream("C:\\Newlec\\workspace\\data5.txt");
		Scanner scan = new Scanner(fis, "UTF-8");

		// ��� ���
		Member[] members = new Member[6];

		{
			int i = 0;
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				String[] tokens = line.split(",");

				// ����� ���� 
				// User Type
				// ������� �׷��θ� : ��ü��
				// Member : ��ü(Entity)�� <-> m : ��ü(Object)��
				Member m = new Member();

				m.id = Integer.parseInt(tokens[0]);
				m.uid = tokens[1];
				m.name = tokens[2];
				m.age = Integer.parseInt(tokens[3]);

				members[i] = m;
				i++;
			}
		}

		scan.close();
		fis.close();

		int size = members.length;
		for (int i = 0; i < size - 1; i++) {
			for (int j = 0; j < size - 1 - i; j++) {

				System.out.println("[�ٲ����]");
				for (int a = 0; a < size; a++) {
					Member m = members[a];

					if (a == j || a == j + 1)
						System.out.printf("*%d, %s, %s, %d\n", m.id, m.uid, m.name, m.age);
					else if (a >= size - i) 
						System.out.printf("[%d, %s, %s, %d]\n", m.id, m.uid, m.name, m.age);
					else
						System.out.printf("%d, %s, %s, %d\n", m.id, m.uid, m.name, m.age);
				}

				boolean isSwap = false;
				if (members[j].age > members[j + 1].age) {
					Member temp = members[j];
					members[j] = members[j + 1];
					members[j + 1] = temp;
					isSwap = true;
				}
				System.out.println();

				System.out.println("[�ٲ� ��]");
				for (int a = 0; a < size; a++) {
					Member m = members[a];

					if (a == j || a == j + 1)
						System.out.printf("->%d, %s, %s, %d\n", m.id, m.uid, m.name, m.age);
					else if (a >= size - i)
						System.out.printf("[%d, %s, %s, %d]\n", m.id, m.uid, m.name, m.age);
					else
						System.out.printf("%d, %s, %s, %d\n", m.id, m.uid, m.name, m.age);
				}

				for (int a = 0; a < 5; a++)
					System.out.println();

				//Thread.sleep(1000);
			}
		}

		for (int i = 0; i < size; i++) {
			Member m = members[i];

			System.out.printf("id: %d, uid: %s, �̸�: %s, ����: %d\n", m.id, m.uid, m.name, m.age);
		}
	}

}