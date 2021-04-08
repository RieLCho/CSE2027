// 2019112130 ������
// Dog.java

package week10_01;

import java.util.Random;

public class Dog implements move, life{
	/* �������̽� ��� �޼ҵ� */ 
	// move
	public void front(){
		if(!isSleeping) {
			// ���������� �ٽ� ��������ϴ�
			this.isHungry = true;
			System.out.println("Dog ������ �̵��߽��ϴ�.");
		}else {
			System.out.println("Dog �ڰ� �ֽ��ϴ�.");
		}
	}
	public void back() {
		if(!isSleeping) {
			this.isHungry = true;
			System.out.println("Dog �ڷ� �̵��߽��ϴ�.");
		}else {
			System.out.println("Dog �ڰ� �ֽ��ϴ�.");
		}
	}
	public void left() {
		if(!isSleeping) {
			this.isHungry = true;
			System.out.println("Dog �������� �̵��߽��ϴ�.");
		}else {
			System.out.println("Dog �ڰ� �ֽ��ϴ�.");
		}
	}
	public void right() {
		if(!isSleeping) {
			this.isHungry = true;
			System.out.println("Dog ���������� �̵��߽��ϴ�.");
		}else {
			System.out.println("Dog �ڰ� �ֽ��ϴ�.");
		}
	}
	
	// life
	public void eat() {
		if(!isSleeping) {
			this.isHungry = false;
			System.out.println("Dog ���� �Ծ����ϴ�.");
		}else {
			System.out.println("Dog �ڰ� �ֽ��ϴ�.");
		}
	}
	
	public void sleep() {
		this.isSleeping = true;
		System.out.println("Dog ���� ��ϴ�.");
	}
	
	// 5���� ����
	private boolean isSleeping;			// �ڰ� �ִ��� ����
	private boolean isHungry;			// ���� �Ծ����� ����
	private String name = "No Named";	// �̸�
	private int IQ = 0;					// IQ
	private boolean isBarking;			// ¢�� �ִ���
	
	/* �߰� �޼ҵ� */
	// �ῡ�� ����
	public void wakeUp() {
		if(isSleeping) {
			this.isSleeping = false;
			System.out.println("Cat ���� ���ϴ�.");
		}else {
			System.out.println("�̹� Cat ���� �����ֽ��ϴ�.");
		}
	}
	// �̸� ���ϱ�
	public void setName() {
		// �������ִ� �̸��߿� �������� �̸��� ���մϴ�.
		String nameList[] = {"Ara", "Nari", "Hari", "Korone", "Peko"};
		Random rand = new Random(); 
		int temp = rand.nextInt(5);
		this.name = nameList[temp];
	}
	// IQ ���ϱ�
	public void setIQ() {
		Random rand = new Random();
		this.IQ = rand.nextInt(50);
	}
	// ¢��
	public void barkOn() {
		this.isBarking = true;
		System.out.println("Dog ¢�� �����߽��ϴ�.");
	}
	// �׸� ¢��
	public void barkOff() {
		this.isBarking = false;
		System.out.println("Dog ¢�⸦ ������ϴ�.");
	}
	
	// ����
	public void status() {
		System.out.println("Dog�� �����Դϴ�.");
		System.out.println("��: "+ this.isSleeping);
		System.out.println("�����: "+this.isHungry);
		System.out.println("�̸�: "+this.name);
		System.out.println("IQ: " +this.IQ);
		System.out.println("¢��: "+this.isBarking);
	}
}
