// 2019112130 ������
package week_3_2;

import java.util.Scanner;
import java.text.SimpleDateFormat;

public class Timer {

	public static void main(String[] args) {
		// ����ڿ��� ����� �Է¹��� ���� select_mode
		int select_mode = 0;
		// ����ڿ��� Ÿ�̸��� ���Ḧ �Է¹��� ���� timer_exit
		int timer_exit = 0;
		Scanner sc = new Scanner(System.in);
		// form1�� ������ HH:mm:ss���� �����մϴ�
		SimpleDateFormat form1 = new SimpleDateFormat("HH:mm:ss");
		
		// while(true) �ݺ������� ���� �ݺ��մϴ�
		while(true) {
			System.out.println("select menu");
			System.out.println("1: current time");
			System.out.println("2: timer");
			System.out.println("3: exit");
		
			// ����ڿ��� ���ڸ� �Է� �޽��ϴ�.
			select_mode = sc.nextInt();
		
			switch(select_mode) {
				case 1: 
					// ���� �ð��� form1�� ������ ���˿� ���� ����մϴ�.
					System.out.println("���� �ð��� " + form1.format(System.currentTimeMillis()));
					break;
				case 2:
					// 2���� �Է����� ������ �ð��� time1�� ����
					long time1 = System.currentTimeMillis();
					System.out.println("Ÿ�̸Ӹ� �����Ϸ��� ���� 5�� �Է����ּ���");
					// timer_exit�� 5�� ���� �� ���� �ݺ� ���
					while(timer_exit != 5) {
						timer_exit = sc.nextInt();
					}
					// timer_exit�� 5�� ���� ������ �ð��� time2�� ����
					long time2 = System.currentTimeMillis();
					// time2 - time1���� �ɸ� �ð��� ����մϴ�
					System.out.println("�ɸ� �ð��� "+(time2 - time1)/1000.000 + "�� �Դϴ�.");
					break;
				case 3:
					// ���α׷��� �����մϴ�
					System.out.println("Program exit");
					System.exit(0);
					break;
			}
		}
	}
}
