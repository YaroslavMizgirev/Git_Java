
public class StaticDemo {
	
	static int a = 42;
	static int b = 99;
	
	static void callme() {
		System.out.println("a = " + a);
		System.out.println("b = " + b);
	}
	
	public StaticDemo() {
		a = 55;
		b = 56;
		System.out.println("Constructor without parameters");
	}
	
	public StaticDemo(int i, int j) {
		a = i;
		b = j;
		System.out.println("Constructor with parameters");
	}

}
