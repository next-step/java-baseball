package baseball.generate;

import java.util.Random;

// 100 ~ 999까지의 랜덤한 수를 생성한다.
public class BaseBallNumberGenerator implements BaseBallGenerator {

    @Override
    public int[] generate() {
        Random random = new Random();
        int[] values = new int[3];

        // 000 값을 우선 랜덤 값을 넣는다.
        for(int i=0; i<values.length; i++) {
            values[i] = random.nextInt(10);
        }

        // 1번째 값이 2,3번째 값과 같은지 확인하고 같다면 다른 값이 들어갈때 까지 넣는다.
        while(values[0] == values[1] || values[0] == values[2]) {
            values[0] = random.nextInt(10);
        }

        // 2번째 값이 1,3번째 값과 같은지 확인하고 같다면 다른 값이 들어갈때 까지 넣는다.
        while(values[1] == values[0] || values[1] == values[2]) {
            values[1] = random.nextInt(10);
        }
        return values;
    }
}
