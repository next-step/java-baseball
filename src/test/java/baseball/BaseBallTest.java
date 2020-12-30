/*
 * BaseBallTest
 *
 * 0.1
 *
 * 2020.12.28
 *
 * 저작권 주의 by huey.j
 */

package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseBallTest {
    int[] com_num = new int[3];
    int[] user_num = new int[3];
    boolean[] used_num = new boolean[10];
    boolean end;

    @Test
    @DisplayName("랜덤으로 만들어지는 수 체")
    public void Test(){
        init();
        assertThat(com_num[0]).isGreaterThan(0).isLessThan(10);
        assertThat(com_num[1]).isGreaterThan(0).isLessThan(10);
        assertThat(com_num[2]).isGreaterThan(0).isLessThan(10);

        assertThat(com_num[0]).isNotEqualTo(com_num[1]).isNotEqualTo(com_num[2]);
        assertThat(com_num[1]).isNotEqualTo(com_num[0]).isNotEqualTo(com_num[2]);
        assertThat(com_num[2]).isNotEqualTo(com_num[0]).isNotEqualTo(com_num[1]);
    }

    private void init() {
        end = false;

        //숫자의 사용여부 저장 배열
        for(int i=0;i<10;i++)
            used_num[i] = false;

        //컴퓨터의 숫자 3개 랜덤으로 생성
        for(int i=0;i<3;i++){
            com_num[i] = random();
            user_num[i] = 0;
        }

    }

    private int random() {
        int num = (int) (Math.random() * 9 + 1);  // 1 ~ 9까지 수를 랜덤으로 생성

        while(used_num[num]){
            num = (int) (Math.random() * 9 + 1);  // 1 ~ 9까지 수를 랜덤으로 생성
        }

        used_num[num] = true;   // num이 사용되었음을 체크

        return num;
    }

}
