package ui;

import domain.BaseballGame;
import domain.BaseballResult;
import domain.RandomBaseballNumbersGenerator;
import domain.exceptions.OutOfBoundBaseballNumberException;
import ui.exceptions.InvalidSizeException;

import java.util.Scanner;

public class BaseballGameRunner {
    private static final String GAME_ENDING = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            BaseballGame baseballGame = BaseballGame.init(new RandomBaseballNumbersGenerator());

            playOneGame(baseballGame);

            System.out.println(GAME_ENDING);
        } catch (OutOfBoundBaseballNumberException e) {
            System.out.println("1 ~ 9 사이의 숫자를 입력해주세요.");
        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력 가능합니다.");
        } catch (InvalidSizeException e) {
            System.out.println("중복 없는 세자리 숫자만 입력 가능합니다.");
        } catch (Exception e) {
            System.out.println("알 수 없는 오류로 인해 게임을 종료합니다.");
        }
    }

    private static void playOneGame(BaseballGame baseballGame) {
        while(!baseballGame.isFinished()) {
            System.out.println("숫자를 입력해주세요: ");
            UserInput userInput = new UserInput(scanner.nextLine());

            BaseballResult baseballResult = baseballGame.play(userInput.convertToBaseballNumbers());

            System.out.println(UserOutput.parseResult(baseballResult));
        }
    }
}
