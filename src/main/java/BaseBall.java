import java.util.Random;
import java.util.Scanner;

public class BaseBall {

	public static void main(String[] args) {
		BaseBall ball = new BaseBall();
		ball.gameStart();
	}

	/**
	 * 게임시작
	 */
	public void gameStart() {
		do {
			game(createBaseBall());
		} while (closeCheck());
	}

	/**
	 * 게임 종료
	 * @return
	 */
	public boolean closeCheck() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		if (scanner.nextInt() == 1) {
			return true;
		}
		return false;
	}

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
		} while (userBallCheck(value));
		return value;
	}

	/**
	 * 사용자가 입력한 값 체크 (중복값, 3자리 숫자 체크)
	 * @param value
	 * @return 잘못입력하면 true, 맞게 입력하면 false
	 */
	public boolean userBallCheck(String value) {
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

	/**
	 * @param baseball
	 */
	public void game(String baseball) {
		boolean flag = false;
		do {
			flag = ballCompare(userBall(), baseball);
		} while (flag);
	}

	/**
	 * 사용자 값과 야구공 비교하기
	 * @param userBall
	 * @param ball
	 * @return boolean
	 */
	public boolean ballCompare(String userBall, String ball) {
		if (!ball.equals(userBall)) {
			userHint(userBall, ball);
			return true;
		}
		System.out.println("3스트라이크");
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
		return false;
	}

	/**
	 * 유저에게 힌트 주기 (볼, 스트라이크, 낫싱 메세지 출력)
	 * @param value
	 * @param ball
	 */
	public void userHint(String userBall, String ball) {
		int strikeCount = strikeCount(userBall, ball);
		int ballCount = ballCount(userBall, ball);
		if (ballCount == 0 && strikeCount == 0) {
			System.out.print("낫싱");
		}
		if (strikeCount > 0 && strikeCount != 3) {
			System.out.print(strikeCount + "스트라이크");
		}
		if (ballCount > 0) {
			System.out.print(ballCount + "볼");
		}
		System.out.println();
	}

	/**
	 * @param userBall
	 * @param ball
	 * @return
	 */
	public int strikeCount(String userBall, String ball) {
		int count = 0;
		for (int i = 0; i < 3; i++) {
			count += strikeCheck(userBall, ball, i);
		}
		return count;
	}

	/**
	 * @param userBall
	 * @param ball
	 * @param i
	 * @return
	 */
	public int strikeCheck(String userBall, String ball, int i) {
		if (userBall.charAt(i) == ball.charAt(i)) {
			return 1;
		}
		return 0;
	}

	/**
	 * @param userBall
	 * @param ball
	 * @return
	 */
	public int ballCount(String userBall, String ball) {
		int count = 0;
		for (int i = 0; i < 3; i++) {
			count += ballCheck(userBall, ball, i);
		}
		return count;
	}

	/**
	 * @param userBall
	 * @param ball
	 * @param i
	 * @return
	 */
	public int ballCheck(String userBall, String ball, int i) {
		if (ball.contains(userBall.charAt(i) + "") && userBall.charAt(i) != ball.charAt(i)) {
			return 1;
		}
		return 0;
	}

}
