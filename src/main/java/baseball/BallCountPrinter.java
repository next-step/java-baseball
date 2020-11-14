package baseball;

public class BallCountPrinter {

    private BallCount ballCount;

    public BallCountPrinter(BallCount ballCount) {
        this.ballCount = ballCount;
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        if(ballCount.hasStrike()){
            sb.append(ballCount.getStrike());
            sb.append(GameResource.TEXT_STRIKE);
            sb.append(GameResource.TEXT_BLANK);
        }

        if(ballCount.hasBall()){
            sb.append(ballCount.getBall());
            sb.append(GameResource.TEXT_BALL);
            sb.append(GameResource.TEXT_BLANK);
        }

        if(ballCount.isNoting()){
            sb.append(GameResource.TEXT_NOTHING);
        }

        if(ballCount.isEndGame()){
            sb.append("\r\n");
            sb.append(GameResource.TEXT_GAME_END);
        }

        System.out.println(sb.toString().trim());
    }
}
