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

    @Test
    public void compareIDTest_senario_same(){
        ID computerID = new ID();
        ID userID = new ID();

        computerID.genByRandom();
        userID.genByTyping(arr2int(computerID.arr));

        assertEquals("same", computerID.compare(userID));
    }

    @Test
    public void compareIDTest_senario_3ball(){
        ID computerID = new ID();
        ID userID = new ID();

        computerID.genByTyping(123);
        userID.genByTyping(231);

        assertEquals("3볼", computerID.compare(userID));
    }

    @Test
    public void compareIDTest_senario_2strike_0ball(){
        ID computerID = new ID();
        ID userID = new ID();

        computerID.genByTyping(123);
        userID.genByTyping(923);

        assertEquals("2스트라이크 ", computerID.compare(userID));
    }

    @Test
    public void compareIDTest_senario_1strike_2ball(){
        ID computerID = new ID();
        ID userID = new ID();

        computerID.genByTyping(920);
        userID.genByTyping(290);

        assertEquals("1스트라이크 2볼", computerID.compare(userID));
    }

    @Test
    public void compareIDTest_senario_1strike_1ball(){
        ID computerID = new ID();
        ID userID = new ID();

        computerID.genByTyping(920);
        userID.genByTyping(912);

        assertEquals("1스트라이크 1볼", computerID.compare(userID));
    }

    private int arr2int(int[] arr){
        int retVal = 0;
        for(int i = 0; i < 3; i++){
            retVal = retVal * 10 + arr[i];
        }
        return retVal;
    }
}