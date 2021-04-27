package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.Game;
import domain.User;

class BaseballSwingRsltTest {

	@Test
	@DisplayName("Create Message Strike Check Test")
	void testBaseballSwingRslt() {
		Game game = new Game();
		User user = new User();
		
		int[] gNum = new int[3];
		gNum[0] = 1;
		gNum[1] = 2;
		gNum[2] = 3;
		
		int[] uNum = new int[3];
		uNum[0] = 5;
		uNum[1] = 2;
		uNum[2] = 6;
		
		game.setNpcNumber(gNum);
		user.setUserNumber(uNum);
		
		BaseballSwingRslt swing = new BaseballSwingRslt(game, user);
		String rsltMsg = swing.swingRslt();
		
		assertThat("1 스트라이크").isEqualTo(rsltMsg);
	}
	
	@Test
	@DisplayName("Create Message Nothing Check Test")
	void testBaseballNothingSwingRslt() {
		Game game = new Game();
		User user = new User();
		
		int[] gNum = new int[3];
		gNum[0] = 1;
		gNum[1] = 2;
		gNum[2] = 3;
		
		int[] uNum = new int[3];
		uNum[0] = 5;
		uNum[1] = 8;
		uNum[2] = 6;
		
		game.setNpcNumber(gNum);
		user.setUserNumber(uNum);
		
		BaseballSwingRslt swing = new BaseballSwingRslt(game, user);
		String rsltMsg = swing.swingRslt();
		
		assertThat("낫싱").isEqualTo(rsltMsg);
	}
	
	@Test
	@DisplayName("Create Message Ball Check Test")
	void testBaseballBallSwingRslt() {
		Game game = new Game();
		User user = new User();
		
		int[] gNum = new int[3];
		gNum[0] = 1;
		gNum[1] = 2;
		gNum[2] = 5;
		
		int[] uNum = new int[3];
		uNum[0] = 5;
		uNum[1] = 8;
		uNum[2] = 6;
		
		game.setNpcNumber(gNum);
		user.setUserNumber(uNum);
		
		BaseballSwingRslt swing = new BaseballSwingRslt(game, user);
		String rsltMsg = swing.swingRslt();
		
		assertThat("1 볼").isEqualTo(rsltMsg);
	}

}
