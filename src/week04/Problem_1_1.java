// 2019112130 조양진
package week_4;
import java.util.Scanner;
public class Problem_1_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		// 행렬 A
		int[][] A = {{1,2},{3,4}};
		// 행렬 B
		int[][] B = {{2,4},{6,8}};
		// 행렬 A와 B의 행렬 곱을 저장할 행렬 C
		int[][] C = new int[A.length][A[0].length];
		
		for(int i =0; i<A.length; i++) {
			for(int j=0; j<B[0].length; j++) {
				for(int k = 0; k<A[0].length; k++) {
					// 행렬 곱 일반화 식
					C[i][j] += (A[i][k])*(B[k][j]);
				}
			}
		}
		// 행렬 C 출력
		for(int i = 0; i<A.length; i++) {
			for(int j = 0; j<A[0].length; j++) {
				System.out.print(C[i][j]);
				System.out.print(" ");
			}
			System.out.print("\n");
		}
		
	}

}
