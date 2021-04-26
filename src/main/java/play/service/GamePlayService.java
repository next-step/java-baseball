package play.service;

import play.dto.GameResult;
import ui.dto.InputDataDto;

public interface GamePlayService {
	void init();
	GameResult play(InputDataDto inputDataDto);
}
