package game;

import common.ConstantUtil;

import java.util.*;

public class Pitcher {
    private List<Integer> throwBallList;
    private final Scanner scanner;

    public List<Integer> getThrowBallList() {
        return throwBallList;
    }

    public Pitcher() {
        this.scanner = new Scanner(System.in);
        this.throwBallList = getInputThrowBallList();
    }

    private String getInputThrowBalls() {
        String inputThrowBalls = null;

        try {
            System.out.print("숫자를 입력해주세요 : ");
            inputThrowBalls = scanner.next(ConstantUtil.INPUT_NUMBER_PATTERN);
        } catch (InputMismatchException e) {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            scanner.nextLine();
            getInputThrowBalls();
        }

        return inputThrowBalls;
    }

    private List<Integer> getInputThrowBallList() {
        String inputThrowBalls = getInputThrowBalls();
        List<Integer> inputThrowBallList = new ArrayList<>();

        for (char inputThrowBall : inputThrowBalls.toCharArray()) {
            inputThrowBallList.add(Integer.parseInt(String.valueOf(inputThrowBall)));
        }

        return inputThrowBallList;
    }
}
