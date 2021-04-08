// 2019112130 조양진
// Player.java
package week13;

/*
딜러와 플레이어는 하나의 클래스를 사용하며 이
클래스 안에 해당 플레이어의 블랙잭 확률을 구하는
함수를 정적 함수로 만든다

게임에 사용되는 카드는 (String 배열 ) 정적 변수를
사용한다 이때 카드 무늬는 무시한다
 */

import java.util.Random;
public class Player {
	// 플레이어의 턴 수
	public int turn = 0; 
							      // 2,  3,  4,  5,  6,  7,  8,  9,  10, K,  Q,  J,  A, Joker
	public static String[] deck = {"4","4","4","4","4","4","4","4","4","4","4","4","4","1"};
	// 카드 합산 점수
	public int cardPoint = 0;
	// 플레이어의 카드 패
	public int[] cardSet = new int[60];
	// 카드 뽑기 함수
	public void drawCard() {
		Random rand = new Random();
		// 0~13
		int temp = rand.nextInt(14);
		// cardSet에서 1 빼고 비교
		if((Integer.parseInt(deck[temp]) == 0)) {
			// 해당 숫자의 카드가 없다면 다시 뽑기
			drawCard();
		}else {
			deck[temp] = Integer.toString(Integer.parseInt(deck[temp]) - 1);
			cardSet[turn] = temp;
			turn++;
		}
	}
	// 들고 있는 카드 출력 함수
	public void printCard() {
		for(int i=0; i<turn; i++) {
			if(cardSet[i] >=0 && cardSet[i] <=8) {
				System.out.printf(" %d ", cardSet[i]+2);
			}
			else if(cardSet[i]==9) {
				System.out.print(" K ");
			}
			else if(cardSet[i]==10) {
				System.out.print(" Q ");
			}
			else if(cardSet[i]==11) {
				System.out.print(" J ");
			}
			else if(cardSet[i]==12) {
				System.out.print(" A ");
			}
			else if(cardSet[i]==13) {
				System.out.print(" Joker ");
			}
		}
		System.out.println();
	}
	
	// 해당 플레이어의 블랙잭 확률을 구하는함수를 정적 함수로
	public static void analyze(int point) {
		// 21점을 만들 수 있는 확률을 계산하는 조건문
				if(point < 21) {
					int temp = 21 - point;
					if(temp > 11) {
						System.out.print("21을 만들려면 한 장 더 뽑아야 합니다.");
					}else {
						int total = 0;
						int winTemp = 0;
						float winCase = 0;
						for(int i=0; i<14; i++) {
							total += Integer.parseInt(deck[i]);
						}
						if((temp == 11) || (temp == 1)) {
							winTemp = Integer.parseInt(deck[12]) + Integer.parseInt(deck[13]);
							winCase = (float)winTemp/total;
							System.out.printf("%d장 중 %d장남은 A 또는 Joker를 뽑아 21을 만들 확률은 %.2f%%입니다.", total, winTemp, winCase*100);
						}else if(temp == 10) {
							winTemp = Integer.parseInt(deck[8]) + Integer.parseInt(deck[9]) + Integer.parseInt(deck[10]) + Integer.parseInt(deck[11]) + Integer.parseInt(deck[13]);
							winCase = (float)winTemp/total;
						System.out.printf("%d장 중 Joker, 10, K, Q 또는 J를 %d장을 뽑아 21을 만들 확률은 %.2f%%입니다.", total, winTemp, winCase*100);
						}else if(temp == 9) {
							winTemp = Integer.parseInt(deck[7]) + Integer.parseInt(deck[13]);
							winCase = (float)winTemp/total;
							System.out.printf("%d장 중 %d장남은 Joker, 9를 뽑아 21을 만들 확률은 %.2f%%입니다.", total,winTemp, winCase*100);
						}else if(temp == 8) {
							winTemp = Integer.parseInt(deck[6]) + Integer.parseInt(deck[13]);
							winCase = (float)winTemp/total;
							System.out.printf("%d장 중 %d장남은 Joker, 8를 뽑아 21을 만들 확률은 %.2f%%입니다.", total,winTemp, winCase*100);
						}else if(temp == 7) {
							winTemp = Integer.parseInt(deck[5]) + Integer.parseInt(deck[13]);
							winCase = (float)winTemp/total;
							System.out.printf("%d장 중 %d장남은 Joker, 7를 뽑아 21을 만들 확률은 %.2f%%입니다.", total,winTemp, winCase*100);
						}else if(temp == 6) {
							winTemp = Integer.parseInt(deck[4]) + Integer.parseInt(deck[13]);
							winCase = (float)winTemp/total;
							System.out.printf("%d장 중 %d장남은 Joker, 6를 뽑아 21을 만들 확률은 %.2f%%입니다.", total,winTemp, winCase*100);
						}else if(temp == 5) {
							winTemp = Integer.parseInt(deck[3]) + Integer.parseInt(deck[13]);
							winCase = (float)winTemp/total;
							System.out.printf("%d장 중 %d장남은 Joker, 5를 뽑아 21을 만들 확률은 %.2f%%입니다.", total,winTemp, winCase*100);
						}else if(temp == 4) {
							winTemp = Integer.parseInt(deck[2]) + Integer.parseInt(deck[13]);
							winCase = (float)winTemp/total;
							System.out.printf("%d장 중 %d장남은 Joker, 4를 뽑아 21을 만들 확률은 %.2f%%입니다.", total,winTemp, winCase*100);
						}else if(temp == 3) {
							winTemp = Integer.parseInt(deck[1]) + Integer.parseInt(deck[13]);
							winCase = (float)winTemp/total;
							System.out.printf("%d장 중 %d장남은 Joker, 3를 뽑아 21을 만들 확률은 %.2f%%입니다.", total,winTemp, winCase*100);
						}else if(temp == 2) {
							winTemp = Integer.parseInt(deck[0]) + Integer.parseInt(deck[13]);
							winCase = (float)winTemp/total;
							System.out.printf("%d장 중 %d장남은 Joker, 2를 뽑아 21을 만들 확률은 %.2f%%입니다.", total,winTemp, winCase*100);
						}else if (temp == 0) {
							System.out.println("이미 21점입니다.");
						}
						System.out.println();
				}
			}else if (point > 21) {
				System.out.println("Over 21, BUSTED");
			}else {
				System.out.println("Blackjack - 21");
			}
	}
	
	
}
