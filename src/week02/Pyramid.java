package java_Week2;

// 시스템에서 input을 받기 위해 import 
import java.util.Scanner;

public class Pyramid {
	// char 형은 무조건 쉼표 (따옴표 안됨)
	public char ss = '*';
	public int num = 3;
	// 스캐너 객체 생성
	public Scanner sc = new Scanner(System.in);
	
	// 별 찍는 메소드
	public void printStar() {
		for(int i=0; i<num; i++) {
			for(int j = 1; j<num-i;j++) {
				System.out.print(" ");
			}
			for(int k = 0; k<(i*2)+1; k++) {
				System.out.print(ss);
			}
			System.out.println();
		}
	}
	// 데이터를 입력받는 메소드
	public void SetInfo() {
		System.out.println("Input Character: ");
		// 별을 찍을 문자 입력
		ss = sc.nextLine().charAt(0);
		System.out.println("Input line number: ");
		// 몇 줄 찍을 것인지 입력
		num = sc.nextInt();
	}
}
