package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.ViewLayer;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BaseballGameTest {

    private ViewLayer viewLayer;
    private List<Integer> randomNumberGenerator;

    @BeforeEach
    void init() {
        viewLayer = new ViewLayer() {

            @Override
            public String inputValue() {
                return "345";
            }

            @Override
            public void outValue(String value) {
                System.out.println(value);
            }
        };

        randomNumberGenerator = Arrays.asList(3, 4, 5);
    }

    @DisplayName("야구게임 실행 후 3 Strike 맞춘 후 종료")
    @Test
    void start() {
        BaseballGame baseballGame = new BaseballGame(randomNumberGenerator, viewLayer, true);
        baseballGame.init();
    }
}