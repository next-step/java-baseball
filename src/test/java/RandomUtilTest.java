import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

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

    @Test
    void assertValidateDuplicatedNumList(){
        List<Integer> duplicatedList= Lists.newArrayList(0,1,2,3,3,4,5,5);
        assertThat(randomUtil.IsDuplicatedNumList(duplicatedList)).isTrue();

        List<Integer> notDuplicatedList=Lists.newArrayList(0,1,2,3,4,5,6);
        assertThat(randomUtil.IsDuplicatedNumList(notDuplicatedList)).isFalse();
    }

}