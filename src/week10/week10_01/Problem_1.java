package week10_01;

interface on_off{
	public void on();
	public void off();
}

interface move{
	public void front();
	public void left();
	public void back();
	public void right();
}

interface life{
	public void eat();
	public void sleep();
}

public class Problem_1 {
	public static void testHuman() {
		Human a = new Human();
		a.setName();
		a.setJob();
		a.front();
		a.sleep();
		a.back();
		a.eat();
		a.wakeUp();
		a.setIQ();
		a.left();
		a.eat();
		a.status();
	}
	
	public static void testCat() {
		Cat b = new Cat();
		b.setName();
		b.setIQ();
		b.front();
		b.meowOn();
		b.left();
		b.status();
		b.meowOff();
	}
	
	public static void testDog() {
		Dog c = new Dog();
		c.eat();
		c.setIQ();
		c.setName();
		c.barkOn();
		c.right();
		c.sleep();
		c.left();
		c.eat();
		c.status();
	}
	
	public static void testMicrowave() {
		Microwave d = new Microwave();
		d.plugIn();
		d.on();
		d.clockModeOn();
		d.powerSaveOn();
		d.status();
	}
	
	public static void testTV() {
		TV e = new TV();
		e.setBrand();
		e.plugIn();
		e.on();
		e.channelUp();
		e.channelUp();
		e.powerSaveOn();
		e.status();
		e.powerSaveOff();
	}
	
	public static void testAirplane() {
		Airplane f = new Airplane();
		f.on();
		f.front();
		f.left();
		f.passengerOnBoard();
		f.oiling();
		f.setTargetDistance();
		f.right();
		f.status();
	}
	
	
	static public void main(String[] args) {
		// test class
		
		System.out.println("Human Test");
		testHuman();
		
		System.out.println("\nCat Test");
		testCat();
		
		System.out.println("\nDog Test");
		testDog();
		
		System.out.println("\nMicrowave Test");
		testMicrowave();
		
		System.out.println("\nTV Test");
		testTV();
		
		System.out.println("\nAirplane Test");
		testAirplane();
		
	}
}











