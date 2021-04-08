// 2019112130 조양진
// Blackjack.java

package week11;

/*
 * 딜러와 플레이어 2명이 존재한다
 * 카드는 조커를 포함한 53장이다
 * 2~10은 숫자 그대로 점수를, K/Q/J는 10점으로, A는 1 또는 11, 조커는 가장 유리한 경우로 계산
 * 게임 시작과 동시에 딜러와 게이머는 순차적으로 카드를 하나씩 뽑아 각자 2개의 카드를 소지한다
 * 딜러부터 게임을 진행하며 딜러는 2카드의 합계 점수가 16점 이하이면 반드시 1장을 추가로 뽑고, 17점 이상이면 STAY한다
 * 플레이어는 얼마든지 카드를 추가로 뽑을 수 있다
 * 양쪽 다 STAY한 경우 딜러와 플레이어 중 소유한 카드의 합이 21에 가까운 쪽이 승리한다
 * 단 21을 초과하면 초과한 쪽이 진다.
 * 딜러와 플레이어의 카드는 전부 오픈되어 있으며 플레이어는 블랙잭의 확률을 계산할 수 있어야 한다.
 */
import java.util.Random;
import java.util.Scanner;

public class Blackjack {
	 static int playerTurn = 0;	// 플레이어 턴 횟수
	 static int dealerTurn = 0;	// 딜러 턴 횟수
	 					   // 0,1,2,3,4,5,6,7,8,9,10,11,12,13
	 			   		   // 2,3,4,5,6,7,8,9,10,K,Q,J,A,Joker
	 static int[] cardSet = {4,4,4,4,4,4,4,4,4,4,4,4,4,1};
	 static boolean endGame = false;	// 게임 반복 플래그
	 
	 // 딜러 카드 패
	 static int[] dealerCardSet = new int[60];
	 // 플레이어 카드 패
	 static int[] playerCardSet = new int[60];
	 // 딜러 카드 점수
	 static int dealerCardPoint = 0;
	 // 플레이어 카드 점수
	 static int playerCardPoint = 0;
	 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();	
		 int command = 0; // 사용자 입력 변수
		 
		 System.out.println("Blackjack Game");
		 
		 System.out.println("딜러가 첫 두장의 카드를 뽑습니다.");
		 dealerDrawCard();
		 dealerDrawCard();
		 // 뽑은 카드 출력 함수
		 printDealerCard();
		 
		 System.out.println("플레이어가 첫 두장의 카드를 뽑습니다.");
		 playerDrawCard();
		 playerDrawCard();
		 // 뽑은 카드 출력 함수
		 printPlayerCard();
		 
		
		 /*
		  * // 첫 두장에 게임이 끝난 경우
		 if(((playerCardPoint == 21) && (playerTurn == 2))&&
				 (dealerCardPoint == 21) && (dealerTurn == 2)) {
			 System.out.println("BLACKJACK!!!: DRAW");
			 endGame = true;
		 }
		 else if((playerCardPoint == 21) && (playerTurn == 2)) {
			 System.out.println("BLACKJACK!!!: Player WON");
			 endGame = true;
		 }else if((dealerCardPoint == 21) && (dealerTurn == 2)) {
			 System.out.println("BLACKJACK!!!: Dealer WON");
			 endGame = true;
		 }
		 */
		 
		 while(!endGame) {	 
			 // 반복되는 입력
			 dealerCardPoint = calculate(dealerCardSet, dealerTurn);
			 playerCardPoint = calculate(playerCardSet, playerTurn);
			 System.out.print("행동을 입력해주세요. (1)Hit, (2)Stay, (3)Analyze: ");
			 try {
				 command = sc.nextInt();
				 System.out.println();
				 
				 if(command == 2) {
					 // 게임 종료 함수
					 normalEndGame();
				 }
				 else if(command == 1){
					 // 딜러 합 16 체크 - 작으면 딜러 카드 뽑는 함수
					 if(dealerCardPoint <= 16 && dealerTurn==2) {
						 dealerDrawCard();
					 }else if(dealerCardPoint < 17) {
						 dealerDrawCard();
					 }
					 // 플레이어 합 21 오버 체크 - 크면 게임 종료 함수
					 if(playerCardPoint >= 21) {
						 // 게임 종료 함수
						 normalEndGame();
						 break;
					 }
					 // 딜러 드로우
					 printDealerCard();
					 // 플레이어 합 21 오버 체크 - 크면 게임 종료 함수
					 if(dealerCardPoint >= 21) {
						 // 게임 종료 함수
						 normalEndGame();
						 break;
					 }
					 // 플레이어 드로우
					 playerDrawCard();
					 // 뽑은 카드 출력 함수
					 printPlayerCard();
					 
				 }
				 else if(command == 3) {
					 playerAnalyze();
				 }
			 }catch (Exception e) {
				 System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
				 e.printStackTrace();
				 throw e;
			 }
		 }
	}
	
	// 카드 뽑는 함수들
	public static void dealerDrawCard() {
		Random rand = new Random();
		// 0~13
		int temp = rand.nextInt(14);
		// cardSet에서 1 빼고 비교
		if((cardSet[temp] == 0)) {
			// 해당 숫자의 카드가 없다면 다시 뽑기
			dealerDrawCard();
		}else {
			cardSet[temp] -= 1;
			dealerCardSet[dealerTurn] = temp;
			dealerTurn++;
		}
	}
	
	public static void playerDrawCard() {
		Random rand = new Random();
		int temp = rand.nextInt(14);
		// cardSet에서 1 빼고 비교
		if((cardSet[temp] == 0)) {
			// 해당 숫자의 카드가 없다면 다시 뽑기
			playerDrawCard();
		}else {
			cardSet[temp] -= 1;
			playerCardSet[playerTurn] = temp;
			playerTurn++;
		}
	}
	
	
	
	// 카드 출력 함수들 
	public static void printDealerCard() {
		System.out.printf("Dealer Cards:\n");
		for(int i=0; i<dealerTurn; i++) {
			if(dealerCardSet[i] >=0 && dealerCardSet[i] <=8) {
				System.out.printf(" %d ", dealerCardSet[i]+2);
			}
			else if(dealerCardSet[i]==9) {
				System.out.print(" K ");
			}
			else if(dealerCardSet[i]==10) {
				System.out.print(" Q ");
			}
			else if(dealerCardSet[i]==11) {
				System.out.print(" J ");
			}
			else if(dealerCardSet[i]==12) {
				System.out.print(" A ");
			}
			else if(dealerCardSet[i]==13) {
				System.out.print(" Joker ");
			}
		}
		System.out.println();
	}
	
	public static void printPlayerCard() {
		System.out.printf("Player Cards:\n");
		for(int i=0; i<playerTurn; i++) {
			if(playerCardSet[i] >=0 && playerCardSet[i] <=8) {
				System.out.printf(" %d ", playerCardSet[i]+2);
			}
			else if(playerCardSet[i]==9) {
				System.out.print(" K ");
			}
			else if(playerCardSet[i]==10) {
				System.out.print(" Q ");
			}
			else if(playerCardSet[i]==11) {
				System.out.print(" J ");
			}
			else if(playerCardSet[i]==12) {
				System.out.print(" A ");
			}
			else if(playerCardSet[i]==13) {
				System.out.print(" Joker ");
			}
		}
		System.out.println();
	}
	
	// 21을 만들 수 있는 확률 계산 함수
	public static void playerAnalyze() {
		System.out.println("Dealer Points: "+ dealerCardPoint);
		System.out.println("Player Points: "+ playerCardPoint);
		
		if((playerCardPoint > dealerCardPoint)&&((dealerCardPoint > 21) || (playerCardPoint <=21))) {
			System.out.println("Stay하면 이깁니다.");
		}else if(playerCardPoint == dealerCardPoint) {
			System.out.println("Stay하면 비깁니다.");
		}else {
			System.out.println("Stay하면 집니다.");
		}
		
		// 21점을 만들 수 있는 확률을 계산하는 조건문
		if(playerCardPoint < 21) {
			int temp = 21 - playerCardPoint;
			if(temp > 11) {
				System.out.print("21을 만들려면 한 장 더 뽑아야 합니다.");
			}else {
				int total = 0;
				int winTemp = 0;
				float winCase = 0;
				for(int i=0; i<14; i++) {
					total += cardSet[i];
				}
				if((temp == 11) || (temp == 1)) {
					winTemp = cardSet[12] + cardSet[13];
					winCase = (float)winTemp/total;
					System.out.printf("%d장 중 %d장남은 A 또는 Joker를 뽑아 21을 만들 확률은 %.2f%%입니다.", total, winTemp, winCase*100);
				}else if(temp == 10) {
					winTemp = cardSet[8] + cardSet[9] + cardSet[10] + cardSet[11];
					winCase = (float)winTemp/total;
					System.out.printf("%d장 중 10, K, Q 또는 J를 %d장을 뽑아 21을 만들 확률은 %.2f%%입니다.", total, winTemp, winCase*100);
				}else if(temp == 9) {
					winTemp = cardSet[7];
					winCase = (float)winTemp/total;
					System.out.printf("%d장 중 %d장남은 9를 뽑아 21을 만들 확률은 %.2f%%입니다.", total,winTemp, winCase*100);
				}else if(temp == 8) {
					winTemp = cardSet[6];
					winCase = (float)winTemp/total;
					System.out.printf("%d장 중 %d장남은 8를 뽑아 21을 만들 확률은 %.2f%%입니다.", total,winTemp, winCase*100);
				}else if(temp == 7) {
					winTemp = cardSet[5];
					winCase = (float)winTemp/total;
					System.out.printf("%d장 중 %d장남은 7를 뽑아 21을 만들 확률은 %.2f%%입니다.", total,winTemp, winCase*100);
				}else if(temp == 6) {
					winTemp = cardSet[4];
					winCase = (float)winTemp/total;
					System.out.printf("%d장 중 %d장남은 6를 뽑아 21을 만들 확률은 %.2f%%입니다.", total,winTemp, winCase*100);
				}else if(temp == 5) {
					winTemp = cardSet[3];
					winCase = (float)winTemp/total;
					System.out.printf("%d장 중 %d장남은 5를 뽑아 21을 만들 확률은 %.2f%%입니다.", total,winTemp, winCase*100);
				}else if(temp == 4) {
					winTemp = cardSet[2];
					winCase = (float)winTemp/total;
					System.out.printf("%d장 중 %d장남은 4를 뽑아 21을 만들 확률은 %.2f%%입니다.", total,winTemp, winCase*100);
				}else if(temp == 3) {
					winTemp = cardSet[1];
					winCase = (float)winTemp/total;
					System.out.printf("%d장 중 %d장남은 3를 뽑아 21을 만들 확률은 %.2f%%입니다.", total,winTemp, winCase*100);
				}else if(temp == 2) {
					winTemp = cardSet[0];
					winCase = (float)winTemp/total;
					System.out.printf("%d장 중 %d장남은 2를 뽑아 21을 만들 확률은 %.2f%%입니다.", total,winTemp, winCase*100);
				}
				System.out.println();
			}
		}
	}
	
	// 카드 점수 계산 알고리즘 함수
	public static int calculate(int[] input, int turnCounter) {
		int total = 0;
		int aCounter = 0;
		boolean isJokerIn = false;
		// 1. 2~10,J,Q,K는 우선 처리
		for(int i=0; i<turnCounter; i++) {
			if(input[i] == 0) {
				total +=2;
			}else if(input[i]==1){
				total +=3;
			}else if(input[i]==2){
				total +=4;
			}else if(input[i]==3){
				total +=5;
			}else if(input[i]==4){
				total +=6;
			}else if(input[i]==5){
				total +=7;
			}else if(input[i]==6){
				total +=8;
			}else if(input[i]==7){
				total +=9;
			}else if(input[i]==8){
				total +=10;
			}else if(input[i]==9){
				total +=10;
			}else if(input[i]==10){
				total +=10;
			}else if(input[i]==11){
				total +=10;
			}else if(input[i]==12) {
				aCounter++;
			}else if(input[i]==13) {
				isJokerIn = true;
			}
		}
		// 2. A의 개수를 저장해놨다가 1번과 비교하여 더하기
		if(aCounter > 0) {
			for(int j=0; j<aCounter; j++) {
				if(total < 11) {
					total += 11;
				}else {
					total += 1;
				}
			}
		}
		// 3. 조커의 유무
		if(isJokerIn) {
			// total값이 1과 11 사이라면 total 21에 맞출 수 있도록 더합니다
			if((21-total)>=1 && (21-total)<=11) {
				total += (21-total);
				// total값이 11보다 작다면 11을 더합니다
			}else if(total<11) {
				total += 11;
				// 나머지 경우는 1을 더합니다
			}else {
				total +=1;
			}
		}
		// total을 반환합니다
		return total;
	}
	 
	
	// 게임 종료 함수
	public static void normalEndGame() {
		System.out.println("Dealer Points: "+ dealerCardPoint);
		System.out.println("Player Points: "+ playerCardPoint);
		endGame = true;
		if(playerCardPoint > 21) {
			System.out.println("BUST: Dealer WON");
		}else if(dealerCardPoint > 21) {
			System.out.println("BUST: Player WON");
		}else if(playerCardPoint == dealerCardPoint) {
			System.out.println("DRAW");
		}else if(playerCardPoint-dealerCardPoint>0) {
			System.out.println("Player WON");
		}else if(playerCardPoint-dealerCardPoint<0) {
			System.out.println("Dealer WON");
		}
	}
	
}
