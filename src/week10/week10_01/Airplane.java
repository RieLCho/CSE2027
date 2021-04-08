// 2019112130 ������
// Airplane.java

package week10_01;
import java.util.Random;
public class Airplane implements on_off, move {
	/* �������̽� ��� �޼ҵ� */ 
	// on_off
	public void on() {
		this.isStarted = true;
		System.out.println("Airplane �õ��� �׽��ϴ�.");
	}
	public void off() {
		this.isStarted = false;
		System.out.println("Airplane �õ��� �����ϴ�.");
	}
	
	// move
	public void front(){
		if(isStarted) {
			System.out.println("Airplane ������ �̵��߽��ϴ�.");
		}else {
			System.out.println("Airplane �õ��� �����ֽ��ϴ�.");
		}
	}
	public void back() {
		if(isStarted) {
			System.out.println("Airplane �ڷ� �̵��߽��ϴ�.");
		}else {
			System.out.println("Airplane �õ��� �����ֽ��ϴ�.");
		}
	}
	public void left() {
		if(isStarted) {
			System.out.println("Airplane �������� �̵��߽��ϴ�.");
		}else {
			System.out.println("Airplane �õ��� �����ֽ��ϴ�.");
		}
	}
	public void right() {
		if(isStarted) {
			System.out.println("Airplane ���������� �̵��߽��ϴ�.");
		}else {
			System.out.println("Airplane �õ��� �����ֽ��ϴ�.");
		}
	}
	
	// 5���� ����
	private boolean isStarted;		// �õ� �������� ����
	private double leftFuel;		// ���� ������ ��
	private int passenger;			// ž�°��� ��
	private double targetDistance;	// ������������ �Ÿ� (km)
	private int travelCounter;		// ����Ƚ��
	
	/* �߰� �޼ҵ� */
	// ����
	public void oiling() {
		this.leftFuel += 100;
		System.out.println("Airplane 100 ���� �����߽��ϴ�.");
	}
	
	// ž�°� �߰�
	public void passengerOnBoard() {
		this.passenger += 1;
		System.out.println("Airplane ž�°� �����߽��ϴ�.");
	}
	// �������Ÿ� ���ϱ�
	public void setTargetDistance() {
		Random rand = new Random();
		targetDistance = rand.nextInt(1000);
		System.out.println("Airplane ���� �������� �Ÿ��� ���������ϴ�.");
	}
	// ����
	public void status() {
		System.out.println("Airplane�� �����Դϴ�.");
		System.out.println("�õ�: "+ this.isStarted);
		System.out.println("ž�°�: "+this.passenger);
		System.out.println("���� ����: "+this.leftFuel);
		System.out.println("���������� �Ÿ�: "+this.targetDistance);
	}
}
