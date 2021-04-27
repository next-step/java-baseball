package player;

import static org.mockito.BDDMockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import baseballnumber.BaseballNumberBoard;
import display.Display;
import gamemaster.GameProgress;

class PlayerTest {

	@Mock
	private Display display;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	@DisplayName("잘못된 포멧의 answer 를 입력하면 다시 입력하라는 메시지를 노출한다")
	void displayTwiceIfUserMakeAnswerWithWrongFormat() {
		// given
		Player player = new Player(new BaseballNumberBoard(0, 0));
		given(display.input()).willReturn("122")
			.willReturn("123");

		// when
		int result = player.answer(display);

		// then
		verify(display, times(2)).input();
	}

	@Test
	@DisplayName("정확한 포멧으로 answer 한다")
	void displayOnceIfUserMakeAnswerWithWrongFormat() {
		// given
		Player player = new Player(new BaseballNumberBoard(0, 0));
		given(display.input()).willReturn("123");

		// when
		int result = player.answer(display);

		// then
		verify(display, times(1)).input();
	}

	@Test
	@DisplayName("1과 2 이외의 다른 값으로 게임 재시작 여부를 결정하는 물음에 답하면, 다시 입력하라는 메시지를 노출한다")
	void displayTwiceIfUserMakeInputWithWrongFormat() {
		// given
		Player player = new Player(new BaseballNumberBoard(3, 0));
		given(display.input()).willReturn("3")
			.willReturn("1");

		// when
		GameProgress result = player.inputAboutRestartOrStop(display);

		// then
		verify(display, times(2)).input();
	}

	@Test
	@DisplayName("1과 2 로 게임 재시작 여부를 결정하는 물음에 답한다.")
	void displayOnceIfUserMakeInputCorrectly() {
		// given
		Player player = new Player(new BaseballNumberBoard(3, 0));
		given(display.input()).willReturn("1");

		// when
		GameProgress result = player.inputAboutRestartOrStop(display);

		// then
		verify(display, times(1)).input();
	}
}
