package game.baseball.domain.shared;

import java.util.StringJoiner;

public class StringUtils {
	public static final String EMPTY = "";
	public static final String BLANK = " ";

	public static String join(String delimiter, String... strings) {
		StringJoiner stringJoiner = new StringJoiner(delimiter);

		for (String string : strings) {
			addStringJoiner(stringJoiner, string);
		}

		return stringJoiner.toString();
	}

	private static void addStringJoiner(StringJoiner stringJoiner, String string) {
		if (string != null && !string.equals(EMPTY)) {
			stringJoiner.add(string);
		}
	}
}
