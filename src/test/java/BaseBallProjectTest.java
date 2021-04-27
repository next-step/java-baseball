import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseBallProjectTest {

    @Test
    void stopGameTest(){
        BaseballProject project = new BaseballProject();
        project.stopGame("2", project);
        Assertions.assertThat(project.isContinue).isEqualTo(false);
    }

}
