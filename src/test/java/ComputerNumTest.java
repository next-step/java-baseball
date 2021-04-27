import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import java.util.*;

class ComputerNumTest {
    int START = 1;
    int END = 10;

    @Test
    @DisplayName("컴퓨터 수를 설정할 1-9의 숫자 리스트를 확인한다")
    void setDefaultNumCheckTest(){
        ComputerNum computerNum = new ComputerNum();
        List<Integer> defaultNum = computerNum.setDefaultNum();
        for(int i = START; i < END; i++){
            assertThat(defaultNum.contains(i)).isTrue();
        }
    }

    @Test
    @DisplayName("1-9 리스트의 index 범위 내에서 랜덤한 수를 뽑아 리스트의 인덱스가 맞는지 확인한다")
    void pickRandomNumTest(){
        List<Integer> numList = new ArrayList<>();
        for(int i = START; i < END; i++){
            numList.add(i);
        }
        for(int i = 0; i < 100; i++){
            Integer pickRandomNum = ComputerNum.pickRandomNum(numList);
            try {
                numList.get(pickRandomNum);
            } catch (IndexOutOfBoundsException t) {
                fail("Fail picRandomNum");
            }
        }
    }

    @Test
    @DisplayName("1-9 리스트에서 내부 인덱스중 한개를 OutNumInList 메서드로 실행시켰을때 리스트 갯수가 1 감소한다")
    void OutNumInListTest(){
        List<Integer> numList = new ArrayList<>();
        for(int i = START; i < END; i++){
            numList.add(i);
        }
        int randomNum = 8;
        List<Integer> outNumResult = ComputerNum.outNumInList(numList, randomNum);
        assertThat(outNumResult.size()).isEqualTo(8);
    }

}
