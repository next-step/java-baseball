package game;

import common.CommonUtil;
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
        return CommonUtil.scannerNextMessageAndPattern("숫자를 입력해주세요 : ", ConstantUtil.INPUT_NUMBER_PATTERN);
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
