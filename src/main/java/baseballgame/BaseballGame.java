package baseballgame;

import lombok.Getter;

import java.util.Random;

public class BaseballGame {

    Random r = new Random();

    @Getter
    private String gameNumber;

    // 게임에 필요한 3자리 숫자 초기화
    public void initGame() {
        int randomNumberSize = 3;
        gameNumber = getRandomNumberString(randomNumberSize);
    }

    public boolean startGame() {
        return false;
    }

    private String getRandomNumberString(int size) {
        String numberString = "";

        for (int i = 0; i < size; i++) {
            int v = r.ints(0, 10)
                    .findFirst()
                    .orElse(0);
            numberString = numberString.concat(Integer.toString(v));
        }

        return numberString;
    }
}
