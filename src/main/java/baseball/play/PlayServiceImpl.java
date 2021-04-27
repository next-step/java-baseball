package baseball.play;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import baseball.answer.AnswerService;
import baseball.judge.Judge;
import baseball.judge.JudgeService;
import baseball.question.QuestionService;

public class PlayServiceImpl implements PlayService {

	private final AnswerService answerService;
	private final QuestionService questionService;
	private final JudgeService judgeService;

	public PlayServiceImpl(AnswerService answerService, QuestionService questionService, JudgeService judgeService) {
		this.answerService = answerService;
		this.questionService = questionService;
		this.judgeService = judgeService;
	}

	@Override
	public void playBall() {
		List<Integer> answer = answerService.buildAnswer();
		boolean roop = true;
		while (roop) {
			List<String> question = questionService.inputQuestion();
			Judge judge = judgeService.judgeQuestion(answer, question);
			System.out.println(judge.getMessage());
			roop = !judge.isSuccess();
		}
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
		reTry();
	}

	private void reTry() {
		int selectNumber = getSelectNumber();
		if (selectNumber == 1) {
			playBall();
			return;
		}
		if (selectNumber == 2) {
			return;
		}
		reTry();
	}

	private int getSelectNumber() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		int selectNumber;
		try {
			Scanner scanner = new Scanner(System.in);
			selectNumber = scanner.nextInt();
		} catch (InputMismatchException ime) {
			selectNumber = 0;
		}
		return selectNumber;
	}
}
