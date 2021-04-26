package baseball.service;

import baseball.error.DuplicateCharactersException;
import baseball.error.NonNumericCharactersException;
import org.assertj.core.api.ThrowableTypeAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class GameServiceTest {

	private GameService gameService;

	@BeforeEach
	void setUp() {
		gameService = new GameService();
	}

	@Test
	@DisplayName("1~9 서로 다른 3자리 난수 생성")
	void generateNumber() {
		assertThat(gameService.generateNumber()).allMatch(i -> i > 0).hasSize(3);
	}

	@Test
	@DisplayName("사용자 입력 문자 구문 분석")
	void parseNumbers() {
		assertThat(gameService.parseNumbers("123")).containsExactly(1, 2, 3);
		assertThat(gameService.parseNumbers("413")).containsExactly(4, 1, 3);

		ThrowableTypeAssert<NullPointerException> nullPointer = assertThatExceptionOfType(NullPointerException.class);
		nullPointer.isThrownBy(() -> gameService.parseNumbers(null));

		ThrowableTypeAssert<NonNumericCharactersException> nonNumericCharacters = assertThatExceptionOfType(NonNumericCharactersException.class);
		nonNumericCharacters.isThrownBy(() -> gameService.parseNumbers(""));
		nonNumericCharacters.isThrownBy(() -> gameService.parseNumbers("   "));
		nonNumericCharacters.isThrownBy(() -> gameService.parseNumbers("1a3"));
		nonNumericCharacters.isThrownBy(() -> gameService.parseNumbers("1a1"));
		nonNumericCharacters.isThrownBy(() -> gameService.parseNumbers("123 "));
		nonNumericCharacters.isThrownBy(() -> gameService.parseNumbers(" 123 "));

		ThrowableTypeAssert<DuplicateCharactersException> duplicateCharacters = assertThatExceptionOfType(DuplicateCharactersException.class);
		duplicateCharacters.isThrownBy(() -> gameService.parseNumbers("112"));
		duplicateCharacters.isThrownBy(() -> gameService.parseNumbers("122"));
	}

}