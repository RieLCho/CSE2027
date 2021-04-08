// 2019112130 조양진
// Microwave.java

package week10_01;

public class Microwave implements on_off{
	/* 인터페이스 상속 메소드 */ 
	// on_off
	public void on() {
		if(isPlugged) {
			this.isStarted = true;
			System.out.println("Microwave 전원을 켰습니다.");
		}else {
			System.out.println("Microwave 콘센트에 연결되어 있지 않습니다.");
		}
	}
	public void off() {
		if(isPlugged) {
			this.isStarted = false;
			System.out.println("Microwave 전원을 껐습니다.");
		}else {
			System.out.println("Microwave 콘센트에 연결되어 있지 않습니다.");
		}
	}
	
	// 5개의 변수
	private boolean isPlugged;		// 콘센트에 연결되어있는지 여부
	private boolean isStarted;		// 가동중인지 여부
	private boolean isOpen;			// 전자레인지 뚜껑이 열렸는지 여부
	private boolean isPowerSaving;	// 절전모드 여부
	private boolean isClockMode;	// 시계모드 여부 (전자레인지에 시계를 띄울 수 있음)
	
	/* 추가 메소드 */
	// 콘센트에 꽂습니다
	public void plugIn() {
		this.isPlugged = true;
		System.out.println("Microwave 콘센트에 연결했습니다.");
	}
	// 콘센트를 뽑습니다
	public void plugOut() {
		this.isPlugged = false;
		System.out.println("Microwave 콘센트에 연결했습니다.");
	}
	// 뚜껑을 엽니다
	public void open() {
		this.isOpen = true;
		System.out.println("Microwave 뚜껑을 열었습니다.");
	}
	// 뚜껑을 닫습니다
	public void close() {
		this.isOpen = false;
		System.out.println("Microwave 뚜껑을 닫았습니다.");
	}
	// 절전모드를 킵니다
	public void powerSaveOn() {
		this.isPowerSaving = true;
		System.out.println("Microwave 절전모드를 켰습니다.");
	}
	// 절전모드를 끕니다
	public void powerSaveOff() {
		this.isPowerSaving = false;
		System.out.println("Microwave 절전모드를 껐습니다.");
	}
	// 시계모드를 킵니다
	public void clockModeOn() {
		this.isPowerSaving = true;
		System.out.println("Microwave 시계모드를 켰습니다.");
	}
	// 시계모드를 끕니다
	public void clockModeOff() {
		this.isPowerSaving = false;
		System.out.println("Microwave 시계모드를 껐습니다.");
	}
	// 상태
	public void status() {
		System.out.println("Microwave의 상태입니다.");
		System.out.println("콘센트: "+ this.isPlugged);
		System.out.println("가동중: "+this.isStarted);
		System.out.println("뚜껑열림: "+this.isOpen);
		System.out.println("절전모드: "+this.isPowerSaving);
		System.out.println("시계모드: "+this.isClockMode);
	}
}
