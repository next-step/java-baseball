package domain;

import org.junit.jupiter.api.*;

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
        assertEquals(String.format(BaseballCodeDefinition.STRIKE, 1), player.result(userNumber).toString());
    }

    @Test
    @Order(2)
    @DisplayName("사용자 입력 값 [1, 2, 5], 결과 : 2스트라이크")
    public void twoStrike() {
        Number userNumber = new Number(125);
        assertEquals(String.format(BaseballCodeDefinition.STRIKE, 2), player.result(userNumber).toString());
    }

    @Test
    @Order(3)
    @DisplayName("사용자 입력 값 [1, 2, 3], 결과 : 3스트라이크")
    public void threeStrike() {
        Number userNumber = new Number(123);
        assertEquals(String.format(BaseballCodeDefinition.STRIKE, 3), player.result(userNumber).toString());
    }
}