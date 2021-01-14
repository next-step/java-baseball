public class GameManager {

    private final Input input;

    public GameManager(Input input) {
        this.input = input;
    }

    public void start() {
        // 랜덤 숫자 생성
        Numbers answerNumbers = RandomNumbersGenerator.generate();

        // TODO: 위에서 생성한 `number`와 아래에서 받는 수가 일치할 때까지 반복(loop)
        // 플레이어의 입력을 받는다
        String inputValue = this.input.getInputValue("숫자를 입력해 주세요 : ");
        Numbers playerNumbers = new Numbers(inputValue);

        BallCount ballCount = answerNumbers.getBallCount(playerNumbers);
        System.out.println(ballCount.getBallCountMessage());
    }
}
