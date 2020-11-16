package app;

/**
 * 숫자야구 메인 클래스
 */
public class BaseballGame {

    private final Score score = new Score();
    private final String generateNumber;
    private final String[] generateNumberArray;

    public BaseballGame(String generateNumber) {
        this.generateNumber = generateNumber;
        this.generateNumberArray = generateNumber.split("");
    }

    /**
     * 사용자가 입력한 값과 임의로 생성된 값을 비교하여 판별한 결과 리턴
     *
     * @param input 사용자 입력값
     * @return Score
     */
    public Score guess(String input) {
        score.clearCount();
        int length = generateNumber.length();
        for (int i = 0; i < length; i++) {
            String number = String.valueOf(input.charAt(i));
            checkStrikeCount(number, i);
            checkBallCount(number, i);
        }

        return score;
    }

    /**
     * 스트라이크 카운트 체크
     *
     * @param number 판별대상 숫자
     * @param i      generateNumberArray 인덱스
     */
    private void checkStrikeCount(String number, int i) {
        if (generateNumberArray[i].equals(number)) {
            score.setStrike();
        }
    }

    /**
     * 볼카운트 체크
     *
     * @param number 판별대상 숫자
     * @param i      generateNumberArray 인덱스
     */
    private void checkBallCount(String number, int i) {
        if (!generateNumberArray[i].equals(number) && generateNumber.contains(number)) {
            score.setBall();
        }
    }
}
