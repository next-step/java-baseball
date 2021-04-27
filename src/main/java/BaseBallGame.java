import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

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
		while (numbers.size() < 3) {
			int randomNum = ThreadLocalRandom.current().nextInt(1, 9);
			numbers.add(String.valueOf(randomNum));
		}
		return numbers;
	}

	public String inputNumbers() {
		Scanner scan = new Scanner(System.in);
		String numbers = String.valueOf(scan.nextInt());
		scan.close();
		return numbers;
	}
}
