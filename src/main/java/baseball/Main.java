package baseball;

public class Main {

    public static void main(String[] args) {
        BaseBall baseBall = new BaseBall();
        boolean isFinish;

        do {
            baseBall.playGame();
            isFinish = baseBall.requestContinue();
        } while (isFinish);

        System.out.println("게임이 종료되었습니다.");
    }
}
