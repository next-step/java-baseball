package baseball;

import baseball.player.Computer;
import baseball.player.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import type.PitchingResultType;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("타석 결과")
class PlateAppearanceResultTest {

	@DisplayName("[성공] 생성")
	@RepeatedTest(10)
	public void success_create() {
		// given
		int size = 3;
		Computer computer = Computer.of(size);
		Random random = new Random();
		List<Integer> inputList = Arrays.asList(
			random.nextInt(9) + 1,
			random.nextInt(9) + 1,
			random.nextInt(9) + 1);
		User user = User.of(inputList);


		// when
		PlateAppearanceResult plateAppearanceResult = new PlateAppearanceResult(computer, user);

		// then
		int pitchingCount = 0;
		for (PitchingResultType pitchingResultType : PitchingResultType.values()) {
			pitchingCount += plateAppearanceResult.count(pitchingResultType);
		}

		assertThat(pitchingCount).isEqualTo(size);

		System.out.printf("### %s\n", inputList);
		for (PitchingResultType pitchingResultType : PitchingResultType.values()) {
			System.out.printf("%s ", pitchingResultType.name());
		}
		System.out.println();
	}
}
