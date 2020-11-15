package domain;

import org.junit.jupiter.api.*;

import static domain.BaseballCodeDefinition.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("상대방(컴퓨터) 값 : [1, 2, 3]")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PlayerTest {

    private Player player;

    @BeforeEach
    public void setUp() {
        player = new Player(new Number(123));
    }

    @Test
    @Order(1)
    @DisplayName("사용자 입력 값 [1, 4, 5], 결과 : 1스트라이크")
    public void oneStrike() {
        Number userNumber = new Number(145);
        assertEquals(String.format(STRIKE, 1), player.result(userNumber).toString());
    }

    @Test
    @Order(2)
    @DisplayName("사용자 입력 값 [1, 2, 5], 결과 : 2스트라이크")
    public void twoStrike() {
        Number userNumber = new Number(125);
        assertEquals(String.format(STRIKE, 2), player.result(userNumber).toString());
    }

    @Test
    @Order(3)
    @DisplayName("사용자 입력 값 [1, 2, 3], 결과 : 3스트라이크")
    public void threeStrike() {
        Number userNumber = new Number(123);
        assertEquals(String.format(STRIKE, 3), player.result(userNumber).toString());
    }

    @Test
    @Order(4)
    @DisplayName("사용자 입력 값 [4, 5, 1], 결과 : 1볼")
    public void oneBall() {
        Number userNumber = new Number(451);
        assertEquals(String.format(BALL, 1), player.result(userNumber).toString());
    }

    @Test
    @Order(5)
    @DisplayName("사용자 입력 값 [2, 5, 1], 결과 : 2볼")
    public void twoBall() {
        Number userNumber = new Number(251);
        assertEquals(String.format(BALL, 2), player.result(userNumber).toString());
    }

    @Test
    @Order(6)
    @DisplayName("사용자 입력 값 [2, 3, 1], 결과 : 3볼")
    public void threeBall() {
        Number userNumber = new Number(231);
        assertEquals(String.format(BALL, 3), player.result(userNumber).toString());
    }

    @Test
    @Order(7)
    @DisplayName("사용자 입력 값 [1, 3, 2], 결과 : 1스트라이크 2볼")
    public void oneStrikeTwoBall() {
        Number userNumber = new Number(132);
        assertEquals(String.format(STRIKE_AND_BALL, 1, 2), player.result(userNumber).toString());
    }

    @Test
    @Order(8)
    @DisplayName("사용자 입력 값 [4, 5, 6], 결과 : 낫싱")
    public void nothing() {
        Number userNumber = new Number(456);
        assertEquals(NOTHING, player.result(userNumber).toString());
    }
}