import nextstep.baseball.di.Injection;
import nextstep.baseball.service.Baseball;

public class Main {
    public static void main(String[] args) {
        Baseball baseball = Injection.provideBaseballGame();
        baseball.run();
    }
}
