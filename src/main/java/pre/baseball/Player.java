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

	if (hasNotMatchDigit(input))
	    throw new IllegalArgumentException(Computer.DEFAULT_DIGIT + "자리의 숫자만 입력할 수 있습니다.");

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

    /**
     * 자릿수가 일치하는지 확인한다.
     * 
     * @param input
     * @return
     */
    private boolean hasNotMatchDigit(int input) {
	int length = (int) (Math.log10(input) + 1);
	return (Computer.DEFAULT_DIGIT != length);
    }

}
