package play.service;

import ui.dto.InputDataDto;

public interface GamePlay {
	void init();
	boolean play(InputDataDto inputDataDto);
}
