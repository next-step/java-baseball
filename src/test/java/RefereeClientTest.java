import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RefereeClientTest {

	@DisplayName("3스트라이크일때 게임 종료가 되는지")
	@Test
	public void when3StrikesGameEnd(){
		RefereeClient refereeClient = new RefereeClient();
		refereeClient.setDefenseNumbers(
			new ArrayList<Integer>(){{
				add(1);
				add(2);
				add(3);
			}}
		);
		refereeClient.setOffenseNumbers(
			new ArrayList<Integer>(){{
				add(1);
				add(2);
				add(3);
			}}
		);
		assertEquals(true, refereeClient.isGameEnd());
	}

}
