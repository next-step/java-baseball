package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {
    @DisplayName("Computer 생성 테스트 - 정상")
    @Test
    void 정상_생성_테스트(){
        Player computer = new Computer();
        BaseballNumberBundle randomBaseballNumberBundle = computer.getBaseballNumberBundle();
    }
}