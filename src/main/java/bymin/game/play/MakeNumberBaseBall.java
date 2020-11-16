package bymin.game.play;

import java.util.ArrayList;
import java.util.Random;

public class MakeNumberBaseBall {
    ArrayList<Integer> numList;

    public void make() {
        Random rand = new Random();
        numList = new ArrayList<>();
        while (numListCheck(rand.nextInt(9) + 1)) {
        }
    }

    // 3개까지 숫자를 채운다.
    public boolean numListCheck(int cnt) {
        if (!numList.contains(cnt)) {
            numList.add(cnt);
        }
        return numList.size() != 3;
    }

    public ArrayList<Integer> getNumList() {
        return numList;
    }
}
