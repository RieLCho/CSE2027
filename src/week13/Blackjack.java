// 2019112130 조양진
// Blackjack.java
package week13;

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
import java.util.Scanner;

public class Blackjack {
	
	// Cpu 객체 생성 - Dealer
	public static Player Cpu = new Player();
	// User 객체 생성 - Player
	public static Player User = new Player();
	static boolean endGame = false;	// 게임 반복 플래그
	 
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		 int command = 0; // 사용자 입력 변수
		 
		 System.out.println("Blackjack Game");
		 MediaPlayer gamestart = new MediaPlayer();
		 gamestart.play("game_start");
		 
		 System.out.println("딜러가 첫 두장의 카드를 뽑습니다.");
		 Cpu.drawCard();
		 Cpu.drawCard();
		 // 뽑은 카드 출력 함수
		 Cpu.printCard();
		 System.out.println("플레이어가 첫 두장의 카드를 뽑습니다.");
		 User.drawCard();
		 User.drawCard();
		 // 뽑은 카드 출력 함수
		 User.printCard();
		 
		 while(!endGame) {	 
			 // 반복되는 입력
			 Cpu.cardPoint = calculate(Cpu.cardSet, Cpu.turn);
			 User.cardPoint = calculate(User.cardSet, User.turn);
			 System.out.print("\n행동을 입력해주세요.\n(1)Hit, (2)Stay, (3)Analyze Player, (4) Analyze Dealer: ");
			 
			 try {
				 sc.reset();
				 command = 0;
				 command = sc.nextInt();
				 System.out.println();
				 
				 if(command == 2) {
					 // 게임 종료 함수
					 normalEndGame();
					 // 프로그램이 종료되면 사운드가 씹히는 버그를 방지
					 Thread.sleep(2000);
				 }
				 else if(command == 1){
					 MediaPlayer hit = new MediaPlayer();
					 hit.play("hit_the_card");
					 
					 // 딜러 합 16 체크 - 작으면 딜러 카드 뽑는 함수
					 if(Cpu.cardPoint <= 16 && Cpu.turn==2) {
						 Cpu.drawCard();
					 }else if(Cpu.cardPoint < 17) {
						 Cpu.drawCard();
					 }
					 // 플레이어 합 21 오버 체크 - 크면 게임 종료 함수
					 if(User.cardPoint > 21) {
						 // 게임 종료 함수
						 normalEndGame();
						 // 프로그램이 종료되면 사운드가 씹히는 버그를 방지
						 Thread.sleep(2000);
						 break;
					 }
					 // 플레이어 합 21 오버 체크 - 크면 게임 종료 함수
					 if(Cpu.cardPoint > 21) {
						 // 게임 종료 함수
						 normalEndGame();
						 // 프로그램이 종료되면 사운드가 씹히는 버그를 방지
						 Thread.sleep(2000);
						 break;
					 }
					 // 플레이어 드로우
					 User.drawCard();
					 // 뽑은 카드 출력 함수
					 System.out.println("Dealer: ");
					 Cpu.printCard();
					 System.out.println("Player: ");
					 User.printCard();
				 }
				 else if(command == 3) {
					 User.analyze(User.cardPoint);
				 }
				 else if(command == 4) {
					 if(Cpu.cardPoint <= 16 && Cpu.turn==2) {
						 Cpu.analyze(Cpu.cardPoint);
					 }else if(Cpu.cardPoint < 17) {
						 Cpu.analyze(Cpu.cardPoint);
					 }else {
						 System.out.println("더이상 Dealer는 카드를 뽑지 않습니다.");
					 }
				 }
				 else {
					 throw new Exception("\n잘못된 입력입니다. 다시 입력해주세요.");
				 }
			 }catch (Exception e) {
				 System.out.println("\n잘못된 입력입니다. 다시 입력해주세요.");
				 sc = new Scanner(System.in);
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
		System.out.println("Dealer Points: "+ Cpu.cardPoint);
		System.out.println("Player Points: "+ User.cardPoint);
		MediaPlayer sound = new MediaPlayer();
		endGame = true;
		if(User.cardPoint > 21) {
			sound.play("lose");
			System.out.println("BUST: Dealer WON");
		}else if(Cpu.cardPoint > 21) {
			sound.play("win");
			System.out.println("BUST: Player WON");
		}else if(User.cardPoint == Cpu.cardPoint) {
			System.out.println("DRAW");
		}else if(User.cardPoint-Cpu.cardPoint>0) {
			sound.play("win");
			System.out.println("Player WON");
		}else if(User.cardPoint-Cpu.cardPoint<0) {
			sound.play("lose");
			System.out.println("Dealer WON");
		}
	}
	
}
