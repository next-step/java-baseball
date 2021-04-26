package me.mkhwang.baseball.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by mkhwang on 2021/04/25
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
class BaseballValidTest {

    private BaseballValid baseballValid;

    public BaseballValidTest() {
        baseballValid = new BaseballValid();
    }

    @Test
    void isBaseballValidLength_true_test(){
        boolean isBaseballValidLength = baseballValid.isBaseballLengthValid("123");
        assertEquals(true, isBaseballValidLength);
    }

    @Test
    void isBaseballValidLength_false_test(){
        boolean isBaseballValidLength = baseballValid.isBaseballLengthValid("1234");
        assertEquals(false, isBaseballValidLength);
    }

    @Test
    void isBaseballValidDuplicate_true_test(){
        boolean isBaseballValidDuplicate = baseballValid.isBaseballDuplicateValid("123");
        assertEquals(true, isBaseballValidDuplicate);
    }

    @Test
    void isBaseballValidDuplicate_false_test(){
        boolean isBaseballValidDuplicate = baseballValid.isBaseballDuplicateValid("133");
        assertEquals(false, isBaseballValidDuplicate);
    }

    @Test
    void isBaseballTextValid_test() {
        boolean invalidText = baseballValid.isBaseballTextValid("asdf");
        assertEquals(false, invalidText);
    }

    @Test
    void isBaseballTextValid_true_test() {
        boolean validText = baseballValid.isBaseballTextValid("123");
        assertEquals(true, validText);
    }
}