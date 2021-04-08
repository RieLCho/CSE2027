// 2019112130 조양진
// TV.java

package week10_01;

import java.util.Random;

public class TV implements on_off{
	/* 인터페이스 상속 메소드 */ 
	// on_off
	public void on() {
		if(isPlugged) {
			this.isPowerOn = true;
			System.out.println("TV 전원을 켰습니다.");
		}else {
			System.out.println("TV 콘센트에 연결되어 있지 않습니다.");
		}
	}
	public void off() {
		if(isPlugged) {
			this.isPowerOn = false;
			System.out.println("TV 전원을 껐습니다.");
		}else {
			System.out.println("TV 콘센트에 연결되어 있지 않습니다.");
		}
	}
	
	// 5개의 변수
	private boolean isPlugged;		// 콘센트에 연결되어있는지 여부
	private boolean isPowerOn;		// 전원이 켜졌는지 여부
	private boolean isPowerSaving;	// 절전모드 여부
	private int		channel;		// 채널
	private String	brand;			// TV 제조사
	
	/* 추가 메소드 */
	// 콘센트에 꽂습니다
	public void plugIn() {
		this.isPlugged = true;
		System.out.println("TV 콘센트에 연결했습니다.");
	}
	// 콘센트를 뽑습니다
	public void plugOut() {
		this.isPlugged = false;
		System.out.println("TV 콘센트에 연결했습니다.");
	}
	// 절전모드를 킵니다
	public void powerSaveOn() {
		this.isPowerSaving = true;
		System.out.println("TV 절전모드를 켰습니다.");
	}
	// 절전모드를 끕니다
	public void powerSaveOff() {
		this.isPowerSaving = false;
		System.out.println("TV 절전모드를 껐습니다.");
	}
	public void channelUp() {
		this.channel += 1;
		System.out.println("TV 채널을 올렸습니다.");
	}
	public void channelDown() {
		if(!(channel==0)) {
			this.channel -= 1;
			System.out.println("TV 채널을 내렸습니다.");
		}else {
			System.out.println("채널을 내릴 수 없습니다.");
		}
	}
	public void setBrand() {
		String nameList[] = {"Samsung", "LG", "Apple", "Xiaomi", "Panasonic"};
		Random rand = new Random(); 
		int temp = rand.nextInt(5);
		this.brand = nameList[temp];
	}
	// 상태
	public void status() {
		System.out.println("TV의 상태입니다.");
		System.out.println("제조사: "+ this.brand);
		System.out.println("콘센트: "+ this.isPlugged);
		System.out.println("가동중: "+this.isPowerOn);
		System.out.println("절전모드: "+this.isPowerSaving);
		System.out.println("채널: "+this.channel);
	}
}
