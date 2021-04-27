package process;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {


    @Test
    void 값이_메뉴에_포함되는_값이_아니면_false를_리턴한다() throws Exception {

        // when
        boolean isValid = Validator.isValid(Validator.Type.END_GAME, "3");

        // then
        assertFalse(isValid);

        // when
        boolean isValid2 = Validator.isValid(Validator.Type.END_GAME, "f");

        // then
        assertFalse(isValid2);

        // when
        boolean isValid3 = Validator.isValid(Validator.Type.END_GAME, "Q");

        // then
        assertFalse(isValid3);


    }

    @Test
    void 값이_메뉴에_포함되는_값이면_true를_리턴한다() throws Exception {

        // when
        boolean isValid = Validator.isValid(Validator.Type.END_GAME, "1");

        // then
        assertTrue(isValid);

        // when
        boolean isValid2 = Validator.isValid(Validator.Type.END_GAME, "2");

        // then
        assertTrue(isValid2);
    }

    @Test
    void 입력받은_값이_숫자야구_입력값이_아니면_false를_리턴한다() throws Exception {
        // when
        boolean isValid = Validator.isValid(Validator.Type.INPUT_NUMBER, "012");

        // then
        assertFalse(isValid);

        // when
        isValid = Validator.isValid(Validator.Type.INPUT_NUMBER, "1234");

        // then
        assertFalse(isValid);

        // when
        isValid = Validator.isValid(Validator.Type.INPUT_NUMBER, "990");

        // then
        assertFalse(isValid);

        // when
        isValid = Validator.isValid(Validator.Type.INPUT_NUMBER, "123 ");

        // then
        assertFalse(isValid);

        // when
        isValid = Validator.isValid(Validator.Type.INPUT_NUMBER, " ");

        // then
        assertFalse(isValid);

        // when
        isValid = Validator.isValid(Validator.Type.INPUT_NUMBER, "");

        // then
        assertFalse(isValid);

        // when
        isValid = Validator.isValid(Validator.Type.INPUT_NUMBER, "9 11");

        // then
        assertFalse(isValid);

    }
}