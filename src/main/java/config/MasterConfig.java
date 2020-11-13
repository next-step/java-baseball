package config;

import generator.NumberGenerator;
import generator.RandomNumberGenerator;
import master.BaseballMaster;

public class MasterConfig {
    public BaseballMaster baseballMaster() {
        return new BaseballMaster(randomNumberGenerator());
    }

    private NumberGenerator randomNumberGenerator() {
        return new RandomNumberGenerator();
    }
}
