package me.rn00n.baseball.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseballRandomNumberTest {

    @Test
    @DisplayName("임의의수 3개 생성후 중복검사 - 1000회 반복")
    void createRandom3Number() {
        for (int i = 1; i <= 1000; i++) {
            int random3Number = BaseballRandomNumber.getNumber(3);

            int first = random3Number / 100;
            int second = (random3Number % 100) / 10;
            int third = random3Number % 10;

            System.out.println(i + " : " + random3Number);
            assertNotEquals(random3Number, 0);
            assertNotEquals(first, second);
            assertNotEquals(first, third);
            assertNotEquals(second, third);
        }
    }

    @Test
    @DisplayName("임의의수 4개 생성후 중복검사 - 1000회 반복")
    void createRandom4Number() {
        for (int i = 1; i <= 1000; i++) {
            int random4Number = BaseballRandomNumber.getNumber(4);

            int first = random4Number / 1000;
            int second = (random4Number % 1000) / 100;
            int third = (random4Number % 100) / 10;
            int four = random4Number % 10;

            System.out.println(i + " : " + random4Number);
            assertNotEquals(random4Number, 0);
            assertNotEquals(first, second);
            assertNotEquals(first, third);
            assertNotEquals(first, four);
            assertNotEquals(second, third);
            assertNotEquals(second, four);
            assertNotEquals(third, four);
        }
    }

}