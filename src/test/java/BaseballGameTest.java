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
    @DisplayName("컴퓨터가 숫자를 하나 뽑는다")
    public void findOneNumberBox(){
        assertThat(randomBox.get(0)).isGreaterThan(0);
    }
}
