public class BaseBallGame {

    private final BaseBallGameService baseBallGameService = new BaseBallGameService();

    public void start() {
        System.out.println("숫자야구게임 START!");
        BaseBallNumber baseBallNumber = baseBallGameService.createBaseBallNumber();
    }
}
