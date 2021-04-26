package techcamp.baseball;

import techcamp.baseball.domain.Answer;
import techcamp.baseball.domain.Question;
import techcamp.baseball.setting.Config;

import java.util.Scanner;

public class BaseBall {

    public void play() {
        start();
        reStart();
    }

    private void start() {
        Question question = new Question();
        Scanner scanner = new Scanner(System.in);
        boolean status = true;

        System.out.println(question.getNumbers().toString());

        while(status) {
            status = calculateResult(scanner, question);
        }
    }

    private boolean calculateResult(Scanner scanner, Question question) {
        Calculation calculation = new Calculation();
        Validation validation = new Validation();
        Answer answer;
        String input;

        System.out.print("숫자를 입력해주세요 : ");
        input = scanner.next();
        if(!validation.isAllowableSize(input)) {
            System.out.println(Config.NUMBERS_LENGTH + "자리 숫자가 아닙니다.");
            return true;
        }
        if(!validation.isDigit(input)) {
            System.out.println("입력값이 다음과 같은 범위의 숫자형식이 아닙니다.[1-9]");
            return true;
        }

        answer = new Answer(input);
        calculation.execute(question, answer);
        if(answer.getStrikeCount() == Config.NUMBERS_LENGTH) {
            System.out.println("3개의 숫자를 전부 맞히셨습니다! 게임 종료");
            return false;
        }

        System.out.println(answer.getCountResult());

        return true;
    }

    private void reStart() {
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        input = scanner.next();
        if(input.equals("1")) {
            this.play();
            return;
        }
        if(input.equals("2")) {
            System.out.println("어플리케이션을 종료합니다.");
            return;
        }

        this.reStart();
    }
}
