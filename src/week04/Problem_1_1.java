// 2019112130 ������
package week_4;
import java.util.Scanner;
public class Problem_1_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		// ��� A
		int[][] A = {{1,2},{3,4}};
		// ��� B
		int[][] B = {{2,4},{6,8}};
		// ��� A�� B�� ��� ���� ������ ��� C
		int[][] C = new int[A.length][A[0].length];
		
		for(int i =0; i<A.length; i++) {
			for(int j=0; j<B[0].length; j++) {
				for(int k = 0; k<A[0].length; k++) {
					// ��� �� �Ϲ�ȭ ��
					C[i][j] += (A[i][k])*(B[k][j]);
				}
			}
		}
		// ��� C ���
		for(int i = 0; i<A.length; i++) {
			for(int j = 0; j<A[0].length; j++) {
				System.out.print(C[i][j]);
				System.out.print(" ");
			}
			System.out.print("\n");
		}
		
	}

}
