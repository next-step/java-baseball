package core;

import java.util.Scanner;

/**
 * Description : Game main module class
 *
 * Created by jychoi on 2021/04/27.
 */
public class Game {

	public Game(Integer inputSize, Scanner sc) {
		this.sc = sc;
		this.inputSize = inputSize;
	}

	private final Integer inputSize;
	private final Scanner sc;
	private final BaseballLogic baseballLogic = new BaseballLogic();
	private final InputUtils inputUtils = new InputUtils();

	/**
	 * Description: 전체 game module method
	 */
	public void runGameModule() {

		boolean isSolve;
		boolean restart = false;
		Integer[] answer = baseballLogic.generateAnswer(inputSize);

		do {
			isSolve = process(answer);
		} while (!isSolve);

		if (isSolve) {
			printEndMessage();
			restart = inputUtils.isGameRestart(sc.nextLine());
		}

		restartGame(restart);
	}

	/**
	 * Description : 게임 재시작 method
	 *
	 * @param isRestart 재시작 플래그 (T/F)
	 */
	private void restartGame(boolean isRestart) {
		if (isRestart) {
			runGameModule();
		}
	}

	/**
	 * Description: 종료 메시지 출력
	 */
	private void printEndMessage() {
		System.out.println(GameMessageEnum.END_MESSAGE.getMessage());
		System.out.println(GameMessageEnum.CONTINUE_MESSAGE.getMessage());
	}

	/**
	 * Description:
	 * @param answer 정답 배열
	 * @return (T / F) 정답 시 T, 오답 시 F
	 */
	private boolean process(Integer[] answer) {

		boolean isSolve = false;

		System.out.print(GameMessageEnum.INPUT_MESSAGE.getMessage());
		Integer[] userInput = inputUtils.parseInput(sc.nextLine(), inputSize);
		AnswerObject answerObject = baseballLogic.run(answer, userInput);
		System.out.println(GameMessageEnum.getCurrentResultMessage(answerObject));

		// 정답을 맞춘건지 판단
		if (answerObject.getStrike() == inputSize) {
			isSolve = true;
		}

		return isSolve;
	}
}
