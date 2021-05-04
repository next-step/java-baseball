import application.cli.GameMachine;
import domain.core.Baseball;

public class MainApplication {
    public static void main(String[] args) {
        GameMachine gameMachine = GameMachine.of(Baseball.newInstance());
        gameMachine.start();
    }
}
