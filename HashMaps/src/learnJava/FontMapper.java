package learnJava;

import java.awt.Font;
import java.util.HashMap;
import java.util.Map;

public class FontMapper {

	public FontMapper() {
		Font times = new Font("Times New Roman", Font.BOLD, 12);
		Font verdana = new Font("Verdana", Font.ITALIC, 25);
		Font courier = new Font("Courier New", Font.PLAIN, 6);
		
		HashMap<String, Font> fonts = new HashMap<>();
		fonts.put("Основной текст", times);
		fonts.put("Заголовок", verdana);
		fonts.put("Мелкий шрифт", courier);
		
		for (Map.Entry<String, Font> entry: fonts.entrySet()) {
			String key = entry.getKey();
			Font value = entry.getValue();
			System.out.println(key + ": " + value.getSize() + "-pt " + value.getFontName());
		}
	}

	public static void main(String[] args) {
		new FontMapper();
	}

}
