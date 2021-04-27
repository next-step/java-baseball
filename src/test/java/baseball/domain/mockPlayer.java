package baseball.domain;

import java.util.Map;

class mockPlayer implements Player {
	private final Map<BallNumber, Integer> mockDataMap;

	mockPlayer(Map<BallNumber, Integer> mockDataMap) {
		this.mockDataMap = mockDataMap;
	}

	@Override
	public Map<BallNumber, Integer> getNumbers() {
		return mockDataMap;
	}
}
