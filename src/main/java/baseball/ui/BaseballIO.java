package baseball.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import baseball.code.DisplayCode;

public class BaseballIO {

	// 시스템 입력
	private InputStreamReader inputStreamReader = new InputStreamReader(System.in);
	private BufferedReader bufferedReader = new BufferedReader(this.inputStreamReader);

	/**
	 * 시스템에서 입력된 문자열 라인을 읽는다.
	 * - 올바른 입력이 아닌 경우 (null)을 리턴한다.
	 * @return String
	 */
	private String readLineFromSystemIn() {
		try {
			String input = this.bufferedReader.readLine().trim();
			return input;
		} catch (IOException e) {
			System.out.println("정보를 입력받는 도중 오류가 발생했습니다. 다시 시도해 주세요.");
			return null;
		}
	}

	/**
	 * InputStreamReader, BufferedReader 자원이 있는 경우 각각의 자원을 해제한다.
	 */
	void closeIO() {
		if (this.bufferedReader != null) {
			this.closeBufferedReader();
		}
		if (this.inputStreamReader != null) {
			this.closeInputStreamReader();
		}
	}

	/**
	 * BufferedReader 자원을 해제한다.
	 */
	private void closeBufferedReader() {
		try {
			this.bufferedReader.close();
			this.bufferedReader = null;
		} catch (IOException e) {
			this.printIoExceptionMessage();
			e.printStackTrace();
		}
	}

	/**
	 * InputStreamReader 자원을 해제한다.
	 */
	private void closeInputStreamReader() {
		try {
			this.inputStreamReader.close();
			this.inputStreamReader = null;
		} catch (IOException e) {
			this.printIoExceptionMessage();
			e.printStackTrace();
		}
	}

	/**
	 * 시스템에서 입력한 숫자를 통하여 화면코드를 리턴한다.
	 * @return DisplayCode
	 */
	DisplayCode getDisplayCodeFromSystemIn() {
		int codeFromSystemIn =  this.getIntegerFromSystemIn();
		return DisplayCode.getDisplayCode(codeFromSystemIn);
	}

	/**
	 * 시스템에서 입력된 문자열 라인을 숫자로 변환한다.
	 * @return int
	 */
	private int getIntegerFromSystemIn() {
		try {
			return Integer.parseInt(this.readLineFromSystemIn());
		} catch (NumberFormatException e) {
			this.printBadParameterContinueGameMessage();
			System.out.println("사유 : 숫자가 아닙니다.");
			return Integer.MIN_VALUE;
		}
	}


	/**
	 * 게임화면에서 입력한 사용자의 3자리 숫자 문자열을 취득한다.
	 * @return String
	 */
	String getPlayerInput() {
		String playerInput = this.readLineFromSystemIn();
		if (this.checkLength(playerInput)
			&& this.checkNumber(playerInput)
			&& this.checkIsDuplicatedNumber(playerInput)) {
			return playerInput;
		}
		return null;
	}

	/**
	 * 사용자가 입력한 문자열 길이가 3자리 인지 확인힌다.
	 * @param playerInput
	 * @return boolean
	 */
	private boolean checkLength(String playerInput) {
		boolean flag = playerInput.length() == 3;
		if (flag) {
			return true;
		}
		this.printBadParameterInGameMessage();
		System.out.println("사유 : 길이가 맞지 않습니다.");
		return false;
	}

	/**
	 * 사용자가 입력한 문자열이 3자리면서 숫자인지 확인한다.
	 * @param playerInput
	 * @return boolean
	 */
	private boolean checkNumber(String playerInput) {
		Pattern pattern = Pattern.compile("[1-9]{3}");
		Matcher matcher = pattern.matcher(playerInput);
		if (matcher.find()) {
			return true;
		}
		this.printBadParameterInGameMessage();
		System.out.println("사유 : 숫자가 아닙니다.");
		return false;
	}

	/**
	 * 사용자가 입력한 문자열이 중복된 chracter가 있는지 확인한다.
	 * @param playerInput
	 * @return boolean
	 */
	private boolean checkIsDuplicatedNumber(String playerInput) {
		int strLength = playerInput.length();
		int nonDuplicatedStrLength = new HashSet<>(Arrays.asList(playerInput.split(""))).size();
		if (strLength == nonDuplicatedStrLength) {
			return true;
		}
		this.printBadParameterInGameMessage();
		System.out.println("사유 : 중복된 숫자가 있습니다.");
		return false;
	}

	/**
	 * 자원을 해제하는 도중 오류가 발생했을 경우 표출하는 메시지.
	 */
	private void printIoExceptionMessage() {
		System.out.println("자원을 관리하는 도중 오류가 발생했습니다.");
	}

	/**
	 * 컨틴뉴 화면에서 입력 값이 아래의 조건을 만족하지 않는 경우 표출하는 메시지.
	 * - 숫자로 구성
	 */
	private void printBadParameterContinueGameMessage() {
		System.out.print("유효한 입력 값이 아닙니다. ");
	}

	/**
	 * 게임 도중 입력 값이 아래의 조건을 만족하지 않는 경우 표출하는 메시지.
	 * - 1~9 사이 숫자로 구성
	 * - 중복된 숫자가 없음
	 * - 3자리 숫자로 구성
	 */
	private void printBadParameterInGameMessage() {
		System.out.print("1~9 사이의 숫자를 중복된 숫자 없이 3자리 입력해주세요. ");
	}
}
