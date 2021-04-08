package java_Week2;

// 시스템에서 input을 받기 위해 import
import java.util.Scanner;

// public 클래스 Snack 선언
public class Snack {
	// Snack 클래스의 변수들
	public String name;
	public int price;
	public int numberofsnack;
	// Scanner 생성
	Scanner ac = new Scanner(System.in);
	
	public void Setinfo() {
		System.out.println("Snack name :");
		// 과자 이름 입력
		name = ac.nextLine();
		System.out.println("Snack price :");
		// 과자 가격 입력
		price = ac.nextInt();
		System.out.println("Number of snacks :");
		// 과자 개수 입력
		numberofsnack = ac.nextInt();
	}
	public void Printinfo() {
		// 과자 이름, 가격, 개수 출력
		System.out.println("Snack name is " + name);
		System.out.println("Snack price is " + price);
		System.out.println("Snack number of snack(s) (is)are " + numberofsnack);
	}
}
