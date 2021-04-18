import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class MakeRandomNumberTest {


    @Test
    public void baseballNumberExpect3DigitNumber() throws Exception{
        //given
        int baseballNumber = new MakeRandomNumber().getNewRandomNumber();
        //when

        //then
        org.assertj.core.api.Assertions.assertThat(baseballNumber < 988);
        org.assertj.core.api.Assertions.assertThat(baseballNumber > 122);
    }

    @Test
    public void whenMakeNumberEachPositionExpectDifferent() throws Exception{
        //given
        int baseballNumber = new MakeRandomNumber().getNewRandomNumber();
        int firstDigit = baseballNumber / 100;
        int secondDigit = (baseballNumber - firstDigit *100) /10;
        int thirdDigit = (baseballNumber - (firstDigit *100) - (secondDigit *10));
        //when

        //then
        assertNotEquals(firstDigit,secondDigit);
        assertNotEquals(firstDigit,thirdDigit);
    }

    @Test
    public void whenMakeOtherNumberExpectDifferent () throws Exception{
        //given
        int baseballNumber = new MakeRandomNumber().getNewRandomNumber();

        //when
        int newBaseballNumber = new MakeRandomNumber().getNewRandomNumber();
        //then
        assertNotEquals(baseballNumber,newBaseballNumber);
}

}
