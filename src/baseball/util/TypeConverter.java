package baseball.util;

public class TypeConverter {
	
	public static int[] stringToIntAarray(String str) {
		int[] intArray = new int[GameStatus.BALL_SIZE];
		for (int i = 0; i < str.length(); i++) {
			intArray[i] = str.charAt(i) - '0';
		}
		return intArray;
	}
	
	public static int StringToInt(String str) {
		return Integer.parseInt(str);
	}
}
