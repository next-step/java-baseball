package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.*;

import static org.assertj.core.api.Assertions.*;


/**
 *  1.1부터 9까지 서로 다른 수로 이루어진 3자리의 수 입력 받기(사용자, 컴퓨터)
 *      1-1.컴퓨터, 입력 숫자 배열로 만들기
 *      1-2.사용자 입력 숫자 배열 만들기
 *          -3자리 정수
 *          -중복 허용 X
 *          -0 제외
 *
 *
 *  2.컴퓨터 데이터와 사용자 데이터 비교
 *      2-1.같은 수가 같은 자리  = 스트라이크
 *      2-2.다른 자리에 수가 있으면    = 볼
 *      2-3.같은 수가 없으면 = 낫씽
 *
 *  3.상대방 점수 맞추면 승리
 *
 */
public class PlayBaseballTest {


    Integer[] computerPlayer;

    /**
     * 1-1.컴퓨터, 입력 숫자 배열로 만들기
     */
    @BeforeEach
    void setComputerPlayerNumbers() {
        Random randNum = new Random();
        Set<Integer> randomNumbers = new LinkedHashSet<Integer>();
//        randomNumbers.add(1);
//        randomNumbers.add(2);
//        randomNumbers.add(3);

        while (randomNumbers.size() < 3) {
            randomNumbers.add(randNum.nextInt(9)+1);
        }

        this.computerPlayer = randomNumbers.toArray(new Integer[randomNumbers.size()]);
    }

    @Test
    @DisplayName("0 값이 포함되었는지 확인")
    void vaildationSetRandomNum(){
        int i = 0;
        while (i < 100){
            //given
            setComputerPlayerNumbers();
            System.out.println(Arrays.toString(computerPlayer));

            //when
            boolean flag = Arrays.toString(computerPlayer).contains("0");

            //then
            assertThat(flag).isFalse();

            i++;
        }
    }

    /**
     *
     *  2.컴퓨터 데이터와 사용자 데이터 비교
     *      2-1.같은 수가 같은 자리  = 스트라이크
     *      2-2.다른 자리에 수가 있으면    = 볼
     *      2-3.같은 수가 없으면 = 낫씽
     *
     */
   @Test
   @DisplayName("스트라이크, 볼 수 구하기")
   void checkScore(){
        int strike = 0;
        int ball = 0;
        //given
        int[] computerPlayer = {3,2,6};
        int[] inputPlayer = {1,2,6};
//       System.out.println(Arrays.toString(inputPlayer));
//       System.out.println(Arrays.toString(computerPlayer));

       //when
       for (int i = 0; i < inputPlayer.length; i++) {
           for (int j = 0; j < computerPlayer.length; j++) {
               if (inputPlayer[i] == computerPlayer[j] && i == j) {
                   strike++;
               }
               if (inputPlayer[i] == computerPlayer[j] && i != j) {
                   ball++;
               }
           }
       }
//       System.out.println("스트라이크 = "+strike);
//       System.out.println("볼 = " + ball);

       //then
       assertThat(strike).isEqualTo(2);
       assertThat(ball).isEqualTo(0);

    }

}

