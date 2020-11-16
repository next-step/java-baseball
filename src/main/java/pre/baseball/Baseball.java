package pre.baseball;

import java.util.Scanner;

/**
 * 숫자야구 게임
 * 
 * @author hyenny
 *
 */
public class Baseball {

    private static final int START = 1;
    private static final int EXIST = 2;
    private Computer computer;
    private Player user;

    public Baseball() {
	this.computer = new Computer();
	this.user = new Player(new Scanner(System.in));
    }

    /**
     * 게임을 시작한다
     */
    public void start() {
	while (true) {
	    System.out.printf("숫자를 입력해주세요 : ");
	    boolean result = computer.check(toIntArray(user.input()));

	    if (result && !isRestart())
		break;
	}
    }

    /**
     * 게임 재시작여부를 체크한다.
     * 
     * @return
     */
    private boolean isRestart() {
	System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	int input = user.input();
	if (input == EXIST)
	    return false;

	if (input != START)
	    invalidRestartFlag();

	computer.init();
	return true;
    }

    /**
     * 유효하지 않은 플래그를 입력할 경우 다시 재시작여부를 체크한다.
     */
    private void invalidRestartFlag() {
	System.out.println("1 또는 2만 가능합니다.");
	isRestart();
    }

    /**
     * int 배열을 만든다
     * 
     * @param input
     * @return
     */
    private int[] toIntArray(int input) {
	String temp = Integer.toString(input);
	int[] inputArray = new int[temp.length()];
	for (int i = 0; i < temp.length(); i++)
	    inputArray[i] = temp.charAt(i) - '0';

	return inputArray;
    }

}
