import java.util.Scanner;

public class BaseballGame {
    public static final int NUMBER_LENGTH = 3;

    static Scanner scanner;
    public static final String commentWhenReceiveNumber = "숫자를 입력해 주세요: ";
    static Checker numberChecker;
    static Checker endingInputChecker;
    static InputManager inputManager;
    static {
        scanner = new Scanner(System.in);
        numberChecker = new Checker() {
            @Override
            public void checkValid(String input) throws Exception{
                if(input.length() != BaseballGame.NUMBER_LENGTH){
                    throw new Exception("유효하지 않은 인풋 입니다");
                }
            }
        };
        endingInputChecker = new Checker() {
            @Override
            public void checkValid(String input) throws Exception {
                if("1".equals(input) || "2".equals(input)){
                    return;
                }
                throw new Exception("유효하지 않은 인풋 입니다");
            }
        };
        inputManager = new InputManager();
    }
    public void play(){
        Answer answer = new Answer();

        String input = inputManager.receiveInput(commentWhenReceiveNumber, numberChecker);
        while(!answer.isCorrect(input)){
            input = inputManager.receiveInput(commentWhenReceiveNumber, numberChecker);
        }
        System.out.println(NUMBER_LENGTH + "개의 숫자를 모두 맞혔습니다! 게임 종료");
        input = inputManager.receiveInput("게임을 새로 시작하려면 1, 종료하려면 2를 눌러주세요", endingInputChecker);
        if(input.equals("1"))
            play();
    }
}
