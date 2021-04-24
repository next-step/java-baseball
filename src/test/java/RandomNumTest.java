
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
public class RandomNumTest {
	private Set<Integer> distinctNumSet;
	private String testNumStr;
	private int numnCreateCnt;
	
	@BeforeEach
	void setUp() {
		distinctNumSet = new LinkedHashSet<Integer>();
		distinctNumSet.add(1);
		distinctNumSet.add(2);
		distinctNumSet.add(3);
		testNumStr = "123";
		numnCreateCnt = 3;
	}
	
	@Test
	@DisplayName("난수 생성(중복제외)")
	void createRandomNum() {
		Set<Integer> testDisSet = new LinkedHashSet<>();
		while(testDisSet.size() < numnCreateCnt) {
			testDisSet.add(new Random().nextInt(9) + 1);
		}
		assertEquals(testDisSet.size(), numnCreateCnt);
	}
	
	@Test
	@DisplayName("난수Set 분자열 변환")
	void convertSetToStr() {
		StringBuilder returnStrBd = new StringBuilder();
		for (Integer num : distinctNumSet) {
			returnStrBd.append(num.toString());
		}
		assertEquals(returnStrBd.toString(), testNumStr);
	}
	
}
