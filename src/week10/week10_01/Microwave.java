// 2019112130 ������
// Microwave.java

package week10_01;

public class Microwave implements on_off{
	/* �������̽� ��� �޼ҵ� */ 
	// on_off
	public void on() {
		if(isPlugged) {
			this.isStarted = true;
			System.out.println("Microwave ������ �׽��ϴ�.");
		}else {
			System.out.println("Microwave �ܼ�Ʈ�� ����Ǿ� ���� �ʽ��ϴ�.");
		}
	}
	public void off() {
		if(isPlugged) {
			this.isStarted = false;
			System.out.println("Microwave ������ �����ϴ�.");
		}else {
			System.out.println("Microwave �ܼ�Ʈ�� ����Ǿ� ���� �ʽ��ϴ�.");
		}
	}
	
	// 5���� ����
	private boolean isPlugged;		// �ܼ�Ʈ�� ����Ǿ��ִ��� ����
	private boolean isStarted;		// ���������� ����
	private boolean isOpen;			// ���ڷ����� �Ѳ��� ���ȴ��� ����
	private boolean isPowerSaving;	// ������� ����
	private boolean isClockMode;	// �ð��� ���� (���ڷ������� �ð踦 ��� �� ����)
	
	/* �߰� �޼ҵ� */
	// �ܼ�Ʈ�� �Ƚ��ϴ�
	public void plugIn() {
		this.isPlugged = true;
		System.out.println("Microwave �ܼ�Ʈ�� �����߽��ϴ�.");
	}
	// �ܼ�Ʈ�� �̽��ϴ�
	public void plugOut() {
		this.isPlugged = false;
		System.out.println("Microwave �ܼ�Ʈ�� �����߽��ϴ�.");
	}
	// �Ѳ��� ���ϴ�
	public void open() {
		this.isOpen = true;
		System.out.println("Microwave �Ѳ��� �������ϴ�.");
	}
	// �Ѳ��� �ݽ��ϴ�
	public void close() {
		this.isOpen = false;
		System.out.println("Microwave �Ѳ��� �ݾҽ��ϴ�.");
	}
	// ������带 ŵ�ϴ�
	public void powerSaveOn() {
		this.isPowerSaving = true;
		System.out.println("Microwave ������带 �׽��ϴ�.");
	}
	// ������带 ���ϴ�
	public void powerSaveOff() {
		this.isPowerSaving = false;
		System.out.println("Microwave ������带 �����ϴ�.");
	}
	// �ð��带 ŵ�ϴ�
	public void clockModeOn() {
		this.isPowerSaving = true;
		System.out.println("Microwave �ð��带 �׽��ϴ�.");
	}
	// �ð��带 ���ϴ�
	public void clockModeOff() {
		this.isPowerSaving = false;
		System.out.println("Microwave �ð��带 �����ϴ�.");
	}
	// ����
	public void status() {
		System.out.println("Microwave�� �����Դϴ�.");
		System.out.println("�ܼ�Ʈ: "+ this.isPlugged);
		System.out.println("������: "+this.isStarted);
		System.out.println("�Ѳ�����: "+this.isOpen);
		System.out.println("�������: "+this.isPowerSaving);
		System.out.println("�ð���: "+this.isClockMode);
	}
}
