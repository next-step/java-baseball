package bymin.game.play;

import bymin.game.constans.GameResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GamePlayTest {

	GamePlay gamePlay;
	MakeNumberBaseBall makeNumberBaseBall;

	@BeforeEach
	void initBaseballService() {
		gamePlay = new GamePlay();
		makeNumberBaseBall = new MakeNumberBaseBall();
		makeNumberBaseBall.make();
	}


	@DisplayName("result value print")
	@Test
	void gemeCheckStrike() {
		Map<String, Integer> mapResult = new HashMap<>();
		mapResult.put(GameResult.STRIKE, 0);
		mapResult.put(GameResult.BALL, 0);
		gamePlay.resultMessage(mapResult);
		assertEquals(makeNumberBaseBall.numListCheck(1), false);
	}

}
