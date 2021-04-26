package baseball;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import baseball.player.Computer;
import baseball.player.User;
import type.Message;
import type.PitchingResultType;

public class PlateAppearanceResult {

	private final Map<PitchingResultType, Integer> pitchingResultMap = new HashMap<>();

	public PlateAppearanceResult(Computer computer, User user) {
		List<Integer> userNumberList = user.getNumberList();
		for (int i = 0; i < userNumberList.size(); i++) {
			PitchingResultType pitchingResult = computer.checkNumber(userNumberList.get(i), i);
			this.pitchingResultMap.put(pitchingResult, count(pitchingResult) + 1);
		}
	}

	public int count(PitchingResultType pitchingResultType) {
		return pitchingResultMap.getOrDefault(pitchingResultType, 0);
	}

	public boolean isAllStrike() {
		return (count(PitchingResultType.STRIKE) == 3);
	}

	public String generateMessage() {
		if (count(PitchingResultType.OUT) == 3) {
			return Message.NOTING.toString();
		}

		return PitchingResultType.STRIKE.generateMessage(count(PitchingResultType.STRIKE))
			+ PitchingResultType.BALL.generateMessage(count(PitchingResultType.BALL));
	}
}
