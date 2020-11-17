import baseball.Balls;
import baseball.Computer;
import baseball.Score;
import util.UserInputConverter;
import view.InputView;
import view.ResultView;

public class Game {

	public static void main(String[] args) {
		Game game = new Game();
		game.start();
	}

	public void start() {
		do {
			play();
		} while (quit());
	}

	private void play() {
		Computer computer = new Computer();
		boolean continueGame;
		do {
			InputView inputView = InputView.request("숫자를 입력해주세요 : ");
			String userInput = inputView.inputString();

			UserInputConverter userInputConverter = new UserInputConverter(userInput);
			Balls userBalls = new Balls(userInputConverter.convertBallsItem());

			Score score = computer.requestUserBalls(userBalls);
			ResultView resultView = new ResultView(score);
			resultView.printResult();

			continueGame = !score.isStrikeout();
		} while(continueGame);
	}

	private boolean quit() {
		InputView inputView = InputView.request("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		inputView.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		int endGame = inputView.inputNumber();

		return endGame != 2;
	}
}
