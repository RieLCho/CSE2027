// 2019112130 ������
// Cat.java

package week10_01;

import java.util.Random;

public class Cat implements move, life{
	/* �������̽� ��� �޼ҵ� */ 
	// move
	public void front(){
		if(!isSleeping) {
			// ���������� �ٽ� ��������ϴ�
			this.isHungry = true;
			System.out.println("Cat ������ �̵��߽��ϴ�.");
		}else {
			System.out.println("Cat �ڰ� �ֽ��ϴ�.");
		}
	}
	public void back() {
		if(!isSleeping) {
			this.isHungry = true;
			System.out.println("Cat �ڷ� �̵��߽��ϴ�.");
		}else {
			System.out.println("Cat �ڰ� �ֽ��ϴ�.");
		}
	}
	public void left() {
		if(!isSleeping) {
			this.isHungry = true;
			System.out.println("Cat �������� �̵��߽��ϴ�.");
		}else {
			System.out.println("Cat �ڰ� �ֽ��ϴ�.");
		}
	}
	public void right() {
		if(!isSleeping) {
			this.isHungry = true;
			System.out.println("Cat ���������� �̵��߽��ϴ�.");
		}else {
			System.out.println("Cat �ڰ� �ֽ��ϴ�.");
		}
	}
	
	// life
	public void eat() {
		if(!isSleeping) {
			this.isHungry = false;
			System.out.println("Cat ���� �Ծ����ϴ�.");
		}else {
			System.out.println("Cat �ڰ� �ֽ��ϴ�.");
		}
	}
	
	public void sleep() {
		this.isSleeping = true;
		System.out.println("Cat ���� ��ϴ�.");
	}
	
	// 5���� ����
	private boolean isSleeping;			// �ڰ� �ִ��� ����
	private boolean isHungry;			// ���� �Ծ����� ����
	private String name = "No Named";	// �̸�
	private int IQ = 0;					// IQ
	private boolean isMeowing;			// ��� �ִ��� ����
	
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
		String nameList[] = {"Ara", "Nari", "Hari", "Kyaru", "Peko"};
		Random rand = new Random(); 
		int temp = rand.nextInt(5);
		this.name = nameList[temp];
	}
	// IQ ���ϱ�
	public void setIQ() {
		Random rand = new Random();
		this.IQ = rand.nextInt(50);
	}
	// ���
	public void meowOn() {
		this.isMeowing = true;
		System.out.println("Cat ��� �����߽��ϴ�.");
	}
	// �׸� ���
	public void meowOff() {
		this.isMeowing = false;
		System.out.println("Cat ��⸦ ������ϴ�.");
	}
	
	// ����
	public void status() {
		System.out.println("Cat�� �����Դϴ�.");
		System.out.println("��: "+ this.isSleeping);
		System.out.println("�����: "+this.isHungry);
		System.out.println("�̸�: "+this.name);
		System.out.println("IQ: " +this.IQ);
		System.out.println("���:"+this.isMeowing);
	}
}
