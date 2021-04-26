import java.util.Random;

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

}
