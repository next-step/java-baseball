import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BaseballGameTest {
    private List<Integer> randomBox;
    private List<Integer> player2Number;

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
        player2Number = new ArrayList<>();
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
    public void addPlayer2Number(){
        for(int i=0;i<3;i++){
            player2Number.add(randomBox.remove(0));
        }

        assertThat(randomBox.size()).isEqualTo(6);

        assertThat(player2Number.get(0)).isInstanceOf(Integer.class);
        assertThat(player2Number.get(0)).isNotZero();
        assertThat(player2Number.get(0)).isEqualTo(1);

        assertThat(player2Number.get(1)).isInstanceOf(Integer.class);
        assertThat(player2Number.get(1)).isNotZero();
        assertThat(player2Number.get(1)).isEqualTo(2);

        assertThat(player2Number.get(2)).isInstanceOf(Integer.class);
        assertThat(player2Number.get(2)).isNotZero();
        assertThat(player2Number.get(2)).isEqualTo(3);
    }
}
