package pre.baseball;

import java.util.Scanner;

public class Player {

    private Scanner scanner;

    public Player(Scanner scanner) {
	this.scanner = scanner;
    }

    public int input() {
	return validateInput(scanner.nextInt());
    }

    /**
     * 입력값의 유효성을 검사한다.
     * 
     * @param input
     * @return
     */
    private int validateInput(int input) {
	if (hasZero(input))
	    throw new IllegalArgumentException("0은 포함할 수 없습니다.");

	return input;
    }

    /**
     * 0을 가지고 있는지 확인한다.
     * 
     * @param input
     * @return
     */
    private boolean hasZero(int input) {
	return Integer.toString(input).contains("0");
    }

}
