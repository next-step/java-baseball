package com.dnswkdl.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

public class GamePlayServiceTest {
    private static ImplGamePlayService implGamePlayService;

    @BeforeAll
    public static void init(){
        implGamePlayService = (compare, input)->{return (compare==input?1:0);};
    }

    @ParameterizedTest
    @CsvSource(value = {"123:123:3:0", "123:132:1:2" , "123:452:0:1", "123:456:0:0"}, delimiter = ':')
    @DisplayName("Check Strike and Ball TEST")
    public void testCheck1(int answer, int input, int strike, int ball){
        int[] result = check(answer, input);

        assertThat(result[0]).isEqualTo(strike);
        assertThat(result[1]).isEqualTo(ball);
    }
    @ParameterizedTest
    @CsvSource(value = {"123:123:3:0", "123:132:1:2" , "123:452:0:1", "123:456:0:0"}, delimiter = ':')
    @DisplayName("Check Strike and Ball TEST")
    public void testCheck2(int answer, int input, int strike, int ball){
        int[] result = check(toList(answer), toList(input));

        assertThat(result[0]).isEqualTo(strike);
        assertThat(result[1]).isEqualTo(ball);
    }

    @Test
    @DisplayName("100~1000 사이 중복 없는 3자리 수 / indent 2")
    public void makeAnswer1(){
        int answer;
        while(true){
            answer = (int)(Math.random()*900+100);

            int first = answer/100;
            int second = (answer - first*100)/10;
            int third = (answer - first*100)%10;

            if(first==second || second==third || third==first){
                continue;
            }
            break;
        }

        int[] test = toArray(answer);
        assertThat(test[0]).isNotEqualTo(test[1]);
        assertThat(test[1]).isNotEqualTo(test[2]);
        assertThat(test[2]).isNotEqualTo(test[0]);
    }

    @Test
    @DisplayName("Collection shuffle 1,2,3,4,5,6,7,8,9 중 3개 선택")
    public void makeAnswer2(){
        List<Integer> resource = new ArrayList<>();
        for (int i = 1; i < 10; i++){
            resource.add(i);
        }
        Collections.shuffle(resource);

        List<Integer> answer = resource.subList(0,3);

        assertThat(answer.get(0)).isNotEqualTo(answer.get(1));
        assertThat(answer.get(1)).isNotEqualTo(answer.get(2));
        assertThat(answer.get(2)).isNotEqualTo(answer.get(0));
    }


    @Test
    public void formatTest(){
        int number = 12;
        assertThat(toList(number).get(0)).isEqualTo(0);

        number = 1234;
        assertThat(toList(number).get(0)).isGreaterThanOrEqualTo(10);

        number = 112;
        assertThat(toList(number).get(0)).isEqualTo(toList(number).get(1));

        number = 122;
        assertThat(toList(number).get(1)).isEqualTo(toList(number).get(2));

        number = 121;
        assertThat(toList(number).get(2)).isEqualTo(toList(number).get(0));

    }

    private int[] check(int answer, int input){

        /* result[0] = strike, result[1] = ball */
        int[] result = {0,0};

        int[] ansArray = toArray(answer);
        int[] inpArray = toArray(input);
        for(int i = 0 ; i < ansArray.length; i++){
            result[0] += implGamePlayService.compareTo(ansArray[i], inpArray[i%3]);
            result[1] += implGamePlayService.compareTo(ansArray[i], inpArray[(i+1)%3]);
            result[1] += implGamePlayService.compareTo(ansArray[i], inpArray[(i+2)%3]);
        }
        return result;
    }

    private int[] check(List<Integer> answer, List<Integer> input){

        /* result[0] = strike, result[1] = ball */
        int[] result = {0,0};

        for(int i = 0 ; i < answer.size(); i++){
            result[0] += implGamePlayService.compareTo(answer.get(i), input.get(i%3));
            result[1] += implGamePlayService.compareTo(answer.get(i), input.get((i+1)%3));
            result[1] += implGamePlayService.compareTo(answer.get(i), input.get((i+2)%3));
        }
        return result;
    }
    private List<Integer> toList(int number){
        List<Integer> result = new ArrayList<>();
        int first = number/100;
        int second = (number - first*100)/10;
        int third = (number - first*100)%10;
        result.add(first);
        result.add(second);
        result.add(third);
        return result;
    }
    private int[] toArray(int number){
        int[] result = {0,0,0};

        int first = number/100;
        int second = (number - first*100)/10;
        int third = (number - first*100)%10;
        result[0] = first;
        result[1] = second;
        result[2] = third;

        return result;
    }

}
