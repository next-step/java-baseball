public class GameManager {
    private final Input input;

    public GameManager(Input input) {
        this.input = input;
    }

    public void start() {
        // 랜덤 숫자 생성
        Numbers answerNumbers = RandomNumbersGenerator.generate();
    }
}
