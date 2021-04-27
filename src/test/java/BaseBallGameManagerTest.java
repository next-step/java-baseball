import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseBallGameManagerTest {

	BaseBallGameManager baseBallGameManager = new BaseBallGameManager();

	@DisplayName("스트라이크 횟수 테스트")
	@Test
	public void countStrikeTest() {
		List<String> targetList = Arrays.asList(new String[] {"1", "4", "6"});
		List<String> compareList = Arrays.asList(new String[] {"3", "5", "6"});
		int countStrike = baseBallGameManager.countStrike(targetList, compareList, 0, 0);
		assertThat(countStrike).isEqualTo(1);
	}

	@DisplayName("볼 횟수 테스트")
	@Test
	public void countBallsTest() {
		List<String> targetList = Arrays.asList(new String[] {"4", "7", "2"});
		List<String> compareList = Arrays.asList(new String[] {"9", "5", "6"});
		Set<String> compareSet = new HashSet<>(compareList);
		int countStrike = baseBallGameManager.countBalls(targetList, compareList, compareSet, 0, 0);
		assertThat(countStrike).isEqualTo(0);
	}

}
