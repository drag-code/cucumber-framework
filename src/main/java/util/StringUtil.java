package util;

public class StringUtil {
	public static String remove(String regex, String text) {
		return text.replaceAll(regex, "");
	}
	
	public static String replace(String regex, String text, String replacement) {
		return text.replaceAll(regex, replacement);
	}
}
