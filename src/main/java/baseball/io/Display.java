package baseball.io;

public final class Display {

	/* Menu */
	public static void start() {
		System.out.println("\n새 게임을 시작하겠습니까? (Y/n):");
	}

	/* Inning */
	public static void pitch() {
		System.out.println("\n세자리 숫자를 입력하세요:");
	}

	public static void notThreeDigits() {
		System.out.println("세자리 숫자가 아닙니다.");
	}

	/* Decision */
	public static void count(int strikes, int balls) {
		if (strikes > 0) {
			System.out.printf("%d 스트라이크 ", strikes);
		}
		if (balls > 0) {
			System.out.printf("%d 볼", balls);
		}
		if (strikes + balls > 0) {
			System.out.println();
		}
	}

	public static void correct() {
		System.out.println("정답입니다!");
	}

	public static void nothing() {
		System.out.println("낫싱");
	}

}
