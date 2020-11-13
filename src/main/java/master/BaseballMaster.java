package master;

import checkor.BaseballCheckor;
import checkor.Checkor;
import generator.NumberGenerator;

import java.util.Arrays;
import java.util.Scanner;

public class BaseballMaster implements Master {

    private int[] answer;
    private NumberGenerator generator;
    private Checkor checkor;

    public BaseballMaster(NumberGenerator generator) {
        this.generator = generator;
    }

    @Override
    public void initAnswer() {
        this.answer = generator.generate(3);
        checkor = new BaseballCheckor(answer);
    }

    @Override
    public void open() {
        Boolean check = Boolean.FALSE;

        while (!check) {
            System.out.print("숫자를 입력해주세요 : ");
            Scanner scanner = new Scanner(System.in);
            String value = scanner.next();
            check = (Boolean) checkor.check(value);
        }
        inquireReopen();
    }

    private void inquireReopen() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        String value = scanner.next();
        if ("1".equals(value)) {
            initAnswer();
            open();
        }
    }
}
