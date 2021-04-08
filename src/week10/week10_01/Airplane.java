// 2019112130 조양진
// Airplane.java

package week10_01;
import java.util.Random;
public class Airplane implements on_off, move {
	/* 인터페이스 상속 메소드 */ 
	// on_off
	public void on() {
		this.isStarted = true;
		System.out.println("Airplane 시동을 켰습니다.");
	}
	public void off() {
		this.isStarted = false;
		System.out.println("Airplane 시동을 껐습니다.");
	}
	
	// move
	public void front(){
		if(isStarted) {
			System.out.println("Airplane 앞으로 이동했습니다.");
		}else {
			System.out.println("Airplane 시동이 꺼져있습니다.");
		}
	}
	public void back() {
		if(isStarted) {
			System.out.println("Airplane 뒤로 이동했습니다.");
		}else {
			System.out.println("Airplane 시동이 꺼져있습니다.");
		}
	}
	public void left() {
		if(isStarted) {
			System.out.println("Airplane 왼쪽으로 이동했습니다.");
		}else {
			System.out.println("Airplane 시동이 꺼져있습니다.");
		}
	}
	public void right() {
		if(isStarted) {
			System.out.println("Airplane 오른쪽으로 이동했습니다.");
		}else {
			System.out.println("Airplane 시동이 꺼져있습니다.");
		}
	}
	
	// 5개의 변수
	private boolean isStarted;		// 시동 켜졌는지 유무
	private double leftFuel;		// 남은 연료의 양
	private int passenger;			// 탑승객의 수
	private double targetDistance;	// 도착지까지의 거리 (km)
	private int travelCounter;		// 운행횟수
	
	/* 추가 메소드 */
	// 주유
	public void oiling() {
		this.leftFuel += 100;
		System.out.println("Airplane 100 리터 주유했습니다.");
	}
	
	// 탑승객 추가
	public void passengerOnBoard() {
		this.passenger += 1;
		System.out.println("Airplane 탑승객 증원했습니다.");
	}
	// 도착지거리 정하기
	public void setTargetDistance() {
		Random rand = new Random();
		targetDistance = rand.nextInt(1000);
		System.out.println("Airplane 다음 목적지의 거리가 정해졌습니다.");
	}
	// 상태
	public void status() {
		System.out.println("Airplane의 상태입니다.");
		System.out.println("시동: "+ this.isStarted);
		System.out.println("탑승객: "+this.passenger);
		System.out.println("남은 연료: "+this.leftFuel);
		System.out.println("도착지까지 거리: "+this.targetDistance);
	}
}
