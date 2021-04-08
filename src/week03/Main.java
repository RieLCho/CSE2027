// 2019112130 조양진

package week_3_1;
import java.util.Scanner;

public class Main {
		public static void main (String[] args) {
			// 메뉴 값을 입력받기 위해 Scanner class의 sc 생성
			Scanner sc = new Scanner(System.in);
			// calculator class의 cc를 생성
			calculator cc = new calculator();
			int select_mode = 0;
			
		// do-while 반복문으로 반복됩니다 	
		while(true){
			
			System.out.println("select menu");
			System.out.println("1: addiction");
			System.out.println("2: subtraction");
			System.out.println("3: multiply");
			System.out.println("4: division");
			System.out.println("5: exit");
			
			// 사용자에게서 값을 입력 받습니다
			select_mode = sc.nextInt();
	      
			switch(select_mode) {
				case 1:
					// calculator 클래스의 addition 메소드를 호출합니다
					cc.addition();
					break;
				case 2:
					// calculator 클래스의 subtraction 메소드를 호출합니다
					cc.subtraction();
					break;
				case 3:
					// calculator 클래스의 multiply 메소드를 호출합니다
					cc.multiply();
					break;
				case 4:
					// calculator 클래스의 division 메소드를 호출합니다
					cc.division();
					break;
				case 5:
					// 프로그램을 종료합니다
					System.out.println("Program exit");
					System.exit(0);
					break;
				}
			
		}
	}
}
