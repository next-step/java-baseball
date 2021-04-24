package baseball;

import java.util.ArrayList;
import java.util.List;

import baseball.player.Computer;
import baseball.player.User;
import config.Property;
import input.InputService;
import input.ParseService;
import type.GameStatusType;
import type.Message;

public class BaseballGame {

	private final InputService inputService;

	private final Computer computer;
	private final User user;

	private GameStatusType gameStatusType;

	public BaseballGame(int numberSize) {
		this.inputService = new InputService(new ParseService());

		this.computer = Computer.of(numberSize);
		this.user = User.of(new ArrayList<>());

		this.gameStatusType = GameStatusType.RESTART;
	}

	/**
	 * 1. doBat() 을 통해 타석 결과를 받습니다.
	 * 2. 게임이 끝나면 afterGame() 을 통해 GameStatusType.END 로 업데이트 합니다.
	 */
	public void doGame() {
		PlateAppearanceResult plateAppearanceResult;
		do {
			plateAppearanceResult = doBat();
			System.out.println(plateAppearanceResult.generateMessage());
		} while (!plateAppearanceResult.isAllStrike());

		afterGame();
	}

	/**
	 * 사용자의 입력으로 타석 결과를 반환합니다.
	 */
	private PlateAppearanceResult doBat() {
		do {
			List<Integer> inputNumberList = inputService.nextIntegerList(
				Message.ENTER_NUMBER.toString(), Property.NUMBER_SIZE);
			user.updateNumberList(inputNumberList);
		} while (!user.isValid());

		return new PlateAppearanceResult(computer, user);
	}

	private void afterGame() {
		System.out.println(Message.WIN_GAME);
		gameStatusType = GameStatusType.END;
	}

	public void askRestart() {
		int flag = 0;
		do {
			flag = inputService.nextGameStatusTypeFlag(Message.ENTER_RETRY_GAME.toString());
		} while (!GameStatusType.isValidFlag(flag));

		updateGameStatus(GameStatusType.findByFlag(flag));
		afterAskRestart();
	}

	private void afterAskRestart() {
		if (gameStatusType.equals(GameStatusType.RESTART)) {
			computer.reset();
		}
	}

	private void updateGameStatus(GameStatusType newGameStatusType) {
		gameStatusType = newGameStatusType;
	}

	public boolean isRestart() {
		return gameStatusType.equals(GameStatusType.RESTART);
	}
}
