package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BaseballStatusTest {

    @DisplayName("BaseballStatus 출력 테스트")
    @Test
    void 출력_테스트(){
        BaseballStatus baseballStatus;
        baseballStatus = new BaseballStatus(1, 1);
        assertThat(baseballStatus.toString()).isEqualTo("1볼1스트라이크");

        baseballStatus = new BaseballStatus(2, 0);
        assertThat(baseballStatus.toString()).isEqualTo("2스트라이크");

        baseballStatus = new BaseballStatus(0, 2);
        assertThat(baseballStatus.toString()).isEqualTo("2볼");

        baseballStatus = new BaseballStatus(0, 0);
        assertThat(baseballStatus.toString()).isEqualTo("낫싱");
    }
}