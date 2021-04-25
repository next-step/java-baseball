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


}
