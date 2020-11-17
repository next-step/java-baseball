package bymin.game.play;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MakeNumberBaseBallTest {

    private MakeNumberBaseBall makeNumberBaseBall;

    @BeforeEach
    void initBaseballService() {
        makeNumberBaseBall = new MakeNumberBaseBall();
        makeNumberBaseBall.make();
    }

    @DisplayName("size check!")
    @Test
    void isValidInputScore() {
//        assertEquals(makeNumberBaseBall.getNumList().size(), 2);
        assertEquals(makeNumberBaseBall.getNumList().size(), 3);
    }

	@DisplayName("number 3 check")
	@Test
	void isValidNumListCheck() {
//        assertEquals(makeNumberBaseBall.getNumList().size(), 2);
		assertEquals(makeNumberBaseBall.numListCheck(1), false);
		assertEquals(makeNumberBaseBall.numListCheck(2), false);
		assertEquals(makeNumberBaseBall.numListCheck(3), false);
		assertEquals(makeNumberBaseBall.numListCheck(4), false);
		assertEquals(makeNumberBaseBall.numListCheck(5), false);
		assertEquals(makeNumberBaseBall.numListCheck(6), false);
	}



}
