import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StringStudyTest {
    @Test
    void create(){
        StringStudy stringStudy = new StringStudy();
        assertNotNull(stringStudy);
    }
}
