package java_Week2;

// �ý��ۿ��� input�� �ޱ� ���� import 
import java.util.Scanner;

public class Pyramid {
	// char ���� ������ ��ǥ (����ǥ �ȵ�)
	public char ss = '*';
	public int num = 3;
	// ��ĳ�� ��ü ����
	public Scanner sc = new Scanner(System.in);
	
	// �� ��� �޼ҵ�
	public void printStar() {
		for(int i=0; i<num; i++) {
			for(int j = 1; j<num-i;j++) {
				System.out.print(" ");
			}
			for(int k = 0; k<(i*2)+1; k++) {
				System.out.print(ss);
			}
			System.out.println();
		}
	}
	// �����͸� �Է¹޴� �޼ҵ�
	public void SetInfo() {
		System.out.println("Input Character: ");
		// ���� ���� ���� �Է�
		ss = sc.nextLine().charAt(0);
		System.out.println("Input line number: ");
		// �� �� ���� ������ �Է�
		num = sc.nextInt();
	}
}
