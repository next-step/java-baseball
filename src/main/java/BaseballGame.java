import java.util.Arrays;

public class BaseballGame {

	public static void main(String[] args) {
		String com[] = new String[3];
		//String user[] = new String[3];

		com = pickNumber(com);
	}

	public static String[] pickNumber(String[] com) {
		String random = "";
		for (int i = 0; i < com.length; i++) {
			do {
				random = String.valueOf((int)(Math.random() * 9) + 1);
			} while (checkOverlap(com, random));
			com[i] = random;
		}
		return com;
	}

	public static boolean checkOverlap(String[] com, String target) {
		return Arrays.asList(com).contains(target);
	}
}
