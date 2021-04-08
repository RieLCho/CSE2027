package week10_02;

// TimeZone 클래스 사용을 위해 import
import java.util.TimeZone;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

public class SimpleWatch {
	
	// 시간대를 저장할 time 객체 생성
	TimeZone time;
	// 현재 날짜와 시간을 가지는 인스턴스 반환
	Date date = new Date();
	// 시간 출력 형식 지정 df 객체 생성
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String nt;
	
	SimpleWatch(String input){
		// 생성자에서 입력된 문자열로 시간대 판별후 get 메소드로 시간대 확보
		time = TimeZone.getTimeZone(input);
		// 알아낸 시간대로 df객체에 시간대 입력
		df.setTimeZone(time);
	}
	
	public void time() {
		// 출력형식을 지정하여 출력
		System.out.format("%s%n%s%n",time.getDisplayName(),df.format(date));
	}
	
	public static void main(String[] args) {
		
		// 아래 사용법을 통해 생성자에 String이 인자로 들어감을 확인
		SimpleWatch wc1 = new SimpleWatch("Asia/Seoul");
		SimpleWatch wc2 = new SimpleWatch("JST");
		SimpleWatch wc3 = new SimpleWatch("America/New_York");
		
		// SimpleWatch class에는 time 메소드가 존재
		wc1.time();
		wc2.time();
		wc3.time();
	}

}
