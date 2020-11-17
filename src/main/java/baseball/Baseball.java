package baseball;

public class Baseball {

    private final Player player;
    private final Opponent opponent;

    public Baseball() {
        this.player = new Player();
        this.opponent = new Opponent();
    }

    public void start() {
        boolean isUserCorrect = false;
        opponent.selectValue();

        while (!isUserCorrect) {
            player.inputValue();
            opponent.judgeGame(player.getValue());
            opponent.printGameResult();
            isUserCorrect = opponent.isUserCorrect();
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
