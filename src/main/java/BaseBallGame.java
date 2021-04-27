import java.util.Random;

public class BaseBallGame {
	public static int getRandomNumber() {
		return new Random().nextInt(9) + 1;
	}
}