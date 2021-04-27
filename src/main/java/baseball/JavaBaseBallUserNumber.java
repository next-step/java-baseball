package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class JavaBaseBallUserNumber {

	private static final String ENTER_NUMBER_TEXT = "숫자를 입력해주세요 : ";

	public List<Integer> userNumber;
	public boolean numberIsError;

	/**
	 * 플레이어로 부터 서로 다른 숫자3개를 입력받는다.
	 */
	public void setUserNumber() {
		numberIsError = false;
		Scanner scan = new Scanner(System.in);
		System.out.print(ENTER_NUMBER_TEXT);
		String text = scan.next();
		this.userNumber = new ArrayList<Integer>();

		if (validateUserNumber(text) && checkUserNumberLength(text)) {
			Arrays.asList(text.split("")).forEach(s -> changeTextAsInteger(s));
		}
	}

	/**
	 * 플레이어가 입력한 문자를 숫자로 변환하여 저장한다.
	 * 
	 * @param singleText
	 */
	public void changeTextAsInteger(String singleText) {
		this.userNumber.add(Integer.parseInt(singleText));
	}

	/**
	 * 플레이어가 입력한 숫자의 유효성을 체크한다.
	 * 
	 * @param text
	 * @return
	 */
	public boolean validateUserNumber(String text) {
		try {
			Integer.parseInt(text);
			return true;
		} catch (NumberFormatException numberFormatException) {
			System.err.println("숫자가 아닌값이 입력되었습니다.");
			numberIsError = true;
			return false;
		}
	}

	/**
	 * 플레이어가 입력한 숫자의 수를 확인한다.
	 * 
	 * @param text
	 * @return
	 */
	public boolean checkUserNumberLength(String text) {
		if (text.length() == 3) {
			return true;
		}
		System.err.println("숫자 3개를 입력해주세요.");
		numberIsError = true;
		return false;
	}
}