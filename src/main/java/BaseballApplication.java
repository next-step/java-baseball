
public class BaseballApplication {
    public static void main(String[] args) {
        BaseballApplication.run();
    }

    public static void run() {
        GameMaster master = new GameMaster();
        while(master.isWantToPlay()) {
            master.readyForPlay();
            master.play();
        }
    }
}
