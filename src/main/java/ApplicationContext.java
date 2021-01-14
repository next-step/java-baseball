public class ApplicationContext {

    private static final Input input = new InputKey();

    public static GameManager getGameManager() {
        return new GameManager(input);
    }
}
