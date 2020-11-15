package baseball.presenter;

import baseball.game.GameScore;

public interface GameScoreMessageGenerator {

	String getScoreMessage(GameScore score);
}
