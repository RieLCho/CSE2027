// 2019112130 ������
// TV.java

package week10_01;

import java.util.Random;

public class TV implements on_off{
	/* �������̽� ��� �޼ҵ� */ 
	// on_off
	public void on() {
		if(isPlugged) {
			this.isPowerOn = true;
			System.out.println("TV ������ �׽��ϴ�.");
		}else {
			System.out.println("TV �ܼ�Ʈ�� ����Ǿ� ���� �ʽ��ϴ�.");
		}
	}
	public void off() {
		if(isPlugged) {
			this.isPowerOn = false;
			System.out.println("TV ������ �����ϴ�.");
		}else {
			System.out.println("TV �ܼ�Ʈ�� ����Ǿ� ���� �ʽ��ϴ�.");
		}
	}
	
	// 5���� ����
	private boolean isPlugged;		// �ܼ�Ʈ�� ����Ǿ��ִ��� ����
	private boolean isPowerOn;		// ������ �������� ����
	private boolean isPowerSaving;	// ������� ����
	private int		channel;		// ä��
	private String	brand;			// TV ������
	
	/* �߰� �޼ҵ� */
	// �ܼ�Ʈ�� �Ƚ��ϴ�
	public void plugIn() {
		this.isPlugged = true;
		System.out.println("TV �ܼ�Ʈ�� �����߽��ϴ�.");
	}
	// �ܼ�Ʈ�� �̽��ϴ�
	public void plugOut() {
		this.isPlugged = false;
		System.out.println("TV �ܼ�Ʈ�� �����߽��ϴ�.");
	}
	// ������带 ŵ�ϴ�
	public void powerSaveOn() {
		this.isPowerSaving = true;
		System.out.println("TV ������带 �׽��ϴ�.");
	}
	// ������带 ���ϴ�
	public void powerSaveOff() {
		this.isPowerSaving = false;
		System.out.println("TV ������带 �����ϴ�.");
	}
	public void channelUp() {
		this.channel += 1;
		System.out.println("TV ä���� �÷Ƚ��ϴ�.");
	}
	public void channelDown() {
		if(!(channel==0)) {
			this.channel -= 1;
			System.out.println("TV ä���� ���Ƚ��ϴ�.");
		}else {
			System.out.println("ä���� ���� �� �����ϴ�.");
		}
	}
	public void setBrand() {
		String nameList[] = {"Samsung", "LG", "Apple", "Xiaomi", "Panasonic"};
		Random rand = new Random(); 
		int temp = rand.nextInt(5);
		this.brand = nameList[temp];
	}
	// ����
	public void status() {
		System.out.println("TV�� �����Դϴ�.");
		System.out.println("������: "+ this.brand);
		System.out.println("�ܼ�Ʈ: "+ this.isPlugged);
		System.out.println("������: "+this.isPowerOn);
		System.out.println("�������: "+this.isPowerSaving);
		System.out.println("ä��: "+this.channel);
	}
}
