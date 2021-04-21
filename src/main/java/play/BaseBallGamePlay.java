package play;

import ui.InputDataVO;

public class BaseBallGamePlay implements GamePlay{

	private int[] targetNumberArray;

	@Override
	public void init() {

	}

	@Override
	public boolean play(InputDataVO inputDataVO) {
		return true;
	}

	private int[] generateTargetNumber(){
		return new int[]{};
	}
}
