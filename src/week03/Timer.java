// 2019112130 조양진
package week_3_2;

import java.util.Scanner;
import java.text.SimpleDateFormat;

public class Timer {

	public static void main(String[] args) {
		// 사용자에게 명령을 입력받을 변수 select_mode
		int select_mode = 0;
		// 사용자에게 타이머의 종료를 입력받을 변수 timer_exit
		int timer_exit = 0;
		Scanner sc = new Scanner(System.in);
		// form1의 포맷을 HH:mm:ss으로 지정합니다
		SimpleDateFormat form1 = new SimpleDateFormat("HH:mm:ss");
		
		// while(true) 반복문으로 무한 반복합니다
		while(true) {
			System.out.println("select menu");
			System.out.println("1: current time");
			System.out.println("2: timer");
			System.out.println("3: exit");
		
			// 사용자에게 숫자를 입력 받습니다.
			select_mode = sc.nextInt();
		
			switch(select_mode) {
				case 1: 
					// 현재 시각을 form1에 지정한 포맷에 맞춰 출력합니다.
					System.out.println("현재 시간은 " + form1.format(System.currentTimeMillis()));
					break;
				case 2:
					// 2번을 입력했을 순간의 시각을 time1에 저장
					long time1 = System.currentTimeMillis();
					System.out.println("타이머를 종료하려면 숫자 5를 입력해주세요");
					// timer_exit에 5가 들어올 때 까지 반복 대기
					while(timer_exit != 5) {
						timer_exit = sc.nextInt();
					}
					// timer_exit에 5가 들어온 순간의 시각을 time2에 저장
					long time2 = System.currentTimeMillis();
					// time2 - time1으로 걸린 시간을 출력합니다
					System.out.println("걸린 시간은 "+(time2 - time1)/1000.000 + "초 입니다.");
					break;
				case 3:
					// 프로그램을 종료합니다
					System.out.println("Program exit");
					System.exit(0);
					break;
			}
		}
	}
}
