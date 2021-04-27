import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComputerUserTest {
	private List<Integer> candidates;

	@BeforeEach
	void setUp() {
		candidates = new ArrayList<Integer>() {
			{
				add(1);
				add(2);
				add(3);
				add(4);
				add(5);
			}
		};
	}

	@DisplayName("pickNumbers결과리스트의크기가3")
	@Test
	public void pickNumberSizeTest(){
		ComputerUser computerUser = new ComputerUser();
		List<Integer> actual = computerUser.pickNumbers(candidates, 3);
		assertEquals(3, actual.size());
	}

	@DisplayName("서로 겹치지 않는 수가 선택된다")
	@Test
	public void pickNumberRangeCheck(){
		ComputerUser computerUser = new ComputerUser();
		List<Integer> actual = computerUser.pickNumbers(candidates, 3);
		List<Integer> expect = new ArrayList<Integer>() {
			{
				add(1);
				add(2);
				add(3);
				add(4);
				add(5);
			}
		};
		assertEquals(expect, actual);
	}
}
