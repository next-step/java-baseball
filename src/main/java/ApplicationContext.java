public class ApplicationContext {

    private static final Input input = new KeyboardInput();

    public static GameManager getGameManager() {
        return new GameManager(input);
    }
}
