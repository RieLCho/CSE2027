package java_Week2;

// �ý��ۿ��� input�� �ޱ� ���� import
import java.util.Scanner;

// public Ŭ���� Snack ����
public class Snack {
	// Snack Ŭ������ ������
	public String name;
	public int price;
	public int numberofsnack;
	// Scanner ����
	Scanner ac = new Scanner(System.in);
	
	public void Setinfo() {
		System.out.println("Snack name :");
		// ���� �̸� �Է�
		name = ac.nextLine();
		System.out.println("Snack price :");
		// ���� ���� �Է�
		price = ac.nextInt();
		System.out.println("Number of snacks :");
		// ���� ���� �Է�
		numberofsnack = ac.nextInt();
	}
	public void Printinfo() {
		// ���� �̸�, ����, ���� ���
		System.out.println("Snack name is " + name);
		System.out.println("Snack price is " + price);
		System.out.println("Snack number of snack(s) (is)are " + numberofsnack);
	}
}
