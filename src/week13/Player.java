// 2019112130 ������
// Player.java
package week13;

/*
������ �÷��̾�� �ϳ��� Ŭ������ ����ϸ� ��
Ŭ���� �ȿ� �ش� �÷��̾��� ���� Ȯ���� ���ϴ�
�Լ��� ���� �Լ��� �����

���ӿ� ���Ǵ� ī��� (String �迭 ) ���� ������
����Ѵ� �̶� ī�� ���̴� �����Ѵ�
 */

import java.util.Random;
public class Player {
	// �÷��̾��� �� ��
	public int turn = 0; 
							      // 2,  3,  4,  5,  6,  7,  8,  9,  10, K,  Q,  J,  A, Joker
	public static String[] deck = {"4","4","4","4","4","4","4","4","4","4","4","4","4","1"};
	// ī�� �ջ� ����
	public int cardPoint = 0;
	// �÷��̾��� ī�� ��
	public int[] cardSet = new int[60];
	// ī�� �̱� �Լ�
	public void drawCard() {
		Random rand = new Random();
		// 0~13
		int temp = rand.nextInt(14);
		// cardSet���� 1 ���� ��
		if((Integer.parseInt(deck[temp]) == 0)) {
			// �ش� ������ ī�尡 ���ٸ� �ٽ� �̱�
			drawCard();
		}else {
			deck[temp] = Integer.toString(Integer.parseInt(deck[temp]) - 1);
			cardSet[turn] = temp;
			turn++;
		}
	}
	// ��� �ִ� ī�� ��� �Լ�
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
	
	// �ش� �÷��̾��� ���� Ȯ���� ���ϴ��Լ��� ���� �Լ���
	public static void analyze(int point) {
		// 21���� ���� �� �ִ� Ȯ���� ����ϴ� ���ǹ�
				if(point < 21) {
					int temp = 21 - point;
					if(temp > 11) {
						System.out.print("21�� ������� �� �� �� �̾ƾ� �մϴ�.");
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
							System.out.printf("%d�� �� %d�峲�� A �Ǵ� Joker�� �̾� 21�� ���� Ȯ���� %.2f%%�Դϴ�.", total, winTemp, winCase*100);
						}else if(temp == 10) {
							winTemp = Integer.parseInt(deck[8]) + Integer.parseInt(deck[9]) + Integer.parseInt(deck[10]) + Integer.parseInt(deck[11]) + Integer.parseInt(deck[13]);
							winCase = (float)winTemp/total;
						System.out.printf("%d�� �� Joker, 10, K, Q �Ǵ� J�� %d���� �̾� 21�� ���� Ȯ���� %.2f%%�Դϴ�.", total, winTemp, winCase*100);
						}else if(temp == 9) {
							winTemp = Integer.parseInt(deck[7]) + Integer.parseInt(deck[13]);
							winCase = (float)winTemp/total;
							System.out.printf("%d�� �� %d�峲�� Joker, 9�� �̾� 21�� ���� Ȯ���� %.2f%%�Դϴ�.", total,winTemp, winCase*100);
						}else if(temp == 8) {
							winTemp = Integer.parseInt(deck[6]) + Integer.parseInt(deck[13]);
							winCase = (float)winTemp/total;
							System.out.printf("%d�� �� %d�峲�� Joker, 8�� �̾� 21�� ���� Ȯ���� %.2f%%�Դϴ�.", total,winTemp, winCase*100);
						}else if(temp == 7) {
							winTemp = Integer.parseInt(deck[5]) + Integer.parseInt(deck[13]);
							winCase = (float)winTemp/total;
							System.out.printf("%d�� �� %d�峲�� Joker, 7�� �̾� 21�� ���� Ȯ���� %.2f%%�Դϴ�.", total,winTemp, winCase*100);
						}else if(temp == 6) {
							winTemp = Integer.parseInt(deck[4]) + Integer.parseInt(deck[13]);
							winCase = (float)winTemp/total;
							System.out.printf("%d�� �� %d�峲�� Joker, 6�� �̾� 21�� ���� Ȯ���� %.2f%%�Դϴ�.", total,winTemp, winCase*100);
						}else if(temp == 5) {
							winTemp = Integer.parseInt(deck[3]) + Integer.parseInt(deck[13]);
							winCase = (float)winTemp/total;
							System.out.printf("%d�� �� %d�峲�� Joker, 5�� �̾� 21�� ���� Ȯ���� %.2f%%�Դϴ�.", total,winTemp, winCase*100);
						}else if(temp == 4) {
							winTemp = Integer.parseInt(deck[2]) + Integer.parseInt(deck[13]);
							winCase = (float)winTemp/total;
							System.out.printf("%d�� �� %d�峲�� Joker, 4�� �̾� 21�� ���� Ȯ���� %.2f%%�Դϴ�.", total,winTemp, winCase*100);
						}else if(temp == 3) {
							winTemp = Integer.parseInt(deck[1]) + Integer.parseInt(deck[13]);
							winCase = (float)winTemp/total;
							System.out.printf("%d�� �� %d�峲�� Joker, 3�� �̾� 21�� ���� Ȯ���� %.2f%%�Դϴ�.", total,winTemp, winCase*100);
						}else if(temp == 2) {
							winTemp = Integer.parseInt(deck[0]) + Integer.parseInt(deck[13]);
							winCase = (float)winTemp/total;
							System.out.printf("%d�� �� %d�峲�� Joker, 2�� �̾� 21�� ���� Ȯ���� %.2f%%�Դϴ�.", total,winTemp, winCase*100);
						}else if (temp == 0) {
							System.out.println("�̹� 21���Դϴ�.");
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
