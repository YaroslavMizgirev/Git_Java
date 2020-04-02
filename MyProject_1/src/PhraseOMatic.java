import java.security.SecureRandom;

public class PhraseOMatic {

	public static void main(String[] args) {
		String[] wordListOne = {"круглосуточный", "трех-звенный",
			"30000-футовый", "взаимный", "обоюдный выигрыш", "фронтэнд",
			"на основе вэб-технологий", "проникающий", "умный", "шесть сигм",
			"метод критического пути", "динамичный"};
		String[] wordListTwo = {"уполномоченный", "трудный", "чистый продукт",
			"ориентированный", "центральный", "распределенный", "кластеризованный",
			"фирменный", "нестандартный ум", "позиционированный", "сетевой",
			"сфокусированный", "использованный с выгодой", "выровненный", 
			"нацеленный на", "общий", "совместный", "ускоренный"};
		String[] wordListThree = {"процесс", "пункт разгрузки", "выход из положения",
			"тип структуры", "талант", "подход", "уровень завоеванного внимания",
			"портал", "период времени", "обзор", "образец", "пункт следования"};
		
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
		System.out.println("Все что нам нужно - это " + phrase);
	}

}
