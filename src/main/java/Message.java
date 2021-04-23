public class Message {
    private final String GET_INPUT = "숫자를 입력해 주세요 : ";
    private final String NOT_NUMBER = "숫자만 입력가능합니다.";
    private final String NOT_THREE_NUMBER = "숫자 3자리를 입력해주세요.";
    private final String GAME_OVER = "3개의 숫자를 모두 맞히셨습니다. 게임종료";

    public void getInput() {
        System.out.println(this.GET_INPUT);
    }

    public void notNumber() {
        System.out.println(this.NOT_NUMBER);
    }

    public void notThreeNumber() {
        System.out.println(this.NOT_THREE_NUMBER);
    }

    public void gameOver() {
        System.out.println(this.GAME_OVER);
    }
}
