package player;

import baseballnumber.BaseballNumber;
import baseballnumber.BaseballNumberBoard;
import baseballnumber.BaseballNumberComparer;
import display.Display;
import gamemaster.GameProgress;

public class Player {
	private static final int INVALID_NUMBER = 0;

	private boolean participant;
	private BaseballNumberBoard baseballNumberBoard;

	public Player() {
		this.participant = true;
	}

	public Player(BaseballNumberBoard baseballNumberBoard) {
		this.participant = true;
		this.baseballNumberBoard = baseballNumberBoard;
	}

	protected int answer(Display display) {
		while (true) {
			int answer = getAnswer(display);
			BaseballNumber baseballNumber = new BaseballNumber(answer);
			if (baseballNumber.isValid()) {
				return answer;
			}
			display.exposeInputRetry();
		}
	}

	private int getAnswer(Display display) {
		try {
			return Integer.parseInt(display.input());
		} catch (Exception ex) {
			return INVALID_NUMBER;
		}
	}

	public GameProgress inputAboutRestartOrStop(Display display) {
		if (baseballNumberBoard.isContinue()) {
			return GameProgress.INVALID;
		}
		display.exposeEndMessage();
		display.exposeCheckRetry();
		GameProgress gameProgress = GameProgress.INVALID;

		while (gameProgress.isInvalid()) {
			GameProgress answer = getGameProgress(display);
			gameProgress = exposeErrorMessageIfInputIsInvalid(answer, display);
		}
		return gameProgress;
	}

	private GameProgress getGameProgress(Display display) {
		try {
			return GameProgress.findByPlayerAnswer(Integer.parseInt(display.input()));
		} catch (Exception ex) {
			return GameProgress.INVALID;
		}
	}

	private GameProgress exposeErrorMessageIfInputIsInvalid(GameProgress gameProgress, Display display) {
		if (gameProgress.isInvalid()) {
			display.exposeInputRestart();
		}
		return gameProgress;
	}

	public void exitNumberBaseball() {
		this.participant = false;
	}

	public boolean isParticipant() {
		return participant;
	}

	public void answerNumberAndCalculateBoardScore(Display display, int goalNumber) {
		int answer = answer(display);
		BaseballNumberComparer comparer = new BaseballNumberComparer(goalNumber, answer);
		BaseballNumberBoard numberBoard = comparer.compare();
		display.exposeGameScore(numberBoard);
		this.baseballNumberBoard = numberBoard;
	}
}
