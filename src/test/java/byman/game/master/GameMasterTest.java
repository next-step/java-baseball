package byman.game.master;

import bymin.game.constans.GameResult;
import bymin.game.play.GamePlay;
import bymin.game.play.MakeNumberBaseBall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class GameMasterTest {
	GamePlay gamePlay;
	MakeNumberBaseBall makeNumberBaseBall;

	@BeforeEach
	void initBaseballService() {
		gamePlay = new GamePlay();
		makeNumberBaseBall = new MakeNumberBaseBall();
		makeNumberBaseBall.make();
	}

	@DisplayName("gamePlayCall")
	@Test
	void gamePlayCall() {
		char[] userBall = {'3', '4', '5'};
		Map<String, Integer> mapResult = new HashMap<>();
		mapResult.put(GameResult.STRIKE, 0);
		mapResult.put(GameResult.BALL, 0);
		gamePlay.gameCheckRuleFirstNumber(makeNumberBaseBall.getNumList(), userBall, mapResult);
		System.out.println(mapResult.toString());
	}
}
