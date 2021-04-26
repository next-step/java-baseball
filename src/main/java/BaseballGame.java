import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaseballGame implements Game {
	private static final int ANSWER_LENGTH = 3;

	private List<Integer> rightAnswer;
	private Scanner scanner;

	public BaseballGame() {
		rightAnswer = new ArrayList<>();
		scanner = new Scanner(System.in);
	}

	@Override
	public void play() {

	}
}
