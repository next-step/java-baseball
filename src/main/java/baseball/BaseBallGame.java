package baseball;

import java.util.Random;

public class BaseBallGame {
    public static void main(String[] args) {
        int i[] = createComNum();

        System.out.println("x");
    }

    // 컴퓨터의 수를 생성한다.
    public static int[] createComNum(){
        int comNum[] = new int[3];
        Random ran = new Random();
        
        for (int i=0; i < comNum.length; i++){

            comNum[i] = ran.nextInt(10);

			for (int j = 0; j < i; j++) {
				if (comNum[j] == comNum[i]) {
					i--;
					break;
                }
            }
        }

        return comNum;
    }
}
