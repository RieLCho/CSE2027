package week10_02;

// TimeZone Ŭ���� ����� ���� import
import java.util.TimeZone;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

public class SimpleWatch {
	
	// �ð��븦 ������ time ��ü ����
	TimeZone time;
	// ���� ��¥�� �ð��� ������ �ν��Ͻ� ��ȯ
	Date date = new Date();
	// �ð� ��� ���� ���� df ��ü ����
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String nt;
	
	SimpleWatch(String input){
		// �����ڿ��� �Էµ� ���ڿ��� �ð��� �Ǻ��� get �޼ҵ�� �ð��� Ȯ��
		time = TimeZone.getTimeZone(input);
		// �˾Ƴ� �ð���� df��ü�� �ð��� �Է�
		df.setTimeZone(time);
	}
	
	public void time() {
		// ��������� �����Ͽ� ���
		System.out.format("%s%n%s%n",time.getDisplayName(),df.format(date));
	}
	
	public static void main(String[] args) {
		
		// �Ʒ� ������ ���� �����ڿ� String�� ���ڷ� ���� Ȯ��
		SimpleWatch wc1 = new SimpleWatch("Asia/Seoul");
		SimpleWatch wc2 = new SimpleWatch("JST");
		SimpleWatch wc3 = new SimpleWatch("America/New_York");
		
		// SimpleWatch class���� time �޼ҵ尡 ����
		wc1.time();
		wc2.time();
		wc3.time();
	}

}
