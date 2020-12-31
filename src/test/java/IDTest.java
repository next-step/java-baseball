import org.junit.jupiter.api.Test;

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
}