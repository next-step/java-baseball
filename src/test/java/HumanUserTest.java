import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HumanUserTest {

	@DisplayName("문자열을 숫자리스트로 변경한다")
	@Test
	public void parseNumericStringTest(){
		HumanUser humanUser = new HumanUser();
		ArrayList<Integer> actual = humanUser.parseNumericString("135");
		ArrayList<Integer> expect = new ArrayList<Integer>(){
			{
				add(1);
				add(3);
				add(5);
			}
		};
		assertEquals(expect, actual);
	}
}
