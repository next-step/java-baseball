package bymin.game.play;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MakeNumberBaseBallTest_Make {

    private MakeNumberBaseBall makeNumberBaseBall;

    @BeforeEach
    void initBaseballService() {
        makeNumberBaseBall = new MakeNumberBaseBall();
		makeNumberBaseBall.setNumList(new ArrayList<>());
    }

	@DisplayName("3 over numberball check")
	@Test
	void isValidNumListCheck() {
		assertEquals(makeNumberBaseBall.numListCheck(1), true);
		assertEquals(makeNumberBaseBall.numListCheck(2), true);
		assertEquals(makeNumberBaseBall.numListCheck(3), false);
		assertEquals(makeNumberBaseBall.numListCheck(4), false);
		assertEquals(makeNumberBaseBall.numListCheck(5), false);
		assertEquals(makeNumberBaseBall.numListCheck(6), false);
		assertEquals(makeNumberBaseBall.numListCheck(7), false);
		assertEquals(makeNumberBaseBall.numListCheck(8), false);
		assertEquals(makeNumberBaseBall.numListCheck(9), false);
	}





}
