// 2019112130 Á¶¾çÁø
// Problem1.java
package week9_01;

public class Problem1 {
	public static Animal[] animals;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		animals = new Animal[3];
		animals[0] = new Cat();
		animals[1] = new Dog();
		animals[2] = new Cow();
		
		for(int i=0; i<animals.length; i++) {
			animals[i].bark();
		}
	}
}
