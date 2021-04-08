// 2019112130 ������

package week5;
import java.util.Scanner;
public class AdvancedDotCom {

	public static void main(String[] args) { 
		// ����ڿ��� ���� �Է¹ޱ� ���� scanner ���
		Scanner sc = new Scanner(System.in);
		// inputCounter -> ����ڿ��� �Է¹��� Ƚ���� ����, ���� ������ ���ǰ� ���� ���
		int inputCounter = 0;
		// hitCounter -> ����ڰ� try�� ��� hit �ߴ��� ����, ��迡�� ���
		int hitCounter = 0;
		// killCounter -> ����ڰ� try�� ��� kill �ߴ��� ����, ���� ������ ���ǰ� ���� ���
		int killCounter = 0;
		
		// map 2���� �迭 ���� - dotcom�� �����
		int[][] map = new int[10][10];
		for(int i =0; i<10; i++) {
			for(int j =0; j<10; j++) {
				// map 2���� �迭�� ��� 0���� �ʱ�ȭ -> �⺻ ���� 0���� ����
				map[i][j] = 0;
			}
		}
		
		// dotComCount -> Math.random�� ����Ͽ� 3~5 ������ ���� ���α׷� ����� ���� ����
		int dotComCount = (int)(Math.random()*3.0)+3;
		// ������ 2���� �迭�� ����
		System.out.println("Welcome to Dot Com Burst Game MK2!");
		System.out.println("Made by Yangjin Cho - 2019112130");
		System.out.println("Target kill: " + dotComCount +" kills\n");
		int[][] saveSeed = new int[dotComCount][2];
		
		// map�� dotcom (���簢�� ���) ���� 
		int counter = 0;
		while(counter != dotComCount) {
			// 10 by 10������ 10�� �Ǹ� 4ĭ ������ �ȵ� (map�� ���)
			//
			// ������� Math.random()*10�� �ϸ� 0~9�� ���������� 
			// [1][2]
			// [3][4]
			// ���� 1�� �ڸ��� �������� �õ带 �����Ͽ��� ������, 
			// Math.random()*10�� �ϸ� 10 by 10 �迭�� �𼭸� �κ� (���� ���ڸ� arr[10][10])�� 
			// �õ尡 ����� ���簢�� ����� dotcom�� ������ �� ��� �Ϻη� Math.random()*9�� �Ͽ� 
			// 0~8������ �õ带 �����Ͽ� dotcom�� ���������� ������ �� �ְԲ� �߽��ϴ�.
			int randomSeed_X = (int)(Math.random()*9);
			int randomSeed_Y = (int)(Math.random()*9);
			// ���� randomSeed�� ������ map�� �ִ� ���� ���ؼ�, �ֺ� ���簢�� �κ��� �� 0�� ��쿡��
			// (dotcom������ ��ġ�� �ȵǱ� ����)
			if((map[randomSeed_X][randomSeed_Y] == 0)
				&&(map[randomSeed_X][randomSeed_Y+1] == 0)
				&&(map[randomSeed_X+1][randomSeed_Y] == 0)
				&&(map[randomSeed_X+1][randomSeed_Y+1] == 0)) {
				try{
						// �õ带 �������� x�� ��ĭ y�� ��ĭ�� �� 1�� �ٲ���ϴ�. 
						//(���簢�� ��� dotcom ����!)
						map[randomSeed_X][randomSeed_Y] = 1;
						map[randomSeed_X][randomSeed_Y+1] = 1;
						map[randomSeed_X+1][randomSeed_Y] = 1;
						map[randomSeed_X+1][randomSeed_Y+1] = 1;
						
						// ���߿� kill check �� �� ����ϱ� ���ؼ� �����صӴϴ�. 
						// ex) ù��° �õ尡 5,5�� �������� �����Ǿ��ٸ� saveSeed�� 5,5�� ����
						saveSeed[counter][0] = randomSeed_X;
						saveSeed[counter][1] = randomSeed_Y;
						
				}catch(Exception e) {
					// ����ó��
				}
			// dotcom ���� �ݺ��� Ż���� ����
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
		
		// ����ڿ��� ��ǥ�� �Է¹޽��ϴ� (A~J)(0~9)
		// �ִ� �Է� ���� Ƚ���� 60���Դϴ�.
		while(inputCounter != 60) {
			// ���� ����ڰ� ��� dotcom�� kill�ߴٸ� �����մϴ�.
			if (killCounter == dotComCount) {
				break;
			}
			int input_X;
			int input_Y;
			try {
				// ���� �Է¹��� �� �ִ� Ƚ���� ����մϴ�.
				System.out.println("Left tryout: " + (60-inputCounter)+" times");
				// X ��ǥ�� �Է� �޽��ϴ�
				System.out.print("Enter X location (A~J): ");
				input_X = (sc.next().charAt(0))-65;
				// �Է°��� 0�� 9 ���̰� �ƴ϶�� ���ܸ� �����ϴ�.
				if(!(input_X<=9 && input_X>=0)) {
					Exception e = new Exception();
					throw e;
				}
				// ���� Ŭ����
				sc.nextLine();
				// Y ��ǥ�� �Է� �޽��ϴ�.
				System.out.print("Enter Y location (0~9): ");
				input_Y = sc.nextInt();
				// �Է°��� 0�� 9 ���̰� �ƴ϶�� ���ܸ� �����ϴ�.
				if(!(input_Y<=9 && input_Y>=0)) {
					Exception e = new Exception();
					throw e;
				}
				// ���� Ŭ����
				sc.nextLine();
				
			}catch(Exception e) {
				// �߰��� ��� - �Է� ����ó��
				System.out.println("Wrong input. Please try again.\n");
				// ���� Ŭ����
				sc.nextLine();
				continue;
			}
			
			// �Է¹��� ��ǥ ������ map ����
			if(map[input_X][input_Y] == 1) {
				System.out.println("\nHit!\n");
				// Hit ���Ŀ� map�� ����մϴ�.
				map[input_X][input_Y] = 2;
				for(int x =0; x<map.length; x++) {
					for(int y=0; y<map[x].length; y++) {
						// 2�� �Ǿ� �ִ� ���� Hit
						if(map[x][y] == 2) {
							System.out.print("[O]");
						}
						// 3���� �Ǿ� �ִ� ���� �̹� Kill�� ��
						else if(map[x][y] == 3) {
							System.out.print("[X]");
						}
						// �� �ܴ� ���� ó���մϴ�
						else {
						System.out.print("[ ]");
						}
					}
					System.out.println();
				}
				hitCounter++;
				// hit�� �� �������� ������ kill check�� �մϴ�.
				// kill check - �������� ������ dotcom ������ŭ Ȯ��
				for(int i=0; i<dotComCount; i++) {
					// �Ʊ� saveSeed�� �����ص� ��ǥ�� �������� 
					// �ֺ� +1 �� �� Ȯ���մϴ�.
					int seed_X = saveSeed[i][0];
					int seed_Y = saveSeed[i][1];
					// �ֺ� ���簢���� �� hit�� ���,
					if((map[seed_X][seed_Y] == 2)
						&&(map[seed_X][seed_Y+1] == 2)
						&&(map[seed_X+1][seed_Y] == 2)
						&&(map[seed_X+1][seed_Y+1] == 2)) {
							// ��� �� kill�� �ٲߴϴ�.
							map[seed_X][seed_Y] = 3;
							map[seed_X][seed_Y+1] = 3;
							map[seed_X+1][seed_Y] = 3;
							map[seed_X+1][seed_Y+1] = 3;
							
							System.out.println("\nKilled!\n");
							
							// �ٽ� map�� ������ݴϴ�.
							for(int x =0; x<map.length; x++) {
								for(int y=0; y<map[x].length; y++) {
									// 2�� �Ǿ� �ִ� ���� Hit
									if(map[x][y] == 2) {
										System.out.print("[O]");
									}
									// 3���� �Ǿ� �ִ� ���� �̹� Kill�� ��
									else if(map[x][y] == 3) {
										System.out.print("[X]");
									}
									// �� �ܴ� ���� ó���մϴ�
									else {
									System.out.print("[ ]");
									}
								}
								System.out.println();
							}
							++killCounter;
					}
				}
			// �߰��� ��� - �̹� hit�� ���� ���� ǥ���մϴ�.
			}else if(map[input_X][input_Y] == 2) {
				System.out.println("\nAlready hit.\n");
			// �߰��� ��� - �̹� kill�� dotcom�� ���� ǥ���մϴ�.
			}else if (map[input_X][input_Y] == 3) {
				System.out.println("\nAlready killed.\n");
			}else{
				System.out.println("\nMiss.\n");
			}
			// �Է� Ƚ���� ���մϴ�
			inputCounter++;
		}
		
		// �߰��� ��� - �ð����� ��� ��� �� ��� ���		
		System.out.println("\n======= Game Over =======\n");

		for(int x =0; x<map.length; x++) {
			for(int y=0; y<map[x].length; y++) {
				// 2�� �Ǿ� �ִ� ���� Hit
				if(map[x][y] == 2) {
					System.out.print("[O]");
				}
				// 3���� �Ǿ� �ִ� ���� �̹� Kill�� ��
				else if(map[x][y] == 3) {
					System.out.print("[X]");
				}
				// �� �ܴ� ���� ó���մϴ�
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

