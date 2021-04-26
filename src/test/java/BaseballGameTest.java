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

}
