
public class StaticByName {

	public static void main(String[] args) {
		StaticDemo.callme(); 
		//System.out.println("b  =  "  +  StaticDemo.b);
		
		StaticDemo ab1 = new StaticDemo();
		StaticDemo.callme();
		
		StaticDemo ab2 = new StaticDemo(10, 11);
		StaticDemo.callme();
	}

}
