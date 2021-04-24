
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
public class GameResultTest {
	private Map<String, Integer> returnMap;
	
	@BeforeEach
	void setUp() {
		returnMap = new HashMap<String, Integer>();
		returnMap.put("N", 3);
	}
	
	@Test
	@DisplayName("게임결과 실행제어")
	void actGameResult() {
		assertEquals(returnMap.getOrDefault("N", 0), 3);
		assertEquals(returnMap.getOrDefault("S", 0), 3);
	}
	
	@Test
	@DisplayName("게임결과 문구 출력")
	public void printGameResultMap() {
		assertTrue(returnMap.containsKey("N"));
		assertTrue(returnMap.containsKey("S"));
		assertTrue(returnMap.containsKey("B"));
	}
}
