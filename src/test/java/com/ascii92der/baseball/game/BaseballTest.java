package com.ascii92der.baseball.game;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballTest {
    private List<Integer> computerNumberList;
    private List<Integer> playerNumberList;

    @BeforeEach
    void setup() {
        computerNumberList = new ArrayList<>();
        computerNumberList.add(3);
        computerNumberList.add(7);
        computerNumberList.add(6);

        playerNumberList = new ArrayList<>();
        playerNumberList.add(3);
        playerNumberList.add(6);
        playerNumberList.add(1);
    }

    @Test
    public void checkBallCountTest() {
        Baseball baseball = new Baseball();
        assertThat(baseball.checkBallCount(computerNumberList, playerNumberList)).isEqualTo(2);
    }

    @Test
    public void checkStrikeCountTest() {
        Baseball baseball = new Baseball();
        assertThat(baseball.checkStrikeCount(computerNumberList, playerNumberList)).isEqualTo(1);
    }

    @Test
    public void resultBaseballTest() {
        Baseball baseball = new Baseball();
        assertThat(baseball.resultBaseball(computerNumberList, playerNumberList)).isFalse();
    }

}
