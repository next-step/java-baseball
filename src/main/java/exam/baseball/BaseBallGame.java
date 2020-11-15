package exam.baseball;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class BaseBallGame implements Game {
	
	static final String GAME_FINISH_MSG = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	
	private Supplier<String> inputMethod;
	private Consumer<String> printMethod;
	private final Supplier<String> randomMethod;
	
	public BaseBallGame(Supplier<String> randomMethod) {
		this.randomMethod = randomMethod;
	}
	
	@Override
	public void start() {
		String correctAnswer = randomMethod.get();
		BaseBallScore score = null;
		do {
			score = new BaseBallScore();
			String input = getInputValue(); 
			score = match(correctAnswer, input);
			printResult(score);
		}
		while (keepGoing(score));
	}

	private String getInputValue() {
		return inputMethod.get();	
	}
	
	@Override
	public void setInputMethod(Supplier<String> inputMethod) {
		this.inputMethod = inputMethod;
	}

	@Override
	public void setPrintMethod(Consumer<String> printMethod) {
		this.printMethod = printMethod;
	}

	private boolean keepGoing(BaseBallScore score) {
		return score.gameIsNotOver();
	}

	String makeScoreText(BaseBallScore score) {
		if (score.isNothing()) {
			return "낫싱";
		}
		String msg = score.existStrike() ? score.getStrike() + " 스트라이크" : "";
		msg += !msg.isEmpty() ? " " : "";
		msg += score.existBall() ? score.getBall() + " 볼" : ""; 
		return msg;
	}

	private void printResult(BaseBallScore score) {
		String scoreText = makeScoreText(score);
		printMethod.accept(scoreText);
		
		if (score.isWin()) {
			printMethod.accept(GAME_FINISH_MSG);
		}
	}

	BaseBallScore match(String correctAnswer, String input) {
		BaseBallScore score = new BaseBallScore();
		String[] splitedInput = input.split("");
		for (int i = 0; i < splitedInput.length; i++) {
			checkScore(correctAnswer, splitedInput[i], i, score);
		}
		return score;
	}
	
	private void checkScore(String correctAnswer, String ch, int indexOfCh, BaseBallScore score) {
		String charAt = correctAnswer.split("")[indexOfCh];
		if(charAt.equals(ch)) {
			score.countStrike();
			return;
		}
		if (correctAnswer.contains(ch)) {
			score.countBall();
		}
	}

	
	static class BaseBallScore {
		private int strike;
		private int ball;
		
		public BaseBallScore() {
			this.strike = 0;
			this.ball = 0;
		}
		
		public void countStrike() {
			this.strike += 1;
		}
		
		public void countBall() {
			this.ball += 1;
		}
		
		public boolean gameIsNotOver() {
			return this.strike != 3;
		}
		
		public boolean isWin() {
			return !gameIsNotOver();
		}
		
		public int getStrike() {
			return this.strike;
		}
		
		public int getBall() {
			return this.ball;
		}
		
		public boolean existStrike() {
			return this.strike > 0;
		}
		
		public boolean existBall() {
			return this.ball > 0;
		}
		
		public boolean isNothing() {
			return !existStrike() && !existBall(); 
		}
	}

	
}
