package baseball.player;

import baseball.BaseballUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    private User user;
    private BaseballUtil baseballUtil;

    @BeforeEach
    void init() {
        user = new User();
        baseballUtil = new BaseballUtil();
    }

    @DisplayName("사용자로부터 입력받은 문자열 범위 유효성 검사")
    @Test
    void 문자열_범위_유효성검사() {

        //given
        String[] rightInput = {"129","325","312","864","158"};
        String[] wrongInput = {"120","320","012","045","089"};
        int isByNumber = 9;
        int rightCnt = 0;
        int wrongCnt = 0;

        //when
        for (int i = 0; i < rightInput.length; i++) {
            if (baseballUtil.isDigit(rightInput[i], isByNumber)) {
                rightCnt++;
            }
        }
        for (int i = 0; i < wrongInput.length; i++) {
            if (!baseballUtil.isDigit(wrongInput[i], isByNumber)) {
                wrongCnt++;
            }
        }

        //then
        assertThat(rightCnt).isEqualTo(5);
        assertThat(wrongCnt).isEqualTo(5);
    }

    @DisplayName("사용자로부터 입력받은 문자열 길이 및 중복 유효성 검사")
    @Test
    void 문자열_길이_및_중복_유효성검사() {

        //given
        String[] rightInput = {"129","325","312","864","158"};
        String[] wrongInput = {"1235","333","6453537","12","336677"};
        int ballCount = 3;
        int rightCnt = 0;
        int wrongCnt = 0;

        //when
        for (int i = 0; i < rightInput.length; i++) {
            if (user.ballValidationCheck(rightInput[i], ballCount)) {
                rightCnt++;
            }
        }
        for (int i = 0; i < wrongInput.length; i++) {
            if (!user.ballValidationCheck(wrongInput[i], ballCount)) {
                wrongCnt++;
            }
        }

        //then
        assertThat(rightCnt).isEqualTo(5);
        assertThat(wrongCnt).isEqualTo(5);
    }

}