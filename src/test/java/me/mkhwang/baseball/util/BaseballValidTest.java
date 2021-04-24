package me.mkhwang.baseball.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by mkhwang on 2021/04/25
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
class BaseballValidTest {

    @Test
    void isBaseballValidLength_true_test(){
        boolean isBaseballValidLength = BaseballValid.isBaseballValidLength("123");
        assertEquals(true, isBaseballValidLength);
    }

    @Test
    void isBaseballValidLength_false_test(){
        boolean isBaseballValidLength = BaseballValid.isBaseballValidLength("1234");
        assertEquals(false, isBaseballValidLength);
    }

    @Test
    void isBaseballValidDuplicate_true_test(){
        boolean isBaseballValidDuplicate = BaseballValid.isBaseballValidDuplicate("123");
        assertEquals(true, isBaseballValidDuplicate);
    }

    @Test
    void isBaseballValidDuplicate_false_test(){
        boolean isBaseballValidDuplicate = BaseballValid.isBaseballValidDuplicate("133");
        assertEquals(false, isBaseballValidDuplicate);
    }
}