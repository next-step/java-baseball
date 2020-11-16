
public class BaseballApplication {
    public static void main(String[] args) {
        BaseballApplication.run();
    }

    public static void run() {
        GameMaster master = new GameMaster();
        master.readyForPlay();
        while(!master.isWantToPlay()) {
            master.play();
        }
    }
}
