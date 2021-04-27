package baseball.question;

import static baseball.BaseBallApplication.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class QuestionServiceImpl implements QuestionService {

	@Override
	public List<String> inputQuestion() {
		System.out.print("숫자를 입력해주세요 : ");
		Scanner scanner = new Scanner(System.in);
		String inputData = scanner.nextLine();
		if (inputData.length() > BALL_COUNT) {
			inputData = inputData.substring(0, BALL_COUNT);
		}
		String[] split = inputData.split("");
		return Arrays.asList(split);
	}
}
