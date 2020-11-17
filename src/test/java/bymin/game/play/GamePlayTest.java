package bymin.game.play;

import bymin.game.constans.GameResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class GamePlayTest {

	GamePlay gamePlay;
	MakeNumberBaseBall makeNumberBaseBall;

	@BeforeEach
	void initBaseballService() {
		gamePlay = new GamePlay();
		makeNumberBaseBall = new MakeNumberBaseBall();
		makeNumberBaseBall.make();
	}


	@DisplayName("사이즈 체크")
	@Test
	void isValidInputScore() {
		char[] userBall = {'3','4','5'};
		Map<String, Integer> mapResult = new HashMap<>();
		mapResult.put(GameResult.STRIKE, 0);
		mapResult.put(GameResult.BALL, 0);
		gamePlay.gameCheckRuleFirstNumber(makeNumberBaseBall.getNumList(), userBall, mapResult);
		System.out.println(mapResult.toString());
	}

}
