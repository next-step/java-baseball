package view;

public class ResultView {
    public void displayResult(String toString) {
        System.out.println(toString);
    }

    public void clearMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작할려면 1, 종료할려면 2를 입력하세요.");
    }
}
