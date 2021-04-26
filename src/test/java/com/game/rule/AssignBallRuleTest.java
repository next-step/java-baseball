package com.game.rule;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AssignBallRuleTest {

    @Test
    @DisplayName("1 스트라이크 테스트")
    void infoGameResultOneStrike() {

        List<String> comNumberList = new ArrayList<>();
        List<String> userNumberList = new ArrayList<>();

        comNumberList.add("1");
        comNumberList.add("3");
        comNumberList.add("5");

        userNumberList.add("2");
        userNumberList.add("4");
        userNumberList.add("5");

        AssignBallRule assignBallRule = new AssignBallRule();
        assignBallRule.infoGameResult(comNumberList,userNumberList);

        assertThat(assignBallRule.getStrikeCount())
                .isEqualTo(1);

        assertThat(assignBallRule.getBallCount())
                .isEqualTo(0);
    }

    @Test
    @DisplayName("3 스트라이크 테스트")
    void infoGameResultThreeStrike() {
        List<String> comNumberList = new ArrayList<>();
        List<String> userNumberList = new ArrayList<>();

        comNumberList.add("1");
        comNumberList.add("3");
        comNumberList.add("5");

        userNumberList.add("1");
        userNumberList.add("3");
        userNumberList.add("5");

        AssignBallRule assignBallRule = new AssignBallRule();
        assignBallRule.infoGameResult(comNumberList,userNumberList);


        assertThat(assignBallRule.getStrikeCount())
                .isEqualTo(3);

        assertThat(assignBallRule.getBallCount())
                .isEqualTo(0);
    }

    @Test
    @DisplayName("3 볼 테스트")
    void infoGameResultThreeBall() {
        List<String> comNumberList = new ArrayList<>();
        List<String> userNumberList = new ArrayList<>();

        comNumberList.add("1");
        comNumberList.add("3");
        comNumberList.add("5");

        userNumberList.add("5");
        userNumberList.add("1");
        userNumberList.add("3");

        AssignBallRule assignBallRule = new AssignBallRule();
        assignBallRule.infoGameResult(comNumberList,userNumberList);

        assertThat(assignBallRule.getStrikeCount())
                .isEqualTo(0);

        assertThat(assignBallRule.getBallCount())
                .isEqualTo(3);
    }

    @Test
    @DisplayName("낫딩 테스트")
    void infoGameResultNothing() {
        List<String> comNumberList = new ArrayList<>();
        List<String> userNumberList = new ArrayList<>();

        comNumberList.add("1");
        comNumberList.add("3");
        comNumberList.add("5");

        userNumberList.add("7");
        userNumberList.add("8");
        userNumberList.add("9");

        AssignBallRule assignBallRule = new AssignBallRule();
        assignBallRule.infoGameResult(comNumberList,userNumberList);

        assertThat(assignBallRule.getStrikeCount())
                .isEqualTo(0);

        assertThat(assignBallRule.getBallCount())
                .isEqualTo(0);
    }
}