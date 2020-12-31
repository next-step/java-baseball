import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class IDTest {

    @Test
    public void genByRandomTest(){
        ID tid = new ID();
        boolean exist[] = new boolean[10];

        tid.genByRandom();
        for(int i = 0; i < 3; i++){
            assertTrue(!exist[tid.arr[i]]);
            exist[tid.arr[i]] = true;
        }
    }

    @Test
    public void genByTypingTest(){
        ID tid = new ID();
        int testInput = 010;

        tid.genByTyping(testInput);
        int track = 0;
        for(int i = 0; i < 3; i++) {
            track = track * 10 + tid.arr[i];
        }
        assertEquals(testInput, track);
    }
}