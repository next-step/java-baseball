package baseball;

public class Main {

    public static void main(String[] args) {
        BaseBall baseBall = new BaseBall();

        do {
            baseBall.playGame();
        } while (baseBall.askContinue());

        System.out.println("게임이 종료되었습니다.");
    }
}
