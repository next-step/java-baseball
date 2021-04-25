package com.dnswkdl.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;

public class GamePlayServiceTest {

    @Test
    @DisplayName("3 Strike TEST")
    public void test1(){
        int answer = 123;
        int input = 123;
        int[] result = check(answer, input);
        assertThat(result[0]).isEqualTo(3);
    }
    @Test
    @DisplayName("1 Strike 2 Ball TEST")
    public void test2(){
        int answer = 123;
        int input = 132;
        int[] result = check(answer, input);
        assertThat(result[0]).isEqualTo(1);
        assertThat(result[1]).isEqualTo(2);
    }
    @Test
    @DisplayName("1 Ball TEST")
    public void test3(){
        int answer = 123;
        int input = 452;
        int[] result = check(answer, input);
        assertThat(result[0]).isEqualTo(0);
        assertThat(result[1]).isEqualTo(1);
    }
    private int[] check(int answer, int input){

        /** result[0] = strike, result[1] = ball */
        int[] result = {0,0};

        int[] ansArray = toArray(answer);
        int[] inpArray = toArray(input);
        for(int i = 0 ; i < ansArray.length; i++){
            if(ansArray[i]==inpArray[i%3]){
                result[0]++;
            }
            if(ansArray[i]==inpArray[(i+1)%3]){
                result[1]++;
            }
            if(ansArray[i]==inpArray[(i+2)%3]){
                result[1]++;
            }
        }
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
