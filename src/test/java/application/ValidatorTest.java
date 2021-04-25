package application;

import basball.application.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ValidatorTest {

    Validator validator;

    @BeforeEach
    public void setValidator() {
        validator = new Validator();
    }

    @Test
    @DisplayName("1,2 입력 테스트")
    public void checkContinueTest() {
        try {
            Method method = validator.getClass().getDeclaredMethod("checkContinue", int.class);
            method.setAccessible(true);
            boolean ret = (boolean) method.invoke(validator, 1);
            assertThat(ret).isTrue();
            ret = (boolean) method.invoke(validator, 2);
            assertThat(ret).isTrue();
            ret = (boolean) method.invoke(validator, 3);
            assertThat(ret).isFalse();
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
