package ui.service;

import ui.type.GameCommand;
import ui.dto.InputDataDto;

public interface GamerAction {
	InputDataDto inputData();
	GameCommand inputCommand();
}
