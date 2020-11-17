import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballCompareResultTest {

    @Test
    @DisplayName("BaseballCompareResult 생성자에 볼, 스트라이크 입력받은 갯수에 따라 상태값 세팅 테스트")
    void test1() {
        // 볼=0, 스트라이크=0.. 상태는 NOTHING 이어야 한다
        BaseballCompareResult result1 = new BaseballCompareResult(0, 0);
        BaseballCompareResultStatus status1 = result1.getStatus();
        assertThat(status1).isEqualTo(BaseballCompareResultStatus.NOTHING);

        // 볼=1, 스트라이크=0.. 상태는 EXIST 이어야 한다
        BaseballCompareResult result2 = new BaseballCompareResult(1, 0);
        BaseballCompareResultStatus status2 = result2.getStatus();
        assertThat(status2).isEqualTo(BaseballCompareResultStatus.EXIST);

        // 볼=0, 스트라이크=1.. 상태는 EXIST 이어야 한다
        BaseballCompareResult result3 = new BaseballCompareResult(0, 1);
        BaseballCompareResultStatus status3 = result3.getStatus();
        assertThat(status3).isEqualTo(BaseballCompareResultStatus.EXIST);

        // 볼=1, 스트라이크=1.. 상태는 EXIST 이어야 한다
        BaseballCompareResult result4 = new BaseballCompareResult(1, 1);
        BaseballCompareResultStatus status4 = result4.getStatus();
        assertThat(status4).isEqualTo(BaseballCompareResultStatus.EXIST);

        // 볼=0, 스트라이크=3.. 상태는 MATCHED 이어야 한다
        BaseballCompareResult result5 = new BaseballCompareResult(0, 3);
        BaseballCompareResultStatus status5 = result5.getStatus();
        assertThat(status5).isEqualTo(BaseballCompareResultStatus.MATCHED);

        // 볼, 스트라이크 갯수 합계가 3을 넘어서면 IllegalArgumentException을 발생시켜야 한다
        assertThatThrownBy(() -> {
            BaseballCompareResult result6 = new BaseballCompareResult(3, 1);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 볼, 스트라이크 카운트가 아닙니다.");

        // 볼, 스트라이크 갯수 합계가 3을 넘어서면 IllegalArgumentException을 발생시켜야 한다
        assertThatThrownBy(() -> {
            BaseballCompareResult result7 = new BaseballCompareResult(1, 3);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 볼, 스트라이크 카운트가 아닙니다.");

    }

}