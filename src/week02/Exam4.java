package java_Week2;

// ������ �Է� ���� ��ĳ�� import
import java.util.Scanner;

public class Exam4 {
	// ���� �Լ�
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size;
		// ��ĳ�� ��ü sc�� ����Ͽ� �迭�� ũ�⸦ �Է� ����
		System.out.print("�迭 ũ�⸦ �Է����ּ���: ");
		size = sc.nextInt();
		// 3���� �迭 A B C �� ����
		int A[] = new int[size];
		int B[] = new int[size];
		int C[] = new int[size*2];
		// �迭 A�� ¦����
		System.out.print("�迭 A: ");
		for(int i = 0; i<A.length; i++) {
			A[i] = (i+1)*2;
			System.out.print(A[i] + " ");
		}
		System.out.println();
		// �迭 B�� Ȧ����
		System.out.print("�迭 B: ");
		for(int i = 0; i<B.length; i++) {
			B[i] = (i+1)*2-1;
			System.out.print(B[i] + " ");
		}
		System.out.println();
		// �迭 C�� �迭 A�� �迭 B�� ����Ͽ� ��� ���Ҹ� ����
		System.out.print("�迭 C: ");
		for(int i = 0; i<size; i++) {
			C[A[i]-1] = A[i];
			C[B[i]-1] = B[i];
		}
		// �ݺ������� �迭�� ����մϴ�
		for(int i = 0; i<C.length; i++) {
			System.out.print(C[i] + " ");
		}
		
	}
}
