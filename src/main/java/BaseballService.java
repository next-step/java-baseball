
public class BaseballService {

    public void start() {
        Baseball baseball;
        baseball = new Baseball();
        baseball.setOpponentNumber(BaseUtil.getRandomNumber());
    }

}