import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;

public class RandomNumGeneratorTest {

    private RandomNumGenerator generator;

    @Before
    public void setUp(){
        generator = new RandomNumGenerator(BaseballGame.DEFAULT_LEN);
    }


    // 1.랜덤숫자생성기가 생성한 문자열은 null일 수 없다.
    //유효성 검사 1. 널이 아닌가?
    @Test
    public void isStringIsValidatedIsNotNullWhichIsGeneratedByRandomNumGenerator(){
        String balls = generator.generateRandomNum();
        assertEquals(balls != null, true);
    }

    // 2.랜덤숫자생성기가 생성한 문자열의 길이는 게임에서 정한 주어진 길이이다.
    //유효성 검사 2. 게임에서 지정한 길이인가?
    @Test
    public void isStringIsValidatedIsLengthEqualsBaseballGamesMaxLenWhichIsGeneratedByRandomNumGenerator(){
        String balls = generator.generateRandomNum();
        assertEquals(balls.length(), BaseballGame.DEFAULT_LEN);
    }

    // 3.랜덤숫자생성기가 생성한 문자열은 모두 1~9까지 숫자로 이루어져 있다.
    //유효성 검사 3. 문자열이 1~9까지의 숫자들로 이루어져 있는가
    @Test
    public void isStringValidatedAllLettersComposedNumber1To9(){
        String balls = generator.generateRandomNum();
        for (int i=0; i<balls.length(); i++){
            int c = balls.charAt(i) - '0';
            assertEquals( (c >= 1 && c <= 9), true );
        }
    }

    // 4.랜덤숫자생성기가 생성한 문자열은 원소가 문자열 내 각각 1개씩만 존재한다.
    // 5.랜덤숫자생성기가 생성한 문자열은 적어도 한 번은 바뀌어야 한다.
    //유효성 검사 4. 생성되는 문자열이 랜덤인가
    @Test
    public void isStringValidatedIsRandomlyGenerated(){
        int testCnt = 10;
        String ballsArr [] =new String[testCnt];

        for (int i=0; i<testCnt; i++)
            ballsArr[i] = generator.generateRandomNum();

        for (int i=0; i<testCnt; i++){
            final String balls =ballsArr[i];
            assertEquals(Arrays.stream(ballsArr).filter(s -> s.equals(balls)).count(), 1);
        }
    }
}
