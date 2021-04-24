public class BaseBallGameController {
    private final int BASEBALL_NUM_LENGTH = 3;

    BaseBallCatcher catcher;
    BaseBallPitcher pitcher;

    BaseBallGameController() {
        catcher = new BaseBallCatcher(BASEBALL_NUM_LENGTH);
        pitcher = new BaseBallPitcher(BASEBALL_NUM_LENGTH);
    }

    public void start() {
        do {
             catcher.setPitchingNumber(pitcher.getPitchingNumber());
             catcher.printScore();
        } while(isContinueGame());
    }

    private boolean isContinueGame() {
        if (catcher.is3Strike() && wantsEnd()) {
            return false;
        }

        return true;
    }

    private boolean wantsEnd() {

        return false;
    }
}