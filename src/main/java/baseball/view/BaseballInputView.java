package baseball.view;

import baseball.exceptions.DuplicateBallNumberException;
import baseball.exceptions.InvalidBallNumbersSizeException;
import baseball.exceptions.InvalidInputValueException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BaseballInputView implements InputView {

    private static final InputView instance = new BaseballInputView();

    public static final String QUESTION_NUMBERS = "숫자를 입력해주세요: ";
    public static final String QUESTION_NEXT_PROCESS = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final int CONTINUE_NUMBER = 1;
    public static final int STOP_NUMBER = 2;
    public static final int BALL_EXACT_SIZE = 3;
    private final Scanner scanner;

    private BaseballInputView() {
        this.scanner = new Scanner(System.in);
    }

    public static InputView getInstance() {
        return instance;
    }

    @Override
    public List<Integer> questionNumbers() throws InvalidBallNumbersSizeException, DuplicateBallNumberException {
        System.out.println(QUESTION_NUMBERS);
        int number = scanner.nextInt();

        List<Integer> splitResult = splitNumbers(number);
        validateNumberSize(splitResult);

        return splitResult;
    }

    private List<Integer> splitNumbers(int number) {
        List<Integer> list = new ArrayList<>();

        while (number > 0) {
            int digit = number % 10;

            validateDigit(list, digit);

            list.add(digit);
            number = number / 10;
        }

        Collections.reverse(list);

        return list;
    }

    private void validateDigit(List<Integer> list, int digit) {
        if (list.contains(digit)) {
            throw new DuplicateBallNumberException();
        }
    }

    private void validateNumberSize(List<Integer> numbers) {
        if (numbers.isEmpty() || numbers.size() != BALL_EXACT_SIZE) {
            throw new InvalidBallNumbersSizeException();
        }
    }

    @Override
    public int questionNextProcess() {
        System.out.println(QUESTION_NEXT_PROCESS);
        int flag = scanner.nextInt();

        validateInputProcess(flag);

        return flag;
    }

    private void validateInputProcess(int flag) {
        if (flag < CONTINUE_NUMBER || flag > STOP_NUMBER) {
            throw new InvalidInputValueException("1 또는 2만 입력 가능합니다.");
        }
    }
}
