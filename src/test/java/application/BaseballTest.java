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


    @Test
    @DisplayName("find Strike 테스트")
    public void findStrikeTest() {
        baseball.questionSet = numberFactory.createUserNumber("123");

        try {
            Method method = baseball.getClass().getDeclaredMethod("findStrike", int.class, int.class);
            method.setAccessible(true);
            int ret = (int) method.invoke(baseball,2,1);
            assertThat(ret).isEqualTo(1);
            ret = (int) method.invoke(baseball,2,0);
            assertThat(ret).isEqualTo(0);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("find Ball 테스트")
    public void findBallTest() {
        baseball.questionSet = numberFactory.createUserNumber("123");

        try {
            Method method = baseball.getClass().getDeclaredMethod("findBall", int.class, int.class);
            method.setAccessible(true);
            int ret = (int) method.invoke(baseball,2,1);
            assertThat(ret).isEqualTo(0);
            ret = (int) method.invoke(baseball,2,0);
            assertThat(ret).isEqualTo(1);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("result msg 테스트")
    public void resultTest() {
        baseball.questionSet = numberFactory.createUserNumber("123");

        try {
            Method method = baseball.getClass().getDeclaredMethod("result", int.class, int.class);
            method.setAccessible(true);
            String ret = (String) method.invoke(baseball,0,0);
            assertThat(ret).isEqualTo("낫싱");
            ret = (String) method.invoke(baseball,2,0);
            assertThat(ret).isEqualTo("2 스트라이크 ");
            ret = (String) method.invoke(baseball,2,1);
            assertThat(ret).isEqualTo("2 스트라이크 1볼");
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
