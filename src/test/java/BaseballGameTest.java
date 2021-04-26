import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BaseballGameTest{

	@Test
	public void couldMakeThreeDigits(){
		BaseballGame game = new BaseballGame();
		String numbers = game.generateNumbers();
		Integer intNumbers = Integer.parseInt(numbers);
		assertTrue(intNumbers  >= 100 && intNumbers <= 999);
	}

	@Test
	public void couldMakeDigitsContainsTo1From9(){
		BaseballGame game = new BaseballGame();
		String numbers = game.generateNumbers();
		assertTrue(numbers.indexOf("0") < 0);
	}

	@Test
	public void couldMakeRandomDigits(){
		BaseballGame game = new BaseballGame();
		String first_numbers = game.generateNumbers();
		String second_numbers = game.generateNumbers();
		String third_numbers = game.generateNumbers();
		assertNotEquals(first_numbers, second_numbers);
		assertNotEquals(second_numbers, third_numbers);
		assertNotEquals(first_numbers, third_numbers);
	}

	@Test
	public void couldMakeRandomDigitsNotDuplicated(){
		BaseballGame game = new BaseballGame();
		String numbers = game.generateNumbers();
		String[] splitedNumbers = numbers.split("");
		assertNotEquals(splitedNumbers[0], splitedNumbers[1]);
		assertNotEquals(splitedNumbers[1], splitedNumbers[2]);
		assertNotEquals(splitedNumbers[0], splitedNumbers[2]);

		String numbers1 = game.generateNumbers();
		String[] splitedNumbers1 = numbers1.split("");
		assertNotEquals(splitedNumbers1[0], splitedNumbers1[1]);
		assertNotEquals(splitedNumbers1[1], splitedNumbers1[2]);
		assertNotEquals(splitedNumbers1[0], splitedNumbers1[2]);
	}

	@Test
	public void outputWhenResultIsOneBall(){
		String answer = "123";
		String oneball_guess = "__2";
		BaseballGame game = new BaseballGame();
		String output = game.guess(answer,oneball_guess);

		assertEquals("1볼", output);
	}


	@Test
	public void outputWhenResultIsTwoBall(){
		String answer = "123";
		String twoball_guess = "_32";
		BaseballGame game = new BaseballGame();
		String output = game.guess(answer,twoball_guess);

		assertEquals("2볼", output);
	}


	@Test
	public void outputWhenResultIsThreeBall(){
		String answer = "123";
		String threeball_guess = "312";
		BaseballGame game = new BaseballGame();
		String output = game.guess(answer,threeball_guess);

		assertEquals("3볼", output);
	}

	@Test
	public void outputWhenResultIsOneStrike(){
		String answer = "123";
		String onestrike_guess = "1__";
		BaseballGame game = new BaseballGame();
		String output = game.guess(answer,onestrike_guess);

		assertEquals("1스트라이크", output);
	}


	@Test
	public void outputWhenResultIsTwoStrike(){
		String answer = "123";
		String twostrike_guess = "1_3";
		BaseballGame game = new BaseballGame();
		String output = game.guess(answer,twostrike_guess);

		assertEquals("2스트라이크", output);
	}

	@Test
	public void outputWhenResultIsThreeStrike(){
		String answer = "123";
		String threestrike_guess = "123";
		BaseballGame game = new BaseballGame();
		String output = game.guess(answer,threestrike_guess);

		assertEquals("3개의 숫자를 모두 맞히셨습니다! 게임종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.", output);
	}


	@Test
	public void outputWhenResultIsNothing(){
		String answer = "123";
		String nothing_guess = "___";
		BaseballGame game = new BaseballGame();
		String output = game.guess(answer,nothing_guess);

		assertEquals("낫싱", output);
	}





}
