// 2019112130 ������
package week_4;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
public class Problem_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] arr = new String[20]; 
		String[] ascend_arr = new String[20];
		String[] descend_arr = new String[20];
		// counter�� ���ڿ� �迭�� ���� ����Ű�� �߿��� ������ ����մϴ�.
		int counter = 0;
		// TODO Auto-generated method stub
		while(true) {
			// ���� �������� ���� ������ �������� �ƴ� ���� �����ٸ� �ٽ� �õ��� �� �ְԲ� try-catch
			try {
				// ���� �޴� ���
				System.out.println("select menu");
				System.out.println("1: �������� ���");
				System.out.println("2: �������� ���");
				System.out.println("3: ���ڿ� �Է� (20��)");
				System.out.println("4: exit");
				
				// ����ڿ��Լ� ���� �Է� �޽��ϴ�
				int select_mode = sc.nextInt();
				
				// �Է¹��� �޴��� ���� �����մϴ�
				switch(select_mode) {
					case 1:
						// ��� 1: �������� ���
						// ���� counter�� 0�̶�� �ƹ��͵� ����� ���� �����ϴ�
						if(counter == 0) {
							System.out.println("�Էµ� ���ڿ��� �����ϴ�.");
							break;
						}
						// ascend_arr�� ������ arr �迭�� �����մϴ�
						for(int i=0; i<counter; i++) {
							ascend_arr[i] = arr[i];
						}
						// sort�� �ȵ� ��츦 ���� try-catch (nullpointer)
						try{
							// �迭�� ������ range ��ŭ�� sort�մϴ�. (�迭,�����ε���,���ε���)
							// �迭�� ũ�Ⱑ 20���� �����Ǿ� �־� �Է¹��� ���� �κ��� null�� ä�����ְ�
							// null�� sort �Լ��� ����� �Ǹ� �ȵ˴ϴ�.
							Arrays.sort(ascend_arr,0,counter);
						}catch(Exception e) {
							System.out.println("�ٽ� �õ����ּ���.");
						}
						// ���� ������ �迭�� ����մϴ�
						for(int j=0; j<counter; j++) {
							System.out.print((j+1)+ "��: " + ascend_arr[j]+" ");
						}
						System.out.print("\n");
						break;
					case 2:
						// ���2: �������� ��� 
						// ���� counter�� 0�̶�� �ƹ��͵� ����� ���� �����ϴ�
						if(counter == 0) {
							System.out.println("�Էµ� ���ڿ��� �����ϴ�.");
							break;
						}
						// descend_arr�� ������ arr �迭�� �����մϴ�
						for(int i=0; i<counter; i++) {
							descend_arr[i] = arr[i];
						}
						// sort�� �ȵ� ��츦 ���� try-catch (nullpointer)
						try{
							// �迭�� ������ range ��ŭ�� sort�մϴ�. (�迭,�����ε���,���ε���)
							// Collections.reverseOrder�� ���� �������� �����մϴ�
							Arrays.sort(descend_arr,0,counter,Collections.reverseOrder());
						}catch(Exception e) {
							System.out.println("�ٽ� �õ����ּ���.");
						}
						// ���� ������ �迭�� ����մϴ�
						for(int j=0; j<counter; j++) {
							System.out.print((j+1)+ "��: " + descend_arr[j]+" ");
						}
						System.out.print("\n");
						break;
					case 3:
						if(counter >= 19) {
							// ��� 4: ���ڿ��� 20���� �Ѿ ��� �� á�ٴ� ���� ���
							System.out.println("���ڿ��� ������ 20�� �̻��Դϴ�.");
							break;
						}
						// ��� 3: ���ڿ� �Է�
						System.out.println("�߰��� ���ڿ��� �Է����ּ���: ");
						// ���� Ŭ����
						 sc.nextLine();
						// ��ĳ�� ���ڿ� �Է¹���
						String temp = sc.nextLine();
						arr[counter] = temp;
						counter++;
						System.out.println("���� �Էµ� ���ڿ��� ������ "+ counter + "�� �Դϴ�.");
						break;
					case 4:
						// ���α׷��� �����մϴ�
						System.out.println("Program exit");
						System.exit(0);
						break;
					}
			}catch (Exception e) {
				System.out.println("�ٽ� �õ����ּ���.");
				sc.nextLine();
				continue;
			}
		}
		
	}

}
