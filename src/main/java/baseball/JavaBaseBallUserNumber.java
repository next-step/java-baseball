package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class JavaBaseBallUserNumber {

	private static final String ENTER_NUMBER_TEXT = "���ڸ� �Է����ּ��� : ";

	public List<Integer> userNumber;
	public boolean numberIsError;

	/**
	 * �÷��̾�� ���� ���� �ٸ� ����3���� �Է¹޴´�.
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
	 * �÷��̾ �Է��� ���ڸ� ���ڷ� ��ȯ�Ͽ� �����Ѵ�.
	 * 
	 * @param singleText
	 */
	public void changeTextAsInteger(String singleText) {
		this.userNumber.add(Integer.parseInt(singleText));
	}

	/**
	 * �÷��̾ �Է��� ������ ��ȿ���� üũ�Ѵ�.
	 * 
	 * @param text
	 * @return
	 */
	public boolean validateUserNumber(String text) {
		try {
			Integer.parseInt(text);
			return true;
		} catch (NumberFormatException numberFormatException) {
			System.err.println("���ڰ� �ƴѰ��� �ԷµǾ����ϴ�.");
			numberIsError = true;
			return false;
		}
	}

	/**
	 * �÷��̾ �Է��� ������ ���� Ȯ���Ѵ�.
	 * 
	 * @param text
	 * @return
	 */
	public boolean checkUserNumberLength(String text) {
		if (text.length() == 3) {
			return true;
		}
		System.err.println("���� 3���� �Է����ּ���.");
		numberIsError = true;
		return false;
	}
}