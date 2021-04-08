// 2019112130 조양진

package week5;
import java.util.Scanner;
public class AdvancedDotCom {

	public static void main(String[] args) { 
		// 사용자에게 값을 입력받기 위해 scanner 사용
		Scanner sc = new Scanner(System.in);
		// inputCounter -> 사용자에게 입력받은 횟수를 저장, 게임 오버의 조건과 통계로 사용
		int inputCounter = 0;
		// hitCounter -> 사용자가 try중 몇번 hit 했는지 저장, 통계에서 사용
		int hitCounter = 0;
		// killCounter -> 사용자가 try중 몇번 kill 했는지 저장, 게임 종료의 조건과 통계로 사용
		int killCounter = 0;
		
		// map 2차원 배열 생성 - dotcom이 저장됨
		int[][] map = new int[10][10];
		for(int i =0; i<10; i++) {
			for(int j =0; j<10; j++) {
				// map 2차원 배열을 모두 0으로 초기화 -> 기본 값을 0으로 설정
				map[i][j] = 0;
			}
		}
		
		// dotComCount -> Math.random을 사용하여 3~5 사이의 값을 프로그램 실행시 마다 생성
		int dotComCount = (int)(Math.random()*3.0)+3;
		// 저장할 2차원 배열을 생성
		System.out.println("Welcome to Dot Com Burst Game MK2!");
		System.out.println("Made by Yangjin Cho - 2019112130");
		System.out.println("Target kill: " + dotComCount +" kills\n");
		int[][] saveSeed = new int[dotComCount][2];
		
		// map에 dotcom (정사각형 모양) 생성 
		int counter = 0;
		while(counter != dotComCount) {
			// 10 by 10이지만 10가 되면 4칸 생성이 안됨 (map을 벗어남)
			//
			// 예를들어 Math.random()*10을 하면 0~9가 생성되지만 
			// [1][2]
			// [3][4]
			// 저는 1번 자리를 기준으로 시드를 생성하였기 때문에, 
			// Math.random()*10을 하면 10 by 10 배열의 모서리 부분 (예를 들자면 arr[10][10])에 
			// 시드가 생기면 정사각형 모양의 dotcom을 생성할 수 없어서 일부러 Math.random()*9를 하여 
			// 0~8까지의 시드를 생성하여 dotcom을 정상적으로 생성할 수 있게끔 했습니다.
			int randomSeed_X = (int)(Math.random()*9);
			int randomSeed_Y = (int)(Math.random()*9);
			// 이후 randomSeed의 값으로 map에 있는 값을 비교해서, 주변 정사각형 부분이 다 0인 경우에만
			// (dotcom끼리는 겹치면 안되기 때문)
			if((map[randomSeed_X][randomSeed_Y] == 0)
				&&(map[randomSeed_X][randomSeed_Y+1] == 0)
				&&(map[randomSeed_X+1][randomSeed_Y] == 0)
				&&(map[randomSeed_X+1][randomSeed_Y+1] == 0)) {
				try{
						// 시드를 기준으로 x로 한칸 y로 한칸씩 다 1로 바꿨습니다. 
						//(정사각형 모양 dotcom 생성!)
						map[randomSeed_X][randomSeed_Y] = 1;
						map[randomSeed_X][randomSeed_Y+1] = 1;
						map[randomSeed_X+1][randomSeed_Y] = 1;
						map[randomSeed_X+1][randomSeed_Y+1] = 1;
						
						// 나중에 kill check 할 때 사용하기 위해서 저장해둡니다. 
						// ex) 첫번째 시드가 5,5를 기준으로 생성되었다면 saveSeed에 5,5를 저장
						saveSeed[counter][0] = randomSeed_X;
						saveSeed[counter][1] = randomSeed_Y;
						
				}catch(Exception e) {
					// 예외처리
				}
			// dotcom 생성 반복문 탈출을 위해
			counter ++;
			}
		}
		
		// For debugging - show map how generated
		/*
		for(int i =0; i<map.length; i++) {
			for(int j=0; j<map[i].length; j++) {
				if(map[i][j] == 1) {
					System.out.print("[X]");
				}
				else {
				System.out.print("[ ]");
				}
			}
			System.out.println();
		}
		System.out.println();
		*/
		
		// 사용자에게 좌표를 입력받습니다 (A~J)(0~9)
		// 최대 입력 받을 횟수는 60번입니다.
		while(inputCounter != 60) {
			// 만약 사용자가 모든 dotcom을 kill했다면 종료합니다.
			if (killCounter == dotComCount) {
				break;
			}
			int input_X;
			int input_Y;
			try {
				// 남은 입력받을 수 있는 횟수를 출력합니다.
				System.out.println("Left tryout: " + (60-inputCounter)+" times");
				// X 좌표를 입력 받습니다
				System.out.print("Enter X location (A~J): ");
				input_X = (sc.next().charAt(0))-65;
				// 입력값이 0과 9 사이가 아니라면 예외를 던집니다.
				if(!(input_X<=9 && input_X>=0)) {
					Exception e = new Exception();
					throw e;
				}
				// 버퍼 클리어
				sc.nextLine();
				// Y 좌표를 입력 받습니다.
				System.out.print("Enter Y location (0~9): ");
				input_Y = sc.nextInt();
				// 입력값이 0과 9 사이가 아니라면 예외를 던집니다.
				if(!(input_Y<=9 && input_Y>=0)) {
					Exception e = new Exception();
					throw e;
				}
				// 버퍼 클리어
				sc.nextLine();
				
			}catch(Exception e) {
				// 추가한 기능 - 입력 예외처리
				System.out.println("Wrong input. Please try again.\n");
				// 버퍼 클리어
				sc.nextLine();
				continue;
			}
			
			// 입력받은 좌표 값으로 map 변경
			if(map[input_X][input_Y] == 1) {
				System.out.println("\nHit!\n");
				// Hit 이후에 map을 출력합니다.
				map[input_X][input_Y] = 2;
				for(int x =0; x<map.length; x++) {
					for(int y=0; y<map[x].length; y++) {
						// 2로 되어 있는 곳은 Hit
						if(map[x][y] == 2) {
							System.out.print("[O]");
						}
						// 3으로 되어 있는 곳은 이미 Kill된 곳
						else if(map[x][y] == 3) {
							System.out.print("[X]");
						}
						// 그 외는 공란 처리합니다
						else {
						System.out.print("[ ]");
						}
					}
					System.out.println();
				}
				hitCounter++;
				// hit을 한 다음에는 무조건 kill check를 합니다.
				// kill check - 랜덤으로 생성된 dotcom 개수만큼 확인
				for(int i=0; i<dotComCount; i++) {
					// 아까 saveSeed에 저장해둔 좌표를 기준으로 
					// 주변 +1 씩 다 확인합니다.
					int seed_X = saveSeed[i][0];
					int seed_Y = saveSeed[i][1];
					// 주변 정사각형이 다 hit인 경우,
					if((map[seed_X][seed_Y] == 2)
						&&(map[seed_X][seed_Y+1] == 2)
						&&(map[seed_X+1][seed_Y] == 2)
						&&(map[seed_X+1][seed_Y+1] == 2)) {
							// 모두 다 kill로 바꿉니다.
							map[seed_X][seed_Y] = 3;
							map[seed_X][seed_Y+1] = 3;
							map[seed_X+1][seed_Y] = 3;
							map[seed_X+1][seed_Y+1] = 3;
							
							System.out.println("\nKilled!\n");
							
							// 다시 map을 출력해줍니다.
							for(int x =0; x<map.length; x++) {
								for(int y=0; y<map[x].length; y++) {
									// 2로 되어 있는 곳은 Hit
									if(map[x][y] == 2) {
										System.out.print("[O]");
									}
									// 3으로 되어 있는 곳은 이미 Kill된 곳
									else if(map[x][y] == 3) {
										System.out.print("[X]");
									}
									// 그 외는 공란 처리합니다
									else {
									System.out.print("[ ]");
									}
								}
								System.out.println();
							}
							++killCounter;
					}
				}
			// 추가한 기능 - 이미 hit한 곳은 따로 표시합니다.
			}else if(map[input_X][input_Y] == 2) {
				System.out.println("\nAlready hit.\n");
			// 추가한 기능 - 이미 kill한 dotcom은 따로 표시합니다.
			}else if (map[input_X][input_Y] == 3) {
				System.out.println("\nAlready killed.\n");
			}else{
				System.out.println("\nMiss.\n");
			}
			// 입력 횟수를 더합니다
			inputCounter++;
		}
		
		// 추가한 기능 - 시각적인 결과 출력 및 통계 출력		
		System.out.println("\n======= Game Over =======\n");

		for(int x =0; x<map.length; x++) {
			for(int y=0; y<map[x].length; y++) {
				// 2로 되어 있는 곳은 Hit
				if(map[x][y] == 2) {
					System.out.print("[O]");
				}
				// 3으로 되어 있는 곳은 이미 Kill된 곳
				else if(map[x][y] == 3) {
					System.out.print("[X]");
				}
				// 그 외는 공란 처리합니다
				else {
				System.out.print("[ ]");
				}
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("Your kill: " + killCounter);
		System.out.println("Your hit: " + hitCounter);
		System.out.println("Your try: " + inputCounter);
		System.out.println("\nThank you for playing.");
	}		
}

