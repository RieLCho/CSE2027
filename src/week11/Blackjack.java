// 2019112130 ������
// Blackjack.java

package week11;

/*
 * ������ �÷��̾� 2���� �����Ѵ�
 * ī��� ��Ŀ�� ������ 53���̴�
 * 2~10�� ���� �״�� ������, K/Q/J�� 10������, A�� 1 �Ǵ� 11, ��Ŀ�� ���� ������ ���� ���
 * ���� ���۰� ���ÿ� ������ ���̸Ӵ� ���������� ī�带 �ϳ��� �̾� ���� 2���� ī�带 �����Ѵ�
 * �������� ������ �����ϸ� ������ 2ī���� �հ� ������ 16�� �����̸� �ݵ�� 1���� �߰��� �̰�, 17�� �̻��̸� STAY�Ѵ�
 * �÷��̾�� �󸶵��� ī�带 �߰��� ���� �� �ִ�
 * ���� �� STAY�� ��� ������ �÷��̾� �� ������ ī���� ���� 21�� ����� ���� �¸��Ѵ�
 * �� 21�� �ʰ��ϸ� �ʰ��� ���� ����.
 * ������ �÷��̾��� ī��� ���� ���µǾ� ������ �÷��̾�� ������ Ȯ���� ����� �� �־�� �Ѵ�.
 */
import java.util.Random;
import java.util.Scanner;

public class Blackjack {
	 static int playerTurn = 0;	// �÷��̾� �� Ƚ��
	 static int dealerTurn = 0;	// ���� �� Ƚ��
	 					   // 0,1,2,3,4,5,6,7,8,9,10,11,12,13
	 			   		   // 2,3,4,5,6,7,8,9,10,K,Q,J,A,Joker
	 static int[] cardSet = {4,4,4,4,4,4,4,4,4,4,4,4,4,1};
	 static boolean endGame = false;	// ���� �ݺ� �÷���
	 
	 // ���� ī�� ��
	 static int[] dealerCardSet = new int[60];
	 // �÷��̾� ī�� ��
	 static int[] playerCardSet = new int[60];
	 // ���� ī�� ����
	 static int dealerCardPoint = 0;
	 // �÷��̾� ī�� ����
	 static int playerCardPoint = 0;
	 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();	
		 int command = 0; // ����� �Է� ����
		 
		 System.out.println("Blackjack Game");
		 
		 System.out.println("������ ù ������ ī�带 �̽��ϴ�.");
		 dealerDrawCard();
		 dealerDrawCard();
		 // ���� ī�� ��� �Լ�
		 printDealerCard();
		 
		 System.out.println("�÷��̾ ù ������ ī�带 �̽��ϴ�.");
		 playerDrawCard();
		 playerDrawCard();
		 // ���� ī�� ��� �Լ�
		 printPlayerCard();
		 
		
		 /*
		  * // ù ���忡 ������ ���� ���
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
			 // �ݺ��Ǵ� �Է�
			 dealerCardPoint = calculate(dealerCardSet, dealerTurn);
			 playerCardPoint = calculate(playerCardSet, playerTurn);
			 System.out.print("�ൿ�� �Է����ּ���. (1)Hit, (2)Stay, (3)Analyze: ");
			 try {
				 command = sc.nextInt();
				 System.out.println();
				 
				 if(command == 2) {
					 // ���� ���� �Լ�
					 normalEndGame();
				 }
				 else if(command == 1){
					 // ���� �� 16 üũ - ������ ���� ī�� �̴� �Լ�
					 if(dealerCardPoint <= 16 && dealerTurn==2) {
						 dealerDrawCard();
					 }else if(dealerCardPoint < 17) {
						 dealerDrawCard();
					 }
					 // �÷��̾� �� 21 ���� üũ - ũ�� ���� ���� �Լ�
					 if(playerCardPoint >= 21) {
						 // ���� ���� �Լ�
						 normalEndGame();
						 break;
					 }
					 // ���� ��ο�
					 printDealerCard();
					 // �÷��̾� �� 21 ���� üũ - ũ�� ���� ���� �Լ�
					 if(dealerCardPoint >= 21) {
						 // ���� ���� �Լ�
						 normalEndGame();
						 break;
					 }
					 // �÷��̾� ��ο�
					 playerDrawCard();
					 // ���� ī�� ��� �Լ�
					 printPlayerCard();
					 
				 }
				 else if(command == 3) {
					 playerAnalyze();
				 }
			 }catch (Exception e) {
				 System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է����ּ���.");
				 e.printStackTrace();
				 throw e;
			 }
		 }
	}
	
	// ī�� �̴� �Լ���
	public static void dealerDrawCard() {
		Random rand = new Random();
		// 0~13
		int temp = rand.nextInt(14);
		// cardSet���� 1 ���� ��
		if((cardSet[temp] == 0)) {
			// �ش� ������ ī�尡 ���ٸ� �ٽ� �̱�
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
		// cardSet���� 1 ���� ��
		if((cardSet[temp] == 0)) {
			// �ش� ������ ī�尡 ���ٸ� �ٽ� �̱�
			playerDrawCard();
		}else {
			cardSet[temp] -= 1;
			playerCardSet[playerTurn] = temp;
			playerTurn++;
		}
	}
	
	
	
	// ī�� ��� �Լ��� 
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
	
	// 21�� ���� �� �ִ� Ȯ�� ��� �Լ�
	public static void playerAnalyze() {
		System.out.println("Dealer Points: "+ dealerCardPoint);
		System.out.println("Player Points: "+ playerCardPoint);
		
		if((playerCardPoint > dealerCardPoint)&&((dealerCardPoint > 21) || (playerCardPoint <=21))) {
			System.out.println("Stay�ϸ� �̱�ϴ�.");
		}else if(playerCardPoint == dealerCardPoint) {
			System.out.println("Stay�ϸ� ���ϴ�.");
		}else {
			System.out.println("Stay�ϸ� ���ϴ�.");
		}
		
		// 21���� ���� �� �ִ� Ȯ���� ����ϴ� ���ǹ�
		if(playerCardPoint < 21) {
			int temp = 21 - playerCardPoint;
			if(temp > 11) {
				System.out.print("21�� ������� �� �� �� �̾ƾ� �մϴ�.");
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
					System.out.printf("%d�� �� %d�峲�� A �Ǵ� Joker�� �̾� 21�� ���� Ȯ���� %.2f%%�Դϴ�.", total, winTemp, winCase*100);
				}else if(temp == 10) {
					winTemp = cardSet[8] + cardSet[9] + cardSet[10] + cardSet[11];
					winCase = (float)winTemp/total;
					System.out.printf("%d�� �� 10, K, Q �Ǵ� J�� %d���� �̾� 21�� ���� Ȯ���� %.2f%%�Դϴ�.", total, winTemp, winCase*100);
				}else if(temp == 9) {
					winTemp = cardSet[7];
					winCase = (float)winTemp/total;
					System.out.printf("%d�� �� %d�峲�� 9�� �̾� 21�� ���� Ȯ���� %.2f%%�Դϴ�.", total,winTemp, winCase*100);
				}else if(temp == 8) {
					winTemp = cardSet[6];
					winCase = (float)winTemp/total;
					System.out.printf("%d�� �� %d�峲�� 8�� �̾� 21�� ���� Ȯ���� %.2f%%�Դϴ�.", total,winTemp, winCase*100);
				}else if(temp == 7) {
					winTemp = cardSet[5];
					winCase = (float)winTemp/total;
					System.out.printf("%d�� �� %d�峲�� 7�� �̾� 21�� ���� Ȯ���� %.2f%%�Դϴ�.", total,winTemp, winCase*100);
				}else if(temp == 6) {
					winTemp = cardSet[4];
					winCase = (float)winTemp/total;
					System.out.printf("%d�� �� %d�峲�� 6�� �̾� 21�� ���� Ȯ���� %.2f%%�Դϴ�.", total,winTemp, winCase*100);
				}else if(temp == 5) {
					winTemp = cardSet[3];
					winCase = (float)winTemp/total;
					System.out.printf("%d�� �� %d�峲�� 5�� �̾� 21�� ���� Ȯ���� %.2f%%�Դϴ�.", total,winTemp, winCase*100);
				}else if(temp == 4) {
					winTemp = cardSet[2];
					winCase = (float)winTemp/total;
					System.out.printf("%d�� �� %d�峲�� 4�� �̾� 21�� ���� Ȯ���� %.2f%%�Դϴ�.", total,winTemp, winCase*100);
				}else if(temp == 3) {
					winTemp = cardSet[1];
					winCase = (float)winTemp/total;
					System.out.printf("%d�� �� %d�峲�� 3�� �̾� 21�� ���� Ȯ���� %.2f%%�Դϴ�.", total,winTemp, winCase*100);
				}else if(temp == 2) {
					winTemp = cardSet[0];
					winCase = (float)winTemp/total;
					System.out.printf("%d�� �� %d�峲�� 2�� �̾� 21�� ���� Ȯ���� %.2f%%�Դϴ�.", total,winTemp, winCase*100);
				}
				System.out.println();
			}
		}
	}
	
	// ī�� ���� ��� �˰��� �Լ�
	public static int calculate(int[] input, int turnCounter) {
		int total = 0;
		int aCounter = 0;
		boolean isJokerIn = false;
		// 1. 2~10,J,Q,K�� �켱 ó��
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
		// 2. A�� ������ �����س��ٰ� 1���� ���Ͽ� ���ϱ�
		if(aCounter > 0) {
			for(int j=0; j<aCounter; j++) {
				if(total < 11) {
					total += 11;
				}else {
					total += 1;
				}
			}
		}
		// 3. ��Ŀ�� ����
		if(isJokerIn) {
			// total���� 1�� 11 ���̶�� total 21�� ���� �� �ֵ��� ���մϴ�
			if((21-total)>=1 && (21-total)<=11) {
				total += (21-total);
				// total���� 11���� �۴ٸ� 11�� ���մϴ�
			}else if(total<11) {
				total += 11;
				// ������ ���� 1�� ���մϴ�
			}else {
				total +=1;
			}
		}
		// total�� ��ȯ�մϴ�
		return total;
	}
	 
	
	// ���� ���� �Լ�
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
