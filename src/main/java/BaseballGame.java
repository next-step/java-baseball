import java.util.Scanner;

public class BaseballGame {

	public static void main(String[] args) {
		BaseballGame game = new BaseballGame();
		game.start();
	}

	public void start() {
		Scanner scanner = new Scanner(System.in);
		String[] numbers = checkValid(scanner.nextLine().split(""));
		BaseballNumber userBaseballNumber = new BaseballNumber(numbers[0], numbers[1], numbers[2]);
	}

	public String[] checkValid(String[] numbers) {
		if (numbers.length > BaseballNumber.MAX_SIZE)
			throw new RuntimeException();

		return numbers;
	}

}
