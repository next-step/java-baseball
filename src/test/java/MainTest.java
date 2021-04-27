import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class MainTest {

    @Test
    @DisplayName("Test Baseball Random Number")
    void TEST_getRandomNumStr() {
        String randomNumStr = Main.getRandomNumStr();
        StringBuilder baseballNum = new StringBuilder();
        Set baseballNumSet = new HashSet();

        for (int i = 0; i < randomNumStr.length(); i++) {
            int num = randomNumStr.charAt(i) - '0';
            baseballNumSet.add(num);
            baseballNum.append(num);
            assertThat(num).isGreaterThan(0);
        }

        for (int i = 0; i < randomNumStr.length(); i++) {
            int num = randomNumStr.charAt(i) - '0';
            assertThat(baseballNumSet).containsOnlyOnce(num);
        }
    }

    @Test
    @DisplayName("Test Baseball Strike Number")
    void TEST_getStrikeCount() {

        String userBaseballStr = "123";
        String commRandomNum = "123";

        // Check Strike
        int strikeCount = Main.getStrikeCount(userBaseballStr, commRandomNum);
        System.out.println(strikeCount + " 스트라이크");

        assertThat(strikeCount).isEqualTo(3);
    }

    @Test
    @DisplayName("Test Baseball Strike Number")
    void TEST_getStrikeCount2() {

        String userBaseballStr = "123";
        String commRandomNum = "124";

        // Check Strike
        int strikeCount = Main.getStrikeCount(userBaseballStr, commRandomNum);
        System.out.println(strikeCount + " 스트라이크");

        assertThat(strikeCount).isEqualTo(2);
    }

    @Test
    @DisplayName("Test Baseball Strike Number")
    void TEST_getStrikeCount3() {

        String userBaseballStr = "123";
        String commRandomNum = "543";

        // Check Strike
        int strikeCount = Main.getStrikeCount(userBaseballStr, commRandomNum);
        System.out.println(strikeCount + " 스트라이크");

        assertThat(strikeCount).isEqualTo(1);
    }

    @Test
    @DisplayName("Test Baseball Ball Number")
    void TEST_getBallCount() {

        String userBaseballStr = "123";
        String commRandomNum = "981";

        // Check Ball
        int ballCount = Main.getBallCount(userBaseballStr, commRandomNum);
        System.out.println(ballCount + "볼");
        assertThat(ballCount).isEqualTo(1);
    }

    @Test
    @DisplayName("Test Baseball Ball Number")
    void TEST_getBallCount2() {

        String userBaseballStr = "123";
        String commRandomNum = "381";

        // Check Ball
        int ballCount = Main.getBallCount(userBaseballStr, commRandomNum);
        System.out.println(ballCount + "볼");
        assertThat(ballCount).isEqualTo(2);
    }

    @Test
    @DisplayName("Test Baseball Ball Number")
    void TEST_getBallCount3() {

        String userBaseballStr = "123";
        String commRandomNum = "231";

        // Check Ball
        int ballCount = Main.getBallCount(userBaseballStr, commRandomNum);
        System.out.println(ballCount + "볼");
        assertThat(ballCount).isEqualTo(3);
    }


    @Test
    @DisplayName("Test Baseball Nothing Number")
    void TEST_getNothingCount() {

        String userBaseballStr = "987";
        String commRandomNum = "123";

        // Check Strike
        int strikeCount = Main.getStrikeCount(userBaseballStr, commRandomNum);
        System.out.println(strikeCount + "스트라이크");

        // Check Ball
        int ballCount = Main.getBallCount(userBaseballStr, commRandomNum);
        System.out.println(ballCount + "볼");

        boolean isNothing = strikeCount + ballCount > 0 ? false : true;
        if (isNothing) {
            System.out.println("낫싱");
        }

        assertThat(isNothing).isEqualTo(true);
    }

    @Test
    @DisplayName("Test Baseball Game restart")
    void TEST_startBaseballGame() {

        String userBaseballNum = "1";
        InputStream in = new ByteArrayInputStream(userBaseballNum.getBytes());
        System.setIn(in);

        boolean gameRunningStatus = Main.getGameRunningStatus();
        System.out.println("userBaseballNum : " + userBaseballNum);
        System.out.println("gameRunningStatus : " + gameRunningStatus);


        assertThat(gameRunningStatus).isEqualTo(true);
    }

    @Test
    @DisplayName("Test Baseball Game restart")
    void TEST_startBaseballGame2() {

        String userBaseballNum = "2";
        InputStream in = new ByteArrayInputStream(userBaseballNum.getBytes());
        System.setIn(in);

        boolean gameRunningStatus = Main.getGameRunningStatus();
        System.out.println("userBaseballNum : " + userBaseballNum);
        System.out.println("gameRunningStatus : " + gameRunningStatus);

        assertThat(gameRunningStatus).isEqualTo(false);
    }

}
