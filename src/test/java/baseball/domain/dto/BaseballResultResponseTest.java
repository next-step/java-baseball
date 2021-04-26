package baseball.domain.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("BaseballResultResponse 클래스")
class BaseballResultResponseTest {

    @DisplayName("getAllStrike 메소드는")
    @Nested
    class Describe_getAllStrike {

        @DisplayName("결과가 3스트라이크인 값으로 객체를 생성하면")
        @Nested
        class Context_with_3_Strike {
            @DisplayName("true를 반환한다. ")
            @Test
            void it_is_returns_true() {

            }
        }
        @DisplayName("결과가 3스트라이크가 아닌 값으로 객체를 생성하면")
        @Nested
        class Context_with_Not_3_Strike {
            @DisplayName("false를 반환한다.")
            @Test
            void it_is_returns_false() {

            }
        }
    }

    @DisplayName("isNothing 메서드는")
    @Nested
    class Describe_isNothing{

        @DisplayName("결과가 3낫싱인 값으로 객체를 생성하면")
        @Nested
        class Context_with_3_Nothing {
            @DisplayName("true를 반화한다.")
            @Test
            void it_is_returns_true() {

            }
        }
        @DisplayName("결과가 3낫싱이 아닌 값으로 객체를 생성하면")
        @Nested
        class Context_with_Not_3_Nothing {
            @DisplayName("false를 반환한다.")
            @Test
            void it_is_returns_false() {

            }
        }

    }




}
