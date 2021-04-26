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

	public static void endGame() {
		System.out.println("3개의숫자를모두맞히셨습니다!게임종료\n게임을새로시작하려면1,종료하려면2를입력하세요.");
		System.out.println("게임을새로시작하려면1,종료하려면2를입력하세요.");
	}
}
