import java.util.Scanner;

public class BaseBall {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        App app = new App();
        int restart = 1;
        while (restart == 1) {
            app.start();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            restart = scanner.nextInt();
        }
    }
}
