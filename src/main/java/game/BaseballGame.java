package game;

import validators.Validator;

public class BaseballGame {
    public static final int NUMBER_LENGTH = 3;
    static final String commentWhenReceiveNumber = "숫자를 입력해 주세요: ";

    Validator numberChecker;
    Validator endingInputChecker;
    InputManager inputManager;

    public BaseballGame(Validator numberChecker,
                        Validator endingInputChecker,
                        InputManager inputManager) {
        this.numberChecker = numberChecker;
        this.endingInputChecker = endingInputChecker;
        this.inputManager = inputManager;
    }

    public BaseballGame() throws Exception {
        throw new Exception("기본 생성자로는 사용 불가 합니다. 필수 의존성 넣어주세요.");
    }

    public void play() {
        Answer answer = new Answer();

        String input = inputManager.receiveInput(commentWhenReceiveNumber, numberChecker);
        while (!answer.isCorrect(input)) {
            input = inputManager.receiveInput(commentWhenReceiveNumber, numberChecker);
        }
        System.out.println(NUMBER_LENGTH + "개의 숫자를 모두 맞혔습니다! 게임 종료");
        input = inputManager.receiveInput("게임을 새로 시작하려면 1, 종료하려면 2를 눌러주세요", endingInputChecker);
        if (input.equals("1"))
            play();
    }
}
