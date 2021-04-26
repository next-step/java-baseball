import java.util.Scanner;

public class BaseballGame {
    private Scanner scn = new Scanner(System.in);
    private int LEN = 3;

    public static void main(String[] args) {
        int regame = 1;
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.startBaseball();

    }
    public BaseballGame() {
    }

    /**
     * startBaseball
     * 게임 시작 메소드
     * 첫 실행후 게임을 실행하며, 한 게임이 종료된 후엔 게임의 재시작, 종료 여부를 입력받아 처리한다.
     * @return 게임 종료 여부
     */
    public int startBaseball() {
        int regame_flag = 1;

        while (regame_flag != 2) {
            //playOneGame(regame_flag);
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            regame_flag = scn.nextInt();
        }

        return regame_flag;
    }
}
