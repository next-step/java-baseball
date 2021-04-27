import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseBallGameTest {
    @Test
    @DisplayName("입력값 배열로 만들기")
    void createIntArray() {
        assertThatThrownBy(() -> {
            String input = "1234";
            int[] result = new int[3];

            for (int i = 0; i < input.length(); i++) {
                result[i] = Integer.parseInt(String.valueOf(input.charAt(i)));
            }
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Index 3 out of bounds for length 3");
    }

    @Test
    @DisplayName("정답 만들기")
    void createAnswer() {
        ArrayList<Integer> temp_array = new ArrayList<Integer>(){
            {
                add(1);
                add(2);
                add(3);
                add(4);
                add(5);
                add(6);
                add(7);
                add(8);
                add(9);
            }
        };
        int max_idx = temp_array.size();

        int[] answer = new int[3];
        for (int i = 0; i < 3; i++) {
            double random = Math.random();
            int remove_idx = (int)(random * max_idx);
            answer[i] = temp_array.get(remove_idx);
            temp_array.remove(remove_idx);
            max_idx--;
        }
        assertThat(answer).doesNotContain(0)
                .containsOnlyOnce(answer)
                .hasSize(3);
    }

    @Test
    @DisplayName("스트라이크 볼 체크하기")
    void checkNumber() {
        int number = 3;
        int index = 3;
        int[] answer = {3,4,5};

        int strike = 0;
        int ball = 0;

        for (int i = 0; i < answer.length; i++) {
            int answer_number = answer[i];
            if (number == answer_number && index == i) {
                strike++;
            }

            if (number == answer_number && index != i) {
                ball++;
            }
        }

        assertThat(ball).isEqualTo(1);
        assertThat(strike).isEqualTo(0);
    }
}