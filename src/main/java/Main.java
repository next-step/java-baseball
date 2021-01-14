import baseball.*;

public class Main {
    public static void main(String[] args) {
        GameHost gameHost = makeGameHost();
        gameHost.playGame();
    }

    private static GameHost makeGameHost() {
        JudgmentBehavior judgmentBehavior = new JudgmentBehaviorImpl();
        PrintBehavior printBehavior = new PrintBehaviorImpl();
        InputBehavior inputBehavior = new InputBehaviorImpl();
        return new GameHostImpl(judgmentBehavior, printBehavior, inputBehavior);
    }
}
