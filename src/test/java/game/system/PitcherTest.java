package game.system;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PitcherTest {

    @Test
    public void allDifferentDigits_Then_ValidDigits(){
        Pitcher pitcher = new Pitcher();
        int[] digits = pitcher.generateDigits();
        assertEquals(true, findDuplicatedDigit(digits));
    }

    private boolean findDuplicatedDigit(int[] digits) {
        Set<Integer> digitSet = new HashSet<>();
        for (int i : digits) {
            if (digitSet.contains(i)) {
                return false;
            }
            digitSet.add(i);
        }
        return true;
    }


}