package pre.baseball;
import java.util.Scanner;

public class Player {

    private Scanner scanner;

    public Player(Scanner scanner) {
	this.scanner = scanner;
    }

    public int input() {
	int input = scanner.nextInt();
	System.out.println("input : " + input);
	if (!validateInput(input))
	    throw new IllegalArgumentException("유효하지 않은 입력입니다.");

	return input;
    }

    private boolean validateInput(int input) {
	return true;
    }

}
