import java.util.Scanner;

public class BaseballGame {
	private static final int EXIT_GAME = 2;

	public static void main(String[] args) {
		boolean isGameContinue;
		do {
			tryQuestions();
			int userDecision = validateAndGetInputNumber(Comments.DECISION.getComment(),
				Comments.EXIT_RESTART_ERROR.getComment(), new ExitOrRestartValidation());
			isGameContinue = (userDecision == EXIT_GAME) ? false : true;
		} while (isGameContinue);
	}

	public static int getInputNumber() {
		Scanner scanner = new Scanner(System.in);
		while (!scanner.hasNextInt()) {
			System.out.println(Comments.INPUT_NUMBER.getComment());
			scanner.next();
		}
		return scanner.nextInt();
	}

	public static void tryQuestions() {
		boolean isWrongQuestion;
		Answer answer = new Answer();
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

	public static Question getQuestion() {
		Question question = new Question();
		question.init();
		int questionNumber = validateAndGetInputNumber(Comments.INPUT_NUMBER.getComment(),
			Comments.THREE_DIGIT_ERROR.getComment(), new ThreeDigitValidation());
		question.setUserQuestion((questionNumber / 100) % 10, (questionNumber / 10) % 10, questionNumber % 10);
		return question;
	}

	public static int validateAndGetInputNumber(String startComment, String errorComment,
		InputNumberValidation validation) {
		int inputNumber;
		do {
			System.out.print(startComment);
			inputNumber = getInputNumber();
			printErrorComment(!validation.validate(inputNumber), errorComment);
		} while (!validation.validate(inputNumber));
		return inputNumber;
	}

	private static void printErrorComment(boolean condition, String errorComment) {
		if (condition) {
			System.out.println(errorComment);
		}
	}
}
