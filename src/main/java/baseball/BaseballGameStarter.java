package baseball;

import java.util.Random;

public class BaseballGameStarter {

    private BaseballGameScanner baseballGameScanner = new BaseballGameScanner();

    private String computerNumber;

    public void start() {
        init();

        do {
            sayHello();
            String inputData = baseballGameScanner.scan();

        } while (false); // todo 게임 종료 판단로직이 나오면 변경할 것
    }

    private void sayHello() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    private void init() {
        computerNumber = makeComputerNumber();
    }

    String makeComputerNumber() {
        Random random = new Random();
        boolean[] checked = new boolean[10];
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0 ; i < 3 ; i++) {
            stringBuilder.append(getDistinctRandomInt(random, checked));
        }

        return stringBuilder.toString();
    }

    private int getDistinctRandomInt(Random random, boolean[] checked) {
        int randomInt = random.nextInt(9) + 1; // 1 ~ 9 랜덤한 수
        if (!checked[randomInt]) {
            checked[randomInt] = true;
            return randomInt;
        }

        return getDistinctRandomInt(random, checked);
    }
}
