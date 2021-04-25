package gamemaster;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import display.Display;
import machine.Machine;
import player.Player;

class GameMasterTest {
	private static final int GOAL_NUMBER = 123;

	private GameMaster gameMaster;
	@Spy
	private Player player;
	@Mock
	private Display display;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);

		Machine machine = new Machine(GOAL_NUMBER);
		this.gameMaster = new GameMaster(machine, display);
		this.gameMaster.addPlayer(player);
	}

	@Test
	@DisplayName("플레이어가 없는 경우 에러를 던진다")
	void throwErrorIfUserDontExist() {
		// given
		this.gameMaster = new GameMaster(new Machine(GOAL_NUMBER), new Display());

		// when

		// then
		assertThatIllegalArgumentException().isThrownBy(this.gameMaster::run);
	}

	@Test
	@DisplayName("machine 이 없는 경우 에러를 던진다")
	void throwErrorIfMachineDontExist() {
		// given
		this.gameMaster = new GameMaster(null, new Display());

		// when

		// then
		assertThatIllegalArgumentException().isThrownBy(this.gameMaster::run);
	}

	@Test
	@DisplayName("정답을 맞춘 후에 유저가 게임을 종료하기로 결정하면, 게임을 종료한다")
	void compareAndBreakGameIfUserDecideToEndGame() {
		// given
		given(player.answer(display)).willReturn(GOAL_NUMBER);
		given(display.input()).willReturn(GameMaster.GAME_STOP);

		// when
		gameMaster.run();

		// then
		verify(display, times(1)).exposeGameEnd();
	}

	@Test
	@DisplayName("정답을 맞춘 후에 유저가 게임을 다시 시작하기로 결정하면, 게임을 다시 시작한다")
	void compareAndRestartGameIfUserDecideToContinue() {
		// given
		doReturn(GOAL_NUMBER)
			.doReturn(GameMaster.GAME_CONTINUE)
			.doReturn(GOAL_NUMBER)
			.doReturn(GameMaster.GAME_STOP).when(player).answer(display);

		// when
		gameMaster.run();

		// then
		verify(player, times(4)).answer(display);
	}

	@Test
	@DisplayName("게임이 진행된 다음, 모든 플레이어가 exit 을 선언하면 게임이 종료된다")
	void exitGameIfThereIsNoParticipants() {
		doReturn(GOAL_NUMBER)
			.doReturn(GameMaster.GAME_STOP).when(player).answer(display);

		// when
		gameMaster.run();

		// then
		verify(player, times(2)).answer(display);
	}
}
