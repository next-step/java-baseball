package baseballgame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseballGameTest {

    @Test
    @DisplayName("기본 테스트입니다")
    void MainTest() {
        System.out.println("test");
        assertEquals("test", "test");
    }
}
