package baseball.service;

import baseball.config.AppContext;
import baseball.error.NonRestartCharactersException;
import org.assertj.core.api.ThrowableTypeAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class RestartServiceTest {

	private RestartService restartService;

	@BeforeEach
	void setUp() {
		restartService = AppContext.getInstance().getRestartService();
	}

	@Test
	@DisplayName("재시작 여부")
	void isRestart() {
		assertThat(restartService.isRestart("1")).isTrue();
		assertThat(restartService.isRestart("2")).isFalse();

		ThrowableTypeAssert<NullPointerException> nullPointer = assertThatExceptionOfType(NullPointerException.class);
		nullPointer.isThrownBy(() -> restartService.isRestart(null));

		ThrowableTypeAssert<NonRestartCharactersException> nonRestartCharacters = assertThatExceptionOfType(NonRestartCharactersException.class);
		nonRestartCharacters.isThrownBy(() -> restartService.isRestart(""));
		nonRestartCharacters.isThrownBy(() -> restartService.isRestart(" "));
		nonRestartCharacters.isThrownBy(() -> restartService.isRestart("A"));
	}

}