package baseball.report;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ReportTest {
	@Test
	@DisplayName("포볼")
	void isFourBall() {
		Report report = new Report(0, 0);

		assertThat(report.isFourBall()).isTrue();
		assertThat(report.isStrikeOut()).isFalse();
		assertThat(report.getBall()).isEqualTo(0);
		assertThat(report.getStrike()).isEqualTo(0);
	}

	@Test
	@DisplayName("스트라이크 아웃")
	void isStrikeOut() {
		Report report = new Report(3, 0);

		assertThat(report.isFourBall()).isFalse();
		assertThat(report.isStrikeOut()).isTrue();
		assertThat(report.getBall()).isEqualTo(0);
		assertThat(report.getStrike()).isEqualTo(3);
	}

	@Test
	@DisplayName("1 스트라이트 2볼")
	void getStrike() {
		Report report = new Report(1, 2);

		assertThat(report.isFourBall()).isFalse();
		assertThat(report.isStrikeOut()).isFalse();
		assertThat(report.getBall()).isEqualTo(2);
		assertThat(report.getStrike()).isEqualTo(1);
	}

	@Test
	@DisplayName("1 스트라이크")
	void getBall() {
		Report report = new Report(1, 0);

		assertThat(report.isFourBall()).isFalse();
		assertThat(report.isStrikeOut()).isFalse();
		assertThat(report.getBall()).isEqualTo(0);
		assertThat(report.getStrike()).isEqualTo(1);
	}

	@Test
	@DisplayName("2 볼")
	void get2Ball() {
		Report report = new Report(0, 2);

		assertThat(report.isFourBall()).isFalse();
		assertThat(report.isStrikeOut()).isFalse();
		assertThat(report.getBall()).isEqualTo(2);
		assertThat(report.getStrike()).isEqualTo(0);
	}

	@Test
	@DisplayName("피칭 계속")
	void isContinues_2ball() {
		Report report = new Report(0, 2);

		assertThat(report.isContinues()).isTrue();
	}

	@Test
	@DisplayName("피칭 종료")
	void isContinues_3strike() {
		Report report = new Report(3, 0);

		assertThat(report.isContinues()).isFalse();
	}

	@ParameterizedTest
	@DisplayName("결과메시지 확인")
	@CsvSource(value = {"1:2:1스트라이크2볼", "2:0:2스트라이크", "0:3:3볼", "0:0:포볼"}, delimiter = ':')
	void checkResultMessage(Integer strike, Integer ball, String result) {
		Report report = new Report(strike, ball);

		assertThat(report.toString()).contains(result);
	}
}
