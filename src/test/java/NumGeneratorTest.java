import generator.NumGenerator;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;



public class NumGeneratorTest {
    @Test
    public void generatorTest(){
        String generateNumber = NumGenerator.numGenerator();
        System.out.println("generateNumber : " + generateNumber);
        assertThat(checkValid(generateNumber)).isTrue();
        assertThat(generateNumber.length()).isEqualTo(3);

    }

    public boolean checkValid(String input){
        if(!input.matches("[1-9]{3}"))
            return false;
        Set<Integer> chkNum = new HashSet<Integer>();
        for(char c : input.toCharArray()){
            int a = c - '0';
            chkNum.add(a);
        }

        return chkNum.size() == 3 ? true : false;
    }
}
