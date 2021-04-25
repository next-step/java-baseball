import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

class ComputerNumTest {
    @Test
    @DisplayName("컴퓨터 수를 설정할 1-9의 숫자 리스트를 확인한다")
    void setDefaultNumCheckTest(){
        int START = 1;
        int END = 10;
        ComputerNum computerNum = new ComputerNum();
        List<Integer> defaultNum = computerNum.setDefaultNum();
        for(int i = START; i < END; i++){
            assertThat(defaultNum.contains(i)).isTrue();
        }
    }
}
