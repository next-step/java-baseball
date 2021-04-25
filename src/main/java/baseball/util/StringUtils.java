package baseball.util;

public class StringUtils {

	private StringUtils() { }

	public static boolean isNumber(String value) {
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}

}
