package app;

public class Game {
    public void execution() {
        View view = new View();
        Baseball baseball = new Baseball();
        GameResult gameResult = new GameResult();
        GameNumber comNumber = baseball.createRandomGameNumber();
        view.output("야구게임 시작!! 중복되지 않은 3자리 숫자를 입력하세요.");
        do {
            System.out.println("hint: " + comNumber.toString()); // TODO: 원활한 테스트를 위한 힌트!
            gameResult = baseball.getGameResult(comNumber, baseball.convertNumberStringToGameNumber(view.viewUserNumberInput()));
            view.viewGameResultOutput(gameResult);
        } while (!gameResult.isGameSuccess());
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void repeatExecution() {
        View view = new View();
        do {
            execution();
            view.output("게임을 걔속 하시려면 아무키나 입력하세요. 종료하시려면 Q를 입력하세요.");
        } while (!"Q".equals(view.input().toUpperCase()));
        view.output("Good Bye~!!");
    }
}
