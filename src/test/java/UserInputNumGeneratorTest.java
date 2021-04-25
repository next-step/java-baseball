import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserInputNumGeneratorTest {
    private UserInputNumGenerator generator;

    @Before
    public void setUp(){
        generator = new UserInputNumGenerator(BaseballGame.DEFAULT_LEN);
    }

    @Test
    public void generatorCanValidate(){
        generator.validate("123");
    }

    //유효성 검사 1. 널이 아닌가?
    @Test
    public void validateNotNull(){
        assertEquals(generator.validate("123"), true);
        assertEquals(generator.validate(null), false);
    }
    //유효성 검사 2. 게임에서 지정한 길이인가?
    @Test
    public void validateIsMaxLen(){
        assertEquals(generator.validate("123"), true);
        assertEquals(generator.validate("12"), false);
        assertEquals(generator.validate("1234"), false);
    }

    //유효성 검사 3. 문자열이 1~9까지의 숫자들로 이루어져 있는가
    @Test
    public void validateIsOnlyComposed1to9(){
        assertEquals(generator.validate("123"), true);
        assertEquals(generator.validate("12a"), false);
        assertEquals(generator.validate("ㄱ12"), false);
        assertEquals(generator.validate("!12"), false);
    }

    //유효성 검사 4. 문자열이 서로 다른 숫자로 이루어져 있는가
    @Test
    public void validateAllDifferentNumber(){
        assertEquals(generator.validate("123"), true);
        assertEquals(generator.validate("456"), true);
        assertEquals(generator.validate("111"), false);
        assertEquals(generator.validate("112"), false);
        assertEquals(generator.validate("121"), false);
        assertEquals(generator.validate("211"), false);
        assertEquals(generator.validate("337"), false);
        assertEquals(generator.validate("272"), false);
        assertEquals(generator.validate("499"), false);
    }

    @Test
    public void generatorCanBeGenerateNum(){
        generator.generateNum();
    }
}
