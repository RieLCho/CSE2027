// 2019112130 조양진
package week_4;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
public class Problem_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] arr = new String[20]; 
		String[] ascend_arr = new String[20];
		String[] descend_arr = new String[20];
		// counter는 문자열 배열의 끝을 가리키는 중요한 변수로 사용합니다.
		int counter = 0;
		// TODO Auto-generated method stub
		while(true) {
			// 무한 루프에서 만약 지정된 정수형이 아닌 것이 읽힌다면 다시 시도할 수 있게끔 try-catch
			try {
				// 선택 메뉴 출력
				System.out.println("select menu");
				System.out.println("1: 오름차순 출력");
				System.out.println("2: 내림차순 출력");
				System.out.println("3: 문자열 입력 (20개)");
				System.out.println("4: exit");
				
				// 사용자에게서 값을 입력 받습니다
				int select_mode = sc.nextInt();
				
				// 입력받은 메뉴를 토대로 실행합니다
				switch(select_mode) {
					case 1:
						// 기능 1: 오름차순 출력
						// 만약 counter가 0이라면 아무것도 출력할 것이 없습니다
						if(counter == 0) {
							System.out.println("입력된 문자열이 없습니다.");
							break;
						}
						// ascend_arr에 본래의 arr 배열을 복사합니다
						for(int i=0; i<counter; i++) {
							ascend_arr[i] = arr[i];
						}
						// sort가 안될 경우를 위해 try-catch (nullpointer)
						try{
							// 배열의 지정된 range 만큼만 sort합니다. (배열,시작인덱스,끝인덱스)
							// 배열의 크기가 20으로 지정되어 있어 입력받지 못한 부분은 null로 채워져있고
							// null은 sort 함수의 대상이 되면 안됩니다.
							Arrays.sort(ascend_arr,0,counter);
						}catch(Exception e) {
							System.out.println("다시 시도해주세요.");
						}
						// 이후 정렬한 배열을 출력합니다
						for(int j=0; j<counter; j++) {
							System.out.print((j+1)+ "번: " + ascend_arr[j]+" ");
						}
						System.out.print("\n");
						break;
					case 2:
						// 기능2: 내림차순 출력 
						// 만약 counter가 0이라면 아무것도 출력할 것이 없습니다
						if(counter == 0) {
							System.out.println("입력된 문자열이 없습니다.");
							break;
						}
						// descend_arr에 본래의 arr 배열을 복사합니다
						for(int i=0; i<counter; i++) {
							descend_arr[i] = arr[i];
						}
						// sort가 안될 경우를 위해 try-catch (nullpointer)
						try{
							// 배열의 지정된 range 만큼만 sort합니다. (배열,시작인덱스,끝인덱스)
							// Collections.reverseOrder를 통해 내림차순 정렬합니다
							Arrays.sort(descend_arr,0,counter,Collections.reverseOrder());
						}catch(Exception e) {
							System.out.println("다시 시도해주세요.");
						}
						// 이후 정렬한 배열을 출력합니다
						for(int j=0; j<counter; j++) {
							System.out.print((j+1)+ "번: " + descend_arr[j]+" ");
						}
						System.out.print("\n");
						break;
					case 3:
						if(counter >= 19) {
							// 기능 4: 문자열이 20개가 넘어갈 경우 꽉 찼다는 에러 출력
							System.out.println("문자열의 개수가 20개 이상입니다.");
							break;
						}
						// 기능 3: 문자열 입력
						System.out.println("추가할 문자열을 입력해주세요: ");
						// 버퍼 클리어
						 sc.nextLine();
						// 스캐너 문자열 입력받음
						String temp = sc.nextLine();
						arr[counter] = temp;
						counter++;
						System.out.println("현재 입력된 문자열의 개수는 "+ counter + "개 입니다.");
						break;
					case 4:
						// 프로그램을 종료합니다
						System.out.println("Program exit");
						System.exit(0);
						break;
					}
			}catch (Exception e) {
				System.out.println("다시 시도해주세요.");
				sc.nextLine();
				continue;
			}
		}
		
	}

}
