package game;

import common.GameOption;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GameProcessInfoTest {

    private GameProcessInfo gameProcessInfo;

    @BeforeAll
    void setgameProcessInfo() {
        gameProcessInfo = new GameProcessInfo();
    }

    @Test
    void makeGameProcessInfoNumberArray() {
        ArrayList<String> numberArray = gameProcessInfo.getRandomNumberArray();
        HashSet<Integer> numberSet = new HashSet<>();

        for(String number : numberArray){
            numberSet.add(Integer.parseInt(number));
        }

        assertTrue(numberSet.size() == GameOption.RANDOM_NUMBER_COUNT);
    }

}