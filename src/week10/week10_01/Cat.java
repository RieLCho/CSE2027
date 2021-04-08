// 2019112130 조양진
// Cat.java

package week10_01;

import java.util.Random;

public class Cat implements move, life{
	/* 인터페이스 상속 메소드 */ 
	// move
	public void front(){
		if(!isSleeping) {
			// 움직였으니 다시 배고파집니다
			this.isHungry = true;
			System.out.println("Cat 앞으로 이동했습니다.");
		}else {
			System.out.println("Cat 자고 있습니다.");
		}
	}
	public void back() {
		if(!isSleeping) {
			this.isHungry = true;
			System.out.println("Cat 뒤로 이동했습니다.");
		}else {
			System.out.println("Cat 자고 있습니다.");
		}
	}
	public void left() {
		if(!isSleeping) {
			this.isHungry = true;
			System.out.println("Cat 왼쪽으로 이동했습니다.");
		}else {
			System.out.println("Cat 자고 있습니다.");
		}
	}
	public void right() {
		if(!isSleeping) {
			this.isHungry = true;
			System.out.println("Cat 오른쪽으로 이동했습니다.");
		}else {
			System.out.println("Cat 자고 있습니다.");
		}
	}
	
	// life
	public void eat() {
		if(!isSleeping) {
			this.isHungry = false;
			System.out.println("Cat 밥을 먹었습니다.");
		}else {
			System.out.println("Cat 자고 있습니다.");
		}
	}
	
	public void sleep() {
		this.isSleeping = true;
		System.out.println("Cat 잠을 잡니다.");
	}
	
	// 5개의 변수
	private boolean isSleeping;			// 자고 있는지 유무
	private boolean isHungry;			// 밥을 먹었는지 유무
	private String name = "No Named";	// 이름
	private int IQ = 0;					// IQ
	private boolean isMeowing;			// 울고 있는지 유무
	
	/* 추가 메소드 */
	// 잠에서 깨기
	public void wakeUp() {
		if(isSleeping) {
			this.isSleeping = false;
			System.out.println("Cat 잠을 깹니다.");
		}else {
			System.out.println("이미 Cat 잠이 깨어있습니다.");
		}
	}
	// 이름 정하기
	public void setName() {
		// 정해져있는 이름중에 랜덤으로 이름을 정합니다.
		String nameList[] = {"Ara", "Nari", "Hari", "Kyaru", "Peko"};
		Random rand = new Random(); 
		int temp = rand.nextInt(5);
		this.name = nameList[temp];
	}
	// IQ 정하기
	public void setIQ() {
		Random rand = new Random();
		this.IQ = rand.nextInt(50);
	}
	// 울기
	public void meowOn() {
		this.isMeowing = true;
		System.out.println("Cat 울기 시작했습니다.");
	}
	// 그만 울기
	public void meowOff() {
		this.isMeowing = false;
		System.out.println("Cat 울기를 멈췄습니다.");
	}
	
	// 상태
	public void status() {
		System.out.println("Cat의 상태입니다.");
		System.out.println("잠: "+ this.isSleeping);
		System.out.println("배고픔: "+this.isHungry);
		System.out.println("이름: "+this.name);
		System.out.println("IQ: " +this.IQ);
		System.out.println("울기:"+this.isMeowing);
	}
}
