package baseball.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.constant.MatchResult;
import baseball.domain.BaseballNumber;
import baseball.domain.GuessBaseballNumber;
import baseball.domain.GuessResult;

public class BaseballMatcherTest {
	@Test
	@DisplayName("예측숫자와 타겟숫자 3스트라이크 테스트")
	public void matchGuessWithTargetAllStrike() {
		//given
		BaseballNumber target = new GuessBaseballNumber(1, 2, 3);
		BaseballNumber guess = new GuessBaseballNumber(1, 2, 3);
		BaseballMatcher matcher = new BaseballMatcher(target);
		//when
		MatchResult[] results = matcher.match(guess);
		GuessResult guessResult = new GuessResult(results);
		//then
		assertThat(guessResult.isNothing()).isFalse();
		assertThat(guessResult.getStrikes()).isEqualTo(target.getBallCount());
		assertThat(guessResult.getBalls()).isEqualTo(0);
	}

	@Test
	@DisplayName("예측숫자와 타겟숫자 2스트라이크 테스트")
	public void matchGuesswithTargetTwoStrike() {
		//given
		BaseballNumber target = new GuessBaseballNumber(6, 7, 2);
		BaseballNumber guess = new GuessBaseballNumber(5, 7, 2);
		BaseballMatcher matcher = new BaseballMatcher(target);
		//when
		MatchResult[] results = matcher.match(guess);
		GuessResult guessResult = new GuessResult(results);
		//then
		assertThat(guessResult.isNothing()).isFalse();
		assertThat(guessResult.getStrikes()).isEqualTo(2);
		assertThat(guessResult.getBalls()).isEqualTo(0);
	}

	@Test
	@DisplayName("예측숫자와 타겟숫자 1스트라이크 1볼 테스트")
	public void matchGuesswithTargetOneStrikeOneBall() {
		//given
		BaseballNumber target = new GuessBaseballNumber(6, 7, 2);
		BaseballNumber guess = new GuessBaseballNumber(5, 7, 6);
		BaseballMatcher matcher = new BaseballMatcher(target);
		//when
		MatchResult[] results = matcher.match(guess);
		GuessResult guessResult = new GuessResult(results);
		//then
		assertThat(guessResult.isNothing()).isFalse();
		assertThat(guessResult.getStrikes()).isEqualTo(1);
		assertThat(guessResult.getBalls()).isEqualTo(1);
	}

	@Test
	@DisplayName("예측숫자와 타겟숫자 1스트라이크 2볼 테스트")
	public void matchGuesswithTargetOneStrikeTwoBall() {
		//given
		BaseballNumber target = new GuessBaseballNumber(6, 7, 2);
		BaseballNumber guess = new GuessBaseballNumber(2, 7, 6);
		BaseballMatcher matcher = new BaseballMatcher(target);
		//when
		MatchResult[] results = matcher.match(guess);
		GuessResult guessResult = new GuessResult(results);
		//then
		assertThat(guessResult.isNothing()).isFalse();
		assertThat(guessResult.getStrikes()).isEqualTo(1);
		assertThat(guessResult.getBalls()).isEqualTo(2);
	}

	@Test
	@DisplayName("예측숫자와 타겟숫자 3볼 테스트")
	public void matchGuesswithTargetThreeBall() {
		//given
		BaseballNumber target = new GuessBaseballNumber(6, 7, 2);
		BaseballNumber guess = new GuessBaseballNumber(7, 2, 6);
		BaseballMatcher matcher = new BaseballMatcher(target);
		//when
		MatchResult[] results = matcher.match(guess);
		GuessResult guessResult = new GuessResult(results);
		//then
		assertThat(guessResult.isNothing()).isFalse();
		assertThat(guessResult.getStrikes()).isEqualTo(0);
		assertThat(guessResult.getBalls()).isEqualTo(3);
	}

	@Test
	@DisplayName("예측숫자와 타겟숫자 2볼 테스트")
	public void matchGuesswithTargetTwoBall() {
		//given
		BaseballNumber target = new GuessBaseballNumber(6, 7, 2);
		BaseballNumber guess = new GuessBaseballNumber(2, 9, 6);
		BaseballMatcher matcher = new BaseballMatcher(target);
		//when
		MatchResult[] results = matcher.match(guess);
		GuessResult guessResult = new GuessResult(results);
		//then
		assertThat(guessResult.isNothing()).isFalse();
		assertThat(guessResult.getStrikes()).isEqualTo(0);
		assertThat(guessResult.getBalls()).isEqualTo(2);
	}

	@Test
	@DisplayName("예측숫자와 타겟숫자 1볼 테스트")
	public void matchGuesswithTargetOneBall() {
		//given
		BaseballNumber target = new GuessBaseballNumber(6, 7, 2);
		BaseballNumber guess = new GuessBaseballNumber(3, 5, 6);
		BaseballMatcher matcher = new BaseballMatcher(target);
		//when
		MatchResult[] results = matcher.match(guess);
		GuessResult guessResult = new GuessResult(results);
		//then
		assertThat(guessResult.isNothing()).isFalse();
		assertThat(guessResult.getStrikes()).isEqualTo(0);
		assertThat(guessResult.getBalls()).isEqualTo(1);
	}

	@Test
	@DisplayName("예측숫자와 타겟숫자 낫싱 테스트")
	public void matchGuesswithTargetNothing() {
		//given
		BaseballNumber target = new GuessBaseballNumber(6, 7, 2);
		BaseballNumber guess = new GuessBaseballNumber(8, 9, 1);
		BaseballMatcher matcher = new BaseballMatcher(target);
		//when
		MatchResult[] results = matcher.match(guess);
		GuessResult guessResult = new GuessResult(results);
		//then
		assertThat(guessResult.isNothing()).isTrue();
		assertThat(guessResult.getStrikes()).isEqualTo(0);
		assertThat(guessResult.getBalls()).isEqualTo(0);
	}

}
