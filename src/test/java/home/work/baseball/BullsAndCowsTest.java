package home.work.baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.entry;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

class BullsAndCowsTest {

	private static MockedStatic<CommandLineInterface> cli;

	@Test
	final void testBullsAndCows() {
		int gameSize = 3;
		Player p1 = new Player("name", Arrays.asList(1, 2, 3), false);
		Player cpu = new Player("cpu", Arrays.asList(3, 2, 1), true);
		BullsAndCows game = new BullsAndCows(p1, cpu, gameSize);
		assertThat(game).extracting("gameSize").isEqualTo(gameSize);
		assertThat(game).extracting("players").asList().hasSize(2);
		assertThat(game).extracting("opponentMap")
				.asInstanceOf(InstanceOfAssertFactories.MAP)
				.contains(entry(p1, cpu))
				.contains(entry(cpu, p1));
	}
	
	@Test
	@DisplayName("GameSize가 0일 때 예외처리 테스트")
	final void testBullsAndCowsExceptionWhenZeroSize() {
		int gameSize = 0;
		Player p1 = new Player("name", Arrays.asList(1, 2, 3), false);
		Player cpu = new Player("cpu", Arrays.asList(3, 2, 1), true);
		assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
				new BullsAndCows(p1, cpu, gameSize);
			}).withMessageContaining("1 ~ 9");
	}
	
	@Test
	@DisplayName("플레이어가 null일 때 예외처리 테스트")
	final void testBullsAndCowsExceptionWhenNullPlayer() {
		int gameSize = 3;
		Player p1 = null;
		Player cpu = new Player("cpu", Arrays.asList(3, 2, 1), true);
		assertThatIllegalArgumentException().isThrownBy(() -> {
				new BullsAndCows(p1, cpu, gameSize);
			}).withMessage("플레이어가 없습니다.");
	}
	
	@Test
	@DisplayName("플레이어의 숫자개수가 GameSize와 다를 때 예외처리 테스트")
	final void testBullsAndCowsExceptionWhenNumSizeWrong() {
		int gameSize = 3;
		Player p1 = new Player("name", Arrays.asList(1, 2, 3), false);
		Player cpu = new Player("cpu", Arrays.asList(1,2,3,4,5), true);
		assertThatIllegalArgumentException().isThrownBy(() -> {
				new BullsAndCows(p1, cpu, gameSize);
			}).withMessage("플레이어의 숫자 개수가 게임과 맞지 않습니다.");
	}
	
	@BeforeAll
	static void before() {
		cli = mockStatic(CommandLineInterface.class);
	}
	
	@AfterAll
	static void after() {
		cli.close();
	}
	
	@Test
	final void testPlay() {
		int gameSize = 3;
		Player p1 = new Player("name", Arrays.asList(1, 2, 3), false);
		Player cpu = new Player("cpu", Arrays.asList(3, 2, 1), true);
		BullsAndCows game = new BullsAndCows(p1, cpu, gameSize);
		BullsAndCows spyGame = spy(game);
		when(CommandLineInterface.receiveNums(p1, gameSize)).thenReturn(Arrays.asList(3,2,1));
		when(CommandLineInterface.receiveNums(cpu, gameSize)).thenReturn(Arrays.asList(1,2,3));
		spyGame.play();
		verify(spyGame, times(1)).play();
	}

}
