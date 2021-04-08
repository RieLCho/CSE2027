// 2019112130 ������
// Blackjack.java
package week13;

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
import java.util.Scanner;

public class Blackjack {
	
	// Cpu ��ü ���� - Dealer
	public static Player Cpu = new Player();
	// User ��ü ���� - Player
	public static Player User = new Player();
	static boolean endGame = false;	// ���� �ݺ� �÷���
	 
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		 int command = 0; // ����� �Է� ����
		 
		 System.out.println("Blackjack Game");
		 MediaPlayer gamestart = new MediaPlayer();
		 gamestart.play("game_start");
		 
		 System.out.println("������ ù ������ ī�带 �̽��ϴ�.");
		 Cpu.drawCard();
		 Cpu.drawCard();
		 // ���� ī�� ��� �Լ�
		 Cpu.printCard();
		 System.out.println("�÷��̾ ù ������ ī�带 �̽��ϴ�.");
		 User.drawCard();
		 User.drawCard();
		 // ���� ī�� ��� �Լ�
		 User.printCard();
		 
		 while(!endGame) {	 
			 // �ݺ��Ǵ� �Է�
			 Cpu.cardPoint = calculate(Cpu.cardSet, Cpu.turn);
			 User.cardPoint = calculate(User.cardSet, User.turn);
			 System.out.print("\n�ൿ�� �Է����ּ���.\n(1)Hit, (2)Stay, (3)Analyze Player, (4) Analyze Dealer: ");
			 
			 try {
				 sc.reset();
				 command = 0;
				 command = sc.nextInt();
				 System.out.println();
				 
				 if(command == 2) {
					 // ���� ���� �Լ�
					 normalEndGame();
					 // ���α׷��� ����Ǹ� ���尡 ������ ���׸� ����
					 Thread.sleep(2000);
				 }
				 else if(command == 1){
					 MediaPlayer hit = new MediaPlayer();
					 hit.play("hit_the_card");
					 
					 // ���� �� 16 üũ - ������ ���� ī�� �̴� �Լ�
					 if(Cpu.cardPoint <= 16 && Cpu.turn==2) {
						 Cpu.drawCard();
					 }else if(Cpu.cardPoint < 17) {
						 Cpu.drawCard();
					 }
					 // �÷��̾� �� 21 ���� üũ - ũ�� ���� ���� �Լ�
					 if(User.cardPoint > 21) {
						 // ���� ���� �Լ�
						 normalEndGame();
						 // ���α׷��� ����Ǹ� ���尡 ������ ���׸� ����
						 Thread.sleep(2000);
						 break;
					 }
					 // �÷��̾� �� 21 ���� üũ - ũ�� ���� ���� �Լ�
					 if(Cpu.cardPoint > 21) {
						 // ���� ���� �Լ�
						 normalEndGame();
						 // ���α׷��� ����Ǹ� ���尡 ������ ���׸� ����
						 Thread.sleep(2000);
						 break;
					 }
					 // �÷��̾� ��ο�
					 User.drawCard();
					 // ���� ī�� ��� �Լ�
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
						 System.out.println("���̻� Dealer�� ī�带 ���� �ʽ��ϴ�.");
					 }
				 }
				 else {
					 throw new Exception("\n�߸��� �Է��Դϴ�. �ٽ� �Է����ּ���.");
				 }
			 }catch (Exception e) {
				 System.out.println("\n�߸��� �Է��Դϴ�. �ٽ� �Է����ּ���.");
				 sc = new Scanner(System.in);
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
