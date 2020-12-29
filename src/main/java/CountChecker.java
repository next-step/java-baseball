public class CountChecker {

    private String answer;
    private int strikeCnt;
    private int ballCnt;

    CountChecker(int answerNumber) {
        answer = String.valueOf(answerNumber);
        strikeCnt = 0;
        ballCnt = 0;
    }

    public void init() {
        strikeCnt = 0;
        ballCnt = 0;
    }

    public void check(int inputNumber) {
        init();
        String input = String.valueOf(inputNumber);

        for(int inputIndex = 0; inputIndex < input.length(); inputIndex++) {
            compareInputAndAnswer(inputIndex, input.charAt(inputIndex));
        }

        printResult();
    }

    private void compareInputAndAnswer(int inputIndex, char inputNumber) {
        for(int answerIndex = 0; answerIndex < answer.length(); answerIndex++) {
            compareDigitByDigit(inputIndex, inputNumber, answerIndex, answer.charAt(answerIndex));
        }
    }

    private void compareDigitByDigit(int inputIndex, char inputNumber, int answerIndex, char answerNumber) {
        if(inputNumber == answerNumber && inputIndex == answerIndex) {
            strikeCnt++;
        }

        if(inputNumber == answerNumber && inputIndex != answerIndex) {
            ballCnt++;
        }
    }

    private void printResult() {
        String result = "";

        if(strikeCnt > 0) result += strikeCnt + " 스트라이크";
        if(ballCnt > 0) result += ballCnt + " 볼";
        if(result.isEmpty()) result = "맞춘 숫자가 없습니다.";

        System.out.println(result);
    }
}