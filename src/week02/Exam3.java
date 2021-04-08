package java_Week2;

import java.util.Scanner;

public class Exam3 {
	// 메인 함수
	public static void main(String[] args) {
		int x, y;
		
		// 정수형 x와 y를 입력
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 X를 입력해주세요 :");
		x = sc.nextInt();
		System.out.print("정수 y를 입력해주세요 :");
		y = sc.nextInt();
		// 이스케이프 시퀀스를 사용하여 따옴표를 출력함
		System.out.println("\""+x+"/"+y+"의 몫은 "+ x/y + "이고 나머지는 "+x%y+"입니다.\"");
		// 정수형과 정수형을 나누면 소수점으로 나오지 않아서 더블형 x2를 만들고 그 안에 정수형 x를 대입하여 형 변환
		double x2 = x;
		// 정상적으로 소수점이 나옴
		System.out.println("\""+x+"/"+y+"의 값은 "+x2/y+"입니다.\"");
	}
}
