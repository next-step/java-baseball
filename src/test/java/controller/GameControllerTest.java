package controller;

import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {

    @Test
    public void testStrikeCount(){
        GameController gameController = new GameController();
        List<Integer> listA = Arrays.asList(1,2,3);
        List<Integer> listB = Arrays.asList(1,2,4);
        int count = gameController.checkStrikeCount(listA,listB);
        assertEquals(2,count);
    }

    @Test
    public void testBallCount(){
        GameController gameController = new GameController();
        List<Integer> listA = Arrays.asList(1,2,3);
        List<Integer> listB = Arrays.asList(2,3,4);
        int count = gameController.checkBallCount(listA,listB);
        assertEquals(2,count);
    }

}