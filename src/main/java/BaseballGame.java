import java.util.Scanner;

public class BaseballGame {
	private static final int EXIT_GAME = 2;
	private Answer answer;
	private Question question;

	public BaseballGame(Answer answer, Question question) {
		this.answer = answer;
		this.question = question;
	}

	public void main(String[] args) {
		boolean isGameContinue;
		do {
			tryQuestions();
			int userDecision = validateAndGetInputNumber(Comments.DECISION.toString()
				, Comments.EXIT_RESTART_ERROR.toString()
				, new ExitOrRestartValidation());
			isGameContinue = (userDecision == EXIT_GAME) ? false : true;
		} while (isGameContinue);
	}

	public int getInputNumber() {
		Scanner scanner = new Scanner(System.in);
		while (!scanner.hasNextInt()) {
			System.out.println(Comments.INPUT_NUMBER.toString());
			scanner.next();
		}
		return scanner.nextInt();
	}

	public void tryQuestions() {
		boolean isWrongQuestion;
		answer.setAnswer(answer.generateRandomNumber());
		do {
			Question question = getQuestion();
			GameResult gameResult = feedback(answer, question);
			System.out.println(gameResult.print());
			isWrongQuestion = gameResult.isStrikeOut() ? false : true;
		} while (isWrongQuestion);
	}

	public static GameResult feedback(Answer answer, Question question) {
		return new Feedback().compare(answer.getAnswer(), question.getUserQuestion());
	}

	public Question getQuestion() {
		question.init();
		int questionNumber = validateAndGetInputNumber(Comments.INPUT_NUMBER.toString()
			, Comments.THREE_DIGIT_ERROR.toString()
			, new ThreeDigitValidation());
		question.setUserQuestion((questionNumber / 100) % 10, (questionNumber / 10) % 10, questionNumber % 10);
		return question;
	}

	public int validateAndGetInputNumber(String startComment, String errorComment,
		InputNumberValidation validation) {
		int inputNumber;
		do {
			System.out.print(startComment);
			inputNumber = getInputNumber();
			if (validation.validate(inputNumber)) {
				System.out.println(errorComment);
			}
		} while (validation.validate(inputNumber));
		return inputNumber;
	}
}
