package baseball.domain.internal;

import java.util.EnumMap;
import java.util.Map;

import baseball.Const;
import baseball.domain.BallNumber;
import baseball.domain.Game;
import baseball.domain.GameResult;
import baseball.domain.GameStatus;
import baseball.domain.PlayerType;
import baseball.domain.Umpire;
import baseball.presentation.Display;
import baseball.presentation.Input;
import baseball.util.checker.BaseballInputCheckerImpl;
import baseball.util.checker.GameContinueInputCheckImpl;
import baseball.util.checker.InputChecker;
import baseball.util.generator.NumGeneratorImpl;
import baseball.util.generator.RandomNumGeneratorImpl;

public class BaseballGameImpl implements Game {
	private final Display display;
	private final Input input;
	private final InputChecker ballNumChecker;
	private final InputChecker gameContinueChecker;

	private GameStatus gameStatus;
	private Map<PlayerType, BaseballPlayerImpl> playerMap;
	private Umpire umpire;

	public BaseballGameImpl(Display display, Input input) {
		this.display = display;
		this.input = input;
		this.ballNumChecker = new BaseballInputCheckerImpl();
		this.gameContinueChecker = new GameContinueInputCheckImpl();
	}

	@Override
	public void start(Umpire umpire) {
		createPlayers();
		this.umpire = umpire;
		gameStatus = GameStatus.CONTINUE;
	}

	private void createPlayers() {
		this.playerMap = new EnumMap<>(PlayerType.class);

		playerMap.put(PlayerType.AI, new BaseballPlayerImpl());
		playerMap.put(PlayerType.USER, new BaseballPlayerImpl());
	}

	@Override
	public void init() {
		gameStatus = GameStatus.CONTINUE;
		playerMap.get(PlayerType.AI).setNumbers(new RandomNumGeneratorImpl().generate());
		umpire.init();
	}

	@Override
	public void play() {

		while (!umpire.isFinished()) {
			display.show(MessageGenerator.getInputNumsMessage());
			playerMap.get(PlayerType.USER).setNumbers(generateUserNums());
			display.show(getJudgmentResult().toString());
		}
		display.show(MessageGenerator.getFinishedMessage());

		checkGameContinue();
	}

	private GameResult getJudgmentResult() {
		return umpire.judge(playerMap.get(PlayerType.USER),
			playerMap.get(PlayerType.AI));
	}

	private Map<BallNumber, Integer> generateUserNums() {

		return new NumGeneratorImpl(checkInput(ballNumChecker)).generate();
	}

	private String checkInput(InputChecker checker) {
		String inputValue = input.getInput();

		while (!checker.check(inputValue)) {
			display.show(MessageGenerator.getInvalidInputMessage());
			inputValue = input.getInput();
		}

		return inputValue;
	}

	private void checkGameContinue() {
		display.show(MessageGenerator.getCheckGameContinueMessage());
		int value = Integer.parseInt(checkInput(gameContinueChecker));
		setGameStatus(value);
	}

	private void setGameStatus(int value) {
		gameStatus = GameStatus.CONTINUE.getValue() == value ? GameStatus.CONTINUE : GameStatus.END;
	}

	@Override
	public GameStatus getGameStatus() {
		return gameStatus;
	}

	private static class MessageGenerator {
		private static final String INPUT_NUMS = "숫자를 입력해 주세요 : ";
		private static final String INVALID_INPUT = "유효하지 않은 입력입니다. 다시 입력해 주세요. : ";
		private static final String GAME_FINISHED = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
		private static final String CHECK_GAME_CONTINUE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";

		private MessageGenerator() {
		}

		public static String getInputNumsMessage() {
			return INPUT_NUMS;
		}

		public static String getInvalidInputMessage() {
			return INVALID_INPUT;
		}

		public static String getFinishedMessage() {
			return getMessageWithNewLine(GAME_FINISHED);
		}

		public static String getCheckGameContinueMessage() {
			return getMessageWithNewLine(CHECK_GAME_CONTINUE);
		}

		private static String getMessageWithNewLine(String message) {
			StringBuilder sb = new StringBuilder(message);
			sb.append(Const.NEW_LINE);
			return sb.toString();
		}
	}
}
