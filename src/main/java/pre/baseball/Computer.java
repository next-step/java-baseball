package pre.baseball;

import java.util.Arrays;

public class Computer {

    private static final int DEFAULT_DIGIT = 3;
    private int[] answer;
    private int strike;
    private int ball;

    public Computer() {
	init();
    }

    public int[] getAnswer() {
	return answer;
    }

    public int getStrike() {
	return strike;
    }

    public int getBall() {
	return ball;
    }

    /**
     * 정답과 스트라이크, 볼 카운트를 초기화한다.
     */
    public void init() {
	this.answer = generateRandomNumber(DEFAULT_DIGIT);
	this.strike = 0;
	this.ball = 0;
    }

    /**
     * 플레이어가 입력한 숫자에 대한 검사를 한다.
     * 
     * @param userNumbers
     * @return
     */
    public boolean check(int[] userNumbers) {
	int[] answer = getAnswer();
	if (Arrays.equals(getAnswer(), userNumbers)) {
	    System.out.println("3개의 숫자를 모두 맞히셨습니다. 게임 종료");
	    return true;
	}

	for (int i = 0; i < getAnswer().length; i++) {
	    match(i, answer, userNumbers);
	}

	System.out.println(toStringResult());
	resetCount();
	return false;
    }

    /**
     * 자릿수에 맞는 랜덤 숫자를 생성한다.
     * 
     * @param digit
     * @return
     */
    private int[] generateRandomNumber(int digit) {
	int[] array = new int[digit];
	for (int i = 0; i < digit; i++) {
	    array[i] = (int) (Math.random() * 9) + 1;
	}
	return array;
    }

    /**
     * 스트라이크인지, 볼인지 매칭시킨다.
     * 
     * @param i
     * @param answer
     * @param userNumbers
     */
    private void match(int i, int[] answer, int[] userNumbers) {
	for (int j = 0; j < userNumbers.length; j++) {
	    if (isStrike(i, j, answer[i], userNumbers[j]))
		continue;
	    if (isBall(i, j, answer[i], userNumbers[j]))
		continue;
	}
    }

    /**
     * 스트라이크인지를 검사한다.
     * 
     * @param i
     * @param j
     * @param answerNumber
     * @param userNumber
     * @return
     */
    private boolean isStrike(int i, int j, int answerNumber, int userNumber) {
	if (i == j && answerNumber == userNumber) {
	    strike++;
	    return true;
	}
	return false;
    }

    /**
     * 볼인지 검사한다.
     * 
     * @param i
     * @param j
     * @param answerNumber
     * @param userNumber
     * @return
     */
    private boolean isBall(int i, int j, int answerNumber, int userNumber) {
	if (i != j && answerNumber == userNumber) {
	    ball++;
	    return true;
	}
	return false;
    }

    /**
     * 스트라이크와 볼 카운트를 초기화한다.
     */
    private void resetCount() {
	strike = 0;
	ball = 0;
    }

    /**
     * 결과 메세지를 String으로 반환한다.
     * 
     * @return
     */
    private String toStringResult() {
	if (strike == 0 && ball == 0) {
	    return "낫싱";
	}
	return getResult();
    }

    /**
     * 스트라이크, 볼 결과 메세지를 가져온다.
     * 
     * @return
     */
    private String getResult() {
	StringBuffer str = new StringBuffer();
	if (strike != 0)
	    str.append(strike + " 스트라이크 ");

	if (ball != 0)
	    str.append(ball + "볼");

	return str.toString();
    }

}
