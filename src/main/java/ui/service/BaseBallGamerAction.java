package ui.service;

import ui.exception.GamePlayException;
import ui.type.GameCommand;
import ui.dto.InputDataDto;
import ui.type.GameMessage;
import util.ConverterUtil;
import java.util.Scanner;

import static ui.type.GamePlayExceptionType.INPUT_DATA_IS_NOT_VALID;

/**
 * Gamer Acting
 */
public class BaseBallGamerAction implements GamerAction {

	private final Scanner scanner;

	public BaseBallGamerAction(){
		scanner = new Scanner(System.in);
	}

	/**
	 * 사용자(게이머)에게 숫자를 콘솔로 입력받는다.
	 * @return
	 */
	@Override
	public InputDataDto inputData() {
		printConsole(GameMessage.INPUT_DATA);
		String inputData = next();
		InputDataValidator.preValidateInputData(inputData); // 선검사
		Integer pickedNumber = ConverterUtil.convertStringToInteger(inputData); // Type 변환
		InputDataDto inputDataDto = createInputDataVO(pickedNumber); // 객체 생성
		InputDataValidator.postValidateInputData(inputDataDto); // 후검사
		return inputDataDto;
	}

	/**
	 * 사용자(게이머)에게 게임 재시작 or 종료를 콘솔로 입력받는다.
	 * @return
	 */
	@Override
	public GameCommand inputCommand() {
		printConsoleWithLine(GameMessage.INPUT_RESTART_GAME.getMessage());
		String inputData = next();
		int command = ConverterUtil.convertStringToInteger(inputData);
		if(command == 1){
			return GameCommand.RESTART;
		}
		return GameCommand.FINISH;
	}

	private String next(){
		try {
			String inputData = scanner.next();
			return inputData;
		} catch(Exception e){
			throw GamePlayException.getInstance(INPUT_DATA_IS_NOT_VALID);
		}
	}

	/**
	 * 콘솔에 message를 출력한다.
	 * @param message
	 */
	@Override
	public void printConsoleWithLine(String message) {
		System.out.println(message);
	}

	private void printConsole(final GameMessage message){
		System.out.print(message.getMessage());
	}

	private InputDataDto createInputDataVO(int inputData){
		return InputDataDto.getInstance(inputData);
	}
}
