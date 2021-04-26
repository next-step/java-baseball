package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameTest {

    @DisplayName("게임 종료 후 다시시작 or 완전종료 기능 ")
    @Test
    public void 게임종료_후_다시시작_왼전종료_기능(){

        // ui 영역은 진행하지 않는다.

    }

    @DisplayName("입력이 null 인지 - 실패 케이스")
    @Test
    public void 입력값이Null확인_기능(){

        String input = null;
        assertTrue(input != null, "입력이 null 이다");

    }

    @DisplayName("입력이 null 인지 - 성공 케이스")
    @Test
    public void 입력값이Null확인_기능_성공(){

        String input = "TES";
        assertTrue(input != null, "입력이 null 이다");

    }

    @DisplayName("입력값의 문자열 길이 - 실패 케이스")
    @Test
    public void 입력값의길이확인_기능(){

        String input = "TEST";
        assertTrue(input.length() == 3, "입력값의 길이가 안맞다.");

    }

    @DisplayName("입력값의 문자열 길이 - 성공 케이스")
    @Test
    public void 입력값의길이확인_기능_성공(){

        String input = "TES";
        assertTrue(input.length() == 3, "입력값의 길이가 안맞다.");

    }

    @DisplayName("문자열이 1~9 까지로 이루어져 있는지 - 성공 케이스")
    @ParameterizedTest
    @ValueSource(ints = {1,2,9})
    public void 문자열의구성확인_기능_성공(int input){

        assertTrue(getCheckInt(input), "1~9 에 속하지 않는다. : {} " + input );

    }

    @DisplayName("문자열이 1~9 까지로 이루어져 있는지 - 실패 케이스")
    @ParameterizedTest
    @ValueSource(ints = {1,2,10})
    public void 문자열의구성확인_기능(int input){

        assertTrue(getCheckInt(input), "1~9 에 속하지 않는다. : {} " + input );

    }

    @DisplayName("문자열이 서로 다른 숫자로 이루어져 있는지 - 성공 케이스")
    @Test
    public void 문자열_서로다른숫자확인_기능_성공(){

        String input = "123";

        assertTrue(getCheckDiffInt(input), "서로 다른 숫자가 아니다. : {} " + input );

    }

    @DisplayName("문자열이 서로 다른 숫자로 이루어져 있는지 - 실패 케이스")
    @Test
    public void 문자열_서로다른숫자확인_기능(){

        String input = "122";

        assertTrue(getCheckDiffInt(input), "서로 다른 숫자가 아니다. : {} " + input );

    }

    /*
        정수의 크기가 알맞는지 (1 ~ 9)
     */
    private boolean getCheckInt(int input){
        return (input > 0 && input < 10) ? true : false;
    }

    /*
        서로 다른 숫자인지 확인.
     */
    private boolean getCheckDiffInt(String str){
        char[] chars = str.toCharArray();
        Set<Character> set = new HashSet<>();

        for(int i = 0; i < chars.length; i++){
            set.add(chars[i]);
        }

        if(set.size() != chars.length)
            return false;

        return true;
    }

}
