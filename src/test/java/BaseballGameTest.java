import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BaseballGameTest{

	@Test
	public void couldMakeThreeDigits(){
		BaseballGame game = new BaseballGame();
		Integer numbers = game.generateNumbers();
		assertTrue(numbers >= 100 && numbers <= 999);
	}

	@Test
	public void couldMakeDigitsContainsTo1From9(){
		BaseballGame game = new BaseballGame();
		Integer numbers = game.generateNumbers();
        assertTrue(String.valueOf(numbers).indexOf("0") < 0);
	}


}
