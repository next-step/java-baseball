package app;

import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ViewTest {

    @Resource
    Baseball baseball = new Baseball();

    @Resource
    View view = new View();

    private GameNumber setComNumber() {
        GameNumber comNumber = new GameNumber();
        int[] arr = {1, 2, 3};
        ArrayList<Integer> list = new ArrayList<Integer>(arr.length);
        for (int i : arr) {
            list.add(i);
        }
        comNumber.setGameNumberList(list);
        return comNumber;
    }

    private GameNumber setUserNumber() {
        GameNumber userNumber = new GameNumber();
        int[] arr = {1, 3, 4};
        ArrayList<Integer> list = new ArrayList<Integer>(arr.length);
        for (int i : arr) {
            list.add(i);
        }
        userNumber.setGameNumberList(list);
        return userNumber;
    }

    @Test
    void gameResultOutputTest() {
        GameResult gameResult = baseball.getGameResult(setComNumber(), setUserNumber());
        view.gameResultOutput(gameResult);
    }
}