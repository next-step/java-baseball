package NumberBaseBallGame.generater;

import NumberBaseBallGame.domain.Ball;
import NumberBaseBallGame.domain.BallNumberMatchResult;
import NumberBaseBallGame.domain.BaseBallConst;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BallNumberMatcherTest {

	@Test
	@DisplayName("4. 스트라이크 [😊] 원 스트라이크 메치 테스트")
	public void match_one_strike_green(){
		// given
		List<Ball> targetBalls = new ArrayList<>();
		targetBalls.add(new Ball(1));
		targetBalls.add(new Ball(2));
		targetBalls.add(new Ball(3));

		List<Ball> clientBalls = new ArrayList<>();
		clientBalls.add(new Ball(1));
		clientBalls.add(new Ball(4));
		clientBalls.add(new Ball(5));

		BallNumberMatcher ballNumberMatcher = new BallNumberMatcher(BaseBallConst.GAMENUMBERS_LENGTH);
		// when
		BallNumberMatchResult matchResult = ballNumberMatcher.matchNumber(clientBalls, targetBalls);

		// than
		assertThat(matchResult.getStrikeCount())
				.isEqualTo(1);
		assertThat(matchResult.getBallCount())
				.isEqualTo(0);
		assertThat(matchResult.isAllMatch())
				.isFalse();
		assertThat(matchResult.isNothing())
				.isFalse();
	}

	@Test
	@DisplayName("4. 스트라이크 [😊] 투 스트라이크 메치 테스트")
	public void match_two_strike_green(){
		// given
		List<Ball> targetBalls = new ArrayList<>();
		targetBalls.add(new Ball(1));
		targetBalls.add(new Ball(2));
		targetBalls.add(new Ball(3));

		List<Ball> clientBalls = new ArrayList<>();
		clientBalls.add(new Ball(1));
		clientBalls.add(new Ball(2));
		clientBalls.add(new Ball(5));

		BallNumberMatcher ballNumberMatcher = new BallNumberMatcher(BaseBallConst.GAMENUMBERS_LENGTH);
		// when
		BallNumberMatchResult matchResult = ballNumberMatcher.matchNumber(clientBalls, targetBalls);

		// than
		assertThat(matchResult.getStrikeCount())
				.isEqualTo(2);
		assertThat(matchResult.getBallCount())
				.isEqualTo(0);
		assertThat(matchResult.isAllMatch())
				.isFalse();
		assertThat(matchResult.isNothing())
				.isFalse();
	}

	@Test
	@DisplayName("4. 스트라이크 [😊] 쓰리 스트라이크 메치 테스트 :: 올 매칭")
	public void match_three_strike_green(){
		// given
		List<Ball> targetBalls = new ArrayList<>();
		targetBalls.add(new Ball(1));
		targetBalls.add(new Ball(2));
		targetBalls.add(new Ball(3));

		List<Ball> clientBalls = new ArrayList<>();
		clientBalls.add(new Ball(1));
		clientBalls.add(new Ball(2));
		clientBalls.add(new Ball(3));

		BallNumberMatcher ballNumberMatcher = new BallNumberMatcher(BaseBallConst.GAMENUMBERS_LENGTH);
		// when
		BallNumberMatchResult matchResult = ballNumberMatcher.matchNumber(clientBalls, targetBalls);

		// than
		assertThat(matchResult.getStrikeCount())
				.isEqualTo(3);
		assertThat(matchResult.getBallCount())
				.isEqualTo(0);
		assertThat(matchResult.isAllMatch())
				.isTrue();
		assertThat(matchResult.isNothing())
				.isFalse();
	}

	@Test
	@DisplayName("5. 볼 [😊] 원 볼 메치 테스트")
	public void match_one_ball_green(){
		// given
		List<Ball> targetBalls = new ArrayList<>();
		targetBalls.add(new Ball(1));
		targetBalls.add(new Ball(2));
		targetBalls.add(new Ball(3));

		List<Ball> clientBalls = new ArrayList<>();
		clientBalls.add(new Ball(4));
		clientBalls.add(new Ball(5));
		clientBalls.add(new Ball(1));

		BallNumberMatcher ballNumberMatcher = new BallNumberMatcher(BaseBallConst.GAMENUMBERS_LENGTH);
		// when
		BallNumberMatchResult matchResult = ballNumberMatcher.matchNumber(clientBalls, targetBalls);

		// than
		assertThat(matchResult.getStrikeCount())
				.isEqualTo(0);
		assertThat(matchResult.getBallCount())
				.isEqualTo(1);
		assertThat(matchResult.isAllMatch())
				.isFalse();
		assertThat(matchResult.isNothing())
				.isFalse();
	}

	@Test
	@DisplayName("5. 볼 [😊] 투 볼 메치 테스트")
	public void match_two_ball_green(){
		// given
		List<Ball> targetBalls = new ArrayList<>();
		targetBalls.add(new Ball(1));
		targetBalls.add(new Ball(2));
		targetBalls.add(new Ball(3));

		List<Ball> clientBalls = new ArrayList<>();
		clientBalls.add(new Ball(4));
		clientBalls.add(new Ball(3));
		clientBalls.add(new Ball(1));

		BallNumberMatcher ballNumberMatcher = new BallNumberMatcher(BaseBallConst.GAMENUMBERS_LENGTH);
		// when
		BallNumberMatchResult matchResult = ballNumberMatcher.matchNumber(clientBalls, targetBalls);

		// than
		assertThat(matchResult.getStrikeCount())
				.isEqualTo(0);
		assertThat(matchResult.getBallCount())
				.isEqualTo(2);
		assertThat(matchResult.isAllMatch())
				.isFalse();
		assertThat(matchResult.isNothing())
				.isFalse();
	}

	@Test
	@DisplayName("5. 볼 [😊] 쓰리 볼 메치 테스트")
	public void match_three_ball_green(){
		// given
		List<Ball> targetBalls = new ArrayList<>();
		targetBalls.add(new Ball(1));
		targetBalls.add(new Ball(2));
		targetBalls.add(new Ball(3));

		List<Ball> clientBalls = new ArrayList<>();
		clientBalls.add(new Ball(2));
		clientBalls.add(new Ball(3));
		clientBalls.add(new Ball(1));

		BallNumberMatcher ballNumberMatcher = new BallNumberMatcher(BaseBallConst.GAMENUMBERS_LENGTH);
		// when
		BallNumberMatchResult matchResult = ballNumberMatcher.matchNumber(clientBalls, targetBalls);

		// than
		assertThat(matchResult.getStrikeCount())
				.isEqualTo(0);
		assertThat(matchResult.getBallCount())
				.isEqualTo(3);
		assertThat(matchResult.isAllMatch())
				.isFalse();
		assertThat(matchResult.isNothing())
				.isFalse();
	}

	@Test
	@DisplayName("6. 포볼 / 낫싱 [😊] 나싱 메치 테스트")
	public void match_nothing_green(){
		// given
		List<Ball> targetBalls = new ArrayList<>();
		targetBalls.add(new Ball(1));
		targetBalls.add(new Ball(2));
		targetBalls.add(new Ball(3));

		List<Ball> clientBalls = new ArrayList<>();
		clientBalls.add(new Ball(4));
		clientBalls.add(new Ball(5));
		clientBalls.add(new Ball(6));

		BallNumberMatcher ballNumberMatcher = new BallNumberMatcher(BaseBallConst.GAMENUMBERS_LENGTH);
		// when
		BallNumberMatchResult matchResult = ballNumberMatcher.matchNumber(clientBalls, targetBalls);

		// than
		assertThat(matchResult.getStrikeCount())
				.isEqualTo(0);
		assertThat(matchResult.getBallCount())
				.isEqualTo(0);
		assertThat(matchResult.isAllMatch())
				.isFalse();
		assertThat(matchResult.isNothing())
				.isTrue();
	}

	@Test
	@DisplayName("4. 스트라이크 / 5. 볼 [😊] 스트라이크 볼 믹스 메치 테스트 1스트라이크 2볼")
	public void match_strike_ball_green(){
		// given
		List<Ball> targetBalls = new ArrayList<>();
		targetBalls.add(new Ball(1));
		targetBalls.add(new Ball(2));
		targetBalls.add(new Ball(3));

		List<Ball> clientBalls = new ArrayList<>();
		clientBalls.add(new Ball(1));
		clientBalls.add(new Ball(3));
		clientBalls.add(new Ball(6));

		BallNumberMatcher ballNumberMatcher = new BallNumberMatcher(BaseBallConst.GAMENUMBERS_LENGTH);
		// when
		BallNumberMatchResult matchResult = ballNumberMatcher.matchNumber(clientBalls, targetBalls);

		// than
		assertThat(matchResult.getStrikeCount())
				.isEqualTo(1);
		assertThat(matchResult.getBallCount())
				.isEqualTo(1);
		assertThat(matchResult.isAllMatch())
				.isFalse();
		assertThat(matchResult.isNothing())
				.isFalse();
	}
}