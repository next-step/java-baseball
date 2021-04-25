package baseball.core;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BaseballCoreTest {

	private BaseballCore core;
	private Set<Character> numbersForResetInInstance;
	private List<Character> numbersForGameInInstance;
	private Method makeGame;
	private Method countBall;
	private Method countStrike;

	@BeforeEach
	@SuppressWarnings("unchecked")
	void setUp() throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException {
		// 대조군
		this.core = new BaseballCore();

		Field fieldNumbersForReset = this.core.getClass().getDeclaredField("numbersForReset");
		fieldNumbersForReset.setAccessible(true);
		numbersForResetInInstance = (Set<Character>) fieldNumbersForReset.get(this.core);

		Field fieldNumbersForGame = this.core.getClass().getDeclaredField("numbersForGame");
		fieldNumbersForGame.setAccessible(true);
		numbersForGameInInstance = (List<Character>) fieldNumbersForGame.get(this.core);

		makeGame = this.core.getClass().getDeclaredMethod("makeGame");
		makeGame.setAccessible(true);
		countBall = this.core.getClass().getDeclaredMethod("countBall", String.class);
		countBall.setAccessible(true);
		countStrike = this.core.getClass().getDeclaredMethod("countStrike", String.class);
		countStrike.setAccessible(true);
	}

	@Test
	@Order(1)
	@DisplayName(value = "1. 컴퓨터가 게임 생성 여부 확인")
	public void testMakeGame() throws InvocationTargetException, IllegalAccessException {
		// 비교군
		int size = 3;
		Set<Character> numbersForReset = new HashSet<>(Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9'));
		List<Character> numbersForGame = Lists.newArrayList('1', '2', '3');

		// 실행 (5회 반복)
		// 낮은 확률로 numbersForGameInInstance(List<String>)이 "1","2","3"이 순서대로 들어가서 오류를 발생할 수도 있다.
		for (int i = 0; i < 5; i++) {
			this.makeGame.invoke(this.core);

			System.out.println(numbersForResetInInstance);
			System.out.println(numbersForGameInInstance);

			assertThat(numbersForResetInInstance.containsAll(numbersForReset)).isEqualTo(true);
			assertThat(numbersForGameInInstance.containsAll(numbersForGame)).isEqualTo(false);
			assertThat(numbersForGameInInstance.size()).isEqualTo(3);
		}
	}

	@DisplayName(value = "2. Ball Count")
	@ParameterizedTest(name = "{index} - {0} are a List of playerInputs. {1} are a List of expected balls.")
	@Order(2)
	@CsvSource(value = {"123,456,789;1,2,0", "147,258,369;1,1,1", "987,624,351;0,3,0"}, delimiter = ';')
	public void testCountBall(String playerInputs, String expectedScores) throws
		InvocationTargetException,
		IllegalAccessException,
		NoSuchFieldException {

		List<Character> numbersForGame = Lists.newArrayList('6', '2', '4');

		Field fieldNumbersForGame = this.core.getClass().getDeclaredField("numbersForGame");
		fieldNumbersForGame.setAccessible(true);
		fieldNumbersForGame.set(this.core, numbersForGame);
		System.out.println("numbersForGameInInstance : " + this.numbersForGameInInstance);

		String[] playerInputsArr = playerInputs.split(",");
		String[] expectedScoreArr = expectedScores.split(",");

		System.out.print("playerInputsArr : [");
		for (String input : playerInputsArr) {
			System.out.print(input + " ");
		}
		System.out.println("]");

		System.out.print("expectedScoreArr : [");
		for (String score : expectedScoreArr) {
			System.out.print(score + " ");
		}
		System.out.println("]");

		for (int i = 0; i < playerInputsArr.length; i++) {
			int ballCnt = (int) countBall.invoke(this.core, playerInputsArr[i]);

			assertThat(ballCnt).isEqualTo(Integer.parseInt(expectedScoreArr[i]));
		}
	}

	@DisplayName(value = "3. Strike Count")
	@ParameterizedTest(name = "{index} - {0} are a List of playerInputs. {1} are a List of expected strikes.")
	@Order(3)
	@CsvSource(value = {"143,256,789;0,2,0", "147,258,369;0,3,0", "987,624,351;0,0,1"}, delimiter = ';')
	public void testCountStrike(String playerInputs, String expectedScores) throws
		InvocationTargetException,
		IllegalAccessException,
		NoSuchFieldException {

		List<Character> numbersForGame = Lists.newArrayList('2', '5', '8');

		Field fieldNumbersForGame = this.core.getClass().getDeclaredField("numbersForGame");
		fieldNumbersForGame.setAccessible(true);
		fieldNumbersForGame.set(this.core, numbersForGame);
		System.out.println("numbersForGameInInstance : " + this.numbersForGameInInstance);

		String[] playerInputsArr = playerInputs.split(",");
		String[] expectedScoreArr = expectedScores.split(",");

		System.out.print("playerInputsArr : [");
		for (String input : playerInputsArr) {
			System.out.print(input + " ");
		}
		System.out.println("]");

		System.out.print("expectedScoreArr : [");
		for (String score : expectedScoreArr) {
			System.out.print(score + " ");
		}
		System.out.println("]");

		for (int i = 0; i < playerInputsArr.length; i++) {
			int strikeCnt = (int) countStrike.invoke(this.core, playerInputsArr[i]);

			assertThat(strikeCnt).isEqualTo(Integer.parseInt(expectedScoreArr[i]));
		}
	}
}
