package baseball;

public class BaseballGameStarter {

    public void start() {
        do {
            sayHello();
        } while (false); // todo 게임 종료 판단로직이 나오면 변경할 것
    }

    private void sayHello() {
        System.out.println("숫자를 입력해주세요 : ");
    }
}
