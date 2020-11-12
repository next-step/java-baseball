package ui;

import domain.exceptions.OutOfBoundBaseballNumberException;
import ui.exceptions.InvalidSizeException;

import java.util.Scanner;

public class BaseballGameRunner {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            System.out.println("숫자를 입력해주세요: ");

            UserInput userInput = new UserInput(scanner.nextLine());
            
            // TODO. 게임 진행 로직 추가해야 함.
        } catch (OutOfBoundBaseballNumberException e) {
            System.out.println("1 ~ 9 사이의 숫자를 입력해주세요.");
        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력 가능합니다.");
        } catch (InvalidSizeException e) {
            System.out.println("세자리 숫자만 입력 가능합니다.");
        } catch (Exception e) {
            System.out.println("알 수 없는 오류로 인해 게임을 종료합니다.");
        }
    }
}
