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

	    if (result)
		break;
	}
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
