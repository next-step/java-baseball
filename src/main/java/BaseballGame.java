import model.Baseball;
import model.Gamer;
import util.CustomException;

public class BaseballGame {

	static Baseball baseball = new Baseball();
	static Gamer gamer = new Gamer();

	public static void main(String[] args) throws
			CustomException.InvalidNumberFormatException,
			CustomException.InvalidNumberOfSizeException,
			CustomException.InvalidNumberOfRangeException {
		System.out.println(baseball.getDefaultNumbers().toString());
		gamer.inputNumberFromUser();
	}
}
