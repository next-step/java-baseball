public class Message {
    private final String GET_INPUT = "숫자를 입력해 주세요 : ";
    private final String NOT_NUMBER = "숫자만 입력가능합니다.";
    private final String NOT_THREE_NUMBER = "숫자 3자리를 입력해주세요.";
    private final String NOTHING = "낫싱";
    private final String GAME_OVER = "3개의 숫자를 모두 맞히셨습니다. 게임종료";

    /**
     * 입력 받기 메세지
     */
    public void getInput() {
        System.out.println(this.GET_INPUT);
    }

    /**
     * 숫자가 아닌 입력값일때 메세지
     */
    public void notNumber() {
        System.out.println(this.NOT_NUMBER);
    }

    /**
     * 3자리 숫자가 아닌 입력값일때 메세지
     */
    public void notThreeNumber() {
        System.out.println(this.NOT_THREE_NUMBER);
    }

    /**
     * 아무것도 맞지 않을경우 메세지
     */
    public void nothing() {
        System.out.println(this.NOTHING);
    }

    /**
     * 게임 종료 메세지
     */
    public void gameOver() {
        System.out.println(this.GAME_OVER);
    }

    /**
     * 입력 결과 메세지
     * @param strike 스크라이크 수
     * @param ball 볼 수
     */
    public void getResult(int strike, int ball) {
        String message = "";
        if (strike > 0) {
            message += strike + " 스트라이크 ";
        }

        if (ball > 0) {
            message += ball + " 볼";
        }

        if (message.length() == 0) {
            this.nothing();
            return;
        }

        System.out.println(message);
    }
}
