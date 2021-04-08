package java_Week2;

public class test {
	public static void main(String[] args) {
		// Exam1 - Snack
		// Snack 클래스의 mySnack 객체 생성
		Snack mySnack = new Snack();
		// mySncak 객체에 저장할 데이터를 입력
		mySnack.Setinfo();
		// mySnack 객체에 저장되어 있는 데이터를 출력
		mySnack.Printinfo();
		
		
		// Exam2 - Pyramid
		// 피라미드 클래스의 피라미드 객체 생성
		Pyramid py =  new Pyramid();
		// 피라미드 객체 py의 클래스 변수값을 입력받음
		py.SetInfo();
		// 별을 찍습니다
		py.printStar();
	}
}
