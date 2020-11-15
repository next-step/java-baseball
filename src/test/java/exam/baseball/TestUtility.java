package exam.baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.RepeatedTest;

class TestUtility {

	@RepeatedTest(value = 100)
	void test_생성된_랜덤수는_길이가_3이다() {
		assertThat(Utility.getRandom3Numbers().length())
			.isEqualTo(3);
	}
	
	@RepeatedTest(value = 100)
	void test_생성된_랜덤수의_각_수는_1부터_9까지의_범위이다() {
		assertThat(Utility.getRandom3Numbers().split(""))
			.allMatch(ch->{
				int number = Integer.parseInt(ch);
				boolean biggerThan1 = number > 0;
				boolean lesserThan9 = number < 10;
				return biggerThan1 && lesserThan9;
			});
	}
	
	@RepeatedTest(value = 100)
	void test_생성된_랜덤수의_각_수는_서로_다른_수이다() {
		String randomStr = Utility.getRandom3Numbers();
		String[] randoms = randomStr.split("");
		Set<String> randomSet = new HashSet<>();
		for (String number : randoms) {
			randomSet.add(number);
		}
		assertThat(randoms.length)
			.isEqualTo(randomSet.size());
	}

}
