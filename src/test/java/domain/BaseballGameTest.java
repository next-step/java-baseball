package domain;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ui.IOManager;
import ui.Input;
import ui.StandardOutput;

class BaseballGameTest {

    private IOManager ioManager;
    private NumbersGenerator numbersGenerator;

    @BeforeEach
    void setUp() {
        Input input = new Input() {
            @Override
            public String nextLine() {
                return "2";
            }

            @Override
            public int nextInt() {
                return 123;
            }
        };

        ioManager = new IOManager(input, new StandardOutput());

        numbersGenerator = () -> {
            List<Integer> numbers = new ArrayList<>();
            numbers.add(1);
            numbers.add(2);
            numbers.add(3);
            return numbers;
        };
    }

    @DisplayName("게임 실행 후 정답을 맞춘 뒤 종료")
    @Test
    void run() {
        BaseballGame baseballGame = new BaseballGame(ioManager, numbersGenerator);
        baseballGame.run();
    }
}