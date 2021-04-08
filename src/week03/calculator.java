// 2019112130 조양진

package week_3_1;
import java.util.Scanner;

public class calculator {
	int num1;
	int num2;
	// num1 과 num2 의 계산 결과 값을 저장하기 위한 변수
	int result;
	// 값을 입력 받기 위해 Scanner 사용
	Scanner sc = new Scanner(System.in);
	
	public calculator() { // 생성자
		num1 = 0;
		num2 = 0;
	}
	
	public void addition() { // 두 정수를 입력받고 더한 값을 출력합니다
		System.out.print("num1을 입력해주세요: ");
		num1 = sc.nextInt();
		System.out.print("num2를 입력해주세요: ");
		num2 = sc.nextInt();
		result = num1 + num2;
		System.out.println("num1 + num2 = " + result);
	}
	
	public void	subtraction() { // 두 정수를 입력받고 뺀 값을 출력합니다
		System.out.print("num1을 입력해주세요: ");
		num1 = sc.nextInt();
		System.out.print("num2를 입력해주세요: ");
		num2 = sc.nextInt();
		result = num1 - num2;
		System.out.println("num1 - num2 = " + result);
	}
	
	public void multiply() { // 두 정수를 입력받고 곱한 값을 출력합니다
		System.out.print("num1을 입력해주세요: ");
		num1 = sc.nextInt();
		System.out.print("num2를 입력해주세요: ");
		num2 = sc.nextInt();
		result = num1 * num2;
		System.out.println("num1 * num2 = " + result);
	}
	
	public void division() { // 두 정수를 입력받고 나눈 값을 출력합니다n (ex 5/2 = 2.5)
		System.out.print("num1을 입력해주세요: ");
		num1 = sc.nextInt();
		System.out.print("num2를 입력해주세요: ");
		num2 = sc.nextInt();
		// 분모에 0이 들어가면 Arithmetic 에러가 나기 때문에 try-catch 문을 사용합니다
		try {
			result = num1 / num2;
			System.out.println("num1 / num2 = " + result);
		}catch(ArithmeticException e) {
			// 만약 arithmetic error가 나온다면 아래의 코드를 실행합니다
			System.out.println(e.getClass().getName() + "예외가 "+ e.getMessage() + "로 인해 발생했습니다.");
		}
	}
}
