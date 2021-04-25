package NumberBaseBallGame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class GenerateGameNumberTest {

	@RepeatedTest(100)
	@DisplayName("2. 대결 준비.[😊] 대결용 임의의 수 1~9사이 서로다른 3자리 수")
	public void 대결준비_랜덤수_생성_Green(){
	    // given
		GenerateGameNumber generateGameNumber = new GenerateGameNumber();
	    // when
		int[] gameNumber = generateGameNumber.generateGameNumber();
		// than :: 서로다른 3자리 수
		assertThat(gameNumber)
				.isNotEmpty()
				.hasSize(3)
				.containsOnlyOnce(
						gameNumber[0]
						,gameNumber[1]
						,gameNumber[2]
				)
				;
	}

}