import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

class ComputerNumTest {
    Integer startNum = 1;
    Integer endNum = 10;
    @Test
    @DisplayName("컴퓨터 수를 설정할 1-9의 숫자 리스트를 확인한다")
    void setDefaultNumCheckTest(){
        ComputerNum computerNum = new ComputerNum();
        List<Integer> defaultNum = computerNum.setDefaultNum();
        for(Integer i = startNum; i < endNum; i++){
            assertThat(defaultNum.contains(i)).isTrue();
        }
    }
}
