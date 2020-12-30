import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RandomNumberMakerTest {
    @Test
    public void test(){
        RandomNumberMaker rnm = new RandomNumberMaker();
        assertEquals(rnm.getRandomNumber().length(), RandomNumberMaker.lengthOfNumber);
    }
}