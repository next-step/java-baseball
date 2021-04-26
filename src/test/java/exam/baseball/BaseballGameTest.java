package exam.baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BaseballGameTest {

	@Test
	void testIsIncorrectPitchingCommand() {

		BaseballGame game = new BaseballGame(null);

		assertThat(game.isIncorrectPitchingCommand("123")).isFalse();
		assertThat(game.isIncorrectPitchingCommand("888")).isFalse();
		assertThat(game.isIncorrectPitchingCommand("596")).isFalse();
		assertThat(game.isIncorrectPitchingCommand("987")).isFalse();

		assertThat(game.isIncorrectPitchingCommand("s87"))
		.as("check %s is incorrect", "not digit input").isTrue();

		assertThat(game.isIncorrectPitchingCommand("045"))
		.as("check %s is incorrect", "contains zero").isTrue();

		assertThat(game.isIncorrectPitchingCommand("99"))
		.as("check %s is incorrect", "short length input").isTrue();

		assertThat(game.isIncorrectPitchingCommand(""))
		.as("check %s is incorrect", "empty string").isTrue();

		assertThat(game.isIncorrectPitchingCommand(null))
		.as("check %s is incorrect", "null").isTrue();
	}

	@Test
	void testIsIncorrectRestartCommand() {
		BaseballGame game = new BaseballGame(null);

		assertThat(game.isIncorrectRestartCommand("1")).isFalse();
		assertThat(game.isIncorrectRestartCommand("2")).isFalse();

		assertThat(game.isIncorrectRestartCommand("3"))
		.as("check %s is incorrect", "not code digit").isTrue();

		assertThat(game.isIncorrectRestartCommand("11"))
		.as("check %s is incorrect", "too long input").isTrue();

		assertThat(game.isIncorrectRestartCommand("22"))
		.as("check %s is incorrect", "too long input").isTrue();

		assertThat(game.isIncorrectRestartCommand("s"))
		.as("check %s is incorrect", "not digit input").isTrue();

		assertThat(game.isIncorrectRestartCommand(""))
		.as("check %s is incorrect", "empty string").isTrue();

		assertThat(game.isIncorrectRestartCommand(null))
		.as("check %s is incorrect", "null").isTrue();
	}
}
