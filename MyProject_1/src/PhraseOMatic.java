import java.security.SecureRandom;

public class PhraseOMatic {

	public static void main(String[] args) {
		String[] wordListOne = {"��������������", "����-�������",
			"30000-�������", "��������", "�������� �������", "��������",
			"�� ������ ���-����������", "�����������", "�����", "����� ����",
			"����� ������������ ����", "����������"};
		String[] wordListTwo = {"��������������", "�������", "������ �������",
			"���������������", "�����������", "��������������", "����������������",
			"���������", "������������� ��", "�����������������", "�������",
			"���������������", "�������������� � �������", "�����������", 
			"���������� ��", "�����", "����������", "����������"};
		String[] wordListThree = {"�������", "����� ���������", "����� �� ���������",
			"��� ���������", "������", "������", "������� ������������ ��������",
			"������", "������ �������", "�����", "�������", "����� ����������"};
		
		//int oneLength = wordListOne.length;
		//int twoLength = wordListTwo.length;
		//int threeLength = wordListThree.length;
		
		SecureRandom secureRandom1 = new SecureRandom();
		//System.out.println(" " + secureRandom1);
		
		int rand1 = secureRandom1.nextInt(wordListOne.length);
		//System.out.print(" - " + secureRandom1);
		//System.out.println(" - " + wordListOne.length);
		
		int rand2 = secureRandom1.nextInt(wordListTwo.length);
		//System.out.print(" - " + secureRandom1);
		//System.out.println(" - " + rand2);
		
		int rand3 = secureRandom1.nextInt(wordListThree.length);
		//System.out.print(" - " + secureRandom1);
		//System.out.println(" - " + rand3);
		
		/*
		 * int rand1 = (int) (Math.random() * oneLength); System.out.print(" " +
		 * Math.random()); System.out.println(" - " + rand1); int rand2 = (int)
		 * (Math.random() * twoLength); System.out.print(" " + Math.random());
		 * System.out.println(" - " + rand2); int rand3 = (int) (Math.random() *
		 * threeLength); System.out.print(" " + Math.random());
		 * System.out.println(" - " + rand3);
		 */
		
		String phrase = wordListOne[rand1] + " " + wordListTwo[rand2] + " " + wordListThree[rand3];
		System.out.println("��� ��� ��� ����� - ��� " + phrase);
	}

}
