import java.util.Scanner;

public class BaseballGame {
    private Scanner scanner = new Scanner(System.in);
    private boolean isSolved = false;
    private int question;

    public BaseballGame() {
        init();
    }

    private void init() {
        question = 123; // TODO 문제 출제
    }

    private boolean isPlaying() {
        if (!isSolved) {
            return true;
        }
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = scanner.nextLine();
        if (input.equals("2")) {
            return false;
        }
        return true;
    }

    private void judge(String answer) {
        // TODO 플레이어가 제출한 답안 확인
        System.out.println("3 스트라이크"); // TODO 결과 출력
        isSolved = true; // TODO 결과에 따라 플레이 상태 변경
    }

    public void run() {
        while (isPlaying()) {
            System.out.print("숫자를 입력해주세요 : ");
            judge(scanner.nextLine());
        }
    }
}
