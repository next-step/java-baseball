import java.util.Scanner;

public class BaseballSimulator {
    public void doSimulation() {
        int computerTurn = Computer.nextTurn();
        Result result;

        do {
            System.out.print("숫자를 입력해주세요 : ");
            int userTurn = User.nextTurn();
            result = Judge.getResult(userTurn, computerTurn);
            result.print();
        } while (!result.equals(new Result(3, 0)));
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BaseballSimulator baseballSimulator = new BaseballSimulator();

        do {
            baseballSimulator.doSimulation();
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        } while (User.selectMenu() == 1);
    }
}
