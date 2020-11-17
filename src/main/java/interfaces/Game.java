package interfaces;

import java.io.IOException;

public interface Game {

    //play game method
    void play() throws IOException;

    //다시 게임플레이 여부
    boolean playGameAgain();

}
