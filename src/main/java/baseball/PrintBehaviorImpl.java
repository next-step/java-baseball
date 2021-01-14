package baseball;

public class PrintBehaviorImpl implements PrintBehavior {
    @Override
    public void printStartInnings() {
        System.out.print("숫자를 입력해 주세요 : ");
    }

    @Override
    public void printInningsResult(InningsResult inningsResult) {
        System.out.println(inningsResult.toString());
        if (inningsResult.isEndMatch()) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }
    }
}
