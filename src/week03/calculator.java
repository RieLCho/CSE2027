// 2019112130 ������

package week_3_1;
import java.util.Scanner;

public class calculator {
	int num1;
	int num2;
	// num1 �� num2 �� ��� ��� ���� �����ϱ� ���� ����
	int result;
	// ���� �Է� �ޱ� ���� Scanner ���
	Scanner sc = new Scanner(System.in);
	
	public calculator() { // ������
		num1 = 0;
		num2 = 0;
	}
	
	public void addition() { // �� ������ �Է¹ް� ���� ���� ����մϴ�
		System.out.print("num1�� �Է����ּ���: ");
		num1 = sc.nextInt();
		System.out.print("num2�� �Է����ּ���: ");
		num2 = sc.nextInt();
		result = num1 + num2;
		System.out.println("num1 + num2 = " + result);
	}
	
	public void	subtraction() { // �� ������ �Է¹ް� �� ���� ����մϴ�
		System.out.print("num1�� �Է����ּ���: ");
		num1 = sc.nextInt();
		System.out.print("num2�� �Է����ּ���: ");
		num2 = sc.nextInt();
		result = num1 - num2;
		System.out.println("num1 - num2 = " + result);
	}
	
	public void multiply() { // �� ������ �Է¹ް� ���� ���� ����մϴ�
		System.out.print("num1�� �Է����ּ���: ");
		num1 = sc.nextInt();
		System.out.print("num2�� �Է����ּ���: ");
		num2 = sc.nextInt();
		result = num1 * num2;
		System.out.println("num1 * num2 = " + result);
	}
	
	public void division() { // �� ������ �Է¹ް� ���� ���� ����մϴ�n (ex 5/2 = 2.5)
		System.out.print("num1�� �Է����ּ���: ");
		num1 = sc.nextInt();
		System.out.print("num2�� �Է����ּ���: ");
		num2 = sc.nextInt();
		// �и� 0�� ���� Arithmetic ������ ���� ������ try-catch ���� ����մϴ�
		try {
			result = num1 / num2;
			System.out.println("num1 / num2 = " + result);
		}catch(ArithmeticException e) {
			// ���� arithmetic error�� ���´ٸ� �Ʒ��� �ڵ带 �����մϴ�
			System.out.println(e.getClass().getName() + "���ܰ� "+ e.getMessage() + "�� ���� �߻��߽��ϴ�.");
		}
	}
}
