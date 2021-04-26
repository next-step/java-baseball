import java.util.LinkedHashSet;

public class BaseBallGame implements Game {
	@Override
	public void playGame() {

	}

	@Override
	public void endGame() {

	}

	@Override
	public void judgeGame() {

	}

	@Override
	public void printMsg(String msg) {
		System.out.println(msg);
	}

	public LinkedHashSet<String> makeNumbers() {
		LinkedHashSet<String> numbers = new LinkedHashSet<>();
		return numbers;
	}

	public String inputNumbers() {
		String numbers = null;
		return numbers;
	}
}
