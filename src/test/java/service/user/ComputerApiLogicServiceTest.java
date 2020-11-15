package service.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import model.entity.Baseball;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class ComputerApiLogicServiceTest {
	private Set<Integer> numberSet = new HashSet<>();

	Baseball baseball = new Baseball();

	@Test
	@DisplayName("중복 되지 않는 랜덤 숫자 생성")
	@RepeatedTest(10)
	public void makeRandomNumber() {
		while (numberSet.size() < 3) {
			numberSet.add((int) (Math.random() * 9 + 1));
		}

		assertThat(numberSet.size()).isEqualTo(3);
		for (int number : numberSet) {
			assertThat(number).isGreaterThanOrEqualTo(1).isLessThanOrEqualTo(9);
		}
	}
}
