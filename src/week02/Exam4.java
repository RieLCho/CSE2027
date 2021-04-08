package java_Week2;

// 데이터 입력 받을 스캐너 import
import java.util.Scanner;

public class Exam4 {
	// 메인 함수
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size;
		// 스캐너 객체 sc를 사용하여 배열의 크기를 입력 받음
		System.out.print("배열 크기를 입력해주세요: ");
		size = sc.nextInt();
		// 3개의 배열 A B C 를 생성
		int A[] = new int[size];
		int B[] = new int[size];
		int C[] = new int[size*2];
		// 배열 A는 짝수만
		System.out.print("배열 A: ");
		for(int i = 0; i<A.length; i++) {
			A[i] = (i+1)*2;
			System.out.print(A[i] + " ");
		}
		System.out.println();
		// 배열 B는 홀수만
		System.out.print("배열 B: ");
		for(int i = 0; i<B.length; i++) {
			B[i] = (i+1)*2-1;
			System.out.print(B[i] + " ");
		}
		System.out.println();
		// 배열 C는 배열 A와 배열 B를 사용하여 모든 원소를 대입
		System.out.print("배열 C: ");
		for(int i = 0; i<size; i++) {
			C[A[i]-1] = A[i];
			C[B[i]-1] = B[i];
		}
		// 반복문으로 배열을 출력합니다
		for(int i = 0; i<C.length; i++) {
			System.out.print(C[i] + " ");
		}
		
	}
}
