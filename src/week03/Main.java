// 2019112130 ������

package week_3_1;
import java.util.Scanner;

public class Main {
		public static void main (String[] args) {
			// �޴� ���� �Է¹ޱ� ���� Scanner class�� sc ����
			Scanner sc = new Scanner(System.in);
			// calculator class�� cc�� ����
			calculator cc = new calculator();
			int select_mode = 0;
			
		// do-while �ݺ������� �ݺ��˴ϴ� 	
		while(true){
			
			System.out.println("select menu");
			System.out.println("1: addiction");
			System.out.println("2: subtraction");
			System.out.println("3: multiply");
			System.out.println("4: division");
			System.out.println("5: exit");
			
			// ����ڿ��Լ� ���� �Է� �޽��ϴ�
			select_mode = sc.nextInt();
	      
			switch(select_mode) {
				case 1:
					// calculator Ŭ������ addition �޼ҵ带 ȣ���մϴ�
					cc.addition();
					break;
				case 2:
					// calculator Ŭ������ subtraction �޼ҵ带 ȣ���մϴ�
					cc.subtraction();
					break;
				case 3:
					// calculator Ŭ������ multiply �޼ҵ带 ȣ���մϴ�
					cc.multiply();
					break;
				case 4:
					// calculator Ŭ������ division �޼ҵ带 ȣ���մϴ�
					cc.division();
					break;
				case 5:
					// ���α׷��� �����մϴ�
					System.out.println("Program exit");
					System.exit(0);
					break;
				}
			
		}
	}
}
