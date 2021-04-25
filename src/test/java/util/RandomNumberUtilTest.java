package util;

import domain.BaseBallNumberInfo;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RandomNumberUtilTest {

    @Test
    public void duplicateTest(){
        BaseBallNumberInfo baseBallNumberInfo = RandomNumberUtil.makeRandomBaseBallInfo();

        Set<Integer> checkHashSet = new HashSet<>();

        for(int pos = 0; pos < baseBallNumberInfo.getBaseBallRandomNumberList().size(); pos++){
            checkHashSet.add(baseBallNumberInfo.getBaseBallPositionNumber(pos));
        }

        assertEquals(3, checkHashSet.size());

    }

}