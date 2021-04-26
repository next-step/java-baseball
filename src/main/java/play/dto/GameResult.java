package play.dto;

import ui.type.GameMessage;

public class GameResult {

	private final static int FINISH_STRIKE_COUNT = 3;

	private int strike = 0;
	private int ball = 0;

	public void strike(){
		strike += 1;
	}

	public void ball(){
		ball += 1;
	}

	public boolean isFinish(){ return this.strike == FINISH_STRIKE_COUNT; }

	public String getResultMessage(){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder = makeOutputStrikeMessage(stringBuilder);
		stringBuilder = makeOutputBallMessage(stringBuilder);
		stringBuilder = makeOutputNothingMessage(stringBuilder);
		return stringBuilder.toString();
	}

	private StringBuilder makeOutputStrikeMessage(StringBuilder stringBuilder){
		if(isEmptyStrike()) return stringBuilder;

		return stringBuilder
				.append(strike)
				.append(" ")
				.append(GameMessage.OUTPUT_STRIKE.getMessage())
				.append(" ");
	}

	private StringBuilder makeOutputBallMessage(StringBuilder stringBuilder){
		if(isEmptyBall()) return stringBuilder;

		return stringBuilder
				.append(ball)
				.append(GameMessage.OUTPUT_BALL.getMessage());
	}

	private StringBuilder makeOutputNothingMessage(StringBuilder stringBuilder){
		if(isEmptyStrike()
			&& isEmptyBall()){
			return stringBuilder.append(GameMessage.OUTPUT_NOTHING.getMessage());
		}
		return stringBuilder;
	}

	private boolean isEmptyStrike(){
		return this.strike == 0;
	}

	private boolean isEmptyBall(){
		return this.ball == 0;
	}
}
