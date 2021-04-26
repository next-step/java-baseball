public class BaseballProject {

    public static void main(String[] args) {
        BaseballService service = new BaseballService();
        service.startGame(Constants.BASEBALL_DEFAULT_NUMBER_SIZE);
    }
}