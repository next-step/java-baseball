package exception;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class BaseBallExceptionTest {

    private Set<Integer> numbers;
    private String input;
    @BeforeEach
    public void setUp(){
        input = "123";
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("널값, 또는 빈문자열 체크")
    @Test
    void isEmptyCheck() {
        boolean exceptionCatched = false;
        input = null;
        if(input == null || "".equals(input)){
            exceptionCatched = true;
        }
        assertThat(exceptionCatched).isTrue();
    }

    @DisplayName("중복된 숫자 체크")
    @Test
     void duplicateCheck() {
        numbers = new HashSet<>();
        for(int i = 0; i < input.length(); i++){
            System.out.println(input.charAt(i)-'0');
            numbers.add(input.charAt(i)-'1');
        }
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("숫자 길이 체크")
    @Test
    void lengthCheck(){
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("숫자만으로 이루어져 있는지 체크")
    @Test
    public void numberCheck() {
        boolean exceptionCatched = false;
        try{
            Integer.parseInt(input);
        }catch (NumberFormatException e){
            exceptionCatched = true;
        }
        assertThat(exceptionCatched).isFalse();
    }

}