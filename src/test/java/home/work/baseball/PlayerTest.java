package home.work.baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

	@Test
	final void testPlayer() {
		List<Integer> nums = Arrays.asList(1,2,3);
		Player p1 = new Player("name", nums, false);
		assertThat(p1.getNums()).hasSameElementsAs(nums);
	}

	@Test
	final void testQuestion() {
		Player p1 = new Player("name", Arrays.asList(1,2,3), false);
		Answer answer = p1.question(Arrays.asList(1,2,3));
		assertThat(answer).isNotNull().extracting("strike").isEqualTo(Arrays.asList(1,2,3).size());
		assertThat(answer).isNotNull().extracting("ball").isEqualTo(0);
		Answer answer2 = p1.question(Arrays.asList(3,1,2));
		assertThat(answer2).isNotNull().extracting("strike").isEqualTo(0);
		assertThat(answer2).isNotNull().extracting("ball").isEqualTo(3);
		Answer answer3 = p1.question(Arrays.asList(4,5,6));
		assertThat(answer3).isNotNull().extracting("strike").isEqualTo(0);
		assertThat(answer3).isNotNull().extracting("ball").isEqualTo(0);
	}
	
	@Test
	@DisplayName("null로 질문했을 때 예외처리")
	final void testQuestionNullParams() {
		Player p1 = new Player("name", Arrays.asList(1,2,3), false);
		assertThatIllegalArgumentException().isThrownBy(() -> {
				p1.question(null);
			})
			.withMessage("질문한 숫자가 없어요.");
	}
	
	@Test
	@DisplayName("잘못된 개수로 질문했을 때 예외처리")
	final void testQuestionWrongParams() {
		Player p1 = new Player("name", Arrays.asList(1,2,3), false);
		assertThatIllegalArgumentException().isThrownBy(() -> {
				p1.question(Arrays.asList(1));
			})
			.withMessage("질문한 숫자 개수가 잘못됐습니다.");
	}
	
}
