package com.woowahan.camp.model;

import com.woowahan.camp.constant.Message;

public class GameResult {
	private int strike;
	private int ball;

	private String computerValue;
	private String userValue;

	private GameResult(int strike, int ball, String computerValue, String userValue) {
		this.strike = strike;
		this.ball = ball;
		this.computerValue = computerValue;
		this.userValue = userValue;
	}

	public static GameResult of(int strike, int ball, String computerInputValue, String userInputValue) {
		return new GameResult(strike, ball, computerInputValue, userInputValue);
	}

	public int getStrike() {
		return strike;
	}

	public int getBall() {
		return ball;
	}

	public boolean isWin() {
		return this.strike == 3;
	}

	public String getResultMsg() {
		String resultMsg = "";
		resultMsg += getStrikeMsg();
		resultMsg += getBallMsg();
		resultMsg += getWinMsg();
		resultMsg += getNothingMsg();
		return resultMsg;
	}

	public String getStrikeMsg() {
		String result = "";
		if (this.strike > 0 && this.strike < 3) {
			result = String.format(Message.STRIKE_MSG, this.strike);
		}
		return result;
	}

	public String getBallMsg() {
		String result = "";
		if (this.ball > 0) {
			result = String.format(Message.BALL_MSG, this.ball);
		}
		return result;
	}

	public String getWinMsg() {
		String result = "";
		if (this.strike == 3) {
			result = Message.GAME_WIN_MSG;
		}
		return result;
	}

	public String getNothingMsg() {
		String result = "";
		if (this.strike == 0 && this.ball == 0) {
			result = Message.NOTHING_MSG;
		}
		return result;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("GameResult{");
		sb.append("strike=").append(strike);
		sb.append(", ball=").append(ball);
		sb.append(", computerValue='").append(computerValue).append('\'');
		sb.append(", userValue='").append(userValue).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
