import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RandomBoxTest {
    private List<Integer> randomBox;
    private List<Integer> player2NumberBox;

    @Test
    @DisplayName("켄트백 형님의 말씀대로 nothing 부터..")
    public void nothing(){

    }

    @BeforeEach
    public void setRandomBox(){
        randomBox = new ArrayList<>();
        for(int i=1;i<10;i++){
            randomBox.add(i);
        }
    }

    @BeforeEach
    public void setPlayer2Number(){
        player2NumberBox = new ArrayList<>();
    }

    @Test
    @DisplayName("랜덤박스 사이즈 테스트")
    public void randomBoxSizeTest(){
        assertThat(randomBox.size()).isEqualTo(9);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6,7,8,9})
    @DisplayName("랜덤박스에 1~9까지 잘 들어있나?")
    public void randomBoxTest(int number){
         assertThat(randomBox.contains(number)).isTrue();
    }

    @Test
    @DisplayName("상자에서 숫자를 하나 뽑는다")
    public void findOneNumberBox(){
        int number = randomBox.get(0);
        assertThat(number).isNotZero();
        assertThat(number).isPositive();
        assertThat(number).isInstanceOf(Integer.class);
    }

    @Test
    @DisplayName("remove를 이용해 List의 숫자를 뽑으면서 전체 숫자를 줄이면 사이즈 관리가 편할듯")
    public void removeOneNumberBox(){
        int number = randomBox.remove(0);
        assertThat(number).isNotZero();
        assertThat(number).isPositive();
        assertThat(number).isInstanceOf(Integer.class);
        assertThat(randomBox.size()).isEqualTo(8);
    }

    @Test
    @DisplayName("player2(컴퓨터)에 숫자를 넣는다")
    public void createPlayer2NumberByRandom(){
        for(int i=0;i<3;i++){
            double randomValue = Math.random();
            int e = (int)(randomValue * randomBox.size()-1);
            player2NumberBox.add(randomBox.remove(e));
        }

        assertThat(randomBox.size()).isEqualTo(6);
        assertThat(player2NumberBox.size()).isEqualTo(3);

        assertThat(player2NumberBox.get(0)).isInstanceOf(Integer.class);
        assertThat(player2NumberBox.get(0)).isNotZero();

        assertThat(player2NumberBox.get(1)).isInstanceOf(Integer.class);
        assertThat(player2NumberBox.get(1)).isNotZero();

        assertThat(player2NumberBox.get(2)).isInstanceOf(Integer.class);
        assertThat(player2NumberBox.get(2)).isNotZero();

        String player2Number = String.valueOf(player2NumberBox.get(0))
                + player2NumberBox.get(1)
                + player2NumberBox.get(2);
        assertThat(player2Number).isInstanceOf(String.class);
    }
}
