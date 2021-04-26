import java.util.Random;
import java.util.Scanner;

public class BaseBall {

	public static void main(String[] args) {}

	/**
	 * 1~9 사이의 서로 다른 수로 이루어진 3자리의 수(야구공) 생성
	 */
	public String createBaseBall() {
		String baseBall = "";
		do {
			baseBall = baseBallContainRandom(baseBall, createRandom());
		} while (baseBall.length() < 3);
		return baseBall;
	}

	/**
	 * @param baseBall
	 * @param random
	 * @return baseBall에 random이 포함되어있지 않으면 baseBall + random 반환
	 */
	public String baseBallContainRandom(String baseBall, int random) {
		if (baseBall.contains(random + "")) {
			return baseBall;
		}
		return baseBall + random;
	}

	/**
	 * @return 1~9 사이의 난수
	 */
	public int createRandom() {
		Random random = new Random();
		return random.nextInt(9) + 1;
	}

	/**
	 * 사용자 UI
	 * @return 사용자가 입력한 값
	 */
	public String userBall() {
		Scanner scanner = new Scanner(System.in);
		String value = "";
		do {
			System.out.print("숫자를 입력해주세요 : ");
			value = scanner.nextLine();
		} while (userInputcheck(value));
		return value;
	}

	/**
	 * 사용자가 입력한 값 체크 (중복값, 3자리 숫자 체크)
	 * @param value
	 * @return 잘못입력하면 true, 맞게 입력하면 false
	 */
	public boolean userInputcheck(String value) {
		boolean result = value.matches("^[1-9]{3}$");
		if (result
			&& ((0 != value.lastIndexOf(value.charAt(0) + "")) || (1 != value.lastIndexOf(value.charAt(1) + "")))) {
			result = false;
		}
		if (!result) {
			System.out.println("\n잘못 입력하셨습니다.");
		}
		return !result;
	}

}
