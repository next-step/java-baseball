import java.util.Arrays;
import java.util.Scanner;

public class BaseballGame {
	public static void main(String[] args) {
		String com[] = new String[3];
		String user[] = new String[3];
		boolean play = true;
		int[] result = new int[2];

		com = setNumber(com);
		while (play) {
			user = getNumber(user);
			result = compareArray(com, user);
			printResult(result);
			if (result[0] == 3) {
				System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
				play = retry();
			}
		}
	}

	public static String[] setNumber(String[] com) {
		String random;
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

	public static String[] getNumber(String[] user) {
		String input = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력해주세요 : ");
		input = sc.next();
		for (int i = 0; i < user.length; i++) {
			user[i] = String.valueOf(input.charAt(i));
		}
		sc.close();
		return user;
	}

	public static int[] compareArray(String[] com, String[] user) {
		int[] result = {0, 0};
		for (int i = 0; i < com.length; i++) {
			for (int j = 0; j < user.length; j++) {
				result = getResult(com[i], user[j], i, j, result);
			}
		}
		return result;
	}

	public static int[] getResult(String com, String user, int i, int j, int[] result) {
		if (com == user) {
			if ((i == j)) {
				result[0] = result[0] + 1;
			}
			result[1] = result[1] + 1;
		}
		return result;
	}

	public static void printResult(int[] result) {
		if (result[0] > 0) {
			System.out.print(result[0] + " 스트라이크");
		}
		if (result[1] > 0) {
			System.out.print(result[1] + "볼");
		}
		System.out.println();
	}

	public static boolean retry() {
		int input;
		Scanner sc = new Scanner(System.in);
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		input = sc.nextInt();
		if (input == 2) {
			return false;
		}
		return true;
	}
}
