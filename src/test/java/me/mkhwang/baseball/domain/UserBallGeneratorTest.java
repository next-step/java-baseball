package me.mkhwang.baseball.domain;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by mkhwang on 2021/04/25
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
class UserBallGeneratorTest {
    ByteArrayInputStream bindData;

    //Scanner를 테스트 하기위한 method
    private void provideInput(String data) {
        bindData = new ByteArrayInputStream(data.getBytes(StandardCharsets.UTF_8));
        System.setIn(bindData);
    }

    @Test
    void user_insert_text_test(){
        String expected = "1234";
        provideInput(expected);
        UserBallGenerator user = new UserBallGenerator();
        user.insertBallNumberForUser();
        assertEquals(expected, user.getBallNumber());
    }

    @Test
    void isValid_test() {
        String ballNumber = "122";
        provideInput(ballNumber);
        UserBallGenerator user = new UserBallGenerator();
        boolean valid = user.isValid(ballNumber);
        assertEquals(false, valid);
    }
}