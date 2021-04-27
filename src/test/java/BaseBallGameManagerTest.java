import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.Arrays;
import java.util.List;

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
	
}
