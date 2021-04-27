package com.woowahan.pro;

import com.woowahan.pro.manager.GameManager;
import com.woowahan.pro.manager.GameManagerImpl;
import com.woowahan.pro.opponent.ComputerOpponent;
import com.woowahan.pro.opponent.Opponent;
import com.woowahan.pro.referee.Referee;
import com.woowahan.pro.referee.RefereeImpl;
import com.woowahan.pro.ui.ConsoleUserInterface;
import com.woowahan.pro.ui.UserInterface;

public class AppConfig {

    public Opponent opponent() {
        return new ComputerOpponent();
    }

    public Referee referee() {
        return new RefereeImpl();
    }

    public UserInterface userInterface() {
        return new ConsoleUserInterface();
    }

    public GameManager gameManager() {
        return new GameManagerImpl(opponent(), referee(), userInterface());
    }
}
