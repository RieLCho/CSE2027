package java_Week2;

public class test {
	public static void main(String[] args) {
		// Exam1 - Snack
		// Snack Ŭ������ mySnack ��ü ����
		Snack mySnack = new Snack();
		// mySncak ��ü�� ������ �����͸� �Է�
		mySnack.Setinfo();
		// mySnack ��ü�� ����Ǿ� �ִ� �����͸� ���
		mySnack.Printinfo();
		
		
		// Exam2 - Pyramid
		// �Ƕ�̵� Ŭ������ �Ƕ�̵� ��ü ����
		Pyramid py =  new Pyramid();
		// �Ƕ�̵� ��ü py�� Ŭ���� �������� �Է¹���
		py.SetInfo();
		// ���� ����ϴ�
		py.printStar();
	}
}
