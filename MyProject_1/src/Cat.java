
public class Cat {
	private int weight; //��� ����
	private String name; //��� ����
	private String color; //����� ����
	
	//��� ���
	public void eat(){
		System.out.print("��� ������ ...\n");
	}
	
	//��� ����
	public void sleep(){
		System.out.print("��� ���� ...zz-z-z-z...\n");
	}
	
	//��� �������
	public String speak(String words){ 
		String phrase = "��� �������: " + words + " ...���...\n";
		return phrase;
	}
	
	public static void main(String[] args) {
		Long a = (long) 2;
		double b = 1 / (double) a;
		System.out.println(b);
	}
}
