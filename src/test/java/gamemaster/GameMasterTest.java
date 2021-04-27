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
import machine.RandomGenerator;
import player.Player;

class GameMasterTest {
	private static final int GOAL_NUMBER = 123;

	private GameMaster gameMaster;
	@Spy
	private Player player;
	@Mock
	private Display display;
	@Mock
	private RandomGenerator randomGenerator;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		this.gameMaster = makeGameMaster();
		this.gameMaster.addPlayer(player);
	}

	private GameMaster makeGameMaster() {
		given(randomGenerator.generate()).willReturn(GOAL_NUMBER);

		Machine machine = new Machine(randomGenerator);
		return new GameMaster(machine, display);
	}

	@Test
	@DisplayName("플레이어가 없는 경우 에러를 던진다")
	void throwErrorIfUserDontExist() {
		// given
		this.gameMaster = new GameMaster(new Machine(new RandomGenerator()), new Display());

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
		given(display.input()).willReturn(String.valueOf(GOAL_NUMBER));
		doReturn(GameProgress.GAME_STOP).when(player).inputAboutRestartOrStop(display);

		// when
		gameMaster.run();

		// then
		verify(display, times(1)).exposeGameEnd();
	}

	@Test
	@DisplayName("정답을 맞춘 후에 유저가 게임을 다시 시작하기로 결정하면, 게임을 다시 시작한다")
	void compareAndRestartGameIfUserDecideToContinue() {
		// given
		given(display.input()).willReturn(String.valueOf(GOAL_NUMBER));
		doReturn(GameProgress.GAME_CONTINUE)
			.doReturn(GameProgress.GAME_STOP)
			.when(player).inputAboutRestartOrStop(display);

		// when
		gameMaster.run();

		// then
		verify(player, times(2)).inputAboutRestartOrStop(display);
	}
}
