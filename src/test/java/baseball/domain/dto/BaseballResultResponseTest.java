package baseball.domain.dto;

import baseball.domain.PitchingResultStatus;
import baseball.exceptions.InvalidBallNumbersSummeryException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static baseball.domain.PitchingResultStatus.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("BaseballResultResponse 클래스")
class BaseballResultResponseTest {

    @DisplayName("of 메서드는")
    @Nested
    class Describe_of {

        @DisplayName("Map의 모든 Entry의 value 합이 3이면")
        @Nested
        class Context_With_Equals_Three_Sum {
            @DisplayName("정상적으로 응답댁체가 생성된다.")
            @Test
            void it_is_returns_BaseballResultResponse() {
                //given
                Map paramMap = createResultParamMap(1, 1, 1);

                //when
                BaseballResultResponse response = BaseballResultResponse.of(paramMap);

                //then
                assertThat(response.isAllStrike()).isFalse();
                assertThat(response.isNothing()).isFalse();
                assertThat(response.getPitchingResult()).isEqualTo(paramMap);
            }
        }

        @DisplayName("Map의 모든 Entry의 value 합이 3이하면")
        @Nested
        class Context_With_Three_Under_Sum {
            @DisplayName("BallNumbersSizeException 예외가 발생한다.")
            @Test
            void it_is_returns_exception() {
                //given
                Map paramMap = createResultParamMap(1, 0, 0);

                //when, then
                assertThatThrownBy(() -> {
                    BaseballResultResponse response = BaseballResultResponse.of(paramMap);
                }).isInstanceOf(InvalidBallNumbersSummeryException.class);
            }

        }

        @DisplayName("Map의 모든 Entry의 value 합이 3이상이면")
        @Nested
        class Context_With_Three_Over_Sum {

            @DisplayName("BallNumbersSizeException 예외가 발생한다.")
            @Test
            void it_is_returns_exception() {
                //given
                Map paramMap = createResultParamMap(4, 0, 0);

                //when, then
                assertThatThrownBy(() -> {
                    BaseballResultResponse response = BaseballResultResponse.of(paramMap);
                }).isInstanceOf(InvalidBallNumbersSummeryException.class);
            }

        }
    }


    @DisplayName("getAllStrike 메소드는")
    @Nested
    class Describe_getAllStrike {

        @DisplayName("결과가 3스트라이크인 값으로 객체를 생성하면")
        @Nested
        class Context_with_3_Strike {
            @DisplayName("true를 반환한다.")
            @Test
            void it_is_returns_true() {
                //given
                Map paramMap = createResultParamMap(3, 0, 0);

                //when
                BaseballResultResponse response = BaseballResultResponse.of(paramMap);

                //then
                assertThat(response.isAllStrike()).isTrue();
            }
        }

        @DisplayName("결과가 3스트라이크가 아닌 값으로 객체를 생성하면")
        @Nested
        class Context_with_Not_3_Strike {
            @DisplayName("false를 반환한다.")
            @Test
            void it_is_returns_false() {
                //given
                Map paramMap1 = createResultParamMap(0, 0, 3);
                Map paramMap2 = createResultParamMap(0, 3, 0);

                //when
                BaseballResultResponse response1 = BaseballResultResponse.of(paramMap1);
                BaseballResultResponse response2 = BaseballResultResponse.of(paramMap2);

                //then
                assertThat(response1.isAllStrike()).isFalse();
                assertThat(response2.isAllStrike()).isFalse();
            }
        }
    }

    @DisplayName("isNothing 메서드는")
    @Nested
    class Describe_isNothing {

        @DisplayName("결과가 3낫싱인 값으로 객체를 생성하면")
        @Nested
        class Context_with_3_Nothing {
            @DisplayName("true를 반화한다.")
            @Test
            void it_is_returns_true() {
                //given
                Map paramMap = createResultParamMap(0, 0, 3);

                //when
                BaseballResultResponse response = BaseballResultResponse.of(paramMap);

                //then
                assertThat(response.isNothing()).isTrue();
            }
        }

        @DisplayName("결과가 3낫싱이 아닌 값으로 객체를 생성하면")
        @Nested
        class Context_with_Not_3_Nothing {
            @DisplayName("false를 반환한다.")
            @Test
            void it_is_returns_false() {
                //given
                Map paramMap1 = createResultParamMap(1, 0, 2);
                Map paramMap2 = createResultParamMap(0, 3, 0);

                //when
                BaseballResultResponse response1 = BaseballResultResponse.of(paramMap1);
                BaseballResultResponse response2 = BaseballResultResponse.of(paramMap2);

                //then
                assertThat(response1.isNothing()).isFalse();
                assertThat(response2.isNothing()).isFalse();
            }
        }

    }

    private static Map createResultParamMap(int strikeCount, int ballCount, int nothingCount) {
        return new EnumMap<PitchingResultStatus, Integer>(PitchingResultStatus.class) {{
            put(STRIKE, strikeCount);
            put(BALL, ballCount);
            put(NOTHING, nothingCount);
        }};
    }


}
