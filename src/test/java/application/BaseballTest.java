package application;

import basball.application.Baseball;
import basball.application.NumberFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BaseballTest {
    private Baseball baseball;
    private NumberFactory numberFactory;

    @BeforeEach
    public void setBaseball() {
        baseball = new Baseball();
        numberFactory = new NumberFactory();
    }

    @Test
    @DisplayName("매칭 테스트")
    public void matchingTest() {
        List<Integer> list = Arrays.asList(1,2,3);
        baseball.questionSet = numberFactory.createUserNumber("123");

        try {
            Method method = baseball.getClass().getDeclaredMethod("matching", List.class);
            method.setAccessible(true);
            boolean ret = (boolean) method.invoke(baseball, list);
            assertThat(ret).isTrue();
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
