// 2019112130 ������
package week_4;
import java.util.Scanner;

public class Problem_1_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		// ����ڿ��Լ� �迭�� ũ�⸦ �Է¹޽��ϴ�
		System.out.print("�迭�� ũ�⸦ �Է����ּ��� : ");
		int input = sc.nextInt();
		// �Է¹��� �迭�� ũ��*�迭�� ũ�� ��ŭ �������迭�� �����մϴ�
		int[][] P = new int[input][input];
		int[][] Q = new int[input][input];
		int[][] R = new int[input][input];
		// P ����� ��� ���Ҵ� 1��
		for(int i =0; i<input; i++) {
			for(int j=0; j<input; j++) {
				P[i][j] = 1;
			}
		}
		// Q ����� ��� ���Ҵ� 3����
		for(int i =0; i<input; i++) {
			for(int j=0; j<input; j++) {
				Q[i][j] = 3;
			}
		}
		// �� ����� ���� ���ο� ��� R�� ����
		for(int i =0; i<input; i++) {
			for(int j=0; j<input; j++) {
				for(int k = 0; k<input; k++) {
					R[i][j] += (P[i][k])*(Q[k][j]);
				}
			}
		}
		// ��� R�� ����մϴ�
		for(int i = 0; i<input; i++) {
			for(int j = 0; j<input; j++) {
				System.out.print(R[i][j]);
				System.out.print(" ");
			}
			System.out.print("\n");
		}
		
	}

}
