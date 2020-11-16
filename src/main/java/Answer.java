public class Answer {

    private String questionNumber;
    int strikeCount = 0;
    int ballCount = 0;

    public Answer(String questionNumber) {
        this.questionNumber = questionNumber;
    }

    public boolean isValid(String answerNumber) {
        return (answerNumber.length() == 3);
    }

    public boolean isRight(String answerNumber) {
        return questionNumber.equals(answerNumber);
    }

    /**
     * 볼카운트 확인 및 출력
     *
     * @param answerNumber
     */
    public boolean getBallCount(String answerNumber) {
        char[] answerCharArray = answerNumber.toCharArray();
        char[] questionCharArray = questionNumber.toCharArray();

        for (int i = 0; i < answerCharArray.length; i++) {
            getBallCountByChar(answerCharArray, questionCharArray, i);
        }

        // 볼카운트 결과 출력
        printBallCount();

        return this.strikeCount == 3;
    }

    /**
     * 한 숫자씩 볼/스트라이크/None 카운트 구분
     *
     * @param answerCharArray
     * @param questionCharArray
     * @param i
     */
    private void getBallCountByChar(char[] answerCharArray, char[] questionCharArray, int i) {
        for (int j = 0; j < questionCharArray.length; j++) {

            // 스타라이크 카운트
            strikeCount = getCount(answerCharArray, questionCharArray, strikeCount, i, j, i == j);

            // 볼 카운트
            ballCount = getCount(answerCharArray, questionCharArray, ballCount, i, j, i != j);
        }
    }

    /**
     * 볼/스트라이크 확인
     *
     * @param answerCharArray
     * @param questionCharArray
     * @param count
     * @param i
     * @param j
     * @param b
     * @return
     */
    private int getCount(char[] answerCharArray, char[] questionCharArray, int count, int i, int j, boolean b) {
        if ((questionCharArray[i] == answerCharArray[j]) && (b)) {
            count++;
        }
        return count;
    }

    /**
     * 볼카운트 결과 출력
     */
    private void printBallCount() {

        String result = (this.strikeCount > 0 ? this.strikeCount + "스타라이크 " : "") + (this.ballCount > 0 ? this.ballCount + "볼" : "");

        if(!"".equals(result)) {
            System.out.println(result);
        }

        if (this.strikeCount == 0 && this.ballCount == 0) {
            System.out.println("낫싱");
        }

        if (this.strikeCount == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
        }
    }

}
