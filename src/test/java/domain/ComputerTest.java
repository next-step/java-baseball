package domain;

import domain.Computer;
import domain.Numbers;
import domain.Result;
import domain.Score;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    @DisplayName("숫자 생성 후 저장 테스트")
    @Test
    void generateNumbers() {
        Numbers input = Numbers.valueOf(1,2,3);
        Computer computer = new Computer(input);
        Numbers result = computer.getNumbers();

        assertThat(input).isEqualTo(result);
    }

    @DisplayName("사용자가 맞추려는 번호 매칭 메소드 테스트")
    @Test
    void matches() {
        Numbers input = Numbers.valueOf(1,2,3);
        Computer computer = new Computer(input);

        Numbers userNumbers = Numbers.valueOf(3,4,5);
        Result result = computer.matches(userNumbers);

        List<Score> scores = result.getScores();
        assertThat(scores).isEqualTo(Arrays.asList(Score.BALL));
    }

    @DisplayName("사용자가 맞추려는 번호 매칭 메소드 테스트 -아무것도 포함 안되었을 때")
    @Test
    void contains() {
        Numbers input = Numbers.valueOf(1,2,3);
        Computer computer = new Computer(input);

        Numbers userNumbers = Numbers.valueOf(4,5,6);
        Result result = computer.matches(userNumbers);

        List<Score> scores = result.getScores();
        assertThat(scores).isEqualTo(Arrays.asList(Score.NOTHING));
    }
}