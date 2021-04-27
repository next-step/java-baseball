package baseball.domain.internal;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiPredicate;
import java.util.function.IntPredicate;

import baseball.Const;
import baseball.domain.BallKind;
import baseball.domain.BallNumber;
import baseball.domain.GameResult;
import baseball.domain.Player;
import baseball.domain.Umpire;

public class BaseballUmpireImpl implements Umpire {
	private static final int NOT_FOUND_INDEX = -1;

	private final Map<BallKind, Integer> ballDataMap;

	public BaseballUmpireImpl() {
		ballDataMap = new EnumMap<>(BallKind.class);
		init();
	}

	BiPredicate<Integer, Integer> checkStrike = Objects::equals;
	BiPredicate<Integer, Integer> checkBall = (pitcherIndex, hitterIndex) -> hitterIndex != NOT_FOUND_INDEX
		&& !Objects.equals(pitcherIndex, hitterIndex);
	IntPredicate checkNoting = hitterIndex -> hitterIndex == NOT_FOUND_INDEX;

	@Override
	public GameResult judge(Player pitcher, Player hitter) {
		init();

		Map<BallNumber, Integer> pitcherNums = pitcher.getNumbers();
		Map<BallNumber, Integer> hitterNums = hitter.getNumbers();

		for (Map.Entry<BallNumber, Integer> pitcherNumEntry : pitcherNums.entrySet()) {
			BallNumber pitcherBallNum = pitcherNumEntry.getKey();
			int pitcherIndex = pitcherNumEntry.getValue();
			int hitterIndex = hitterNums.getOrDefault(pitcherBallNum, NOT_FOUND_INDEX);

			judge(BallKind.STRIKE, pitcherIndex, hitterIndex, checkStrike);
			judge(BallKind.BALL, pitcherIndex, hitterIndex, checkBall);
			judge(BallKind.NOTHING, hitterIndex, checkNoting);
		}

		return new BaseballResult(ballDataMap);
	}

	private void judge(BallKind ballKind, int pitcherIndex, int hitterIndex,
		BiPredicate<Integer, Integer> biPredicate) {

		if (biPredicate.test(pitcherIndex, hitterIndex)) {
			ballDataMap.compute(ballKind, (key, value) -> Objects.isNull(value) ? 1 : value + 1);
		}
	}

	private void judge(BallKind ballKind, int hitterIndex, IntPredicate predicate) {
		if (predicate.test(hitterIndex)) {
			ballDataMap.compute(ballKind, (key, value) -> Objects.isNull(value) ? 1 : value + 1);
		}
	}

	@Override
	public void init() {
		ballDataMap.put(BallKind.STRIKE, Const.DEFAULT_VALUE);
		ballDataMap.put(BallKind.BALL, Const.DEFAULT_VALUE);
		ballDataMap.put(BallKind.NOTHING, Const.DEFAULT_VALUE);
	}

	@Override
	public boolean isFinished() {
		return ballDataMap.getOrDefault(BallKind.STRIKE, Const.DEFAULT_VALUE) == 3;

	}
}
