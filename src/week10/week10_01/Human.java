// 2019112130 ������
// Human.java

package week10_01;
import java.util.Random;

public class Human implements move, life {
	/* �������̽� ��� �޼ҵ� */ 
	// move
	public void front(){
		if(!isSleeping) {
			// ���������� �ٽ� ��������ϴ�
			this.isHungry = true;
			System.out.println("Human ������ �̵��߽��ϴ�.");
		}else {
			System.out.println("Human �ڰ� �ֽ��ϴ�.");
		}
	}
	public void back() {
		if(!isSleeping) {
			this.isHungry = true;
			System.out.println("Human �ڷ� �̵��߽��ϴ�.");
		}else {
			System.out.println("Human �ڰ� �ֽ��ϴ�.");
		}
	}
	public void left() {
		if(!isSleeping) {
			this.isHungry = true;
			System.out.println("Human �������� �̵��߽��ϴ�.");
		}else {
			System.out.println("Human �ڰ� �ֽ��ϴ�.");
		}
	}
	public void right() {
		if(!isSleeping) {
			this.isHungry = true;
			System.out.println("Human ���������� �̵��߽��ϴ�.");
		}else {
			System.out.println("Human �ڰ� �ֽ��ϴ�.");
		}
	}
	
	// life
	public void eat() {
		if(!isSleeping) {
			this.isHungry = false;
			System.out.println("Human ���� �Ծ����ϴ�.");
		}else {
			System.out.println("Human �ڰ� �ֽ��ϴ�.");
		}
	}
	
	public void sleep() {
		this.isSleeping = true;
		System.out.println("Human ���� ��ϴ�.");
	}
	
	// 5���� ����
	private boolean isSleeping;			// �ڰ� �ִ��� ����
	private boolean isHungry;			// ���� �Ծ����� ����
	private String name = "No Named";	// �̸�
	private int IQ = 0;					// IQ
	private String job = "No Job";		// ����
	
	/* �߰� �޼ҵ� */
	// �ῡ�� ����
	public void wakeUp() {
		if(isSleeping) {
			this.isSleeping = false;
			System.out.println("Human ���� ���ϴ�.");
		}else {
			System.out.println("�̹� Human ���� �����ֽ��ϴ�.");
		}
	}
	// �̸� ���ϱ�
	public void setName() {
		// �������ִ� �̸��߿� �������� �̸��� ���մϴ�.
		String nameList[] = {"Alex", "Chris", "JUSTHIS", "Kyaru", "Peko"};
		Random rand = new Random(); 
		int temp = rand.nextInt(5);
		this.name = nameList[temp];
	}
	// IQ ���ϱ�
	public void setIQ() {
		Random rand = new Random();
		this.IQ = rand.nextInt(180);
	}
	// ���� ���ϱ�
	public void setJob() {
		// �������ִ� ���� �߿� �������� ������ ���մϴ�.
		String jobList[] = {"Programmer", "Teacher", "Firefighter", "Policeman", "Virtual Youtuber"};
		Random rand = new Random(); 
		int temp = rand.nextInt(5);
		this.job = jobList[temp];
	}
	// ����
	public void status() {
		System.out.println("Human�� �����Դϴ�.");
		System.out.println("��: "+ this.isSleeping);
		System.out.println("�����: "+this.isHungry);
		System.out.println("�̸�: "+this.name);
		System.out.println("IQ: " +this.IQ);
		System.out.println("����: "+this.job);
	}
}
