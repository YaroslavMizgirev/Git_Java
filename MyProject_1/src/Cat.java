
public class Cat {
	private int weight; //вес кота
	private String name; //имя кота
	private String color; //окрас кота
	
	//кот ест
	public void eat(){
		System.out.print("Кот кушает ...\n");
	}
	
	//кот спит
	public void sleep(){
		System.out.print("Кот спит ...zz-z-z-z...\n");
	}
	
	//кот говорит
	public String speak(String words){ 
		String phrase = "Кот говорит: " + words + " ...МЯУ...\n";
		return phrase;
	}
}
