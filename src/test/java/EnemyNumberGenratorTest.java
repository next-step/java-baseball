import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
public class EnemyNumberGenratorTest {

    private static BaseBallDTO dto;
    private static EnemyNumberGenerator generator;

    @BeforeAll
    static  void  setup(){
        dto = new BaseBallDTO();
        generator = new EnemyNumberGenerator();
    }

    @Test
    public void generateNumber(){
        generator.generateNumber(dto);
        Assertions.assertEquals(3,dto.getEnemyNumbers().size());
        System.out.println("컴퓨터 번호확인 -> "+dto.getEnemyNumbers());
    }

}

