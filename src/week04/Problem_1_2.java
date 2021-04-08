// 2019112130 조양진
package week_4;
import java.util.Scanner;

public class Problem_1_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		// 사용자에게서 배열의 크기를 입력받습니다
		System.out.print("배열의 크기를 입력해주세요 : ");
		int input = sc.nextInt();
		// 입력받은 배열의 크기*배열의 크기 만큼 이차원배열을 생성합니다
		int[][] P = new int[input][input];
		int[][] Q = new int[input][input];
		int[][] R = new int[input][input];
		// P 행렬의 모든 원소는 1로
		for(int i =0; i<input; i++) {
			for(int j=0; j<input; j++) {
				P[i][j] = 1;
			}
		}
		// Q 행렬의 모든 원소는 3으로
		for(int i =0; i<input; i++) {
			for(int j=0; j<input; j++) {
				Q[i][j] = 3;
			}
		}
		// 두 행렬의 곱은 새로운 행렬 R에 저장
		for(int i =0; i<input; i++) {
			for(int j=0; j<input; j++) {
				for(int k = 0; k<input; k++) {
					R[i][j] += (P[i][k])*(Q[k][j]);
				}
			}
		}
		// 행렬 R을 출력합니다
		for(int i = 0; i<input; i++) {
			for(int j = 0; j<input; j++) {
				System.out.print(R[i][j]);
				System.out.print(" ");
			}
			System.out.print("\n");
		}
		
	}

}
