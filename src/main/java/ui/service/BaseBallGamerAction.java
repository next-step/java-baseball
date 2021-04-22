package ui.service;

import ui.type.GameCommand;
import ui.dto.InputDataDto;
import ui.type.GameMessage;

import java.util.Objects;
import java.util.Scanner;

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
		int inputData = nextInt();
		InputDataDto inputDataDto =  createInputDataVO(inputData);
		if(Objects.nonNull(inputData)
		   && validateInputData(inputDataDto)){
			return inputDataDto;
		}
		return null;
	}

	private Integer nextInt(){
		Integer inputData = 0;
		try {
			printConsole(GameMessage.INPUT_DATA);
			inputData = scanner.nextInt();
		} catch(Exception e){
			return null;
		}
		return inputData;
	}

	private void printConsole(final GameMessage message){
		System.out.print(message.getMessage());
	}

	private boolean validateInputData(InputDataDto inputData){
		return false == inputData.containZero(); // 0값을 포함하면 입력값 오류
	}

	private InputDataDto createInputDataVO(int inputData){
		return InputDataDto.getInstance(inputData);
	}

	/**
	 * 사용자(게이머)에게 게임 재시작 or 종료를 콘솔로 입력받는다.
	 * @return
	 */
	@Override
	public GameCommand inputCommand() {
		return null;
	}
}
