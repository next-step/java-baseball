import java.util.ArrayList;
import java.util.List;

public class BaseBallGame {
	Computer computer = new Computer();
	User user = new User();

	private List<Integer> userNumbers = new ArrayList<>();

	/*
	 * 숫자야구게임 시작
	 * */
	public void start() {
		computer.generateNumbers();

		while (true) {
			user.generateNumbers();
			userNumbers = user.getUserNumbers();
			System.out.println(userNumbers);
			computer.matchResult(userNumbers);
			if (computer.getStrikeCount() != 3) {
				computer.showHint();
			}
		}
	}
}
