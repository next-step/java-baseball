import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BaseBallValidationTest {

    private static BaseBallDTO dto;
    private static BaseBallValidation validation;

    @BeforeAll
    static  void  setup(){
        dto = new BaseBallDTO();
        validation = new BaseBallValidation();
    }

    @Test
    public void generateNumber(){
        dto.setInputNumber("가나다");
        Assertions.assertTrue(validation.filedNumberChk(dto));
        dto.setInputNumber("ABC");
        Assertions.assertTrue(validation.filedNumberChk(dto));
        dto.setInputNumber("123");
        Assertions.assertFalse(validation.filedNumberChk(dto));
        dto.setInputNumber("1231111");
        Assertions.assertTrue(validation.filedLengthChk(dto));
        dto.setInputNumber("123");
        Assertions.assertFalse(validation.filedLengthChk(dto));
    }

}
