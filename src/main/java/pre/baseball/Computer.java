package pre.baseball;

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

}
