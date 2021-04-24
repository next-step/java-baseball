package me.mkhwang.baseball.domain;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by mkhwang on 2021/04/25
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
class UserTest {
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
        User user = new User();
        user.insertBallNumberForUser();
        assertEquals(expected, user.getBallNumber());
    }
}