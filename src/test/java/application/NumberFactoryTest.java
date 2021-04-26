package application;

import basball.application.NumberFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class NumberFactoryTest {
    private NumberFactory factory;

    @BeforeEach
    public void setFactory() {
        factory = new NumberFactory();
    }

    @Test
    @DisplayName("사용자가 숫자를 입력하면 List 형태로 반환")
    public void inputTest() {
        List<Integer> testSet = Arrays.asList(2,3,4);

        assertThat(factory.createUserNumber("234")).isEqualTo(testSet);
    }

    @Test
    @DisplayName("컴퓨터는 3개의 숫자를 뽑는다.")
    public void createTest() {
        int size = 3;

        assertThat(factory.createRandomNumber().size()).isEqualTo(size);
    }


    @Test
    @DisplayName("char - int 형변환")
    public void changeTest() {
        try {
            Method method = factory.getClass().getDeclaredMethod("toIntegerList", char.class);
            method.setAccessible(true);
            int ret = (int) method.invoke(factory, '5');
            assertThat(5).isEqualTo(ret);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

