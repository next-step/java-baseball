import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class BaseballTest {
    @Test
    public void isCorrectAnswerTest() {
        Baseball baseball = new Baseball();
        assertThat(baseball.isCorrectAnswer(new ArrayList<>(Arrays.asList(1,2,3)),
                new ArrayList<>(Arrays.asList(1,2,3)))).isTrue();
        assertThat(baseball.isCorrectAnswer(new ArrayList<>(Arrays.asList(1,2,3)),
                new ArrayList<>(Arrays.asList(4,2,3)))).isFalse();
    }

    @Test
    public void getRandomIndexTest() {
        Baseball baseball = new Baseball();
        Set<Integer> set = new HashSet<>(Arrays.asList(0,1,2,3,4,5,6,7,8));
        assertThat(set).contains(baseball.getRandomIndex(new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9))));
    }

    @Test
    public void getComputerNumberTest() {
        Baseball baseball = new Baseball();
        Set<Integer> set = new HashSet<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        assertThat(set).containsAll(baseball.getComputerNumber());
    }

    @Test
    public void getPlayerNumberListTest() {
        Baseball baseball = new Baseball();
        assertThat(baseball.getPlayerNumberList(123)).isEqualTo(new ArrayList<>(Arrays.asList(1,2,3)));
        assertThat(baseball.getPlayerNumberList(456)).isEqualTo(new ArrayList<>(Arrays.asList(4,5,6)));
        assertThat(baseball.getPlayerNumberList(789)).isEqualTo(new ArrayList<>(Arrays.asList(7,8,9)));
    }

    @Test
    public void getBaseballResultIndexTest() {
        Baseball baseball = new Baseball();
        assertThat(baseball.getBaseballResultIndex(1,0, new ArrayList<>(Arrays.asList(1,2,3)))).isEqualTo(0);
        assertThat(baseball.getBaseballResultIndex(2,0, new ArrayList<>(Arrays.asList(1,2,3)))).isEqualTo(1);
        assertThat(baseball.getBaseballResultIndex(4,0, new ArrayList<>(Arrays.asList(1,2,3)))).isEqualTo(2);
    }

    @Test
    public void getResultTest() {
        Baseball baseball = new Baseball();
        assertThat(baseball.getResult(new ArrayList<>(Arrays.asList(1,2,3)),new ArrayList<>(Arrays.asList(1,2,3))))
                .isEqualTo(new int[] {3,0,0});
        assertThat(baseball.getResult(new ArrayList<>(Arrays.asList(4,2,3)),new ArrayList<>(Arrays.asList(1,2,3))))
                .isEqualTo(new int[] {2,0,1});
        assertThat(baseball.getResult(new ArrayList<>(Arrays.asList(4,3,2)),new ArrayList<>(Arrays.asList(1,2,3))))
                .isEqualTo(new int[] {0,2,1});
    }
}
