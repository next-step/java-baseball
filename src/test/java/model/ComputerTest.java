package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {

    @DisplayName("computer 객체 생성")
    @Test
    void create() {
        Computer computer = Computer.of();
        computer.getBaseBallNumbers().getBallNumbers().stream().forEach(number ->
                System.out.println(number.getNumber()));
    }
}