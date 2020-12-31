package game;

import validators.BaseballNumberValidator;
import validators.EndNumberValidator;
import validators.Validator;

import java.util.Scanner;
public class BaseballGame {
    public static final int NUMBER_LENGTH = 3;

    static Scanner scanner;
    public static final String commentWhenReceiveNumber = "숫자를 입력해 주세요: ";
    static Validator numberChecker;
    static Validator endingInputChecker;
    static InputManager inputManager;
    static {
        scanner = new Scanner(System.in);
        numberChecker = new BaseballNumberValidator();
        endingInputChecker = new EndNumberValidator();
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
