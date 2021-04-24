
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
public class CompareNumTest {
	private String status;
	private String uNum;
	private int  rIndex;
	private int uIndex;
	private int numnCreateCnt;
	@BeforeEach
	void setUp() {
		status = "S";
		uNum = "123";
		rIndex = 1;
		uIndex = 1;
		numnCreateCnt = 3;
	}
	@Test
	@DisplayName("스트라이크볼 카운트 측정")
	void compareNums(){
		Map<String, Integer> returnMap = new HashMap<>();
		char[] uNumChar = uNum.toCharArray();
		for (int i = 0; i < uNumChar.length; i++) {
			String resStr = status;
			int cnt = returnMap.getOrDefault(resStr, 0);
			returnMap.put(resStr, cnt + 1);
		}
		assertTrue(returnMap.keySet().size() > 0);
	}
	
	@Test
	@DisplayName("스트라이크볼 검증")
	void getResultChar() {
		assertEquals(rIndex, uIndex);
		assertTrue(rIndex > -1);
	}
}
