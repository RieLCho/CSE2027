package java_Week2;

import java.util.Scanner;

public class Exam3 {
	// ���� �Լ�
	public static void main(String[] args) {
		int x, y;
		
		// ������ x�� y�� �Է�
		Scanner sc = new Scanner(System.in);
		System.out.print("���� X�� �Է����ּ��� :");
		x = sc.nextInt();
		System.out.print("���� y�� �Է����ּ��� :");
		y = sc.nextInt();
		// �̽������� �������� ����Ͽ� ����ǥ�� �����
		System.out.println("\""+x+"/"+y+"�� ���� "+ x/y + "�̰� �������� "+x%y+"�Դϴ�.\"");
		// �������� �������� ������ �Ҽ������� ������ �ʾƼ� ������ x2�� ����� �� �ȿ� ������ x�� �����Ͽ� �� ��ȯ
		double x2 = x;
		// ���������� �Ҽ����� ����
		System.out.println("\""+x+"/"+y+"�� ���� "+x2/y+"�Դϴ�.\"");
	}
}
