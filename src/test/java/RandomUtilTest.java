import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RandomUtilTest {
    private RandomUtil randomUtil=new RandomUtil();

    @Test
    void assertGetRandomRange(){
        assertThat(randomUtil.getRandom(1,9)).isLessThan(10);
        assertThat(randomUtil.getRandom(1,9)).isGreaterThan(0);
    }

    @Test
    void assertGetRandomRandomic(){
        try{
            assertThat(randomUtil.getRandom(0,1000000)).isNotEqualTo(randomUtil.getRandom(0,1000000));
        }catch(Exception e){
            assertThat(randomUtil.getRandom(0,1000000)).isNotEqualTo(randomUtil.getRandom(0,1000000));
        }
    }

}