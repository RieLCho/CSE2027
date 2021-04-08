// 2019112130 조양진
package week6;

public class Problem_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 0x0ffe;
		int y = 0xfff0;
		System.out.printf("%x\n", ~((x+1)&y));
		System.out.printf("%x\n", ~((x-14)|y));
		// 2번 문제
		System.out.printf("%x\n", x+1);
		System.out.printf("%x\n", y+15);
		System.out.printf("%x\n", (x+1)^(y+15));
	}

}
